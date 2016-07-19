package com.sport.service;

import com.sport.persist.gen.dao.db.mapper.SportTypeMapper;
import com.sport.persist.gen.dao.db.model.SportType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wzm on 2016/7/19.
 */
@Service
public class SportTypeService {
    @Autowired
    private SportTypeMapper sportTypeMapper;

    @Autowired
    private CacheManager cacheManager;

    public List<SportType> queryAll() throws Exception {
        return sportTypeMapper.selectByExample(null);
    }

    public int insert(SportType sportType) throws Exception {
        return sportTypeMapper.insert(sportType);
    }
}
