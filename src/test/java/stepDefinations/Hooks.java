package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		// need to create place id to run delete api
		StepDefination m  = new StepDefination();
		if(StepDefination.place_id == null)
		{
		m.add_place_payload_with("Pushkara", "English","Delhi");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_place_id_created_maps_to_using("Pushkara", "getPlaceAPI");
		}
	}

}
