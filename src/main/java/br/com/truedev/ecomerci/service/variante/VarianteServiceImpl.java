package br.com.truedev.ecomerci.service.variante;

import br.com.truedev.ecomerci.dao.VarianteDAO;
import br.com.truedev.ecomerci.model.Produto;
import br.com.truedev.ecomerci.model.Variante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VarianteServiceImpl implements IVarianteService{

    @Autowired
    private VarianteDAO dao;


    @Override
    public Variante adicionarNova(Variante nova) {
        return dao.save(nova);
    }

    @Override
    public Variante alterar(Variante variante) {
        return dao.save(variante);
    }

    @Override
    public List<Variante> recuperarPorProduto(Produto p) {
        return dao.findByProduto(p);
    }

    @Override
    public Variante recuperarPorId(Integer id) {
        return dao.findById(id).orElse(null);
    }
}
