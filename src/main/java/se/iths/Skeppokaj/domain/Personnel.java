package se.iths.Skeppokaj.domain;

public class Personnel{

	private String firstName;
	private String lastName;
	private int id; //do we need this?
	private int persId;
	private int driversLicence;
	private int status;
	private int schemaType;



	public Personnel(String firstName, String lastName, int id, int persId, int driversLicence, int status,
			int schemaType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.persId = persId;
		this.driversLicence = driversLicence;
		this.status = status;
		this.schemaType = schemaType;
	}



	//	  private Personnel(PersonnelBuilder ab){
	//	    this.firstName = ab.name;
	//	  }
	//	  
	//	  public static class PersonnelBuilder{
	//	    private String name;
	//	    
	//	    public PersonnelBuilder name(String name){
	//	      this.name = name;
	//	      return this;
	//	    }
	//	    
	//	    public Personnel build(){
	//	      return new Personnel(this);
	//	    }
	//	  }

	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public int getId() {
		return id;
	}



	public int getPersId() {
		return persId;
	}



	public int getDriversLicence() {
		return driversLicence;
	}



	public int getSchemaType() {
		return schemaType;
	}



	@Override
	public String toString(){
		return new StringBuilder(firstName)  //how do we want a person to be printed? just name?
				.toString();
	}
}