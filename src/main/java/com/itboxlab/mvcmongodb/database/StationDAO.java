package com.itboxlab.mvcmongodb.database;

import com.itboxlab.mvcmongodb.medel.Station;

/**
 * Created by jaturon on 9/28/2015 AD.
 */
public interface StationDAO {
    public void addStation(Station station);

    public Station readById(String id);
}
