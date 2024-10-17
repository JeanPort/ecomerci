package br.com.truedev.ecomerci.dao;

import br.com.truedev.ecomerci.model.Produto;
import br.com.truedev.ecomerci.model.Variante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VarianteDAO extends CrudRepository<Variante, Integer> {

    List<Variante> findByProduto(Produto p);
}
