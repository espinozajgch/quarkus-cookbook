package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {
    public String getGreeting() {
        return "Hello";
    }
}