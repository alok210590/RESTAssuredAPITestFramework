package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {

	@Test(priority = 1, dataProvider="Data", dataProviderClass = DataProviders.class)
	public void postUserDDTest(String userID, String userName, String firstName, String lastName, String email, String pwd, String phno) {

		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phno);
		
		Response response = UserEndpoints.createUser(userPayload);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(":::::::::::::POST : User created succesfully.:::::::::::::");
	}
	
	@Test(priority = 2, dataProvider="UserNames", dataProviderClass = DataProviders.class)
	public void deleteUserDDTest(String uname) {
		
		Response response = UserEndpoints.deleteUser(uname);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(":::::::::::::DELETE : User deleted succesfully.:::::::::::::");
	}
}
