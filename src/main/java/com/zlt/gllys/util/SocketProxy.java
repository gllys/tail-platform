package com.zlt.gllys.util;

import com.zlt.gllys.impl.ProxyTaskImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhangletian on 16/8/1.
 */

public class SocketProxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketProxy.class);

    static final int listenPort=8002;
//    startProxy()

    public   static void main(String[] args) throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        ServerSocket serverSocket = new ServerSocket(listenPort);
        final ExecutorService tpe= Executors.newCachedThreadPool();
        LOGGER.info("Proxy Server Start At "+sdf.format(new Date()));
        LOGGER.info("listening port:"+listenPort+"……");

        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                socket.setKeepAlive(true);
                //加入任务列表，等待处理
                tpe.execute(new ProxyTaskImpl(socket));
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

}
