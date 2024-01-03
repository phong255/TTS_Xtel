package dev.lephong.movies.Configurations;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class CacheJavaConfig {
    @Bean
    public CacheManager cacheManager(){
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("movie","review");
        cacheManager.setCaffeine(caffeineCacheBuider());
        cacheManager.setAllowNullValues(false);
        return cacheManager;
    }

    //Config cho cache manager
    Caffeine<Object, Object> caffeineCacheBuider(){
        return Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(500)
                .expireAfterAccess(2, TimeUnit.MINUTES)
                .weakKeys()
                .recordStats();
    }
}
