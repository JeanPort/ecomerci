package br.com.truedev.ecomerci.service.produto;

import br.com.truedev.ecomerci.model.Categoria;
import br.com.truedev.ecomerci.model.Produto;

import java.util.List;

public interface IProdutoService {

    Produto cadastrarNovo(Produto novo);
    Produto alterarProduto(Produto produto);
    List<Produto> listarTodos();
    List<Produto> recuperarPorPalavraChave(String palavraChave);
    Produto recuperarPorId(Integer id);
    List<Produto> recuperarPorCategoria(Categoria categoria);

}
