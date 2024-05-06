package br.com.fiap.brindes.entity;

import java.util.Set;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "produto", uniqueConstraints = {@UniqueConstraint(columnNames = {"nm_produto", "id_categoria"})})
public class Produto {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_produto")
    @SequenceGenerator(name="sq_produto", sequenceName = "sq_produto", allocationSize = 1)
    @Column(name="id_produto", nullable = false, unique = true)
    private Long id;

    @NotBlank
    @Column(name="nm_produto",nullable = false, unique = true)
    private String nome;

    @NotNull
    @Column(name="pr_produto", nullable = false)
    private Double preco;

    @ManyToOne()
    @JoinColumn(name = "id_categoria", nullable = false, foreignKey = @ForeignKey(name="fk_produto_categoria"))
    private Categoria categoria;

    @ManyToMany(mappedBy = "produtosComercializados")
    private Set<Loja> lojas;
}