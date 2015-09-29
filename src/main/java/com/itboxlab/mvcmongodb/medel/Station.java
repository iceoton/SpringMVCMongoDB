package com.itboxlab.mvcmongodb.medel;

import org.springframework.data.annotation.Id;
/**
 * Created by jaturon on 9/28/2015 AD.
 */
public class Station {

    @Id
    private String id;

    private String name_th;
    private String name_en;
    private String category;
    private Loc loc;
    private String street_th;
    private String street_en;
    private String photo[];

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_th() {
        return name_th;
    }

    public void setName_th(String name_th) {
        this.name_th = name_th;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Loc getLoc() {
        return loc;
    }

    public void setLoc(Loc loc) {
        this.loc = loc;
    }

    public String getStreet_th() {
        return street_th;
    }

    public void setStreet_th(String street_th) {
        this.street_th = street_th;
    }

    public String getStreet_en() {
        return street_en;
    }

    public void setStreet_en(String street_en) {
        this.street_en = street_en;
    }

    public String[] getPhoto() {
        return photo;
    }

    public void setPhoto(String[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "name_th = " + name_th;
    }

    public String toJsonString(){
        String jsonStr = "";
        return null;
    }
}
