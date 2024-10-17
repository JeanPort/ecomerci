package br.com.truedev.ecomerci.dao;

import br.com.truedev.ecomerci.model.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaDAO extends CrudRepository<Categoria, Integer> {

    List<Categoria> findAllByOrderByNomeAsc();
}
