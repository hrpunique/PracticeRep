package RestassuredAPI.RestassuredAPI;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class ParsingXMLResponse {
	@Test
	public void validate() {
	given().when()
.get("http://restapi.adequateshop.com/api/Traveler?page=1")
.then().statusCode(404)
.body("TravelerinformationResponse.page", equalTo("1"))
.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", 
		equalTo("Developer"));
}
}