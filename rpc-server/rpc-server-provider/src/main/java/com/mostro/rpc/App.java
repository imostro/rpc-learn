package com.mostro.rpc;

/**
 * @Author: MOSTRO
 */
public class App {

    public static void main(String[] args){
        IHelloService service = new IHelloServiceImpl();
        RpcProxyServer rpcProxyServer = new RpcProxyServer();
        rpcProxyServer.publisher(8080, service);
    }
}
