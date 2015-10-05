package com.itboxlab.mvcmongodb.database;

import com.itboxlab.mvcmongodb.medel.Station;
import com.mongodb.WriteResult;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;

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
    public Station addStation(Station station) {
        this.mongoOps.insert(station, STATION_COLLECTION);
        return station;
    }

    @Override
    public Station getStationById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return this.mongoOps.findOne(query, Station.class, STATION_COLLECTION);
    }

    @Override
    public ArrayList<Station> getAllStations() {
        ArrayList<Station> stations = (ArrayList<Station>) this.mongoOps.findAll(Station.class,STATION_COLLECTION);
        return stations;
    }

    @Override
    public int reMoveStationById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        WriteResult result = this.mongoOps.remove(query, Station.class, STATION_COLLECTION);
        return result.getN();
    }

    @Override
    public void updateStation(Station station) {

        this.mongoOps.save(station, STATION_COLLECTION);
    }
}
