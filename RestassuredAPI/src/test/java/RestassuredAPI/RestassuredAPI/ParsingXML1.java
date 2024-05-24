package RestassuredAPI.RestassuredAPI;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;



public class ParsingXML1 {
@Test
	public void pars() {
	
	Response res = given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
	
	XmlPath xmlobj= new XmlPath(res.asString());
	
	List<String > travels= xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
	Assert.assertEquals(travels.size(), 10);
	
	List<String > travels_name= xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
	boolean status= false;
	for(String travellername:travels_name) {
		
		if(travellername.equals("Developer")) {
			
			status= true;
			break;
		}
		Assert.assertEquals(status, true);
	}
}
}
