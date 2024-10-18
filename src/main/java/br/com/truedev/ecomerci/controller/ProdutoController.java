package br.com.truedev.ecomerci.controller;

import br.com.truedev.ecomerci.model.Categoria;
import br.com.truedev.ecomerci.model.Produto;
import br.com.truedev.ecomerci.service.produto.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private IProdutoService service;

    @GetMapping(value = "/produtos")
    public ResponseEntity<Page<Produto>> recuperarTodos(@RequestParam(name = "p", defaultValue = "1") Integer p){
        return ResponseEntity.ok(service.listarTodos(p));
    }

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<Produto> recuperarPorId(@PathVariable Integer id){
        Produto result = service.recuperarPorId(id);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/produtos")
    public ResponseEntity<Produto> criarNovo(@RequestBody Produto novo){
        Produto res = service.cadastrarNovo(novo);
        if (res != null) {
            return ResponseEntity.status(201).body(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/produtos/{id}")
    public ResponseEntity<Produto> alterarProduto(@PathVariable Integer id, @RequestBody Produto produto){
        produto.setId(id);
        Produto res = service.alterarProduto(produto);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/produtos/search")
    public ResponseEntity<List<Produto>> buscarPorPalavraChave(@RequestParam(name = "key") String key){
        List<Produto> list = service.recuperarPorPalavraChave(key);
        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/produtos/categoria/{id}")
    public ResponseEntity<List<Produto>> recuperarPorCategoria(@PathVariable Integer id){
        Categoria categoria = new Categoria();
        categoria.setId(id);
        List<Produto> res = service.recuperarPorCategoria(categoria);
        if (!res.isEmpty()) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
}
