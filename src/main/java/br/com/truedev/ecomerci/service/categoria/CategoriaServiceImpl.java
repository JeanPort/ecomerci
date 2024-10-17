package br.com.truedev.ecomerci.service.categoria;

import br.com.truedev.ecomerci.dao.CategoriaDAO;
import br.com.truedev.ecomerci.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaServiceImpl implements ICategoriaService{

    @Autowired
    private CategoriaDAO catDAO;

    @Override
    public Categoria criarNova(Categoria nova) {
        return catDAO.save(nova);
    }

    @Override
    public Categoria alterar(Categoria categoria) {
        return catDAO.save(categoria);
    }

    @Override
    public List<Categoria> listarTudo() {
        return (List<Categoria>) catDAO.findAllByOrderByNomeAsc();
    }

    @Override
    public void remover(Integer id) {
        catDAO.deleteById(id);
    }
}
