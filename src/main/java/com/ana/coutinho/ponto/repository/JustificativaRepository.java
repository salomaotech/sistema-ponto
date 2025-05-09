package com.ana.coutinho.ponto.repository;

import com.ana.coutinho.ponto.model.Justificativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JustificativaRepository extends JpaRepository<Justificativa, Long> {

    // Query personalizada para buscar justificativas pelo ID do funcionário
    @Query("SELECT j FROM Justificativa j WHERE j.funcionarios.id_funcionario = :idFuncionario")
    List<Justificativa> findByFuncionarioId(long idFuncionario);

}
