package com.ana.coutinho.ponto.repository;

import com.ana.coutinho.ponto.model.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long> {

}
