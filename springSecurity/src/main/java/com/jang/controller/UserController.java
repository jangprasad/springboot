package com.jang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/home")
    public String getHome()
    {
        return "home";
    }



    @GetMapping("/admin/home")
    public String getAdminHome()
    {
        return "admin_home";
    }

    @GetMapping("/user/home")
    public String getUserHome()
    {
        return "user_home";
    }


}
