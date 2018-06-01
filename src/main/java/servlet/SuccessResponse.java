package servlet;

/**
 * Created by brian on 5/31/2018.
 */
public class SuccessResponse {
    private static SuccessResponse ourInstance = new SuccessResponse();
    private String response;

    public static SuccessResponse getInstance() {
        return ourInstance;
    }

    private SuccessResponse() {
        response = "Success";
    }
}
