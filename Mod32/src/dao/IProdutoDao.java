package dao;

import br.com.rpires.domain.Curso;
import br.com.rpires.domain.Produto;

import java.util.List;

public interface IProdutoDao {


    public Produto cadastrar(Produto produto);

        public void excluir(Produto pro);

        public List<Produto> buscarTodos();
    }
