package HttpRequest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import java.util.HashMap;

public class CreateUserRequest {
	
	

    @Test
    public void getRequest() {
        // Set Base URI
        baseURI = "https://gorest.co.in";
        
        given()
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer d790a5be17d32be1b6648aa65df1194defd430746a62253fa9302efff143673d")
        .when()
            .get("/public/v2/posts") // Perform GET request
        .then()
            .statusCode(200) // Validate status code
            .log().all(); // Log full response
    }
}
