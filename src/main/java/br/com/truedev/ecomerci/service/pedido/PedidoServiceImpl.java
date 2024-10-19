package br.com.truedev.ecomerci.service.pedido;

import br.com.truedev.ecomerci.dao.PedidoDAO;
import br.com.truedev.ecomerci.dto.FaturamentoMensal;
import br.com.truedev.ecomerci.model.ItemPedido;
import br.com.truedev.ecomerci.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoServiceImpl implements IPedidoService{

    @Autowired
    private PedidoDAO dao;

    @Override
    public Pedido criarPedido(Pedido pedido) {

        pedido.getItens().forEach(itemPedido -> itemPedido.setPedido(pedido));
        pedido.setStatus(1);
        double total = 0.0;
        for (ItemPedido iten : pedido.getItens()) {
            total += iten.getValorTotal();
        }
        pedido.setValorBruto(total);
        if (pedido.getValorBruto() > 30) {
            pedido.setDesconto(total * 0.1);
        }
        pedido.setValorTotal(pedido.getValorBruto() - pedido.getDesconto());

        return dao.save(pedido);
    }

    @Override
    public Pedido alterarPedido(Pedido pedido) {
        return dao.save(pedido);
    }

    @Override
    public List<Pedido> recuperarTodosPedido() {
        return (List<Pedido>) dao.findAll();
    }

    @Override
    public Pedido recuperarPorNumero(Integer num) {
        return dao.findById(num).orElse(null);
    }

    @Override
    public List<Pedido> recuperarPorStatus(Integer status) {
        return dao.findAllByStatus(status);
    }

    @Override
    public List<FaturamentoMensal> recuperarFaturamento(Integer ano) {
        return dao.recuperarFaturamento(ano);
    }
}
