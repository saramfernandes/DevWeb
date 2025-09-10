package com.erp.funcionariocargo.domains.auth.usuario;

import br.com.senai.jpa.domains.role.Role;
import br.com.senai.jpa.domains.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public Usuario salvar(UsuarioDTO dto) {
        Usuario user = new Usuario();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        Set<Role> roles = dto.getRoles().stream().map(nome -> roleRepository.findByNome(nome).orElseThrow()).collect(Collectors.toSet());
        user.setRoles(roles);
        return usuarioRepository.save(user);
    }

    public List<UsuarioDTO> listar() {
        return usuarioRepository.findAll().stream().map(usuario -> {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setUsername(usuario.getUsername());

            dto.setRoles(usuario.getRoles().stream().map(Role::getNome).collect(Collectors.toSet()));
            return dto;
        }).toList();
    }
}
