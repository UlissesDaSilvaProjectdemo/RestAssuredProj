package api.endpoints;

public class Routes {
	
	//Swagger URI ---> https://petstore.swagger.io/v2/user

	  //Create user (POST)  https://petstore.swagger.io/v2/user
	  //Get user    (Get)    https://petstore.swagger.io/v2/user/{username}
	  //Update user (put)    https://petstore.swagger.io/v2/user/{username}
	  //Delete user (Delete) https://petstore.swagger.io/v2/user/{username}


	//User Model
	
	
	public static String base_url="https://petstore3.swagger.io/api/v3/user"; 
	  
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{userName}";
	public static String update_url=base_url+"/user/{userName}";
	public static String delete_url=base_url+"/user/{userName}";
	

       //Store Model Urls

       //PetModel Urls 

}
