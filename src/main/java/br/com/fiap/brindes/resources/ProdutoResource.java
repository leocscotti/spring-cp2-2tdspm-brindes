package br.com.fiap.brindes.resources;

import br.com.fiap.brindes.dtos.ProdutoRequestDTO;
import br.com.fiap.brindes.dtos.ProdutoResponseDTO;
import br.com.fiap.brindes.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource implements ResourceDTO<ProdutoRequestDTO, ProdutoResponseDTO> {

    @Autowired
    private ProdutoService produtoService;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> findById(@PathVariable Long id) {
        ProdutoResponseDTO produtoResponse = (ProdutoResponseDTO) produtoService.findById(id);
        if (produtoResponse != null) {
            return ResponseEntity.ok(produtoResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> save(@RequestBody ProdutoRequestDTO produtoRequest) {
        ProdutoResponseDTO produtoResponse = produtoService.save(produtoRequest);
        return ResponseEntity.ok(produtoResponse);
    }

    @GetMapping
    public ResponseEntity<ProdutoResponseDTO> findByExample(ProdutoRequestDTO produtoRequest) {
        
         ProdutoResponseDTO produtoResponse = produtoService.findByExample(produtoRequest);
         return ResponseEntity.ok(produtoResponse);
       
    }
}
