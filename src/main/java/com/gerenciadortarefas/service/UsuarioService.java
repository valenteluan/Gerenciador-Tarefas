package com.gerenciadortarefas.service;

import com.gerenciadortarefas.entity.users.Usuario;
import com.gerenciadortarefas.repository.RoleRepository;
import com.gerenciadortarefas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario salvarUsuario(Usuario usuario) {
        usuario.setRoles(
                usuario.getRoles()
                        .stream()
                        .map(role -> roleRepository.findByNome(role.getNome()))
                        .toList());

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        usuario.setRoles(
                usuario.getRoles()
                        .stream()
                        .map(role -> roleRepository.findByNome(role.getNome()))
                        .toList());

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obeterUsuarioId(Long usuarioId) {
        return usuarioRepository.findById(usuarioId);
    }

    public void excluirUsuario(Usuario usuario) {
        usuarioRepository.deleteById(usuario.getId());
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

}
