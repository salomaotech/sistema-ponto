package com.ana.coutinho.ponto.controller;

import com.ana.coutinho.ponto.model.Turnos;
import com.ana.coutinho.ponto.repository.TurnosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/turno")
public class TurnosController {

    @Autowired
    private TurnosRepository repository;

    @PostMapping
    public String save(@ModelAttribute Turnos turnos){

        repository.save(turnos);
        return "redirect:/tela/cadastro_turno/" + turnos.getId_turno();

    }

}
