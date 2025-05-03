package com.ana.coutinho.ponto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalTime;

@Entity
public class Turnos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_turno;

    private String turno;
    private LocalTime entradaPadrao;
    private LocalTime saidaPadrao;

    public long getId_turno() {
        return id_turno;
    }

    public void setId_turno(long id_turno) {
        this.id_turno = id_turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public LocalTime getEntradaPadrao() {
        return entradaPadrao;
    }

    public void setEntradaPadrao(LocalTime entradaPadrao) {
        this.entradaPadrao = entradaPadrao;
    }

    public LocalTime getSaidaPadrao() {
        return saidaPadrao;
    }

    public void setSaidaPadrao(LocalTime saidaPadrao) {
        this.saidaPadrao = saidaPadrao;
    }

}
