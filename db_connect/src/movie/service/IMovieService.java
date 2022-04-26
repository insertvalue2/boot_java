package movie.service;

import java.util.List;

import movie.dto.RequestMovie;
import movie.dto.ResPonseMovie;

public interface IMovieService {

	List<ResPonseMovie> selectAllMovieInfo();
	List<ResPonseMovie> selectMovieByMovieName(String movieName);
	boolean insertMovie(RequestMovie req); 
	void updateMovie(String oldName, String newName); 
	void deleteMovie(int movieId); 
	
}
