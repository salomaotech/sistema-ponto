package com.ana.coutinho.ponto.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class RegistroPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_registro;

    @OneToOne
    private CadastroFuncionarios cadastroFuncionarios;

    @OneToOne
    private CadastroTurnos cadastroTurnos;

    @OneToOne
    private CadastroJustificativa cadastroJustificativa;

    private LocalDate data;
    private LocalTime horarioEntrada;
    private LocalTime horarioSaida;
    private String status;

    public Long getId_registro() {
        return id_registro;
    }

    public void setId_registro(Long id_registro) {
        this.id_registro = id_registro;
    }

    public CadastroFuncionarios getCadastroFuncionarios() {
        return cadastroFuncionarios;
    }

    public void setCadastroFuncionarios(CadastroFuncionarios cadastroFuncionarios) {
        this.cadastroFuncionarios = cadastroFuncionarios;
    }

    public CadastroTurnos getCadastroTurnos() {
        return cadastroTurnos;
    }

    public void setCadastroTurnos(CadastroTurnos cadastroTurnos) {
        this.cadastroTurnos = cadastroTurnos;
    }

    public CadastroJustificativa getCadastroJustificativa() {
        return cadastroJustificativa;
    }

    public void setCadastroJustificativa(CadastroJustificativa cadastroJustificativa) {
        this.cadastroJustificativa = cadastroJustificativa;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public LocalTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
