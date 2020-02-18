package com.mostro;

import com.mostro.rpc.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: MOSTRO
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private String localhost;

    private int port;

    public RemoteInvocationHandler(String localhost, int port) {
        this.localhost = localhost;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //请求会进入到这里
        System.out.println("come in");
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameter(args);
        RpcNetTransport transport = new RpcNetTransport(localhost, port);
        Object result = transport.send(rpcRequest);
        return result;
    }
}
