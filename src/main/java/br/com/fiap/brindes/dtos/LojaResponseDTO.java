package br.com.fiap.brindes.dtos;

import java.util.Set;

public interface LojaResponseDTO {
    Long getId();
    String getNome();
    Set<ProdutoResponseDTO> getProdutosComercializados();
}
