package HttpRequest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import java.util.HashMap;

public class Post_QueryParameter {
	

    @Test
    public void getRequest() {
  // Set Base URI
        baseURI = "https://gorest.co.in";
        

        given()
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer 72d4523859458cf8f84732556360836d1013a4af2994c4734c57df6729799d14")
        .when()
            .get("/public/v2/posts") // Perform GET request
        .then()
            .statusCode(200) // Validate status code
            .body("[0].id", equalTo(7568337)) // Validate first user's `id` (adjust as per response data)
            .log().all(); // Log full response
    }
}
