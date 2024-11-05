package com.examen.pruebaTecnica.service;

import com.examen.pruebaTecnica.model.Cliente;
import com.examen.pruebaTecnica.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente obtenerCliente(String clienteId) {
        return clienteRepository.findById(clienteId).orElse(null);
    }

    public Cliente actualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminarCliente(String clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
