package dev.myweb.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired //MovieRepo is a interface so u need to initialize but autowire will tell the framework to instantiate it ofr you
    private MovieRepository movieRepository;

    public List<Movie> AllMovies() {
    return movieRepository.findAll();
    }

    public Optional<Movie> SingleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }


}
