package br.com.truedev.ecomerci.service.variante;

import br.com.truedev.ecomerci.model.Produto;
import br.com.truedev.ecomerci.model.Variante;

import java.util.List;

public interface IVarianteService {

    Variante adicionarNova(Variante nova);
    Variante alterar(Variante variante);
    List<Variante> recuperarPorProduto(Produto p);
    Variante recuperarPorId(Integer id);
}
