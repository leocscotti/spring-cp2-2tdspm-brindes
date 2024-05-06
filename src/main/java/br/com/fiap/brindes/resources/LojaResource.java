package br.com.fiap.brindes.resources;

import br.com.fiap.brindes.dtos.LojaRequestDTO;
import br.com.fiap.brindes.dtos.LojaResponseDTO;
import br.com.fiap.brindes.dtos.ProdutoRequestDTO;
import br.com.fiap.brindes.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lojas")
public class LojaResource implements ResourceDTO<LojaRequestDTO, LojaResponseDTO> {

    @Autowired
    private LojaService lojaService;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<LojaResponseDTO> findById(@PathVariable Long id) {
        LojaResponseDTO lojaResponse = (LojaResponseDTO) lojaService.findById(id);
        if (lojaResponse != null) {
            return ResponseEntity.ok(lojaResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @PostMapping
    public ResponseEntity<LojaResponseDTO> save(@RequestBody LojaRequestDTO lojaRequest) {
        LojaResponseDTO lojaResponse = lojaService.save(lojaRequest);
        return ResponseEntity.ok(lojaResponse);
    }

    @GetMapping
    public ResponseEntity<LojaResponseDTO> findByExample(LojaRequestDTO lojaRequest) {
        
         LojaResponseDTO lojaResponse = lojaService.findByExample(lojaRequest);
        return ResponseEntity.ok(lojaResponse);
        
    }

    
    @PostMapping("/{id}/produtos-comercializados")
    public ResponseEntity<Void> adicionarProdutoComercializado(@PathVariable Long id, @RequestBody ProdutoRequestDTO produtoRequest) {
        return ResponseEntity.ok().build(); 
    }
}
