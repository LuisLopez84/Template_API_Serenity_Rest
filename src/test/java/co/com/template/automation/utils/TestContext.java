package co.com.template.automation.utils;

public class TestContext {
    private static String endpoint;

    public static void setEndpoint(String endpoint) {
        TestContext.endpoint = endpoint;
    }

    public static String getEndpoint() {
        return endpoint;
    }
}