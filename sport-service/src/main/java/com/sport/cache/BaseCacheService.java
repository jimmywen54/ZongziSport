package com.sport.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

/**
 * Created by wzm on 2016/7/19.
 */
@Service
public abstract class BaseCacheService<T> {
    @Autowired
    private CacheManager cacheManager;

    public abstract T getObject();

    public abstract String getCacheName();

    public abstract String getKey();

    public void put() {
        Cache cache = getValidCache();
        cache.put(getKey(), getObject());
    }

    public T getCache() {
        Cache cache = getValidCache();
        Cache.ValueWrapper wrapper = cache.get(getKey());
        return (T)wrapper;
    }

    private Cache getValidCache() {
        Cache cache = cacheManager.getCache(getCacheName());
        if (cache == null) {
            throw new IllegalArgumentException("The cache name is error");
        }
        return cache;
    }
}
