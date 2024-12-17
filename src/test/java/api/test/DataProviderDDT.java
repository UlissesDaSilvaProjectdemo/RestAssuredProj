package api.test;

import org.testng.annotations.Test;

import api.endpoints.UserEndPoint;
import api.payload.UserPayload;
import api.utilities.ExcelDataProvider;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DataProviderDDT {
	
	
	@Test(priority=1, dataProvider="Data", dataProviderClass=ExcelDataProvider.class)
	public void testPostUser( String userID, String userName,  String fname, String lname, String useremail,String pwd, String ph){

		
	UserPayload userPayload = new UserPayload();
		
	 userPayload.setId(Integer.parseInt(userID));
	 userPayload.setUserName(userName);
	 userPayload.setFirtsName(lname);
	 userPayload.setLastName(lname);
	 userPayload.setEmail(useremail);
	 userPayload.setPassword(pwd);
	 userPayload.setPhone(ph);
	 
	 Response reponse=UserEndPoint.createUser(userPayload);
	 Assert.assertEquals(reponse.getStatusCode(),200);
	}

	
	@Test(priority=1, dataProvider="Data", dataProviderClass=ExcelDataProvider.class)
	public void deleteUser(String userName){
		
		 Response reponse=UserEndPoint.deleteUser(userName);
		 Assert.assertEquals(reponse.getStatusCode(),200);
	}
}
