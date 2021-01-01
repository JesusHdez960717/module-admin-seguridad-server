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
package com.root101.module.admin.seguridad.service;

import com.root101.clean.core.app.services.UserResolver;
import com.root101.clean.core.app.services.UserResolverService;
import com.root101.module.admin.seguridad.core.domain.UsuarioDomain;
import com.root101.module.admin.seguridad.oauth2.JwtUserResolver;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class UserResolverServiceImplementation implements UserResolverService<UsuarioDomain> {

    public static UserResolverServiceImplementation init() {
        UserResolverServiceImplementation resolver = new UserResolverServiceImplementation();
        UserResolver.registerUserResolverService(resolver);
        return resolver;
    }

    private UserResolverServiceImplementation() {
    }

    @Override
    public UsuarioDomain resolveUser() throws Exception {
        return JwtUserResolver.getINSTANCE().resolveUser();
    }

}
