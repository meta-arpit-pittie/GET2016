/**
 * Assignment 1
 * Class to represent the attributes for an organisation type node
 * @author Arpit Pittie
 */
package session5;

public class ProfileOrganisation extends Profile{
	
	private String name;	//The name attribute for the node
	private String place;	//The place attribute for the node
	private String type;	//The type attribute for the node
	
	public ProfileOrganisation(String name, String place, String type) {
		this.name = name;
		this.place = place;
		this.type = type;
	}
	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	@Override
	public void setPlace(String place) {
		// TODO Auto-generated method stub
		this.place = place;
	}
	
	@Override
	public String getPlace() {
		// TODO Auto-generated method stub
		return place;
	}
	
	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		this.type = type;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
