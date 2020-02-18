package com.mostro.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.Socket;

/**
 * @Author: MOSTRO
 */
public class ProcessorHandler implements Runnable {

    private Socket socket;
    private Object service;

    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {

        try(ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {

            //输入流中应该有什么东西？
            //请求哪个类，方法名称、参数
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
            Object result = invoke(rpcRequest);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Object invoke(RpcRequest rpcRequest){
        try {
            Object[] args = rpcRequest.getParameter();
            Class<?>[] types = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                types[i] = args[i].getClass();
            }
            String className = rpcRequest.getClassName();
            Class<?> requestClass = Class.forName(className);
            Method[] methods = requestClass.getMethods();
            Method method = requestClass.getMethod(rpcRequest.getMethodName(),types);
            return method.invoke(service, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
