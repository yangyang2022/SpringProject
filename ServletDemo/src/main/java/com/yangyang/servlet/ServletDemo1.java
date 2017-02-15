package com.yangyang.servlet;

import com.yangyang.utils.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDemo1",urlPatterns = "/demo1")
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.getWriter().println(new Util().sayHello());

        //response.getWriter().println("hello servlet demo1 ");
        //AsyncContext ctx = request.startAsync();
        //ServletOutputStream outputStream = response.getOutputStream();
        //
        //FileInputStream file = new FileInputStream(new File("sss"));
        //byte[] buffer = new byte[1024];
        //
        //outputStream.setWriteListener(new WriteListener() {
        //    @Override
        //    public void onWritePossible() throws IOException {
        //        //while (outputStream.isReady()){
        //        //    int len = file.read(buffer);
        //        //    if(len < 0){
        //        //        ctx.complete();
        //        //        return;
        //        //    }
        //        //    outputStream.write(buffer,0,len);
        //        //}
        //    }
        //
        //    @Override
        //    public void onError(Throwable t) {
        //
        //    }
        //});
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
