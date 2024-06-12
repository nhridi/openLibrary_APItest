package tests;

import api.BookClient;
import io.restassured.response.Response;
import models.BookResponse;
import models.Doc;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenLibraryApiTests extends BaseTest {

    private static final String EXPECTED_ISBN = "9781903663660";
    private static final String EXPECTED_TITLE = "The Lord of the Rings";
    private final BookClient bookClient = new BookClient();
    @Test
    public void testBookDetails() {
        BookResponse bookResponse = bookClient.getBookInformation("the lord of the rings");
        boolean isbnFound = bookResponse.getDocs().stream()
                .flatMap(doc -> doc.getIsbn().stream())
                .anyMatch(isbn -> isbn.equals(EXPECTED_ISBN));

        Assert.assertTrue(isbnFound, "ISBN not found in any book entry.");

        Doc book = bookResponse.getDocs().stream()
                .filter(doc -> doc.getIsbn().contains(EXPECTED_ISBN))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Book with expected ISBN not found"));

        Assert.assertEquals(book.getTitle(), EXPECTED_TITLE, "Book title does not match.");
    }
}

