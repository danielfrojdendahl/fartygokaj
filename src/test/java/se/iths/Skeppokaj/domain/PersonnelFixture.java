package se.iths.Skeppokaj.domain;

public class PersonnelFixture{
	
	Personnel p = new Personnel(1, null, null, "A", "100%", "MF");
	
	public void setFirstName(String firstName) {
		p.setFirstName(firstName);
	}
	
	public void setLastName(String lastName) {
		p.setLastName(lastName);
	}
	
	public int getPersId() {
		return p.getPersId();
	}
	
	public String getSchemaType() {
		return p.getSchemaType();
	}
	
	public String getStatus() {
		return p.getStatus();
	}
	
	public String getDriversLicence() {
		return p.getDriversLicence();
	}
	
	public String getFirstName() {
		return p.getFirstName();
	}
	
	public String getLastName() {
		return p.getLastName();
	}
}