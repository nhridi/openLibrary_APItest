package api;

import io.restassured.response.Response;

public class BookClient extends BaseApiClient {
    public static final String BOOKS = "?title=the+lord+of+the+rings";

    public Response getResponse() {

        return getBaseRequestSpecification().get(BOOKS);
    }

    public Response getBookInformation() {
        return getBaseRequestSpecification()
                .queryParam("title", "the+lord+of+the+rings").get("/search.json");
    }
}
