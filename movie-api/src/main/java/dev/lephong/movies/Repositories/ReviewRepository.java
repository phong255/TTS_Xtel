package dev.lephong.movies.Repositories;

import dev.lephong.movies.Models.Review;
import org.bson.types.ObjectId;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
