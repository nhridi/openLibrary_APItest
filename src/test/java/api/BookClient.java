package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;


public class BookClient {
    public HashMap<String, Object> getBookInformation(String title) throws IOException {
        Response response = given()
                .param("title", title)
                .when()
                .get("https://openlibrary.org/search.json")
                .then()
                .statusCode(200)
                .extract().response();

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.asString(), HashMap.class);
    }
}
