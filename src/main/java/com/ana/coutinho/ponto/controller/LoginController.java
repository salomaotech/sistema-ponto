package com.ana.coutinho.ponto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ana.coutinho.ponto.model.Usuario;
import com.ana.coutinho.ponto.repository.UsuarioRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public String logar(@ModelAttribute Usuario usuario, HttpSession session) {

        Optional<Usuario> usuarOptional = repository.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());

        if (!usuarOptional.isEmpty()) {

            session.setAttribute("usuarioLogado", usuarOptional.get());
            session.setAttribute("mensagemLogin", null);
            return "redirect:/tela/home";

        } else {

            session.setAttribute("mensagemLogin", "Login incorreto!!!");
            return "redirect:/tela/login";

        }

    }

}
