package br.com.truedev.ecomerci.controller;

import br.com.truedev.ecomerci.model.Categoria;
import br.com.truedev.ecomerci.service.categoria.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private ICategoriaService service;

    @GetMapping(value = "/categorias")
    public ResponseEntity<List<Categoria>> listaTudo() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @PostMapping(value = "/categorias")
    public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria nova) {
        Categoria result = service.criarNova(nova);
        if (result != null) {
            return ResponseEntity.status(201).body(result);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/categorias/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody Categoria cat){
        cat.setId(id);
        Categoria result = service.alterar(cat);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping(value = "/categorias/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

            service.remover(id);
            return ResponseEntity.ok("Deletado");

    }
}
