package br.com.fiap.brindes.service;

import br.com.fiap.brindes.dtos.ProdutoRequestDTO;
import br.com.fiap.brindes.dtos.ProdutoResponseDTO;
import br.com.fiap.brindes.entity.Produto;

public interface ProdutoService extends ServiceDTO<Produto, ProdutoRequestDTO, ProdutoResponseDTO> {
}
