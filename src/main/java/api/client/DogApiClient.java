package api.client;

import io.restassured.response.Response;

public class DogApiClient extends BaseClient {

    public Response getAllBreeds() {
        return get("/breeds/list/all");
    }

    public Response getBreedImages(String breed) {
        return get("/breed/" + breed + "/images");
    }

    public Response getRandomImage() {
        return get("/breeds/image/random");
    }
}
