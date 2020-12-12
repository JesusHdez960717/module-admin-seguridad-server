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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class JwtUserResolver {

    private final static UsuarioUseCase usuarioUC = A_ModuleAdminSeguridad.usuarioUC;

    public static UsuarioDomain resolveUser() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.oauth2.jwt.Jwt jwt = (org.springframework.security.oauth2.jwt.Jwt) auth.getPrincipal();
        return _resolveUser(jwt);
    }

    public static int resolveAccessLevel() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            org.springframework.security.oauth2.jwt.Jwt jwt = (org.springframework.security.oauth2.jwt.Jwt) auth.getPrincipal();
            if (jwt.containsClaim(ClaimsKeys.ACCESS_LEVEL_KEY)) {
                return jwt.getClaim(ClaimsKeys.ACCESS_LEVEL_KEY);
            } else {
                UsuarioDomain user = _resolveUser(jwt);
                return user.getRolFk().getNivelAcceso();
            }
        } catch (Exception e) {
            return -1;
        }
    }

    private static UsuarioDomain _resolveUser(org.springframework.security.oauth2.jwt.Jwt jwt) throws Exception {
        if (jwt.containsClaim(ClaimsKeys.PRIMARY_KEY_KEY)) {//lo busco por la llave
            return usuarioUC.findBy(jwt.getClaim(ClaimsKeys.PRIMARY_KEY_KEY));
        } else {//lo busco por el nombre de usuario
            String username = jwt.getClaim("user_name");//llave para el nombre de usuario por defecto de oauth2
            return usuarioUC.loadUserByUsername(username);
        }
    }
}
