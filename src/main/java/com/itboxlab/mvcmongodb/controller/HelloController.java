package com.itboxlab.mvcmongodb.controller;

import com.itboxlab.mvcmongodb.database.StationDAO;
import com.itboxlab.mvcmongodb.functions.Userfunction;
import com.itboxlab.mvcmongodb.medel.Loc;
import com.itboxlab.mvcmongodb.medel.Station;
import com.itboxlab.mvcmongodb.medel.User;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class HelloController {
    Userfunction userfn = new Userfunction();
    /*public static final String DB_NAME = "test";
    public static final String STATION_COLLECTION = "stations";
    public static final String MONGO_HOST = "localhost";
    public static final int MONGO_PORT = 27017;*/

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        User usr = userfn.getUserByUsername("user") ;
        usr.setEmail("TEEEEETTTsss");
        userfn.updateUser(usr);
        model.addAttribute("message", "Sun of bitch work for Hello ontroller");
        return "hello";
    }

    @RequestMapping(value="/test")
    @ResponseBody
    public Station printMethod2(ModelMap model){

        return getStationById("55f27eb30bd410106f005549");
    }

    private String addStation(){
        Station st = new Station();
        st.setName_th("ชื่อภาษาไทย");
        st.setName_en("name English");
        st.setCategory("TestCate");

        Loc loc = new Loc();
        loc.setType("Loc type");
        loc.setCoordinates(new String[]{"1231243", "1231231"});
        st.setLoc(loc);

        st.setStreet_th("ชื่อถนน");
        st.setStreet_en("Street name");
        st.setPhoto(new String[]{"",""});

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        StationDAO stationDAO = ctx.getBean("stationDAO", StationDAO.class);
        Station station = stationDAO.addStation(st);
        ctx.close();

        return station.getId();

    }
    private ArrayList<Station> readAllStation(){

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        StationDAO stationDAO = ctx.getBean("stationDAO", StationDAO.class);
        ArrayList<Station> stations = stationDAO.getAllStations();
        ctx.close();
        return stations;
    }

    private boolean removeStationById(String id){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        StationDAO stationDAO = ctx.getBean("stationDAO", StationDAO.class);
        int result = stationDAO.reMoveStationById(id);
        ctx.close();
        System.out.print("Result = " + result);
        if(result==0) {
            return false;
        }else{
            return true;
        }

    }
    private void updateStation(Station station){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        StationDAO stationDAO = ctx.getBean("stationDAO", StationDAO.class);
        stationDAO.updateStation(station);
    }

    private Station getStationById(String id ) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        StationDAO stationDAO = ctx.getBean("stationDAO", StationDAO.class);
        Station s = stationDAO.getStationById(id);
        ctx.close();

        return s;
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
        Station s = stationDAO.getStationById("55f27eb30bd410106f005549");
        ctx.close();

        return s.toString();
    }

    private String converseObjectToJson(Object object){
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = null;
        try {
            json = ow.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;

    }




}