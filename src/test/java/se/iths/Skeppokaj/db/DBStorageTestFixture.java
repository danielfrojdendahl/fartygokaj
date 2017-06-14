package se.iths.Skeppokaj.db;

import se.iths.Skeppokaj.domain.Personnel;

public class DBStorageTestFixture {

	DBStorage storage = new DBStorage();
	int i;
	
	public static void main (String [] args){
		DBStorageTestFixture d = new DBStorageTestFixture();
		d.addPersonnelTest();
	}
	public void setI(int i){
		this.i = i;
	}
	public boolean addPersonnelTest() {
		Personnel p = new Personnel("Apa", "Bepa", "A", "100%", "MF");
		return storage.addPersonnel(p);
	}
}
