package dev.lephong.movies.Services;

import dev.lephong.movies.Models.Movie;
import dev.lephong.movies.Repositories.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@CacheConfig(cacheNames = "movie") // Cache movie da duoc config
public class MovieServiceImpl implements MovieService{
    @Autowired
    MovieRepository movieRepository;
    @Cacheable(unless = "#result == null") // dieu kien khac null truoc khi lay du lieu
    @Override
    public List<Movie> getAllMovie() {
        log.info("Get all movies.");
        return movieRepository.findAll();
    }
    @Cacheable(key = "#id",unless = "#result == null")
    @Override
    public Optional<Movie> getSingleMovie(ObjectId id) {
        Optional<Movie> movie = movieRepository.findById(id);
        log.info("Get movie: {} by Id: {}",movie.get().getTitle(),id);
        return movie;
    }
    @Cacheable(key = "#imdbId",unless = "#result == null")
    @Override
    public Optional<Movie> getMovieByImdbId(String imdbId) {
        Optional<Movie> movie = movieRepository.getMovieByImdbId(imdbId);
        log.info("Get movie: {} by imdbId: {}",movie.get().getTitle(),imdbId);
        return movie;
    }
    @Caching(evict = {@CacheEvict(value = "movie",allEntries = true), @CacheEvict(value = "review",allEntries = true)})
    @Override
    public void clearAllCaches() {
        log.info("Clear all caches!");
    }
}
