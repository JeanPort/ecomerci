package br.com.truedev.ecomerci.controller;

import br.com.truedev.ecomerci.model.Cliente;
import br.com.truedev.ecomerci.service.cliente.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService service;

    @GetMapping(value = "/clientes")
    public ResponseEntity<List<Cliente>> getAll(){
        return ResponseEntity.ok(service.recuperarTodos());
    }

    @GetMapping(value = "/clientes/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable("id") Integer id){
        Cliente cliente = service.recuperarClientePorId(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/clientes")
    public ResponseEntity<Cliente> insertNew(@RequestBody Cliente novo) {
        try{
            Cliente result = service.cadastrarNovoCliente(novo);
            if (result != null) {
                return ResponseEntity.status(201).body(result);
            }
        }catch (Exception ex){
            System.out.println("LOG - Erro ao cadastrar " + ex.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/clientes/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        try{
            Cliente result  = service.alterarCliente(cliente);
            if (result != null) {
                return ResponseEntity.ok(result);
            }
        }catch (Exception ex){
            System.out.println("LOG - erro ao atualizar cliente " + ex.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/clientes/busca")
    public ResponseEntity<Cliente> searchCliente(@RequestParam(name = "telefone") String telefone){
        Cliente result = service.recuperarClientePorTelefone(telefone);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }
}
