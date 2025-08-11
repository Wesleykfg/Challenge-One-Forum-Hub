package br.com.forumhub.challenge.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.forumhub.challenge.forum.model.usuario.UsuarioDTO;
import br.com.forumhub.challenge.forum.model.usuario.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class RequestControllerUsuario {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar") 
    public ResponseEntity<?> cadastrar(@RequestBody @Valid UsuarioDTO dto) {
        usuarioService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    

    
    
}
