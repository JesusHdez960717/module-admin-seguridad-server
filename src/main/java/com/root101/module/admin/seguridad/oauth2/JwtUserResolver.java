/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.admin.seguridad.oauth2;

import com.root101.module.admin.seguridad.core.domain.UsuarioDomain;
import com.root101.module.admin.seguridad.core.usecase_def.UsuarioUseCase;
import com.root101.module.admin.seguridad.permission.ClaimsKeys;
import com.root101.module.admin.seguridad.rest.A_ModuleAdminSeguridad;
import com.root101.utils.services.ConverterService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class JwtUserResolver {

    private static final JwtUserResolver INSTANCE = new JwtUserResolver();

    public static JwtUserResolver getINSTANCE() {
        return INSTANCE;
    }

    private final UsuarioUseCase usuarioUC = A_ModuleAdminSeguridad.usuarioUC;

    private JwtUserResolver() {
    }

    public UsuarioDomain resolveUser() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.oauth2.jwt.Jwt jwt = (org.springframework.security.oauth2.jwt.Jwt) auth.getPrincipal();
        return _resolveUser(jwt);
    }

    public int resolveAccessLevel() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            org.springframework.security.oauth2.jwt.Jwt jwt = (org.springframework.security.oauth2.jwt.Jwt) auth.getPrincipal();
            if (jwt.containsClaim(ClaimsKeys.ACCESS_LEVEL_KEY)) {
                return ConverterService.convert((Object) jwt.getClaim(ClaimsKeys.ACCESS_LEVEL_KEY), Integer.class);
            } else {
                UsuarioDomain user = _resolveUser(jwt);
                return user.getRolFk().getNivelAcceso();
            }
        } catch (Exception e) {
            return -1;
        }
    }

    private UsuarioDomain _resolveUser(org.springframework.security.oauth2.jwt.Jwt jwt) throws Exception {
        if (jwt.containsClaim(ClaimsKeys.PRIMARY_KEY_KEY)) {//lo busco por la llave
            Integer pk = ConverterService.convert((Object) jwt.getClaim(ClaimsKeys.PRIMARY_KEY_KEY), Integer.class);
            return usuarioUC.findBy(pk);
        } else {//lo busco por el nombre de usuario
            String username = jwt.getClaim("user_name");//llave para el nombre de usuario por defecto de oauth2
            return usuarioUC.loadUserByUsername(username);
        }
    }
}
