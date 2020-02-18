package com.mostro.rpc;

/**
 * @Author: MOSTRO
 */
public interface IHelloService {

    /**
     * say hello
     * @param content
     * @return
     */
    String sayHello(String content);

    /**
     * Save user info
     * @param user user
     * @return user info
     */
    String saveUser(User user);
}
