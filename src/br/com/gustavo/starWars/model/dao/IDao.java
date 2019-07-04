package br.com.gustavo.starWars.model.dao;

import com.mongodb.DBObject;

import java.util.List;
import java.util.Map;

/**
 * Interface of funcionalities
 * 
 * @author gustavo
 *
 */
public interface IDao {

	void save(Map<String, Object> mapEntity);

	void update(Map<String, Object> mapQuery, Map<String, Object> mapEntity);

	void delete(Map<String, Object> mapEntity);

	DBObject findOne(Map<String, Object> mapEntity);

	List<DBObject> findAll();

	List<DBObject> findKeyValue(Map<String, Object> keyValue);

}