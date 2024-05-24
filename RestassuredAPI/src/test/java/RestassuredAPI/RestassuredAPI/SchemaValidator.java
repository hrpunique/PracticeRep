package RestassuredAPI.RestassuredAPI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class SchemaValidator {

	@Test
	public void get() {

		baseURI = "https://reqres.in/api";
		given().get("/users?page=2").then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json")).
		statusCode(200);

	}
}
