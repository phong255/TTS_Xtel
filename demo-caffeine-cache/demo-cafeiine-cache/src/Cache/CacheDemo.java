package Cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

public class CacheDemo{
    private static Cache instance;

    private CacheDemo(){};
    public static  Cache getInstance(){ //Tao, config cache duy nhat trong chuong trinh
        if(instance == null){
            Cache<Object,Object> cache = Caffeine.newBuilder()
                    .expireAfterWrite(5, TimeUnit.MINUTES)
                    .maximumSize(100)
                    .build();
            instance = cache;
        }
        return instance;
    }
}
