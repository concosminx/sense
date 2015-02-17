package com.mechanitis.demo.sense.user;

import com.mechanitis.demo.sense.infrastructure.Service;

import java.net.URI;

public class UserService implements Runnable {
    private final Service<TwitterUser> service;

    public UserService() {
        this.service = new Service<>(URI.create("ws://localhost:8081/tweets/"),
                                     "/users/", 8083,
                                     TwitterUser.Factory::twitterUserFromTweet);
    }

    @Override
    public void run() {
        service.run();
    }

    public void stop() throws Exception {
        service.stop();
    }

    public static void main(String[] args) {
        new UserService().run();
    }
}
