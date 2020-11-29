Feature: Validating Place API's

@AddPlace
Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When User calls "AddPlaceAPI" with "Post" http request
	Then API call is success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_Id created maps to "<name>" using "getPlaceAPI"
 
	 
Examples:
 	|name		|language	|address |
 	|PappuHouse	|English 	|Delhi   |
 	|Gopu	|French 	|Mumbai   |
 	
@DeletePlace	
Scenario: Verify if Delete place functionality is working
 	Given DeletePlace payload
	When User calls "deletePlaceAPI" with "POST" http request
	Then API call is success with status code 200
	And "status" in response body is "OK"