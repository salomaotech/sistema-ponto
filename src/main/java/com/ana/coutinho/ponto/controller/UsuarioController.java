package com.ana.coutinho.ponto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ana.coutinho.ponto.model.Usuario;
import com.ana.coutinho.ponto.repository.UsuarioRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ModelAndView cadastrar(@ModelAttribute Usuario usuario, HttpSession session) {

        Optional<Usuario> usuarOptional = repository.findByEmail(usuario.getEmail());
        ModelAndView mv;

        // Usuário existe
        if (!usuarOptional.isEmpty()) {

            session.setAttribute("mensagemUsuarioExiste", "Já existe um usuário com este e-mail!");
            mv = new ModelAndView("redirect:/tela/cadastro_usuario");

        } else {

            // Usuário não existe, crie um novo
            repository.save(usuario);
            mv = new ModelAndView("redirect:/tela/login");

        }

        return mv;

    }

}
