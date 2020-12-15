/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.seguridad.oauth2;

import com.jhw.module.admin.seguridad.core.domain.UsuarioDomain;
import com.jhw.module.admin.seguridad.core.usecase_def.UsuarioUseCase;
import com.jhw.module.admin.seguridad.permission.ClaimsKeys;
import com.jhw.module.admin.seguridad.rest.A_ModuleAdminSeguridad;
import com.jhw.module.authorization_server.oauth2.user.UserDetailServiceAdapter;
import java.util.LinkedHashMap;
import com.jhw.module.authorization_server.oauth2.jwt.JwtEnhancers;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class UserDetailServiceResolver implements UserDetailServiceAdapter<UsuarioDomain> {

    private final UsuarioUseCase usuarioUC = A_ModuleAdminSeguridad.usuarioUC;

    public UserDetailServiceResolver() {
        enhance();
    }

    @Override
    public UsuarioDomain loadUserByUsername(String username) throws Exception {
        return usuarioUC.loadUserByUsername(username);
    }

    @Override
    public UserDetails convert(UsuarioDomain usuario) {
        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPublicPassword())
                .roles(usuario.getRolFk().getNombreRol())
                .build();
    }

    private void enhance() {
        JwtEnhancers.addAdditionalInformation((user) -> {
            Map<String, Object> map = new LinkedHashMap<>();
            try {
                String username = user.getName();
                UsuarioDomain userDomain = loadUserByUsername(username);

                map.put(ClaimsKeys.PRIMARY_KEY_KEY, userDomain.getIdUser());
                map.put(ClaimsKeys.ACCESS_LEVEL_KEY, userDomain.getRolFk().getNivelAcceso());
            } catch (Exception e) {
            }
            return map;
        });
    }
}
