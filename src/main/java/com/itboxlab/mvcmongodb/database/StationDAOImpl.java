package com.itboxlab.mvcmongodb.database;

import com.itboxlab.mvcmongodb.medel.Station;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * Created by jaturon on 9/28/2015 AD.
 */
public class StationDAOImpl implements StationDAO {

    private MongoOperations mongoOps;
    private static final String STATION_COLLECTION = "stations";

    public StationDAOImpl(MongoTemplate mongoOps) {
        this.mongoOps = mongoOps;
    }

    @Override
    public void addStation(Station station) {
        this.mongoOps.insert(station, STATION_COLLECTION);
    }

    @Override
    public Station readById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));

        return this.mongoOps.findOne(query, Station.class, STATION_COLLECTION);
    }
}
