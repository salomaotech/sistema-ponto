package com.ana.coutinho.ponto.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_registro;

    @OneToOne
    private Funcionarios funcionarios;

    @OneToOne
    private Turnos turnos;

    @OneToOne
    private Justificativa justificativa;

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

    public Funcionarios getCadastroFuncionarios() {
        return funcionarios;
    }

    public void setCadastroFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Turnos getCadastroTurnos() {
        return turnos;
    }

    public void setCadastroTurnos(Turnos turnos) {
        this.turnos = turnos;
    }

    public Justificativa getCadastroJustificativa() {
        return justificativa;
    }

    public void setCadastroJustificativa(Justificativa justificativa) {
        this.justificativa = justificativa;
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
