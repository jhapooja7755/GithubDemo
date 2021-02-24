package files;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.*;

public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFilter session = new SessionFilter();
		given().header("Content-Type",  "application/json").body("{ \"username\": \"jhapooja7755\", \"password\": \"papa94300\" }").
		log().all().filter(session).when().post("/rest/auth/1/session").then().extract().response().asString();
		
		RestAssured.baseURI = "http://localhost:8080";
		given().pathParam("id", "10027").log().all().header("Content-Type",  "application/json").body("{\r\n"
				+ "    \"body\": \"I have commented for the automation issue\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).when().post("/rest/api/2/issue/{id}/comment").then().log().all()
		.assertThat().statusCode(201);
		

	}

}
