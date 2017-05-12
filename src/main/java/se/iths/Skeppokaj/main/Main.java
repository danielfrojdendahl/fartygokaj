package se.iths.Skeppokaj.main;
import se.iths.Skeppokaj.db.DBStorage;
import se.iths.Skeppokaj.domain.Personnel;
public class Main{
	public static void main(String[] args){
		while(true){
			Storage storage = new DBStorage();
			String choice = "";
			System.out.println("1. Lägg till ny personal i databasen");
			System.out.println("2. Ta bort personal ur databasen");
			System.out.println("3. Uppdatera status för personal");
			System.out.println("4. Look up a movie");
			System.out.println("5. Quit");
			while(!(choice.equals("1")||
					choice.equals("2")||
					choice.equals("3")||
					choice.equals("4")||
					choice.equals("5"))){
				choice = TextUtil.getReply("Your choice: ");
			}
			switch(choice){
			case "1":
				Personnel p = new Personnel("Harry","Hare",201,"A","Ledig","S");
				storage.addPersonnel(p);
				break;
			case "2":
				Personnel h = new Personnel("Harry","Hare",201,"A","Ledig","S");
				storage.deletePersonnel(h);
				break;
			case "3":
				Personnel q = new Personnel("Harry", "Hare",201,"A","Semester","S");
				storage.updateStatusPersonnel(q);
				break;
			case "4":
				String movie = TextUtil.getReply("Movie title: ");
				System.out.println("The actors in " + movie + " are:");
				//System.out.println(storage.getActorsByMovieTitle(movie));
				break;
			case "5":
				System.out.println(" Bye ");
				return;
			}
		}
	}
}
