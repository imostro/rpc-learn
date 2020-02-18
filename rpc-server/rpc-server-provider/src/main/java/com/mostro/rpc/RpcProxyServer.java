package com.mostro.rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: MOSTRO
 */
public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(int port, Object service){
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(port);
            while(true){
                Socket accept = socket.accept();
                executorService.execute(new ProcessorHandler(accept, service));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}
