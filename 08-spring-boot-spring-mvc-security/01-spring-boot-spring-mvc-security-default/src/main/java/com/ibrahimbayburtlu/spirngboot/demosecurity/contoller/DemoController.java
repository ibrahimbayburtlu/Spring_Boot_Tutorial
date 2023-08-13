package com.ibrahimbayburtlu.spirngboot.demosecurity.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    // add a request mapping for /leaders
    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }

    // add a request mapping for /admins
    @GetMapping("/systems")
    public String showSystems(){
        return "systems";
    }

}
