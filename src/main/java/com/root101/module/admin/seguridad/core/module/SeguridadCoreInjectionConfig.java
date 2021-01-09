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
package com.root101.module.admin.seguridad.core.module;

import com.google.inject.Singleton;
import com.root101.module.admin.seguridad.core.usecase_def.*;
import com.root101.module.control.licence.core.injection.LicenceInjectionConfig;
import com.root101.module.admin.seguridad.core.usecase_impl.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class SeguridadCoreInjectionConfig extends LicenceInjectionConfig {

    @Override
    protected void configure() {
        super.configure();//configura la licencia

        bind(RolUseCase.class).to(RolUseCaseImpl.class).in(Singleton.class);
        bind(UsuarioUseCase.class).to(UsuarioUseCaseImpl.class).in(Singleton.class);
        bind(GrantTypeUseCase.class).to(GrantTypeUseCaseImpl.class).in(Singleton.class);
        bind(ClienteUseCase.class).to(ClienteUseCaseImpl.class).in(Singleton.class);

        bind(PasswordEncoder.class).to(BCryptPasswordEncoder.class).in(Singleton.class);
    }

}
