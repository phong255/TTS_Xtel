package dev.lephong.movies.Controllers;

import dev.lephong.movies.Collections.Movie;
import dev.lephong.movies.Services.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> allMovies(){
        return new ResponseEntity<>(movieService.getAllMovie(), HttpStatus.OK);
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
//        return new ResponseEntity<>(movieService.getSingleMovie(id),HttpStatus.OK);
//    }
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String imdbId){
        return new ResponseEntity<>(movieService.getMovieByImdbId(imdbId),HttpStatus.OK);
    }
}
