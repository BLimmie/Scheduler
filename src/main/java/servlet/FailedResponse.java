package servlet;

public class FailedResponse {
    private static FailedResponse ourInstance = new FailedResponse();
    private String response;
    public static FailedResponse getInstance() {
        return ourInstance;
    }

    private FailedResponse() {
        response = "Failed Response";
    }
}
