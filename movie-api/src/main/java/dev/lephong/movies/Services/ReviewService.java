package dev.lephong.movies.Services;

import dev.lephong.movies.Collections.Review;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    public Review createReview(String reviewBody,String imdbId);
}
