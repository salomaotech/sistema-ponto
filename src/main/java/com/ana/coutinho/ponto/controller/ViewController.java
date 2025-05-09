package com.ana.coutinho.ponto.controller;

import com.ana.coutinho.ponto.model.Funcionarios;
import com.ana.coutinho.ponto.model.Justificativa;
import com.ana.coutinho.ponto.model.Ponto;
import com.ana.coutinho.ponto.model.Turnos;
import com.ana.coutinho.ponto.model.Usuario;
import com.ana.coutinho.ponto.repository.FuncionariosRepository;
import com.ana.coutinho.ponto.repository.JustificativaRepository;
import com.ana.coutinho.ponto.repository.PontoRepository;
import com.ana.coutinho.ponto.repository.TurnosRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tela")
public class ViewController {

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @Autowired
    private TurnosRepository turnosRepository;

    @Autowired
    private JustificativaRepository justificativaRepository;

    @Autowired
    private PontoRepository pontoRepository;

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

    @GetMapping("/pesquisa_funcionario")
    public ModelAndView pesquisar(@RequestParam(value = "cpf", required = false) String cpf) {

        ModelAndView mv = new ModelAndView("pesquisa_funcionario");

        if (cpf != null && !cpf.isEmpty()) {

            // Usando o método com LIKE
            List<Funcionarios> funcionarios = funcionariosRepository.findByCpfContaining(cpf);

            if (!funcionarios.isEmpty()) {

                mv.addObject("resultados", funcionarios);

            } else {

                mv.addObject("resultados", List.of()); // Se não encontrar, retorna lista vazia

            }

        } else {

            mv.addObject("resultados", funcionariosRepository.findAll());

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

    @GetMapping("/pesquisa_turno")
    public ModelAndView pesquisarTurno() {

        ModelAndView mv = new ModelAndView("pesquisa_turno");
        mv.addObject("turnos", turnosRepository.findAll());
        return mv;

    }

    @GetMapping("/cadastro_justificativa")
    public ModelAndView cadastroJustificativa() {

        ModelAndView mv = new ModelAndView("cadastro_justificativa");
        mv.addObject("justificativa", new Justificativa());
        mv.addObject("listaFuncionarios", funcionariosRepository.findAll());
        return mv;

    }

    @GetMapping("/cadastro_justificativa/{id}")
    public ModelAndView abreCadastroJustificativa(@PathVariable("id") long id) {

        Optional<Justificativa> cadastro = justificativaRepository.findById(id);
        ModelAndView mv = new ModelAndView("cadastro_justificativa");

        // Verificar se a justificativa existe
        if (cadastro.isPresent()) {

            mv.addObject("justificativa", cadastro.get());
        } else {

            mv.addObject("justificativa", new Justificativa());

        }

        // Passar a lista de funcionários para o select
        mv.addObject("listaFuncionarios", funcionariosRepository.findAll());

        return mv;

    }

    @GetMapping("/pesquisa_justificativa")
    public ModelAndView pesquisarJustificativa() {

        ModelAndView mv = new ModelAndView("pesquisa_justificativa");
        mv.addObject("listaFuncionarios", funcionariosRepository.findAll());
        mv.addObject("justificativas", justificativaRepository.findAll());
        return mv;

    }

    @GetMapping("/cadastro_ponto")
    public ModelAndView cadastroPonto() {

        ModelAndView mv = new ModelAndView("cadastro_ponto");
        mv.addObject("ponto", new Ponto());
        mv.addObject("listaFuncionarios", funcionariosRepository.findAll());
        return mv;

    }

    @GetMapping("/cadastro_ponto/{id}")
    public ModelAndView abreCadastroPonto(@PathVariable("id") long id) {

        Optional<Ponto> cadastro = pontoRepository.findById(id);
        ModelAndView mv = new ModelAndView("cadastro_ponto");

        if (cadastro.isPresent()) {

            mv.addObject("ponto", cadastro.get());

        } else {

            mv.addObject("ponto", new Ponto());

        }

        mv.addObject("listaFuncionarios", funcionariosRepository.findAll());
        return mv;

    }

    @GetMapping("/pesquisa_ponto")
    public ModelAndView pesquisarPonto(@RequestParam(value = "idFuncionario", required = false) Long idFuncionario,
            @RequestParam(value = "data", required = false) String data) {

        ModelAndView mv = new ModelAndView("pesquisa_ponto");
        LocalDate dataFormatada = null;

        // Carrega todos os funcionários
        mv.addObject("listaFuncionarios", funcionariosRepository.findAll());

        if (idFuncionario == null && (data == null || data.isEmpty())) {

            // Se ambos idFuncionario e data não forem passados, carrega todos os pontos
            mv.addObject("pontos", pontoRepository.findAll());

        } else if (idFuncionario != null && (data == null || data.isEmpty())) {

            // Se apenas o idFuncionario for passado
            mv.addObject("pontos", pontoRepository.buscarPorFuncionarioEData(idFuncionario, null));

        }

        else if (data != null && !data.isEmpty() && (idFuncionario == null)) {

            // Se apenas a data for passada
            LocalDate localDate = LocalDate.parse(data);
            mv.addObject("pontos", pontoRepository.buscarPorFuncionarioEData(null, localDate));

        } else {

            // Se ambos idFuncionario e data forem passados
            LocalDate localDate = LocalDate.parse(data);
            mv.addObject("pontos", pontoRepository.buscarPorFuncionarioEData(idFuncionario, localDate));

        }

        // Converter o parâmetro 'data' para LocalDate (caso necessário)
        if (data != null && !data.isEmpty()) {

            try {

                dataFormatada = LocalDate.parse(data);

            } catch (Exception e) {

            }

        }

        mv.addObject("data", dataFormatada);
        mv.addObject("idFuncionario", idFuncionario);
        return mv;

    }

    @GetMapping("/login")
    public ModelAndView login(HttpSession session) {

        ModelAndView mv;

        if (session.getAttribute("usuarioLogado") == null) {

            // Usuário NÃO logado
            mv = new ModelAndView("login");
            mv.addObject("mensagemLogin", session.getAttribute("mensagemLogin"));
            mv.addObject("usuario", new Usuario());

        } else {

            // Usuário logado
            mv = new ModelAndView("redirect:/tela/home");

        }

        return mv;

    }

    @GetMapping("/cadastro_usuario")
    public ModelAndView cadastroUsuario(HttpSession session) {

        ModelAndView mv = new ModelAndView("cadastro_usuario");
        mv.addObject("mensagemUsuarioExiste", session.getAttribute("mensagemUsuarioExiste"));
        mv.addObject("usuario", new Usuario());
        return mv;

    }

}
