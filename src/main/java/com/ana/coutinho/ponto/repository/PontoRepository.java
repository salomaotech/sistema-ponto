package com.ana.coutinho.ponto.repository;

import com.ana.coutinho.ponto.model.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long> {

        // Pesquisa pelo funcionário e entre datas
        @Query("SELECT p FROM Ponto p WHERE " +
                        "(:idFuncionario IS NULL OR p.funcionarios.id_funcionario = :idFuncionario) AND " +
                        "(:dataInicio IS NULL OR p.data >= :dataInicio) AND " +
                        "(:dataFim IS NULL OR p.data <= :dataFim)")
        List<Ponto> buscarPorFiltros(@Param("idFuncionario") Long idFuncionario,
                        @Param("dataInicio") LocalDate dataInicio,
                        @Param("dataFim") LocalDate dataFim);

}
