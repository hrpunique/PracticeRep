package RestassuredAPI.RestassuredAPI;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import java.util.Map;
public class Cookies {
	@Test
public void cookies() {
	
	Response resp = given()
	
	.when().get("https://www.google.co.in/");
	
	String cookie_value=resp.getCookie("AEC");
	
	System.out.println(cookie_value); //Ae3NU9PpaVu4qvrPXcun59IbhLXmR8nDIDXssMn1XLlUBQG7J9AiJ0i1Vp0
	
	
	Map<String, String > all_cookies =resp.getCookies();
	
	for(String k: all_cookies.keySet()) {
	
	String single_cookie=resp.getCookie(k);
	
	System.out.println(k+ " value is  " + single_cookie );
	}
}
}
