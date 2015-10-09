package com.itboxlab.mvcmongodb.controller;

/**
 * Created by Tkaewkunha on 10/5/15 AD.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("station")
public class StationController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Sun of bitch it work for User Station");
        return "hello";
    }
}
