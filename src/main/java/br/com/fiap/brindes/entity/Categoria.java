package br.com.fiap.brindes.entity;

import java.util.Set;

import br.com.fiap.brindes.dtos.CategoriaResponseDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "categoria", uniqueConstraints = {@UniqueConstraint(name="uk_nome_categoria", columnNames = "nm_categoria")})
public class Categoria implements CategoriaResponseDTO {

   
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_categoria")
    @SequenceGenerator(name="sq_categoria", sequenceName = "sq_categoria", allocationSize = 1)
    @Column(name="id_categoria", nullable = false, unique = true)
    private Long id;

    @NotBlank
    @Column(name="nm_categoria",  nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Produto> produtos;
}