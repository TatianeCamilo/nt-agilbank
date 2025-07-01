package tests;

import api.client.DogApiClient;
import api.utils.JsonSchemaValidatorUtil;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DogApiTest {

    DogApiClient client;

    @BeforeEach
    public void setup() {
        client = new DogApiClient();
    }

    @Test
    public void testGetAllBreeds() {
        Response response = client.getAllBreeds();

        response.then().statusCode(200);
        response.then().body("status", equalTo("success"));
        response.then().body("message", notNullValue());

        JsonSchemaValidatorUtil.validateSchema(response, "breedsListAllSchema.json");
    }

    @Test
    public void testGetBreedImages() {
        Response response = client.getBreedImages("hound");

        response.then().statusCode(200);
        response.then().body("status", equalTo("success"));
        response.then().body("message", not(empty()));
        response.then().body("message[0]", containsString("hound"));

        JsonSchemaValidatorUtil.validateSchema(response, "breedImagesSchema.json");
    }

    @Test
    public void testGetRandomImage() {
        Response response = client.getRandomImage();

        response.then().statusCode(200);
        response.then().body("status", equalTo("success"));
        response.then().body("message", containsString("https://"));

        JsonSchemaValidatorUtil.validateSchema(response, "randomImageSchema.json");
    }

    // Novos cenários de erro HTTP
    @Test
    public void testGetBreedImagesWithInvalidBreedReturns404() {
        given()
            .baseUri("https://dog.ceo/api")
        .when()
            .get("/breed/invalid-breed/images")
        .then()
            .statusCode(404);
    }

    @Test
    public void testGetRandomImageFromInvalidBreedReturns404() {
        given()
            .baseUri("https://dog.ceo/api")
        .when()
            .get("/breed/invalid-breed/images/random")
        .then()
            .statusCode(404);
    }

    @Test
    public void testPostToGetEndpointReturns405() {
        given()
            .baseUri("https://dog.ceo/api")
        .when()
            .post("/breeds/list/all")
        .then()
            .statusCode(405);
    }
}
