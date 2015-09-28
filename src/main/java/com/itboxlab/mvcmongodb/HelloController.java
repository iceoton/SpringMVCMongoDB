package com.itboxlab.mvcmongodb;

import com.itboxlab.mvcmongodb.database.StationDAO;
import com.itboxlab.mvcmongodb.medel.Station;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
    /*public static final String DB_NAME = "test";
    public static final String STATION_COLLECTION = "stations";
    public static final String MONGO_HOST = "localhost";
    public static final int MONGO_PORT = 27017;*/

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        String msg = connectToDatabase();
        model.addAttribute("message", msg);
        return "hello";
    }

    private String connectToDatabase() {
        /*List<Station> stations = new ArrayList<Station>();
        try {
            MongoClient mongo = new MongoClient(MONGO_HOST, MONGO_PORT);
            MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);

            stations = mongoOps.findAll(Station.class, STATION_COLLECTION);

            mongo.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        */
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        StationDAO stationDAO = ctx.getBean("stationDAO", StationDAO.class);
        Station s = stationDAO.readById("5608ce3448297ce911aec250");
        ctx.close();

        return s.toString();
    }


}