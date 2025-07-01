package api.utils;

import io.restassured.response.Response;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

public class JsonSchemaValidatorUtil {
    private static final String SCHEMA_PATH = "src/test/resources/jsonSchemas/";

    public static void validateSchema(Response response, String schemaFile) {
        File file = new File(SCHEMA_PATH + schemaFile);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));
    }
}
