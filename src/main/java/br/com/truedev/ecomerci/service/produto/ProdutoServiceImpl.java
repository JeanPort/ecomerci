package br.com.truedev.ecomerci.service.produto;

import br.com.truedev.ecomerci.dao.ProdutoDAO;
import br.com.truedev.ecomerci.model.Categoria;
import br.com.truedev.ecomerci.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements IProdutoService{
    @Autowired
    private ProdutoDAO prodDAO;

    @Override
    public Produto cadastrarNovo(Produto novo) {
        return prodDAO.save(novo);
    }

    @Override
    public Produto alterarProduto(Produto produto) {
        return prodDAO.save(produto);
    }

    @Override
    public List<Produto> listarTodos() {
        return prodDAO.findByOrderByNomeAsc();
    }

    @Override
    public List<Produto> recuperarPorPalavraChave(String palavraChave) {
        return prodDAO.findByNomeContaining(palavraChave);
    }

    @Override
    public Produto recuperarPorId(Integer id) {
        return prodDAO.findById(id).orElse(null);
    }

    @Override
    public List<Produto> recuperarPorCategoria(Categoria categoria) {
        return prodDAO.findByCategoriasContaining(categoria);
    }
}
