package com.mostro.rpc;

/**
 * @Author: MOSTRO
 */
public class IHelloServiceImpl implements IHelloService{

    @Override
    public String sayHello(String content) {
        System.out.println("say hello:"+ content);
        return "say hello:"+ content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("save user :"+ user);
        return user.toString();
    }
}
