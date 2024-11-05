package com.examen.pruebaTecnica.repository;

import com.examen.pruebaTecnica.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findById(String clienteId);

    void deleteById(String clienteId);
}
