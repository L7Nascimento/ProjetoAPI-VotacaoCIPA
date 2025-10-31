package com.estudo.cipa.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.estudo.cipa.votacao.model.Funcionario; // importe sua entidade

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    // Consultas específicas de Funcionario, se houver
}
