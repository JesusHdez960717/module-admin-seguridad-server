package com.jhw.module.admin.seguridad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.clean.core.domain.services.Resource;
import com.jhw.module.admin.seguridad.core.domain.UsuarioDomain;
import com.jhw.module.admin.seguridad.core.module.SeguridadCoreModule;
import com.jhw.module.admin.seguridad.core.usecase_def.UsuarioUseCase;
import com.jhw.module.admin.seguridad.core.repo_def.UsuarioRepo;
import com.jhw.module.admin.seguridad.service.ResourceKeys;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UsuarioUseCaseImpl extends DefaultCRUDUseCase<UsuarioDomain> implements UsuarioUseCase {

    private final UsuarioRepo repo = SeguridadCoreModule.getInstance().getImplementation(UsuarioRepo.class);

    private final PasswordEncoder encoder = SeguridadCoreModule.getInstance().getImplementation(PasswordEncoder.class);

    public UsuarioUseCaseImpl() {
        super.setRepo(repo);
    }

    //+ encoder al password
    @Override
    public UsuarioDomain edit(UsuarioDomain objectToUpdate) throws Exception {
        UsuarioDomain old = findBy(objectToUpdate.getIdUser());
        if (!old.getUsername().equals(objectToUpdate.getUsername())) {
            throw new UnsupportedOperationException(Resource.getString(ResourceKeys.MSG_ERROR_USER_CANT_EDIT));
        }
        objectToUpdate.setPassword(encoder.encode(objectToUpdate.getPassword()));
        return super.edit(objectToUpdate);
    }

    //+ encoder al password
    @Override
    public UsuarioDomain create(UsuarioDomain newObject) throws Exception {
        newObject.setPassword(encoder.encode(newObject.getPassword()));
        return super.create(newObject);
    }

    @Override
    public UsuarioDomain loadUserByUsername(String username) throws Exception {
        return repo.loadUserByUsername(username);
    }

}
