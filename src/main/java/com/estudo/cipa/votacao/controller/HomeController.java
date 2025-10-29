package com.estudo.cipa.votacao.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
@Controller
public class HomeController {


    @GetMapping("/")
    public String home(){
        return "home";

    }

}
