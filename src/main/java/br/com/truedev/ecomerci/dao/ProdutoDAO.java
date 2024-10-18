package br.com.truedev.ecomerci.dao;

import br.com.truedev.ecomerci.model.Categoria;
import br.com.truedev.ecomerci.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoDAO extends JpaRepository<Produto, Integer> {

    List<Produto> findByNomeContaining(String nome);
    Page<Produto> findByOrderByNomeAsc(Pageable pageable);
    List<Produto> findByCategoriasContaining(Categoria cat);
}
