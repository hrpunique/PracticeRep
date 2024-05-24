package RestassuredAPI.RestassuredAPI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DatadrivenRA {
@DataProvider(name="data")
	public Object[][] postSend(){
//		Object[][] data = new Object[2][3];
//		
//		data[0][0]= "Albert";
//		data[0][1]="Peerapur";
//		data[0][2]= 2;
//		
//
//		data[1][0]= "madhamma";
//		data[1][1]="dharanappa";
//		data[1][2]= 1;
//		return data;
	
	return new Object[][] {{"prat", "pee", 1},{"mad", "dar", 2}};
		
		
	}
	
	
	@Test(dataProvider="data")
	public void post(String firstname, String lastname, int id) {
		
		
	
	JSONObject request = new JSONObject();
	
	/*request.put("name", firstname);
	request.put("job", lastname);

	request.put("job", id);*/
	
	System.out.println(request.toJSONString());
	
	baseURI = "https://reqres.in/api";
	given().body(request.toJSONString()).when()
.post("/users").then().statusCode(201).log().all()	;

	}
	
	
	
}
