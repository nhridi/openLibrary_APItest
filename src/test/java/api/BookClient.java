package api;

import io.restassured.response.Response;
import models.BookResponse;
import static io.restassured.RestAssured.given;


public class BookClient {

    public BookResponse getBookInformation(String title) {
        Response response = given()
                .param("title", title)
                .when()
                .get("https://openlibrary.org/search.json")
                .then()
                .statusCode(200)
                .extract().response();

        return response.as(BookResponse.class);
    }
}
