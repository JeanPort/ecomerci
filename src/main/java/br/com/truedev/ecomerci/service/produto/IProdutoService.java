package br.com.truedev.ecomerci.service.produto;

import br.com.truedev.ecomerci.model.Categoria;
import br.com.truedev.ecomerci.model.Produto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProdutoService {

    Produto cadastrarNovo(Produto novo);
    Produto alterarProduto(Produto produto);
    Page<Produto> listarTodos(Integer page);
    List<Produto> recuperarPorPalavraChave(String palavraChave);
    Produto recuperarPorId(Integer id);
    List<Produto> recuperarPorCategoria(Categoria categoria);

}
