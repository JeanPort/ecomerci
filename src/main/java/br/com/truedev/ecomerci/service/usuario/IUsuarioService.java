package br.com.truedev.ecomerci.service.usuario;

import br.com.truedev.ecomerci.model.Usuario;
import br.com.truedev.ecomerci.security.ECToken;

public interface IUsuarioService {

    Usuario cadastrarUsuario(Usuario novo);
    Usuario alterarUsuario(Usuario usuario);
    ECToken login(String login, String senha);
}
