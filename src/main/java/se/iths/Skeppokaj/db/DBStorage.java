package se.iths.Skeppokaj.db;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import se.iths.Skeppokaj.domain.Personnel;
//import org.iths.domain.Movie;
//import org.iths.domain.Actor;
import se.iths.Skeppokaj.main.Storage;

/**
 * This class should contain all methods that communicates with the database.
 * E.g add/delete/update personnel from database.
 * @author Kråkan
 *
 */
public class DBStorage implements Storage{

	//Change to your db name and path!
	private static final String PATH = "jdbc:sqlite:skeppokaj.db";
	private static Connection con;

	static{ // Will run once, when this class is loaded. Connection to db is initiated.
		try{
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(PATH);
		}catch(ClassNotFoundException|SQLException e){
			System.err.println("Exception getting connection: " + e.getMessage());
		}
	}

	//Do we have a connection?
	public boolean hasConnection(){
		return con != null;
	}

	//Method to add persons to the personnel db
	public void addPersonnel(Personnel p){
		
		if(hasConnection()){
			//Preparation of data to put in db
			Statement stm = null;
			String firstName = p.getFirstName();
			String lastName = p.getLastName();
			int persId = p.getPersId();
			String driversLicence = p.getDriversLicence();
			String status = p.getStatus();
			String schemaType = p.getSchemaType();
			
			try{
				//SQL-statement to insert data in db
				String sql = "INSERT INTO personal(p_id,Firstname,Lastname,License,Status,Schema) VALUES(" + persId + ",'" + firstName +
						"','" + lastName + "','"+ driversLicence + "','" + status + "','" + schemaType + "')";
				stm = con.createStatement();
				stm.executeUpdate(sql);
				System.out.println(firstName + " " + lastName +" has been successfully added.");
				
			}catch(SQLException e){
				System.out.println(e.toString());
				System.out.println("Can't add person " + firstName + " " + lastName +". Please check insert statement!");
			}
			//Alerts.display("Wrong" ,"date format incorrect");
		}
	}
	
	// SQL way - Using strings  - it's more efficient to use IDs however ;-)
	//  public List<Movie>getMoviesByActorName(String actorName){
	//    List<Movie> movies = new ArrayList<>();
	//    try{
	//      String sql = "select title, name from movies "+
	//        "natural join actors_movies natural join actors "+
	//        "where actors.name = '" + actorName +"'";
	//    
	//      ResultSet rs = con.createStatement().executeQuery(sql);
	//      while(rs.next()){
	//        Movie m = new Movie.MovieBuilder()
	//          .title(rs.getString("title"))
	//          .build();
	//        movies.add(m);
	//      }
	//    }catch(SQLException e){
	//      System.err.println("Error: " + e.getMessage());
	//      e.printStackTrace();
	//    }      
	//    return movies;
	//  }
	//  // SQL way - Using strings  - it's more efficient to use IDs however ;-)
	//  public List<Actor>getActorsByMovieTitle(String title){
	//    List<Actor> actors = new ArrayList<>();     
	//    try{
	//      con = DriverManager.getConnection("jdbc:sqlite:movies.db");
	//      String sql = "select title, name from movies "+
	//        "natural join actors_movies natural join actors "+
	//        "where movies.title = '" + title +"'";
	//    
	//      ResultSet rs = con.createStatement().executeQuery(sql);
	//      while(rs.next()){
	//        Actor a = new Actor.ActorBuilder()
	//          .name(rs.getString("name"))
	//          .build();
	//        actors.add(a);
	//      }
	//    }catch(SQLException e){
	//      System.err.println("Error: " + e.getMessage());
	//      e.printStackTrace();
	//    }
	//    return actors;
	//  }
	//  public List<Actor>getAllActors(){
	//    List<Actor>allActors = new ArrayList<>();
	//    try{
	//      ResultSet rs=con.createStatement().executeQuery("select name from actors");
	//      while(rs.next()){
	//        Actor a = new Actor.ActorBuilder()
	//          .name(rs.getString("name"))
	//          .build();
	//        allActors.add(a);
	//      }
	//    }catch(SQLException e){
	//      System.err.println("Error: " + e.getMessage());
	//      e.printStackTrace();
	//    }
	//    return allActors;
	//  }
	//  public List<Movie>getAllMovies(){
	//    List<Movie> allMovies = new ArrayList<>();
	//    try{
	//      ResultSet rs=con.createStatement().executeQuery("select title from movies");
	//      while(rs.next()){
	//        Movie m = new Movie.MovieBuilder()
	//          .title(rs.getString("title"))
	//          .build();
	//        allMovies.add(m);
	//      }
	//    }catch(SQLException e){
	//      System.err.println("Error: " + e.getMessage());
	//      e.printStackTrace();
	//    }
	//    return allMovies;
	//  }
}
