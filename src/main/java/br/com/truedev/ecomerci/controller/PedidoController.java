package br.com.truedev.ecomerci.controller;

import br.com.truedev.ecomerci.dto.FaturamentoMensal;
import br.com.truedev.ecomerci.model.Pedido;
import br.com.truedev.ecomerci.service.pedido.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private IPedidoService service;

    @PostMapping(value = "/pedidos")
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido){
        Pedido resul = service.criarPedido(pedido);

        if (resul != null){
            return ResponseEntity.status(201).body(resul);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/pedidos")
    public ResponseEntity<List<Pedido>> recuperarTodos() {
        List<Pedido> res = service.recuperarTodosPedido();

        if (!res.isEmpty()) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/pedidos/{num}")
    public ResponseEntity<Pedido> recuperarPorNumero(@PathVariable Integer num) {
        Pedido res = service.recuperarPorNumero(num);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "pedidos/faturamento/{ano}")
    public ResponseEntity<List<FaturamentoMensal>> gerarFaturamento(@PathVariable Integer ano) {
        List<FaturamentoMensal> resul = service.recuperarFaturamento(ano);
        if (!resul.isEmpty()) {
            return ResponseEntity.ok(resul);
        }
        return ResponseEntity.badRequest().build();
    }
}
