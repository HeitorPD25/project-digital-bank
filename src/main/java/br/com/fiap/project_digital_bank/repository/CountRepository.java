package br.com.fiap.project_digital_bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.project_digital_bank.model.Count;

public interface CountRepository extends JpaRepository<Count, String> {

    Optional<Count> findByCpf(Long cpf);
    
}
