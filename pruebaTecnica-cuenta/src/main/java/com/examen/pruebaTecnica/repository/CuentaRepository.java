package com.examen.pruebaTecnica.repository;

import com.examen.pruebaTecnica.model.Cuenta;
import com.examen.pruebaTecnica.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {}
