package com.sport.persist.dao.mongo.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCursor;
import com.sport.core.util.DozerBeanMapperWrapper;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public final class MongoAssembler {
	static ObjectMapper mapper = new ObjectMapper();

	public static Document toDocument(Object obj) {
		Document doc = mapper.convertValue(obj, Document.class);
		return doc;
	}

	public static List<Document> toDocuments(List<?> objs) {
		List<Document> docs = new ArrayList<Document>();
		for (Object obj : objs) {
			docs.add(toDocument(obj));
		}
		return docs;
	}
	
	public static <T> T fromDocument(Document doc, T t) {
		DozerBeanMapperWrapper.copy(doc, t);
		return t;
	}

	public static <T> List<T> fromDocuments(List<Document> dbObjs, Class<T> clazz){
		List<T> objs = new ArrayList<T>();
		try {
			for (Document dbObj : dbObjs) {
				objs.add(fromDocument(dbObj, clazz.newInstance()));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		return objs;
	}
	
	public static <T> List<T> fromDocuments(MongoCursor<Document> iterator, Class<T> clazz){
		List<T> objs = new ArrayList<T>();
		try {
			while (iterator.hasNext()) {
				objs.add(fromDocument(iterator.next(), clazz.newInstance()));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 	
		return objs;
	}
}
