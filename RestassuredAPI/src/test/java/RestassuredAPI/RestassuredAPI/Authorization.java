package RestassuredAPI.RestassuredAPI;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Authorization {
	@Test
	public void authorize() {
		
		given().auth().basic("postman","password")
		.when().get("https://postman-echo.com/basic-auth")
		.then().statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
		
	}

}
