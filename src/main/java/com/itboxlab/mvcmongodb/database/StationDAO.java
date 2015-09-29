package com.itboxlab.mvcmongodb.database;

import com.itboxlab.mvcmongodb.medel.Station;

import java.util.ArrayList;

/**
 * Created by jaturon on 9/28/2015 AD.
 */
public interface StationDAO {
    public Station addStation(Station station);

    public Station getStationById(String id);

    public ArrayList<Station> getAllStations();

    public int reMoveStationById(String id);

    public void updateStation(Station station);
}
