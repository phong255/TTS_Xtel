package dev.lephong.movies.Services;

import dev.lephong.movies.Collections.Movie;
import dev.lephong.movies.Repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieRepository movieRepository;
    @Override
    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getSingleMovie(ObjectId id) {
        return movieRepository.findById(id);
    }

    @Override
    public Optional<Movie> getMovieByImdbId(String imdbId) {
        return movieRepository.getMovieByImdbId(imdbId);
    }
}
