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
package com.root101.module.admin.seguridad.core.usecase_impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.clean.core.utils.Licenced;
import com.root101.module.admin.seguridad.core.domain.UsuarioDomain;
import com.root101.module.admin.seguridad.core.module.SeguridadCoreModule;
import com.root101.module.admin.seguridad.core.usecase_def.UsuarioUseCase;
import com.root101.module.admin.seguridad.core.repo_def.UsuarioRepo;
import com.root101.module.admin.seguridad.service.ResourceKeys;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class UsuarioUseCaseImpl extends DefaultCRUDUseCase<UsuarioDomain> implements UsuarioUseCase {

    private final UsuarioRepo repo = SeguridadCoreModule.getInstance().getImplementation(UsuarioRepo.class);

    private final PasswordEncoder encoder = SeguridadCoreModule.getInstance().getImplementation(PasswordEncoder.class);

    public UsuarioUseCaseImpl() {
        super.setRepo(repo);
    }

    //+ encoder al password
    @Override
    @Licenced
    public UsuarioDomain edit(UsuarioDomain objectToUpdate) throws Exception {
        UsuarioDomain old = findBy(objectToUpdate.getIdUser());
        if (!old.getUsername().equals(objectToUpdate.getUsername())) {
            throw new UnsupportedOperationException(ResourceHandler.getString(ResourceKeys.MSG_ERROR_USER_CANT_EDIT));
        }
        objectToUpdate.setPassword(encoder.encode(objectToUpdate.getPassword()));
        return super.edit(objectToUpdate);
    }

    //+ encoder al password
    @Override
    @Licenced
    public UsuarioDomain create(UsuarioDomain newObject) throws Exception {
        newObject.setPassword(encoder.encode(newObject.getPassword()));
        return super.create(newObject);
    }

    @Override
    public UsuarioDomain loadUserByUsername(String username) throws Exception {
        return repo.loadUserByUsername(username);
    }

}
