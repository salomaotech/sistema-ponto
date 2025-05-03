package com.ana.coutinho.ponto.controller;

import com.ana.coutinho.ponto.repository.TurnosRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/turno")
public class TurnosController {

    private TurnosRepository repository;

}
