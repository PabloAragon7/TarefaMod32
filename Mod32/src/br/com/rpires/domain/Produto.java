package br.com.rpires.domain;

public class Produto {

package br.com.rpires.domain;

import javax.persistence.*;
import java.util.List;

    /**
     * @author rodrigo.pires
     *
     */
    @Entity
    @Table(name = "TB_CURSO")
    public class Produto {

        @Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produto_seq")
        @SequenceGenerator(name="produto_seq", sequenceName="pd_curso", initialValue = 1, allocationSize = 1)
        private Long id;

        @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
        private String codigo;

        @Column(name = "NOME", length = 50, nullable = false)
        private String nome;

        @Column(name = "DESCRICAO", length = 100, nullable = false)
        private String descricao;

}
