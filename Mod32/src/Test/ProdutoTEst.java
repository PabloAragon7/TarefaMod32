package Test;

import br.com.rpires.domain.Curso;

import java.time.Instant;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.Instant;
import java.util.List;

import br.com.rpires.domain.Produto;
import dao.IProdutoDao;
import dao.ProdutoDao;
import main.IMatriculaDao;
import org.junit.After;
import org.junit.Test;

import br.com.rpires.dao.CursoDao;
import br.com.rpires.dao.ICursoDao;
import br.com.rpires.dao.IMatriculaDao;
import br.com.rpires.dao.MatriculaDao;
import br.com.rpires.domain.Curso;
import br.com.rpires.domain.Matricula;


    public class ProdutoTEst {

        private IProdutoDao laDao ProdutoDao;

        private IProdutoDao produtoDao;

        public ProdutoTEst() {
            produtoDao = new br.com.rpires.dao.ProdutoDao();
            produtoDao = new ProdutoDao();
        }

        @After
        public void end() {
            List<Produto> list = produtoDaoDao.buscarTodos();
            list.forEach(produto -> produtoDaoDao.excluir(produto));

            List<Produto> listprodutos = produtoDaoDao.buscarTodos();
            listprodutos.forEach(produto -> produtoDaoDao.excluir(produto));
        }

        @Test
        public void cadastrar() {
            Produto produto = criarProduto("P1");
            Produto produto1 = new Produto();
            produto.setCodigo("P1");
            produto.setDataProduto(Instant.now());
            produto.setStatus("ATIVA");
            produto.setValor(2000d);
            produto.setProduto(produto);
            produto = produtoDao.cadastrar(produto);

            assertNotNull(produto);
            assertNotNull(produto.getId());
        }

        @Test
        public void pesquisarPorProduto() {
            Produto produto = criarProduto("P1");
            Produto produto1 = new Produto();
            produto.setCodigo("A1");
            produto.setDataProduto(Instant.now());
            produto.setStatus("ATIVA");
            produto.setValor(2000d);
            produto.setProduto(produto);
            produto = produtoDaoDao.cadastrar(produto);

            assertNotNull(produto);
            assertNotNull(produto.getId());

            ProdutoBD = produtoDaoDao.buscarPorCurso(produto);
            assertNotNull(produtoBD);
            assertEquals(produto.getId(), produtoBD.getId());
        }

        @Test
        public void pesquisarPorCodigoCurso() {
            Curso curso = criarCurso("A1");
            Matricula mat = new Matricula();
            mat.setCodigo("A1");
            mat.setDataMatricula(Instant.now());
            mat.setStatus("ATIVA");
            mat.setValor(2000d);
            mat.setCurso(curso);
            mat = matriculaDao.cadastrar(mat);

            assertNotNull(mat);
            assertNotNull(mat.getId());

            Matricula matricBD = matriculaDao.buscarPorCodigoCurso(curso.getCodigo());
            assertNotNull(matricBD);
            assertEquals(mat.getId(), matricBD.getId());
        }

        @Test
        public void pesquisarPorCodigoCursoCriteria() {
            Curso curso = criarCurso("A1");
            Matricula mat = new Matricula();
            mat.setCodigo("A1");
            mat.setDataMatricula(Instant.now());
            mat.setStatus("ATIVA");
            mat.setValor(2000d);
            mat.setCurso(curso);
            mat = matriculaDao.cadastrar(mat);

            assertNotNull(mat);
            assertNotNull(mat.getId());

            Matricula matricBD = matriculaDao.buscarPorCodigoCursoCriteria(curso.getCodigo());
            assertNotNull(matricBD);
            assertEquals(mat.getId(), matricBD.getId());
        }

        @Test
        public void pesquisarPorCursoCriteria() {
            Curso curso = criarCurso("A1");
            Matricula mat = new Matricula();
            mat.setCodigo("A1");
            mat.setDataMatricula(Instant.now());
            mat.setStatus("ATIVA");
            mat.setValor(2000d);
            mat.setCurso(curso);
            mat = matriculaDao.cadastrar(mat);

            assertNotNull(mat);
            assertNotNull(mat.getId());

            Matricula matricBD = matriculaDao.buscarPorCursoCriteria(curso);
            assertNotNull(matricBD);
            assertEquals(mat.getId(), matricBD.getId());
        }

        private Curso criarCurso(String codigo) {
            Curso curso = new Curso();
            curso.setCodigo(codigo);
            curso.setDescricao("CURSO TESTE");
            curso.setNome("Curso de Java Backend");
            return cursoDao.cadastrar(curso);
        }
    }

}
