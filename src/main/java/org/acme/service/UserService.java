package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService {

    public String greeting(String name) {
        return "Hello " + name;
    }

}
