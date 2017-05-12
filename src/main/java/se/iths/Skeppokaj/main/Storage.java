package se.iths.Skeppokaj.main;
import java.util.List;

import se.iths.Skeppokaj.domain.Personnel;

//import se.iths.domain.Movie;
//import se.iths.domain.Actor;

public interface Storage{
	public void addPersonnel(Personnel p);
	public void deletePersonnel(Personnel p);
	public void updateStatusPersonnel(Personnel p);
//  public List<Movie>getMoviesByActorName(String actorName);
//  public List<Actor>getActorsByMovieTitle(String title);
//  public List<Movie>getAllMovies();
//  public List<Actor>getAllActors();
}