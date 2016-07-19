package com.sport.persist.dao.mongo;

import com.google.common.collect.Lists;
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component("mongoDBService")
@Scope("singleton")
public class MongoDBService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MongoDBService.class);

	private static final String TAG_DB = "sport";

	private MongoClient mongoClient = null;

	@Value("${mongodb.servers}")
	private String mongodbServers;
	@Value("${mongodb.act.userName}")
	private String userName;
	@Value("${mongodb.act.password}")
	private String password;
	@Value("${mongodb.connections}")
	private int connections;
	@Value("${mongodb.maxWaitTime}")
	private int maxWaitTime;
	@Value("${mongodb.socketTimeout}")
	private int socketTimeout;
	/**
	 * 初始化连接池，设置参数。
	 */
	@PostConstruct
	public void init() {
		try {
			MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
			builder.connectionsPerHost(connections);
			builder.maxWaitTime(maxWaitTime);
			builder.socketTimeout(socketTimeout);
			builder.connectTimeout(socketTimeout);
			builder.writeConcern(WriteConcern.UNACKNOWLEDGED);
			builder.readPreference(ReadPreference.secondaryPreferred());
			MongoClientOptions options = builder.build();
			if(StringUtils.isBlank(userName)){
				mongoClient = new MongoClient(parseServers(mongodbServers), options);
			}else{
				MongoCredential credential = MongoCredential.createCredential(userName, TAG_DB, password.toCharArray());
				mongoClient = new MongoClient(parseServers(mongodbServers), Lists.newArrayList(credential), options);
			}
			LOGGER.info("MongoDBService inited....");
		} catch (MongoException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	private List<ServerAddress> parseServers(String servers) {
		List<ServerAddress> serverAddresses = Lists.newArrayList();
		if (StringUtils.isEmpty(mongodbServers)) {
			return serverAddresses;
		}
		String[] serverArray = mongodbServers.split(",");
		for (String server : serverArray) {
			serverAddresses.add(new ServerAddress(server));
		}
		return serverAddresses;
	}

	public MongoDatabase getTagDatabase(){
		return getDatabase(TAG_DB);
	}
	
	public MongoDatabase getDatabaseWithWriteUnSafe(String dbName){
		MongoDatabase db = getDatabase(dbName);
		return db;
	}
	
	public MongoDatabase getDatabase(String dbName){
		if(mongoClient == null) {
			init();
		}
		return mongoClient.getDatabase(dbName);
	}

}
