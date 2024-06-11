package api;

import environment.EnvironmentConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseApiClient {

    protected RequestSpecification getBaseRequestSpecification() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri(EnvironmentConfig.getBaseUrl());
    }
}
