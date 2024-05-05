package br.com.fiap.brindes.service;

import br.com.fiap.brindes.dtos.CategoriaRequestDTO;
import br.com.fiap.brindes.dtos.CategoriaResponseDTO;
import br.com.fiap.brindes.entity.Categoria;

public interface CategoriaService extends ServiceDTO<Categoria, CategoriaRequestDTO, CategoriaResponseDTO> {

    CategoriaResponseDTO findByExample(CategoriaRequestDTO categoriaRequest);
}
