package br.com.truedev.ecomerci.controller;

import br.com.truedev.ecomerci.model.Produto;
import br.com.truedev.ecomerci.model.Variante;
import br.com.truedev.ecomerci.service.variante.IVarianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VarianteController {

    @Autowired
    private IVarianteService service;


    @GetMapping(value = "/variantes")
    public ResponseEntity<List<Variante>> recuperarPorProduto(@RequestParam(name = "idProduto") Integer id) {
        Produto produto = new Produto();
        produto.setId(id);
        List<Variante> res = service.recuperarPorProduto(produto);
        if (!res.isEmpty()) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/variantes/{id}")
    public ResponseEntity<Variante> recuperarPorId(@PathVariable Integer id) {
        Variante res = service.recuperarPorId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/variantes")
    public ResponseEntity<Variante> inserirNova(@RequestBody Variante variante) {
        Variante res = service.adicionarNova(variante);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "variantes/{id}")
    public ResponseEntity<Variante> update(@RequestBody Variante variante, @PathVariable Integer id){
        variante.setId(id);
        Variante res = service.alterar(variante);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }
}
