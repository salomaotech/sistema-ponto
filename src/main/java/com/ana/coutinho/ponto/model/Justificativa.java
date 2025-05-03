package com.ana.coutinho.ponto.model;

import jakarta.persistence.*;

@Entity
public class Justificativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_justificativa;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionarios funcionarios;

    public long getId_justificativa() {
        return id_justificativa;
    }

    public void setId_justificativa(long id_justificativa) {
        this.id_justificativa = id_justificativa;
    }

    public Funcionarios getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
