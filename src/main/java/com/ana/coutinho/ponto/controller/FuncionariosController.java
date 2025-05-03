package com.ana.coutinho.ponto.controller;

import com.ana.coutinho.ponto.repository.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funcionario")
public class FuncionariosController {

    @Autowired
    private FuncionariosRepository repository;


}
