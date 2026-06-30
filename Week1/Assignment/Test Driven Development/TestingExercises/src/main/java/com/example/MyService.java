package com.example;

public class MyService {

    private ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String processData(String endpoint) {
        String rawData = externalApi.fetchData(endpoint);
        if (rawData == null || rawData.isEmpty()) {
            return "No data available";
        }
        return rawData.toUpperCase();
    }

    public boolean greetUser(String userId) {
        String greeting = "Hello, welcome to the system!";
        return externalApi.sendNotification(userId, greeting);
    }
}
