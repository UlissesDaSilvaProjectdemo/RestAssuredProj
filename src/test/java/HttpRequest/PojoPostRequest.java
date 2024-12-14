package HttpRequest;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import PojoClasses.creatUserPojo;

public class PojoPostRequest {
	
	creatUserPojo requestData;
	
	@Test(priority=1)
	public void pojo_PostRequest() {
		
		System.out.println("start test");
				
	}
	
	 @Test(priority=2)
	    public void createPostRequest() {
		 
		    requestData =new creatUserPojo();
			requestData.setUser_name("ulisses");
			requestData.setUser_phone("11dasilva@gmail");
			requestData.setUser_email("ulisses");
			 
		 
			  String courseArr[]= {"Java","Pyhton"};
			  requestData.setCourse(courseArr);
			    
					
	        // Set Base URI
	        baseURI = "https://gorest.co.in";
	        //https://gorest.co.in/public/v2/posts

	        given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", "Bearer  d790a5be17d32be1b6648aa65df1194defd430746a62253fa9302efff143673d")
	            .body(requestData) // Send request pay-load
	        .when()
	            .post("/public/v2/comments") // Perform POST request
	        .then()
	            .statusCode(200) // Validate success (201 Created)
	            .header("Content-type", "application/json")
	            .log().all(); // Log full response
	        
	        
	       
	    }

}
