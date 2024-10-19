package br.com.truedev.ecomerci.dao;

import br.com.truedev.ecomerci.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {

    Usuario findByLogin(String login);
}
