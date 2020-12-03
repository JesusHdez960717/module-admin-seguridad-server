package com.jhw.module.admin.seguridad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.admin.seguridad.core.domain.UsuarioDomain;
import com.jhw.module.admin.seguridad.core.module.SeguridadCoreModule;
import com.jhw.module.admin.seguridad.core.usecase_def.UsuarioUseCase;
import com.jhw.module.admin.seguridad.core.repo_def.UsuarioRepo;

public class UsuarioUseCaseImpl extends DefaultCRUDUseCase<UsuarioDomain> implements UsuarioUseCase {

    private final UsuarioRepo repo = SeguridadCoreModule.getInstance().getImplementation(UsuarioRepo.class);

    public UsuarioUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public UsuarioDomain loadUserByUsername(String username) throws Exception {
        return repo.loadUserByUsername(username);
    }

}
