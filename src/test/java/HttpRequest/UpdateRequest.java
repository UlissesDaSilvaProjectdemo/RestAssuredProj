package HttpRequest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;

public class UpdateRequest {
	
	
HashMap<String, Object> requestData;
	
    @Test
    public void getRequest() {
    	
    	 requestData = new HashMap<>();
         requestData.put("name", "  Da Silva");
         requestData.put("email", "1mail@Gmail.com");
         requestData.put("gender", " male");
         requestData.put("status", " active");
         
   
        given()
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer d790a5be17d32be1b6648aa65df1194defd430746a62253fa9302efff143673d")
        .when()
            .post("https://gorest.co.in/public/v2/users/6942890") // Perform GET request
        .then()
        .statusCode(200) // Validate status code
        .log().all(); // Log full response
    }
}
