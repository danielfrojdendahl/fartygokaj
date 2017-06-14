package se.iths.Skeppokaj.db;

import java.util.List;

import se.iths.Skeppokaj.domain.Personnel;

public class DBStoragePersonnelFixture {

	DBStorage storage = new DBStorage();
	String firstName;
	String lastName;
	String license;
	String status;
	String schema;
	int id;
	String newStatus;
	int soughtID;



	//	public static void main (String [] args){
	//		DBStorageTestFixture d = new DBStorageTestFixture();
	//		d.setName("789");
	//		d.addPersonnelTest();
	//	}

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

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}

	public int getSoughtID() {
		return soughtID;
	}

	public void setSoughtID(int soughtID) {
		this.soughtID = soughtID;
	}

	public boolean addPersonnelTest() {
		Personnel p = new Personnel(firstName, lastName, license, status, schema);
		return storage.addPersonnel(p);
	}

	public boolean deletePersonnelTest(){
		Personnel p = new Personnel(id, firstName, lastName, license, status, schema);
		return storage.deletePersonnel(p);
	}

	public boolean updateStatusPersonnelTest(){
		Personnel p = new Personnel(id, firstName, lastName, license, status, schema);
		p.setStatus(newStatus);
		return storage.updateStatusPersonnel(p);
	}
	
	public List<Personnel> getPersonnelByIDTest(){
		Personnel p = new Personnel(soughtID, firstName, lastName, license, status, schema);
		return storage.getPersonnelByID(soughtID);
	}
}
