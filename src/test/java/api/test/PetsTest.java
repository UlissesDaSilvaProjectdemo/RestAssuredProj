package api.test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoint;
import api.payload.UserPayload;
import io.restassured.response.Response;
 


public class PetsTest {
	
	Faker faker;
	UserPayload userPayload;
	 

	@BeforeClass
	public void setupData() {
		
		faker = new Faker();
		userPayload = new UserPayload();
		
		 userPayload.setId(faker.idNumber().hashCode());
		 userPayload.setFirtsName(faker.name().firstName());
    	 userPayload.setLastName(faker.name().lastName());
    	 userPayload.setPhone(faker.phoneNumber().phoneNumber());
    	 userPayload.setPhone(faker.phoneNumber().cellPhone());
    	 userPayload.setEmail(faker.internet().emailAddress());
    	 userPayload.setPassword(faker.internet().password(5,10));
    	 userPayload.setId(faker.idNumber().hashCode());
    	 
		
	
	}
	
	
	@Test(priority=1)
	public void testPostUser() {
		
		    Response response=UserEndPoint.createUser(userPayload);
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(),200);
	}
	
	
	@Test(priority=2)
	public void testGetUserByName() {
		
	Response response = UserEndPoint.readeUser(this.userPayload.getUserName());
	response.then().log().all();
	Assert.assertEquals(response.statusCode(),200);
		
		
	}
	
	
	@Test(priority=3)
	public void testUpdateUserByName() {
		
	 userPayload.setFirtsName(faker.name().firstName());
   	 userPayload.setLastName(faker.name().lastName());
   	 userPayload.setPhone(faker.phoneNumber().phoneNumber());
   	 userPayload.setPhone(faker.phoneNumber().cellPhone());
   	 userPayload.setEmail(faker.internet().emailAddress());
   	  
    	  
		
	Response response = UserEndPoint.readeUser(this.userPayload.getUserName());	
	response.then().log().all();
	Assert.assertEquals(response.statusCode(), 200);
	
	//check if the data is unique
	
	Response responseAfterUpdate=UserEndPoint.readeUser(this.userPayload.getUserName());
	Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
		
		
	}
	
	
	@Test(priority=4)
	public void testDeleteUserByName() {
		
    Response response = UserEndPoint.readeUser(this.userPayload.getUserName());	
	Assert.assertEquals(response.statusCode(),200);
	
	 
		
	} 

}
