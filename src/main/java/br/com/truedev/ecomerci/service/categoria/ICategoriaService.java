package br.com.truedev.ecomerci.service.categoria;

import br.com.truedev.ecomerci.model.Categoria;

import java.util.List;

public interface ICategoriaService {

    Categoria criarNova(Categoria nova);
    Categoria alterar(Categoria categoria);
    List<Categoria> listarTudo();
    void remover(Integer id);
}
