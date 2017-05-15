package se.iths.Skeppokaj.main;
import java.util.List;

import se.iths.Skeppokaj.domain.Personnel;

//import se.iths.domain.Movie;
//import se.iths.domain.Actor;

public interface Storage{
	public boolean addPersonnel(Personnel p);
	public boolean deletePersonnel(Personnel p);
	public boolean updateStatusPersonnel(Personnel p);
	public List<Personnel> getPersonnelByID(int persID);
//  public List<Movie>getMoviesByActorName(String actorName);
//  public List<Actor>getActorsByMovieTitle(String title);
//  public List<Movie>getAllMovies();
//  public List<Actor>getAllActors();
}
