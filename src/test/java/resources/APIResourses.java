package resources;

public enum APIResourses {

	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
    
	private String resource;
	
	APIResourses(String resource) {
		
		this.resource = resource;
		
	}
	
	public String getResourse()
	{
		return resource;
	}
	
	
	

}
