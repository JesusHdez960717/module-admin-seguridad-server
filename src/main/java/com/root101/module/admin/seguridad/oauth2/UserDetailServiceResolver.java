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
import com.jhw.module.authorization_server.oauth2.user.UserDetailServiceAdapter;
import java.util.LinkedHashMap;
import com.jhw.module.authorization_server.oauth2.jwt.JwtEnhancers;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
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
                .password(usuario.getPassword())
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
