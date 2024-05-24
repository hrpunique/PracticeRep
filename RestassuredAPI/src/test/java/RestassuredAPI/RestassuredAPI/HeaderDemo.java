package RestassuredAPI.RestassuredAPI;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class HeaderDemo {
	@Test
	public void header() {
		
		given().when().get("https://www.google.co.in/").then().header("Content-Type","text/html; charset=ISO-8859-1")
		.and().header("Content-Encoding", "gzip");
		
	}

}
