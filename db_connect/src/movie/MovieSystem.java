package movie;

import java.util.List;

import movie.dto.RequestMovie;
import movie.service.MovieService;

public class MovieSystem {
	
	public static void main(String[] args) {
	
		// 테스트 코드 
		MovieService movieService = new MovieService(); 
		//System.out.println(movieService.selectAllMovieInfo());
		
		//List temp =  movieService.selectMovieByMovieName("엽기적인");
		//System.out.println(temp.toString());
//		RequestMovie requestMovie = new RequestMovie(); 
//		requestMovie.set영화이름("기생충1");
//		requestMovie.set개봉연도(2020);
//		requestMovie.set관객수(12500000);
//		requestMovie.set평점(9.15);
//		// 배우 이름 
//		requestMovie.set배우이름("최우식");
//		requestMovie.set역("기우");
//		movieService.insertMovie(requestMovie);
//		movieService.updateMovie("기생충", "기생충2");
		
		
		movieService.deleteMovie(15);
		
		movieService.close();
		
	}
}
