package com.itboxlab.mvcmongodb.medel;

import org.springframework.data.annotation.Id;
/**
 * Created by jaturon on 9/28/2015 AD.
 */
public class Station {

    @Id
    private String id;

    private String name;
    private String category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return id + "=>name:" + name + "\ncategory:" + category;
    }
}
