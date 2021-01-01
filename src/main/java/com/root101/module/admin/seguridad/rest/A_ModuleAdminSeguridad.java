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
package com.root101.module.admin.seguridad.rest;

import com.root101.module.admin.seguridad.core.module.SeguridadCoreModule;
import com.root101.module.admin.seguridad.core.usecase_def.ClienteUseCase;
import com.root101.module.admin.seguridad.core.usecase_def.GrantTypeUseCase;
import com.root101.module.admin.seguridad.service.ResourceServiceServerImplementation;
import org.springframework.stereotype.Component;
import com.root101.module.admin.seguridad.core.usecase_def.RolUseCase;
import com.root101.module.admin.seguridad.core.usecase_def.UsuarioUseCase;
import com.root101.module.admin.seguridad.core.usecase_impl.init.ClienteInitializer;
import com.root101.module.admin.seguridad.core.usecase_impl.init.UsuarioInitializer;
import com.root101.module.admin.seguridad.service.ResourceServiceImplementation;
import com.root101.module.admin.seguridad.service.UserResolverServiceImplementation;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Component
public class A_ModuleAdminSeguridad {

    public static final String BASE_PACKAGE = "com.root101.module.admin.seguridad";

    public final static UsuarioUseCase usuarioUC;
    public final static RolUseCase rolUC;
    public final static ClienteUseCase clienteUC;

    static {
        ResourceServiceServerImplementation.init();
        UserResolverServiceImplementation.init();
        ResourceServiceImplementation.init();

        SeguridadCoreModule.init();

        usuarioUC = SeguridadCoreModule.getInstance().getImplementation(UsuarioUseCase.class);
        rolUC = SeguridadCoreModule.getInstance().getImplementation(RolUseCase.class);
        clienteUC = SeguridadCoreModule.getInstance().getImplementation(ClienteUseCase.class);

        UsuarioInitializer.init(usuarioUC, rolUC);
        ClienteInitializer.init(clienteUC, SeguridadCoreModule.getInstance().getImplementation(GrantTypeUseCase.class));
    }
}
