package dev.lhphong.bankapi.CacheConfig;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

public class BankCache {
    private static Cache instance;
    private BankCache(){
    }
    public static Cache getInstance(){
        if(instance == null){
            Cache< Class, Class> cache = Caffeine.newBuilder()
                    .expireAfterWrite(10, TimeUnit.MINUTES)
                    .maximumSize(100)
                    .build();
            instance = cache;
        }
        return instance;
    }

    //Check xem object co khoa key da duoc luu vao cache chua
    public static boolean exist(String key){
        if(instance != null && instance.getIfPresent(key) != null)
            return true;
        return false;
    }
}
