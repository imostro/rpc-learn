package com.mostro;

import java.lang.reflect.Proxy;

/**
 * @Author: MOSTRO
 */
public class RpcProxyClient {

     static <T> T  clientPorxy(Class<T> interfaceClazz, String host, int port){

         return (T)Proxy.newProxyInstance(interfaceClazz.getClassLoader(),
                 new Class<?>[]{interfaceClazz},new RemoteInvocationHandler(host,port));
     }
}
