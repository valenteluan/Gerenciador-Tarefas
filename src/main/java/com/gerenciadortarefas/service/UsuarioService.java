package com.gerenciadortarefas.service;

import com.gerenciadortarefas.entity.users.Usuario;
import com.gerenciadortarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void excluirUsuario(Usuario usuario) {
        usuarioRepository.deleteById(usuario.getId());
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

}
