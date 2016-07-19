package com.sport.schedule;

import com.sport.cache.SportTypeCacheService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by wzm on 2016/7/19.
 */
@Component
public class SportTypeCacheJob {
    @Autowired
    private SportTypeCacheService sportTypeCacheService;

    private Logger LOG = getLogger(SportTypeCacheJob.class);

    public void run() {
        LOG.warn("开始job");
        sportTypeCacheService.put();
    }
}
