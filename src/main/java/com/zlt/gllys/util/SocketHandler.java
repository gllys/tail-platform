package com.zlt.gllys.util;

/**
 * Created by zhangletian on 16/8/12.
 */
public class SocketHandler  {

//    public static void main(String args[]) throws Exception {
//        //为了简单起见，所有的异常都直接往外抛
//        String host = "127.0.0.1";  //要连接的服务端IP地址
//        int port = 8002;   //要连接的服务端对应的监听端口
//        //与服务端建立连接
//        Socket client = new Socket(host, port);
//        //建立连接后就可以往服务端写数据了
//        Writer writer = new OutputStreamWriter(client.getOutputStream());
//        writer.write("Hello Server.");
//        writer.flush();
//        //写完以后进行读操作
//        Reader reader = new InputStreamReader(client.getInputStream());
//        char chars[] = new char[64];
//        int len;
//        StringBuffer sb = new StringBuffer();
//        while ((len=reader.read(chars)) != -1) {
//            sb.append(new String(chars, 0, len));
//        }
//        System.out.println("from server: " + sb);
//        writer.close();
//        reader.close();
//        client.close();
//    }

}

