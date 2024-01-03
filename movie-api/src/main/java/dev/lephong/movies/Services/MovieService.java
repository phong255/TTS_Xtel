package dev.lephong.movies.Services;

import dev.lephong.movies.Models.Movie;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {
    public List<Movie> getAllMovie();
    public Optional<Movie> getSingleMovie(ObjectId id);
    public Optional<Movie> getMovieByImdbId(String imdbId);
    public void clearAllCaches();
}
