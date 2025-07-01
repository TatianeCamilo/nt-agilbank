package api.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseClient {
    protected final String BASE_URL = "https://dog.ceo/api";

    public Response get(String endpoint) {
        return RestAssured
                .given()
                .baseUri(BASE_URL)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }
}
