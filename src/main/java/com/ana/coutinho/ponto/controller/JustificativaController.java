package com.ana.coutinho.ponto.controller;

import com.ana.coutinho.ponto.repository.JustificativaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/justificativa")
public class JustificativaController {

    private JustificativaRepository repository;

}
