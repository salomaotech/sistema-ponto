package com.ana.coutinho.ponto.controller;

import com.ana.coutinho.ponto.model.Ponto;
import com.ana.coutinho.ponto.repository.PontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ponto")
public class PontoController {

    @Autowired
    private PontoRepository repository;

    @PostMapping
    public String save(@ModelAttribute Ponto ponto) {

        repository.save(ponto);
        return "redirect:/tela/cadastro_ponto/" + ponto.getId_registro();

    }

}
