package com.sport.persist.dao.mongo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.sport.persist.dao.mongo.model.MongoAssembler;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzm on 2016/6/17.
 */
@Service
public class TestDao {
	
	private final String ANCHOR_COLLECTION = "test";

	private static Logger LOG = LoggerFactory.getLogger(TestDao.class);

	@Resource
	private MongoDBService mongoDBService;

	private MongoCollection<Document> anchorCn;

	@PostConstruct
	public void init() {
		anchorCn = mongoDBService.getTagDatabase().getCollection(ANCHOR_COLLECTION);
		/*IndexOptions indexOptions = new IndexOptions().unique(true);
		anchorCn.createIndex(new BasicDBObject(ANCHOR_ID, 1).append(TAG_NAME, 1), indexOptions);
		anchorCn.createIndex(new BasicDBObject(ANCHOR_ID, 1).append("count", 1));*/
	}

	
	public List<String> find() {
		FindIterable<Document> documents = anchorCn.find();
		MongoCursor<Document> iterator = documents.iterator();
		List<String> list = MongoAssembler.fromDocuments(iterator, String.class);
		/*List<String> list = new ArrayList();
		MongoCursor<Document> iterator = documents.iterator();
		while (iterator.hasNext()) {
			Document next = iterator.next();
			String name = (String)next.get("name");
			list.add(name);
		}*/
		return list;
	}

}
