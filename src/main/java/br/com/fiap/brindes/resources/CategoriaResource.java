package br.com.fiap.brindes.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource implements ResourceDTO<CategoriaRequest, CategoriaResponse> {

    @Override
    @PostMapping
    public ResponseEntity<CategoriaResponse> save(@RequestBody CategoriaRequest r) {
        return ResponseEntity.ok(new CategoriaResponse());
    }

    @Override
    @GetMapping
    public ResponseEntity<CategoriaResponse> findAll() {
        return ResponseEntity.ok(new CategoriaResponse());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new CategoriaResponse());
    }
}
