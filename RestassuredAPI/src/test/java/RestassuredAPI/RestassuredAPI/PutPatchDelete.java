package RestassuredAPI.RestassuredAPI;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDelete {
	@Test
	public void put() {

		JSONObject request = new JSONObject();

		request.put("name", "Pratik");
		request.put("job", "Tester");

		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in/api";
		given().body(request.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();
	}

	@Test
	public void patch() {

		JSONObject request = new JSONObject();

		request.put("name", "Pratik");
		request.put("job", "Tester");

		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in/api";
		given().body(request.toJSONString()).when().patch("/users/2").then().statusCode(200).log().all();
	}

	@Test
	public void delete() {

		baseURI = "https://reqres.in/api";
		given().when().delete("/users/2").then().statusCode(204).log().all();
	}
}
