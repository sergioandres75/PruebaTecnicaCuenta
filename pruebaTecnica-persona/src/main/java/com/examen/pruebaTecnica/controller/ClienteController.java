package com.examen.pruebaTecnica.controller;

import com.examen.pruebaTecnica.model.Cliente;
import com.examen.pruebaTecnica.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }
    @GetMapping("/{clienteId}")
    public Cliente obtenerCliente(@PathVariable String clienteId) {
        return clienteService.obtenerCliente(clienteId);
    }
}
