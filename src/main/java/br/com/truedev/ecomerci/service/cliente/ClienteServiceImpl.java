package br.com.truedev.ecomerci.service.cliente;

import br.com.truedev.ecomerci.dao.ClienteDAO;
import br.com.truedev.ecomerci.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public Cliente cadastrarNovoCliente(Cliente novo) {
        return clienteDAO.save(novo);
    }

    @Override
    public Cliente alterarCliente(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public Cliente recuperarClientePorId(Integer id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    public Cliente recuperarClientePorTelefone(String telefone) {
        return clienteDAO.findByTelefone(telefone);
    }

    @Override
    public List<Cliente> recuperarTodos() {
        return (List<Cliente>) clienteDAO.findAll();
    }
}
