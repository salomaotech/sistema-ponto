package com.ana.coutinho.ponto.repository;

import com.ana.coutinho.ponto.model.Justificativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JustificativaRepository extends JpaRepository<Justificativa, Long> {

}
