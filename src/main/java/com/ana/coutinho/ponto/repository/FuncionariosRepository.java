package com.ana.coutinho.ponto.repository;

import com.ana.coutinho.ponto.model.Funcionarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long> {

    // Método (LIKE)
    List<Funcionarios> findByCpfContaining(String cpf);

}
