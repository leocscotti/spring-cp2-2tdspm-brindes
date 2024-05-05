package br.com.fiap.brindes.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource implements ResourceDTO<ProdutoRequest, ProdutoResponse> {

    @Override
    @PostMapping
    public ResponseEntity<ProdutoResponse> save(@RequestBody ProdutoRequest r) {
        return ResponseEntity.ok(new ProdutoResponse());
    }

    @Override
    @GetMapping
    public ResponseEntity<ProdutoResponse> findAll() {
        return ResponseEntity.ok(new ProdutoResponse());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new ProdutoResponse());
    }
}
