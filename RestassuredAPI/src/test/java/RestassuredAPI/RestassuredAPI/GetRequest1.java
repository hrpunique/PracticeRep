package RestassuredAPI.RestassuredAPI;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GetRequest1 {

	@Test
	public void getTest() {
		baseURI= "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[0].first_name", equalTo("Michael"))
		.body("data.first_name", hasItems("Michael", "Lindsay"));
		
	}
	
}
