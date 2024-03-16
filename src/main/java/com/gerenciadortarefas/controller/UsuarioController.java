package com.gerenciadortarefas.controller;

import com.gerenciadortarefas.entity.users.Usuario;
import com.gerenciadortarefas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<String> salvarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
        return new ResponseEntity<>("Novo usuário criado " + usuarioSalvo.getUsername(), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> atualizarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
        return new ResponseEntity<>("Novo usuário criado " + usuarioSalvo.getUsername(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return new ResponseEntity<>(usuarioService.listarUsuarios(), HttpStatus.OK);
    }

    @DeleteMapping
    public void deletarUsuario(@RequestBody Usuario usuario) {
        usuarioService.excluirUsuario(usuario);
    }

}
