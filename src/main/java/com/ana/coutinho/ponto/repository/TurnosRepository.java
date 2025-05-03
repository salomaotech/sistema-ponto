package com.ana.coutinho.ponto.repository;

import com.ana.coutinho.ponto.model.Turnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnosRepository extends JpaRepository<Turnos, Long> {

}
