package br.com.etechoracio.study.repository;

import br.com.etechoracio.study.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {
    Optional<Monitor> findByEmail(String email);
    Optional<Monitor> findByTelefone(String telefone);
}
