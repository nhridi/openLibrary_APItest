package tests;

import api.BookClient;
import io.restassured.response.Response;
import models.BookResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenLibraryApiTests extends BaseTest {

    private static final String BOOK_TITLE = "The Lord of the Rings";
    private static final String BOOK_ISBN = "9781903663660";
    private final BookClient bookClient = new BookClient();

    @Test
    public void isHttpStatusOK() {
        Response response = bookClient.getResponse();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code is: " + response.getStatusCode());
    }

    @Test
    public void bookResponse() {
        Response response = bookClient.getBookInformation();

        BookResponse bookResponse = response.as(BookResponse.class);
        Assert.assertEquals(bookResponse.getTitle(), BOOK_TITLE, "Title is: " + bookResponse.getTitle());

        Assert.assertEquals(bookResponse.getISBN(), BOOK_ISBN, "ISBN is: " + bookResponse.getISBN());

    }


}
