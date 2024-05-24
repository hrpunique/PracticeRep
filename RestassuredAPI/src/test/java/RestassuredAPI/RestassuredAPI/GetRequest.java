package RestassuredAPI.RestassuredAPI;

import org.testng.annotations.Test;
import io.restassured.*;
import io.restassured.response.Response;

public class GetRequest {

	@Test
	void first() {
	Response resp=	RestAssured.get("https://reqres.in/api/users/2");
	System.out.println(resp.asString());
	System.out.println("response code " + resp.getStatusCode());
		
	


}
}
