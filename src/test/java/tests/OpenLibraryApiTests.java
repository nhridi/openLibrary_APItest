package tests;

import api.BookClient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenLibraryApiTests extends BaseTest {
    private static final String EXPECTED_ISBN = "9781903663660";
    private static final String EXPECTED_TITLE = "The Lord of the Rings";

    private final BookClient bookClient = new BookClient();

    @Test
    public void testBookDetails() throws IOException {
        HashMap<String, Object> bookData = bookClient.getBookInformation("the lord of the rings");
        List<Map<String, Object>> books = (List<Map<String, Object>>) bookData.get("docs");

        boolean isbnFound = books.stream()
                .anyMatch(book -> ((List<String>)book.get("isbn")).contains(EXPECTED_ISBN) && book.get("title").equals(EXPECTED_TITLE));

        Assert.assertTrue(isbnFound, "Book with expected ISBN and title not found.");
    }
}

