package api;

import io.restassured.response.Response;

public class BookClient extends BaseApiClient {
    public static final String BOOKS = "";

    public Response getResponse() {

        return getBaseRequestSpecification().get(BOOKS);
    }

}
