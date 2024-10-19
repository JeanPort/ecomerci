package br.com.truedev.ecomerci.service.usuario;

import br.com.truedev.ecomerci.dao.UsuarioDAO;
import br.com.truedev.ecomerci.model.Usuario;
import br.com.truedev.ecomerci.security.ECToken;
import br.com.truedev.ecomerci.security.ECTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private UsuarioDAO dao;


    @Override
    public Usuario cadastrarUsuario(Usuario novo) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String novaSenha = encoder.encode(novo.getSenha());
        novo.setSenha(novaSenha);
        return dao.save(novo);
    }

    @Override
    public Usuario alterarUsuario(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String novaSenha = encoder.encode(usuario.getSenha());
        usuario.setSenha(novaSenha);
        return dao.save(usuario);
    }

    @Override
    public ECToken login(String login, String senha) {

        Usuario res = dao.findByLogin(login);
        if (res != null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (encoder.matches(senha, res.getSenha())) {
                return ECTokenUtil.generateToken(res);
            }
        }
        return null;
    }
}
