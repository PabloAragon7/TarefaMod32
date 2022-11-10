package dao;

import br.com.rpires.domain.Curso;

import java.util.List;



        import java.util.List;

        import javax.persistence.EntityManager;
        import javax.persistence.EntityManagerFactory;
        import javax.persistence.Persistence;
        import javax.persistence.TypedQuery;
        import javax.persistence.criteria.CriteriaBuilder;
        import javax.persistence.criteria.CriteriaQuery;
        import javax.persistence.criteria.Join;
        import javax.persistence.criteria.JoinType;
        import javax.persistence.criteria.Root;

import br.com.rpires.domain.Produto;
import org.hibernate.Criteria;

        import br.com.rpires.domain.Curso;
        import br.com.rpires.domain.Matricula;


public class ProdutoDao implements IProdutoDao {

    @Override
    public Produto cadastrar(Produto produto) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(mat);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return produto;
    }

    @Override
    public Produto buscarPorCodigoProduto(String codigoProduto) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT m FROM Produto p ");
        sb.append("INNER JOIN Produto c on c = m.produto ");
        sb.append("WHERE c.produto = :codigoProduto");

        entityManager.getTransaction().begin();
        TypedQuery<Produto> query =
                entityManager.createQuery(sb.toString(), Produto.class);
        query.setParameter("codigoProduto", codigoProduto);
        Produto produto = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }

    @Override
    public Produto buscarPorProduto(Produto produto) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT m FROM Produto m ");
        sb.append("INNER JOIN Produto c on c = m.produto ");
        sb.append("WHERE c = :produto");

        entityManager.getTransaction().begin();
        TypedQuery<Produto> query =
                entityManager.createQuery(sb.toString(), Produto.class);
        query.setParameter("produto", produto);
        Produto produto = query.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }

    @Override
    public Produto buscarPorProdutoCriteria(String codigoProduto) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> root = query.from(Produto.class);
        Join<Object, Object> join = root.join("produto", JoinType.INNER);
        query.select(root).where(builder.equal(join.get("codigo"), codigoProduto));

        TypedQuery<Produto> tpQuery =
                entityManager.createQuery(query);
        Produto produto = tpQuery.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }

    @Override
    public Produto buscarPorProdutoCriteria(Produto produto) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> root = query.from(Produto.class);
        Join<Object, Object> join = root.join("produto", JoinType.INNER);
        query.select(root).where(builder.equal(join, produto));

        TypedQuery<Produto> tpQuery =
                entityManager.createQuery(query);
        Produto produto1  = tpQuery.getSingleResult();

        entityManager.close();
        entityManagerFactory.close();

        return produto;
    }

    @Override
    public List<Produto> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        Root<Produto> root = query.from(Produto.class);
        query.select(root);

        TypedQuery<Produto> tpQuery =
                entityManager.createQuery(query);
        List<Produto> list = tpQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return list;
    }

    @Override
    public void excluir(Produto protudo) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        produto = entityManager.merge(produto);
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

}{
}
