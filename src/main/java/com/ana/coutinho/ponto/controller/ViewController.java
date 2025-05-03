package com.ana.coutinho.ponto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {


    @GetMapping("/home")
    public ModelAndView home() {

        ModelAndView mv = new ModelAndView("home");
        return mv;

    }

    @GetMapping("/cadastro")
    public ModelAndView cadastro() {

        ModelAndView mv = new ModelAndView("cadastro");
        return mv;

    }

}
