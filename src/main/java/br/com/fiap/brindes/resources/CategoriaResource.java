package br.com.fiap.brindes.resources;

import br.com.fiap.brindes.dtos.CategoriaRequestDTO;
import br.com.fiap.brindes.dtos.CategoriaResponseDTO;
import br.com.fiap.brindes.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource implements ResourceDTO<CategoriaRequestDTO, CategoriaResponseDTO> {

    @Autowired
    private CategoriaService categoriaService;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> findById(@PathVariable Long id) {
        CategoriaResponseDTO categoriaResponse = categoriaService.findById(id);
        if (categoriaResponse != null) {
            return ResponseEntity.ok(categoriaResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> save(@RequestBody CategoriaRequestDTO categoriaRequest) {
        CategoriaResponseDTO categoriaResponse = categoriaService.save(categoriaRequest);
        return ResponseEntity.ok(categoriaResponse);
    }

    @GetMapping
    public ResponseEntity<CategoriaResponseDTO> findByExample(CategoriaRequestDTO categoriaRequest) {
        
        CategoriaResponseDTO categoriaResponse = categoriaService.findByExample(categoriaRequest);
         return ResponseEntity.ok(categoriaResponse);
        
    }
}
