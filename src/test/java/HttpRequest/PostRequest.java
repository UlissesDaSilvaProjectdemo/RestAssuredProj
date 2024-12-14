package HttpRequest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PojoClasses.creatUserPojo;
public class PostRequest {
	
	HashMap<String, Object> requestData;
	
	@BeforeMethod
    public void prepareTestData() {
        // Initialize HashMap
        requestData = new HashMap<>();
        requestData.put("id", "6942890");
        requestData.put("name", "ulisses");
        requestData.put("email", "e111mail@Gmail.com");
        requestData.put("gender", " male");
        requestData.put("status", " active");
        
        
        // Add an array of courses
       // String[] course = {"Java", "Python"};
      //requestData.put("user_course", course);
    }

    @Test
    public void createPostRequest() {
        // Set Base URI
        baseURI = "https://gorest.co.in";
       
        given()
            .header("Content-Type", "application/json")
            .header("Authorization","Bearer d790a5be17d32be1b6648aa65df1194defd430746a62253fa9302efff143673d")
            .body(requestData) // Send request pay-load
        .when()
            .post("/public/v2/users") // Perform POST request
        .then()
            .statusCode(200) // Validate success (200 Created)
            .log().all(); // Log full response
    }
}
