package ProjetoFinal.controllers;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ProjetoFinal.ApiGerenciadorDoc.model.Usuario;
import ProjetoFinal.controllers.dtos.UsuarioDto;
import ProjetoFinal.controllers.forms.FormUsuario;
import ProjetoFinal.repositorios.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "lista de usuarios", allEntries = true)
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid FormUsuario form, UriComponentsBuilder uriBuilder) {
		Usuario user = form.converter(usuarioRepository);
		usuarioRepository.save(user);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(user));
	}
}
