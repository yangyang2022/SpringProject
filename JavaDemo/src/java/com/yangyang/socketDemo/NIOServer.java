package com.yangyang.socketDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NIOServer {

    static class HttpHandler implements Runnable{
        private int bufferSize = 1024;
        private String localCharset = "UTF-8";
        private SelectionKey key;

        public HttpHandler(SelectionKey key) {
            this.key = key;
        }

        public void handlerAccpet() throws IOException {
            SocketChannel sc = ((ServerSocketChannel) key.channel()).accept();
            //client socket channel
            sc.configureBlocking(false);
            sc.register(key.selector(),SelectionKey.OP_READ,ByteBuffer.allocate(bufferSize));
        }
        public void handleRead() throws IOException {
            SocketChannel sc = (SocketChannel) key.channel();
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            //buffer.clear();
            if(sc.read(buffer) == -1){
                sc.close();
            }else {
                buffer.flip();
                String receiveStr = Charset.forName(localCharset).newDecoder().decode(buffer).toString();

                String[] requestMessage = receiveStr.split("\r\n");
                for(String s:requestMessage){
                    System.out.println(s);
                    if(s.isEmpty()) break;
                }

                if(requestMessage[0] != null){
                    String[] firstLine = requestMessage[0].split(" ");
                    System.out.println("");
                    System.out.println("Method: \t"+firstLine[0]);
                    System.out.println("URL: \t"+firstLine[1]);
                    System.out.println("HTTP version: \t"+firstLine[2]);
                    System.out.println("");
                }

                //return client
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP/1.1 200 ok\r\n");
                sb.append("Content-Type:text/html;charset="+localCharset+"\r\n");
                sb.append("\r\n");//last line is blank
                sb.append("<html><head><title>显示报文</title></head><body>");
                sb.append("接受到的请求报文是: <br/>");
                for(String s:requestMessage){
                    sb.append(s+"<br/>");
                }
                sb.append("</body></html>");
                buffer = ByteBuffer.wrap(sb.toString().getBytes(localCharset));
                sc.write(buffer);
                sc.close();
            }
        }

        @Override
        public void run() {
            try {

                if(key.isAcceptable()) handlerAccpet();
                if(key.isReadable()) handleRead();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static class Handler{
        private int buffersize = 1024;
        private String localCharset = "UTF-8";

        public Handler() {
        }

        public Handler(int buffersize) {
            this(buffersize,null);
        }

        public Handler(String localCharset) {
            this(-1,localCharset);
        }

        public Handler(int buffersize, String localCharset) {
            if (buffersize > 0 )this.buffersize = buffersize;
            if(localCharset != null) this.localCharset = localCharset;
        }

        public void handleAccept(SelectionKey key) throws IOException {
            SocketChannel ss = ((ServerSocketChannel) key.channel()).accept();
            ss.configureBlocking(false);
            ss.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(buffersize));
        }
        public void handleRead(SelectionKey key) throws IOException {
            SocketChannel sc = (SocketChannel) key.channel();
            ByteBuffer buffer = (ByteBuffer)key.attachment();
            buffer.clear();
            if(sc.read(buffer) == -1){
                sc.close();
            }else {
                buffer.flip();
                String receiveString = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
                System.out.println("receive From client: "+receiveString);
                String sendData = "receive data: "+receiveString;
                buffer = ByteBuffer.wrap(sendData.getBytes(localCharset));
                sc.write(buffer);
                sc.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8888));
        ssc.configureBlocking(false);

        Selector selector = Selector.open();
        ssc.register(selector,SelectionKey.OP_ACCEPT);

        while (true){
            if(selector.select(30000) == 0){
                System.out.println("timeout ... ");
                continue;
            }
            Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
            while (keyIter.hasNext()){
                SelectionKey key = keyIter.next();
                new Thread(new HttpHandler(key)).start();
                keyIter.remove();
            }
        }
    }
    public static void main1(String[] args) throws IOException {

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8888));
        ssc.configureBlocking(false);

        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        Handler handler = new Handler(1024);

        while (true){
            if(selector.select(30000) == 0){
                System.out.println("timeout ... ");
                continue;
            }
            System.out.println("handler request ... ");
            Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
            while (keyIter.hasNext()){
                SelectionKey key = keyIter.next();
                if(key.isAcceptable()){
                    handler.handleAccept(key);
                }
                if(key.isReadable()){
                    handler.handleRead(key);
                }
                keyIter.remove();
            }
        }
    }
}
