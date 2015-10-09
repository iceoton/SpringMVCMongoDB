package com.itboxlab.mvcmongodb.controller;

import com.itboxlab.mvcmongodb.functions.Userfunction;
import com.itboxlab.mvcmongodb.medel.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by Tkaewkunha on 10/5/15 AD.
 */
@Controller
@RequestMapping("user")
public class UserController {
    Userfunction userfn = new Userfunction();

    @RequestMapping(value ="adduser",method = RequestMethod.POST,produces={"application/json"})
    @ResponseBody
    public String addUser2(@RequestBody String json) {
        JSONObject jsonObject = new JSONObject(json);
        String a = jsonObject.getString("test");
        return a;

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
