package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.GetBody;
import pojo.location;

public class TestDataBuild {
	
	public GetBody AddPlacePayload(String name, String language, String address)
	{
		GetBody b = new GetBody();
		b.setAccuracy(50);
		b.setAddress(address);
		b.setName(name);
		b.setLanguage(language);
		b.setPhone_number("(+91) 983 893 3937");
		b.setWebsite("http://google.com");
		
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		b.setTypes(types);
		
		location l  = new location();
		l.setLat(-35.383494);
		l.setLng(33.427362);
		
		b.setLocation(l);
		return b;
	}
	
	public String deletePlacePayload(String id)
	{
		return "{\r\n"
				+ "    \"place_id\":\""+id+"\"   	 	\r\n"
				+ "}\r\n"
				+ "";
	}

}
