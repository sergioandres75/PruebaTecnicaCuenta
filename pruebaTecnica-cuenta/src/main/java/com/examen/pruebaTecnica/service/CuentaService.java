package com.examen.pruebaTecnica.service;

import com.examen.pruebaTecnica.model.Cuenta;
import com.examen.pruebaTecnica.model.Movimiento;
import com.examen.pruebaTecnica.repository.CuentaRepository;
import com.examen.pruebaTecnica.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private MovimientoRepository movimientoRepository;

    public Cuenta guardarCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Movimiento registrarMovimiento(Long cuentaId, Movimiento movimiento) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId).orElseThrow(
                () -> new RuntimeException("Cuenta no encontrada"));

        Double nuevoSaldo = cuenta.getSaldoInicial() + movimiento.getValor();

        if (nuevoSaldo < 0) {
            throw new RuntimeException("Saldo no disponible");
        }

        cuenta.setSaldoInicial(nuevoSaldo);
        movimiento.setSaldo(nuevoSaldo);
        cuentaRepository.save(cuenta);
        return movimientoRepository.save(movimiento);
    }

    public Cuenta obtenerCuenta(Long cuentaId) {
        return cuentaRepository.findById(cuentaId).orElseThrow(
                () -> new RuntimeException("Cuenta no encontrada"));
    }
}