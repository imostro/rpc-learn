package com.mostro;

import com.mostro.rpc.IHelloService;

/**
 * @Author: MOSTRO
 */
public class App {

    public static void main(String[] args){
        IHelloService iHelloService = RpcProxyClient.clientPorxy(IHelloService.class, "localhost", 8080);
        String mostro = iHelloService.sayHello("Mostro");
        System.out.println(mostro);
    }
}
