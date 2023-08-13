package com.ibrahimbayburtlu.spirngboot.demosecurity.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("showMyLoginPage")
    public String showMyLoginPage(){
        return "plain-login";
    }

    // add request mapping for /access-denied
    @GetMapping("access-denied")
    public String showMyAcessDenied(){
        return "access-denied";
    }
}
