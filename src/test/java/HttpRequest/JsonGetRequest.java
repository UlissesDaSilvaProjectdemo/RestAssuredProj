 package HttpRequest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JsonGetRequest {

    JSONObject requestData;

    @Test(priority=1)
    public void prepareTestData() {
        // Initialize HashMap
        requestData = new JSONObject();
        requestData.put("body", "John test");
        requestData.put("title", "test");
      

        // Add an array of courses
       // String[] dataCourse = {"Java", "Python"};
        //requestData.put("user_course", dataCourse);
    }

    @Test(priority=2)
    public void createPostRequest() {
        // Set Base URI
        baseURI = "https://gorest.co.in";

        given()
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer  23884b67a5232d22bb10c1581b2d388b029b162a9ad7642ab36e254391bb3979")
            .body(requestData) // Send request pay-load
        .when()
            .post("/public/v2/posts") // Perform POST request
        .then()
            .statusCode(201) // Validate success (201 Created)
            .header("Content-type", "application/json")
            
            .body("title", equalTo("test")) // Validate `user_phone`
            .body("body", equalTo("John test")) // Validate `user_email
            
             
            .log().all(); // Log full response
    }
}
