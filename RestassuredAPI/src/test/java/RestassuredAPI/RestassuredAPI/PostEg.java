package RestassuredAPI.RestassuredAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostEg {
	
	@Test
	public void get() {
		
		Response response=RestAssured.given().log().all()
		.baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").post().then().log().all().extract().response();
		
		Assert.assertEquals(response.statusCode(),   201);
	}

}
