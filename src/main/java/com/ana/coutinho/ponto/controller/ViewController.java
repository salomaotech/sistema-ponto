package com.ana.coutinho.ponto.controller;

import com.ana.coutinho.ponto.model.Funcionarios;
import com.ana.coutinho.ponto.model.Turnos;
import com.ana.coutinho.ponto.repository.FuncionariosRepository;
import com.ana.coutinho.ponto.repository.TurnosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/tela")
public class ViewController {

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @Autowired
    private TurnosRepository turnosRepository;

    @GetMapping("/home")
    public ModelAndView home() {

        ModelAndView mv = new ModelAndView("home");
        return mv;

    }

    @GetMapping("/cadastro_funcionario")
    public ModelAndView cadastro() {

        ModelAndView mv = new ModelAndView("cadastro_funcionario");
        mv.addObject("funcionario", new Funcionarios());
        return mv;

    }

    @GetMapping("/cadastro_funcionario/{id}")
    public ModelAndView abreCadastro(@PathVariable("id") long id) {

        Optional<Funcionarios> cadastro = funcionariosRepository.findById(id);
        ModelAndView mv = new ModelAndView("cadastro_funcionario");

        if (cadastro.isEmpty()) {

            mv.addObject("funcionario", new Funcionarios());

        } else {

            mv.addObject("funcionario", cadastro.get());

        }

        return mv;

    }

    @GetMapping("/cadastro_turno")
    public ModelAndView cadastroTurno() {

        ModelAndView mv = new ModelAndView("cadastro_turno");
        mv.addObject("turno", new Turnos());
        return mv;

    }

    @GetMapping("/cadastro_turno/{id}")
    public ModelAndView abreCadastroTurno(@PathVariable("id") long id) {

        Optional<Turnos> cadastro = turnosRepository.findById(id);
        ModelAndView mv = new ModelAndView("cadastro_turno");

        if (cadastro.isEmpty()) {

            mv.addObject("turno", new Turnos());

        } else {

            mv.addObject("turno", cadastro.get());

        }

        return mv;

    }


}
