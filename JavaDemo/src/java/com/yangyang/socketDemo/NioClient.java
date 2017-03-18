package com.yangyang.socketDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class NioClient {
    public static void main(String[] args) throws IOException {

        SocketChannel sc = SocketChannel.open();
        SocketChannel scc = sc.bind(new InetSocketAddress("127.0.0.1", 8888));

    }
}
