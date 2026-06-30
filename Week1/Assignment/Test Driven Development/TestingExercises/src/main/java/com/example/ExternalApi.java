package com.example;

public class ExternalApi {

    public String fetchData(String endpoint) {
        return "Real data from " + endpoint;
    }

    public boolean sendNotification(String userId, String message) {
        System.out.println("Sending notification to " + userId + ": " + message);
        return true;
    }
}
