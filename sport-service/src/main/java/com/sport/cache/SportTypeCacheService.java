package com.sport.cache;

import com.sport.common.constant.EhCacheConstant;
import com.sport.common.constant.EhCacheKey;
import com.sport.persist.gen.dao.db.model.SportType;
import com.sport.service.SportTypeService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by wzm on 2016/7/19.
 */
@Service
public class SportTypeCacheService extends BaseCacheService {
    @Autowired
    private SportTypeService sportTypeService;

    private Logger LOG = getLogger(SportTypeCacheService.class);

    @Override
    public List getObject() {
        try {
            List<SportType> sportTypes = sportTypeService.queryAll();
            return sportTypes;
        } catch (Exception e) {
            LOG.warn("sportTypeService.queryAll occur error ", e);
        }
        return new ArrayList(0);
    }

    @Override
    public String getCacheName() {
        return EhCacheConstant.SPORT_TYPE;
    }

    @Override
    public String getKey() {
        return EhCacheKey.SPORT_TYPE_ALL;
    }
}
