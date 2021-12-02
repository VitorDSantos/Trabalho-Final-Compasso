package projetofinal.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/doc")
public class DocumentoController {
	
	@PostMapping
	@CacheEvict(value = "Docs", allEntries = true)
	public ResponseEntity<String> adicionar() {
		return new ResponseEntity<>("Documento adicionado.", HttpStatus.CREATED); 
	}
	
	@GetMapping
	@Cacheable(value = "Docs")
	public ResponseEntity<String> listar() {
		return new ResponseEntity<>("Todos os documentos listado.", HttpStatus.OK); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> detalhar() {
		return new ResponseEntity<>("Documento {X} listado.", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@CacheEvict(value = "Docs", allEntries = true)
	public ResponseEntity<String> atualizar() {
		return new ResponseEntity<>("Documento atualizado.", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@CacheEvict(value = "Docs", allEntries = true)
	public ResponseEntity<String> remover() {
		return new ResponseEntity<>("Documento excluido", HttpStatus.OK);
	}
	
}