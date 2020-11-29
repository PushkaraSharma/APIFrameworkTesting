package stepDefinations;

import static io.restassured.RestAssured.given;

import resources.APIResourses;
import resources.TestDataBuild;
import resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.junit.Assert.*;


import java.io.IOException;


public class StepDefination extends Utils {
	
	    static String place_id;
	    RequestSpecification res;
	    ResponseSpecification resspec;
	    Response response;
	    TestDataBuild data = new TestDataBuild();

	    @Given("Add Place Payload with {string} {string} {string}")
	    public void add_place_payload_with(String name, String language, String address) throws IOException {
 			
			 res = given().log().all().spec(requestSpecifications())
						 .body(data.AddPlacePayload(name,language,address));
	    }

	
		@When("User calls {string} with {string} http request")
		public void user_calls_with_http_request(String resource,String method) {
			
			APIResourses resourceAPI = APIResourses.valueOf(resource);
			if(method.equalsIgnoreCase("POST"))
			 response =  res.when().post(resourceAPI.getResourse());
			else if(method.equalsIgnoreCase("GET"))
				response =  res.when().post(resourceAPI.getResourse());
			
			resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
				
				
		}
		
		@Then("API call is success with status code {int}")
		public void api_call_is_success_with_status_code(Integer int1) {
			
			assertEquals(response.getStatusCode(),200);
	
		}
		
		@Then("{string} in response body is {string}")
		public void in_response_body_is(String key, String Expectedvalue) {
		
			String ActualValue = getJsonPath(response,key);
			assertEquals(ActualValue,Expectedvalue);
			
		}
		
		
		@Then("verify place_Id created maps to {string} using {string}")
		public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
		    
			// request spec
			place_id = getJsonPath(response,"place_id");
			res = given().spec(requestSpecifications()).queryParam("place_id",place_id);
			
			//now use call http method function from here only/can also be done from feature file
			user_calls_with_http_request(resource,"GET");
			String actualName = getJsonPath(response,"name");
			assertEquals(actualName,expectedName);
			
			// Now you see how this is done simply here
			
		}
		

		@Given("DeletePlace payload")
		public void delete_place_payload() throws IOException {
		   
			res = given().spec(requestSpecifications()).body(data.deletePlacePayload(place_id));
		}










}
