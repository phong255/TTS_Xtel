package dev.lephong.movies.Services;

import dev.lephong.movies.Models.Movie;
import dev.lephong.movies.Models.Review;
import dev.lephong.movies.Repositories.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@CacheConfig(cacheNames = "review")
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    MongoTemplate mongoTemplate;
    @CachePut(condition = "#reviewBody != null && #imdbId != null") // Dieu kien khac null truoc khi ghi vao cache
    @Override
    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));
        log.info("Insert new review: {}" + review);
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        if(log.isDebugEnabled()){
            log.debug("Update movie.");
        }
        return review;
    }
}
