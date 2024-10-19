package br.com.truedev.ecomerci.dao;

import br.com.truedev.ecomerci.dto.FaturamentoMensal;
import br.com.truedev.ecomerci.model.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {

    List<Pedido> findAllByStatus(Integer status);

    @Query(value = "SELECT new " +
            " br.com.truedev.ecomerci.dto.FaturamentoMensal(month(p.dataPedido), sum(p.valorTotal)) " +
            " FROM Pedido p " +
            " WHERE year(p.dataPedido) = :ano " +
            " GROUP BY month(p.dataPedido) ")
    List<FaturamentoMensal> recuperarFaturamento(@Param("ano") Integer ano);
}
