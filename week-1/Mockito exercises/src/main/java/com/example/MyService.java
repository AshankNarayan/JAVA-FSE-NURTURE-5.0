package com.example;

/**
 * Service class that depends on ExternalApi to fetch data.
 * The dependency is injected via the constructor, making it testable with mocks.
 */
public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    /**
     * Fetches data from the external API.
     * @return The data string returned by the external API.
     */
    public String fetchData() {
        return externalApi.getData();
    }
}
