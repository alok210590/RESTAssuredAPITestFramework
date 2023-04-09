package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	Logger logger;
	
	@BeforeClass
	public void setup() {
		
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//Logs
		logger = LogManager.getLogger(this.getClass());
		logger.info(":::::::::::::Payload created succesfully.:::::::::::::");
		System.out.println(":::::::::::::Payload created succesfully.:::::::::::::");
	}
	
	@Test(priority = 1)
	public void postUserTest() {
		logger.info((":::::::::::::POST : User creation inprogress.:::::::::::::"));
		Response response = UserEndpoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(":::::::::::::POST : User created succesfully.:::::::::::::");
		logger.info(":::::::::::::POST : User created succesfully.:::::::::::::");
	}
	
	@Test(priority = 2)
	public void getUserByNameTest() {
		
		Response response = UserEndpoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(":::::::::::::GET : User retrived succesfully.:::::::::::::");
		logger.info(":::::::::::::GET : User retrived succesfully.:::::::::::::");
	}
	
	@Test(priority = 3)
	public void updateUserByNameTest() {
		
		//Update below data for API
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndpoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(":::::::::::::PUT : User updated succesfully.:::::::::::::::::::");
		logger.info(":::::::::::::PUT : User updated succesfully.:::::::::::::::::::");
		
		//check data after update
		Response responseAfterUpdate = UserEndpoints.readUser(this.userPayload.getUsername());
		responseAfterUpdate.then().log().all();
		
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		System.out.println(":::::::::::::GET : Updated User retrieved succesfully.::::::::::::::::");
		logger.info(":::::::::::::GET : Updated User retrieved succesfully.::::::::::::::::");
	}
	
	@Test(priority = 4)
	public void deletetUserByNameTest() {
		
		Response response = UserEndpoints.deleteUser(this.userPayload.getUsername());
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(":::::::::::::DELETE : User deleted succesfully.:::::::::::::");
		logger.info(":::::::::::::DELETE : User deleted succesfully.:::::::::::::");
	}
}
