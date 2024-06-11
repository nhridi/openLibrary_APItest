package tests;

import api.BookClient;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenLibraryApiTests extends BaseTest {

    private final BookClient bookClient = new BookClient();

    @Test
    public void isHttpStatusOK() {
        Response response = bookClient.getResponse();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code is: " + response.getStatusCode());
    }
}
