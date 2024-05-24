package RestassuredAPI.RestassuredAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class GetandPost {
	
	public void get() {

		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[3].first_name", equalTo("Byron"))
				.body("data.first_name", hasItems("Tobias", "Lindsay"));

	}
	@Test
	public void post() {
		
		Map<String, Object> map = new HashMap<String, Object>();
	
	JSONObject request = new JSONObject();
	
	request.put("name", "Pratik");
	request.put("job", "Tester");
	
	System.out.println(request.toJSONString());
	
	baseURI = "https://reqres.in/api";
	given().body(request.toJSONString()).when()
.post("/users").then().statusCode(201).log().all()	;

	}
}