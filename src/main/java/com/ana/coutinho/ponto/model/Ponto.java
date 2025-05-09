package com.ana.coutinho.ponto.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_registro;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionarios funcionarios;

    @ManyToOne
    @JoinColumn(name = "turno_id")
    private Turnos turnos;

    @ManyToOne
    @JoinColumn(name = "justificativa_id")
    private Justificativa justificativa;

    private LocalDate data;
    private LocalTime horarioEntrada;
    private LocalTime horarioPausa;
    private LocalTime horarioRetorno;
    private LocalTime horarioSaida;

    public Long getId_registro() {
        return id_registro;
    }

    public void setId_registro(Long id_registro) {
        this.id_registro = id_registro;
    }

    public Funcionarios getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Turnos getTurnos() {
        return turnos;
    }

    public void setTurnos(Turnos turnos) {
        this.turnos = turnos;
    }

    public Justificativa getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(Justificativa justificativa) {
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

    public LocalTime getHorarioPausa() {
        return horarioPausa;
    }

    public void setHorarioPausa(LocalTime horarioPausa) {
        this.horarioPausa = horarioPausa;
    }

    public LocalTime getHorarioRetorno() {
        return horarioRetorno;
    }

    public void setHorarioRetorno(LocalTime horarioRetorno) {
        this.horarioRetorno = horarioRetorno;
    }

    public LocalTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

}
