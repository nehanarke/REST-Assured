package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class test1 
{
	@Test
	public void test_1()
	
	{
		Response res=get("https://reqres.in/api/users?page=2");
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getBody().asString());
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeader("content-type"));
		
		int statuscode=res.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	
	}
	
	@Test
	public void test_2()
	{
		baseURI="https://reqres.in/api";
		given()
		.get("/users?page=2").
		
		then().
		statusCode(200);
		
		
		
	}
	

}
