package br.com.truedev.ecomerci.controller;

import br.com.truedev.ecomerci.model.Usuario;
import br.com.truedev.ecomerci.security.ECToken;
import br.com.truedev.ecomerci.service.usuario.IUsuarioService;
import br.com.truedev.ecomerci.service.usuario.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @PostMapping(value = "/usuarios")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario novo) {
        Usuario res = service.cadastrarUsuario(novo);

        if (res != null) {
            return ResponseEntity.status(201).body(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/usuarios/{id}")
    public ResponseEntity<Usuario> alterar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setId(id);

        Usuario res = service.alterarUsuario(usuario);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping(value = "/login")
    public ResponseEntity<ECToken> login(@RequestBody Usuario usuario) {
        ECToken res = service.login(usuario.getLogin(), usuario.getSenha());
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.status(403).build();
    }
}
