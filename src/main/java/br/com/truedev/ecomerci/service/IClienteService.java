package br.com.truedev.ecomerci.service;

import br.com.truedev.ecomerci.model.Cliente;

import java.util.List;

public interface IClienteService {

    Cliente cadastrarNovoCliente(Cliente novo);
    Cliente alterarCliente(Cliente cliente);
    Cliente recuperarClientePorId(Integer id);
    Cliente recuperarClientePorTelefone(String telefone);
    List<Cliente> recuperarTodos();
}
