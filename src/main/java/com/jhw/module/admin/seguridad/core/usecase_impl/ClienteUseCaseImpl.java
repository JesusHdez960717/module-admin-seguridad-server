package com.jhw.module.admin.seguridad.core.usecase_impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.admin.seguridad.core.domain.*;
import com.jhw.module.admin.seguridad.core.module.SeguridadCoreModule;
import com.jhw.module.admin.seguridad.core.usecase_def.*;
import com.jhw.module.admin.seguridad.core.repo_def.*;

public class ClienteUseCaseImpl extends DefaultCRUDUseCase<ClienteDomain> implements ClienteUseCase {

    private final ClienteRepo repo = SeguridadCoreModule.getInstance().getImplementation(ClienteRepo.class);

    public ClienteUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public ClienteDomain loadClientByName(String client) throws Exception {
        return repo.loadClientByName(client);
    }

}
