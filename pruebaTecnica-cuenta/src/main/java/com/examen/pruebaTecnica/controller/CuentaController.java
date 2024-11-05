package com.examen.pruebaTecnica.controller;

import com.examen.pruebaTecnica.model.Cuenta;
import com.examen.pruebaTecnica.model.Movimiento;
import com.examen.pruebaTecnica.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @PostMapping
    public Cuenta crearCuenta(@RequestBody Cuenta cuenta) {
        return cuentaService.guardarCuenta(cuenta);
    }

    @PostMapping("/{cuentaId}/movimientos")
    public Movimiento registrarMovimiento(@PathVariable Long cuentaId, @RequestBody Movimiento movimiento) {
        return cuentaService.registrarMovimiento(cuentaId, movimiento);
    }

    @GetMapping("/{cuentaId}")
    public Cuenta obtenerCuenta(@PathVariable Long cuentaId) {
        return cuentaService.obtenerCuenta(cuentaId);
    }

}