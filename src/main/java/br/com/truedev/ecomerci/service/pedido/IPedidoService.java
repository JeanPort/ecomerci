package br.com.truedev.ecomerci.service.pedido;

import br.com.truedev.ecomerci.dto.FaturamentoMensal;
import br.com.truedev.ecomerci.model.Pedido;

import java.util.List;

public interface IPedidoService {

    Pedido criarPedido(Pedido pedido);
    Pedido alterarPedido(Pedido pedido);
    List<Pedido> recuperarTodosPedido();
    Pedido recuperarPorNumero(Integer num);
    List<Pedido> recuperarPorStatus(Integer status);
    List<FaturamentoMensal> recuperarFaturamento(Integer ano);
}
