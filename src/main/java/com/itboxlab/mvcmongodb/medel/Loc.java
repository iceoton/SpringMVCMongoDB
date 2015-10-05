package com.itboxlab.mvcmongodb.medel;

/**
 * Created by Tkaewkunha on 9/29/15 AD.
 */
public class Loc {
    private String type;
    private String coordinates[];

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String[] coordinates) {
        this.coordinates = coordinates;
    }
}
