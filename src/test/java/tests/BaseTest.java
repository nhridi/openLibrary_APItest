package tests;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setupRestAssured() {
        RestAssured.filters(new RequestLoggingFilter(),
        new ResponseLoggingFilter());
    }
}
