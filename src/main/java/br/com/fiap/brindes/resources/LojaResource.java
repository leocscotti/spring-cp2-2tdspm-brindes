package br.com.fiap.brindes.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lojas")
public class LojaResource implements ResourceDTO<LojaRequest, LojaResponse> {

    @Override
    @PostMapping
    public ResponseEntity<LojaResponse> save(@RequestBody LojaRequest r) {
        return ResponseEntity.ok(new LojaResponse());
    }

    @Override
    @GetMapping
    public ResponseEntity<LojaResponse> findAll() {
        return ResponseEntity.ok(new LojaResponse());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<LojaResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new LojaResponse());
    }

    @PostMapping("/{id}/produtos-comercializados")
    public ResponseEntity<String> addProdutoComercializado(@PathVariable Long id, @RequestBody ProdutoRequest produtoRequest) {
        return ResponseEntity.ok("Produto adicionado à loja com ID " + id);
    }
}
