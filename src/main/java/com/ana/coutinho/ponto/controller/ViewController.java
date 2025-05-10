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

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

        return new ModelAndView("redirect:/tela/painel_pesquisa_ponto");

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
    public ModelAndView pesquisarJustificativa(
            @RequestParam(value = "idFuncionario", required = false) Long idFuncionario,
            @RequestParam(value = "dataInicio", required = false) String dataInicioStr,
            @RequestParam(value = "dataFim", required = false) String dataFimStr) {

        ModelAndView mv = new ModelAndView("pesquisa_justificativa");
        List<Justificativa> justificativas = new ArrayList<>();

        mv.addObject("listaFuncionarios", funcionariosRepository.findAll());

        LocalDate dataInicio = null;
        LocalDate dataFim = null;

        try {

            if (dataInicioStr != null && !dataInicioStr.isEmpty()) {
                dataInicio = LocalDate.parse(dataInicioStr);
            }

            if (dataFimStr != null && !dataFimStr.isEmpty()) {
                dataFim = LocalDate.parse(dataFimStr);
            }

            // Se data final for nula, usa a data inicial
            if (dataInicio != null && dataFim == null) {
                dataFim = dataInicio;
            }

        } catch (Exception ignored) {

        }

        // Isto evita consultar todos os registros
        if (idFuncionario != null) {

            justificativas = justificativaRepository.buscarPorFiltros(idFuncionario, dataInicio, dataFim);

        }

        mv.addObject("justificativas", justificativas);
        mv.addObject("idFuncionario", idFuncionario);
        mv.addObject("dataInicio", dataInicio);
        mv.addObject("dataFim", dataFim);

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
    public ModelAndView pesquisarPonto(
            @RequestParam(value = "idFuncionario", required = false) Long idFuncionario,
            @RequestParam(value = "dataInicio", required = false) String dataInicioStr,
            @RequestParam(value = "dataFim", required = false) String dataFimStr) {

        ModelAndView mv = new ModelAndView("pesquisa_ponto");
        List<Ponto> pontos = new ArrayList<>();

        mv.addObject("listaFuncionarios", funcionariosRepository.findAll());

        LocalDate dataInicio = null;
        LocalDate dataFim = null;

        try {
            if (dataInicioStr != null && !dataInicioStr.isEmpty()) {
                dataInicio = LocalDate.parse(dataInicioStr);
            }
            if (dataFimStr != null && !dataFimStr.isEmpty()) {
                dataFim = LocalDate.parse(dataFimStr);
            }

            // Se data final for nula, use a mesma da data inicial
            if (dataInicio != null && dataFim == null) {
                dataFim = dataInicio;
            }

        } catch (Exception ignored) {
        }

        // Isto evita consultar todos os registros
        if (idFuncionario != null) {

            pontos = pontoRepository.buscarPorFiltros(idFuncionario, dataInicio, dataFim);

        }

        mv.addObject("pontos", pontos);
        mv.addObject("idFuncionario", idFuncionario);
        mv.addObject("dataInicio", dataInicio);
        mv.addObject("dataFim", dataFim);

        return mv;

    }

    @GetMapping("/painel_pesquisa_ponto")
    public ModelAndView pesquisarPainelPonto(
            @RequestParam(value = "idFuncionario", required = false) Long idFuncionario,
            @RequestParam(value = "dataInicio", required = false) String dataInicioStr,
            @RequestParam(value = "dataFim", required = false) String dataFimStr) {

        ModelAndView mv = new ModelAndView("painel_pesquisa_ponto");
        List<Object[]> resultados = new ArrayList<>();

        // Parse das datas
        LocalDate dataInicio = null;
        LocalDate dataFim = null;

        try {

            // Se dataInicio não for informada, pega a data de hoje
            if (dataInicioStr != null && !dataInicioStr.isEmpty()) {

                dataInicio = LocalDate.parse(dataInicioStr);

            } else {

                // Atribui a data de hoje
                dataInicio = LocalDate.now();

            }

            if (dataFimStr != null && !dataFimStr.isEmpty()) {

                dataFim = LocalDate.parse(dataFimStr);

            }

            // Se data final for nula, use a mesma da data inicial
            if (dataInicio != null && dataFim == null) {

                dataFim = dataInicio;

            }

        } catch (Exception ignored) {

        }

        // Buscar funcionários e pontos, usando LEFT JOIN
        resultados = pontoRepository.buscarFuncionariosComPontos(dataInicio, dataFim);

        mv.addObject("funcionariosComPonto", resultados);
        mv.addObject("idFuncionario", idFuncionario);
        mv.addObject("dataInicio", dataInicio);
        mv.addObject("dataFim", dataFim);

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

    public double calcularHorasTrabalhadas(LocalTime entradaPadrao,
            LocalTime pausaPadrao,
            LocalTime retornoPadrao,
            LocalTime saidaPadrao) {

        double totalHoras = 0.0;

        // Calcula horas ANTES da pausa (entrada → pausa)
        if (entradaPadrao != null && pausaPadrao != null) {
            long minutosAntesPausa = Duration.between(entradaPadrao, pausaPadrao).toMinutes();
            totalHoras += minutosAntesPausa / 60.0;
        }

        // Calcula horas DEPOIS da pausa (retorno → saída)
        if (retornoPadrao != null && saidaPadrao != null) {
            long minutosDepoisPausa = Duration.between(retornoPadrao, saidaPadrao).toMinutes();
            totalHoras += minutosDepoisPausa / 60.0;
        }

        return totalHoras;
    }

    public double calcularHorasTrabalhadasFuncionario(LocalTime entrada,
            LocalTime pausa,
            LocalTime retorno,
            LocalTime saida) {

        // --- Caso 1: Funcionário não fez pausa (pausa e retorno são null) ---
        if (pausa == null && retorno == null) {

            if (entrada != null && saida != null && entrada.isBefore(saida)) {

                long minutosTrabalhados = Duration.between(entrada, saida).toMinutes();
                return minutosTrabalhados / 60.0;

            }

            return 0.0;

        }

        // --- Caso 2: Funcionário fez pausa (cálculo normal) ---
        double horasTrabalhadas = 0.0;

        // Horas antes da pausa (entrada → pausa)
        if (entrada != null && pausa != null && entrada.isBefore(pausa)) {
            long minutosAntesPausa = Duration.between(entrada, pausa).toMinutes();
            horasTrabalhadas += minutosAntesPausa / 60.0;
        }

        // Horas depois da pausa (retorno → saída)
        if (retorno != null && saida != null && retorno.isBefore(saida)) {
            long minutosDepoisPausa = Duration.between(retorno, saida).toMinutes();
            horasTrabalhadas += minutosDepoisPausa / 60.0;
        }

        return horasTrabalhadas;

    }

    /* Relacionado ao relatório */
    @GetMapping("/pesquisa_relatorio")
    public ModelAndView pesquisa_relatorio(
            @RequestParam(value = "idFuncionario", required = false) Long idFuncionario,
            @RequestParam(value = "dataInicio", required = false) String dataInicioStr,
            @RequestParam(value = "dataFim", required = false) String dataFimStr) {

        ModelAndView mv = new ModelAndView("pesquisa_relatorio");
        List<Ponto> pontos = new ArrayList<>();
        Turnos turno = turnosRepository.findAll().get(0);

        mv.addObject("listaFuncionarios", funcionariosRepository.findAll());

        LocalDate dataInicio = null;
        LocalDate dataFim = null;

        try {

            if (dataInicioStr != null && !dataInicioStr.isEmpty()) {

                dataInicio = LocalDate.parse(dataInicioStr);

            }

            if (dataFimStr != null && !dataFimStr.isEmpty()) {

                dataFim = LocalDate.parse(dataFimStr);

            }

            // Se data final for nula, use a mesma da data inicial
            if (dataInicio != null && dataFim == null) {

                dataFim = dataInicio;

            }

        } catch (Exception ignored) {

        }

        // Isto evita consultar todos os registros
        if (idFuncionario != null) {

            pontos = pontoRepository.buscarPorFiltros(idFuncionario, dataInicio, dataFim);

        }

        // Calcula as horas que a empresa deve trabalhar diariamente
        double horasDeveTrabalhar = calcularHorasTrabalhadas(turno.getEntradaPadrao(), turno.getPausaPadrao(),
                turno.getRetornoPadrao(), turno.getSaidaPadrao());

        // Lista os pontos batidos pelo funcionario
        for (Ponto p : pontos) {

            // Calcula as horas reais trabalhadas pelo funcionario
            double horasTrabalhadas = calcularHorasTrabalhadasFuncionario(p.getHorarioEntrada(), p.getHorarioPausa(),
                    p.getHorarioRetorno(), p.getHorarioSaida());

            // Calcula o saldo (horas extras)
            double saldoHoras = horasTrabalhadas - horasDeveTrabalhar;

            // Popula as horas extras
            p.setHorasExtras(saldoHoras);

        }

        mv.addObject("pontos", pontos);
        mv.addObject("idFuncionario", idFuncionario);
        mv.addObject("dataInicio", dataInicio);
        mv.addObject("dataFim", dataFim);
        return mv;

    }

}
