package com.erp.funcionariocargo.domains.auth.usuario;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private String username;
    private String password;

    private Set<String> roles;
}
