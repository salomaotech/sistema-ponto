package com.ana.coutinho.ponto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CadastroJustificativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_justificativa;

    private String descricao;

    public long getId_justificativa() {
        return id_justificativa;
    }

    public void setId_justificativa(long id_justificativa) {
        this.id_justificativa = id_justificativa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
