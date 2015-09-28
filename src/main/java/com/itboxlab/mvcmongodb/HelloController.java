package com.itboxlab.mvcmongodb;

import com.itboxlab.mvcmongodb.medel.Stations;
import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {
    public static final String DB_NAME = "test";
    public static final String STATION_COLLECTION = "stations";
    public static final String MONGO_HOST = "localhost";
    public static final int MONGO_PORT = 27017;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        String msg = connectToDatabase();
        model.addAttribute("message", msg);
        return "hello";
    }

    private String connectToDatabase() {
        List<Stations> stations = new ArrayList<Stations>();
        try {
            MongoClient mongo = new MongoClient(MONGO_HOST, MONGO_PORT);
            MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);

            stations = mongoOps.findAll(Stations.class, STATION_COLLECTION);

            mongo.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return  stations.get(0).toString();
    }


}