package Tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import groovy.transform.stc.MapEntryOrKeyValue;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class GetAndPostExample 
{
	@Test
	public void testGet()
	{
		//https://reqres.in/api/unknown
		baseURI="https://reqres.in/api";
		
		
		given().
		get("/unknown").
		then().
		statusCode(200).
		body("data[2].name",equalTo("true red")).
		body("data.name.",hasItems("blue turquoise","aqua sky"));
		
	}

	@Test
	public void testPost()
	{
//		Map<String,Object>map=new HashMap<String,Object>();
//		map.put("name","neha");
//		map.put("job","leader");
//		
//		System.out.println(map);
		
		
		JSONObject request=new JSONObject();
		request.put("name","neha");
		request.put("job","leader");
		
		System.out.println(request.toJSONString());
		
		given().
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201).
		log().all();
	}
}

