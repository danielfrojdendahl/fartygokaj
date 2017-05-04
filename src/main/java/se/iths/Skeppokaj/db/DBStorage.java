package se.iths.Skeppokaj.db;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
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
  private static Connection con;
  static{ // Will run once, when this class is loaded
    try{
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:movies.db");
    }catch(ClassNotFoundException|SQLException e){
      System.err.println("Exception getting movies: " + e.getMessage());
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
