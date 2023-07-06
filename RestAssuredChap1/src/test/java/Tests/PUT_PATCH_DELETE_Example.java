package Tests;

import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;


public class PUT_PATCH_DELETE_Example 

{
	@Test
	public void TestPut()
	{
		baseURI="https://reqres.in/api";
		
		JSONObject req=new JSONObject();
		req.put("name","komal");
		req.put("job","student");
		
		System.out.println(req.toJSONString());
		
		
		given().
		body(req.toJSONString()).
		when().
		put("/users/2").
		then().
		statusCode(200).
		log().all();
	}
	
	@Test
	public void TestPatch()
	{
		baseURI="https://reqres.in/api";
		
		JSONObject req1=new JSONObject();
		
		req1.put("name", "aniket");
		req1.put("job", "Developer");
		
		System.out.println(req1.toJSONString());
		
		given().body(req1.toJSONString()).
		when().
	    patch("/users/2").
	    then().statusCode(200).log().all();
	
	}

	@Test
	public void TestDelete()
	{
		baseURI="https://reqres.in/api";
		
		when().
		delete("/users/2").
		then().statusCode(204).log().all();
	}
}
