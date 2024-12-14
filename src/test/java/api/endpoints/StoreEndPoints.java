package api.endpoints;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.payload.UserPayload;

public class StoreEndPoints{
	
	 
	 public static Response createUser(UserPayload payload) {
		 
		 Response response=given()
		    .contentType(ContentType.JSON)
		    .accept(ContentType.JSON)
		    .body(payload)
		    .when() 
		    .post(Routes.post_url);
		    return response;
		 
	 }
	 
	 

	 public static Response readeUser(String userName) {
		 
		 Response response=given()
		    .pathParam("username", userName)
		    .when()
		    .get(Routes.get_url);
		    return response;
		 
	 }
	 
	 

	 public static Response updateUser(String userName, UserPayload payload) {
		 
		 Response response=given()
		    .contentType(ContentType.JSON)
		    .accept(ContentType.JSON)
		    .body(payload)
		    .param("username",userName)
		    .when()
		    .put(Routes.update_url);
		    return response;
		 
	 }
	
	 


public static Response deleteUser(String userName) {
	Response response=given()
    		.pathParam("userName", userName)
     
    .when()
    .delete(Routes.delete_url);
    return response;
}
}
	
	
	 