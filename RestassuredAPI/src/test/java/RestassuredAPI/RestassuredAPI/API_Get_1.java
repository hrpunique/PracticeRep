package RestassuredAPI.RestassuredAPI;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import static org.hamcrest.Matchers.*;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class API_Get_1 {
	
@Test
public void GetBooksDetails() {
	
	
	/*RestAssured.baseURI = "https://demoqa.com/BookStore/v1/BOOKS"; 
	RequestSpecification httpRequest = RestAssured.given(); 
 
	Response response = httpRequest.request(Method.GET, "");
	 
	System.out.println("Status received => " + response.getStatusLine()); 
	System.out.println("Response=>" + response.prettyPrint());*/
	
	baseURI="https://reqres.in/api";
	given().get("/users?page=2").then().statusCode(200).
	body("data[4].first_name", equalTo("George"))
	.body("data.first_name", hasItems("George", "Rachel"));
	

}
@Test
public void testPost() {
	
//	
//	Map<String, Object> map =  new HashMap<String, Object>();
//	
//	map.put("job", "looking");
	JSONObject request = new JSONObject();
request.put("name","pratik" );
request.put("job", "searching");
System.out.println(request.toJSONString());
baseURI= "https://reqres.in/api";

given()
.body(request.toJSONString()).when().post("/users").then().statusCode(201).log().all();
}

}
