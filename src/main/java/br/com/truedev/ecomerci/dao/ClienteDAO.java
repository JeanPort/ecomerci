package br.com.truedev.ecomerci.dao;

import br.com.truedev.ecomerci.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {

    Cliente findByTelefone(String telefone);
}
