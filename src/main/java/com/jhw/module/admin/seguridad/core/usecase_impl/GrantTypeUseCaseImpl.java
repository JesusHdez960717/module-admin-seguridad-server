package com.jhw.module.admin.seguridad.core.usecase_impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.admin.seguridad.core.domain.*;
import com.jhw.module.admin.seguridad.core.module.SeguridadCoreModule;
import com.jhw.module.admin.seguridad.core.usecase_def.*;
import com.jhw.module.admin.seguridad.core.repo_def.*;

public class GrantTypeUseCaseImpl extends DefaultCRUDUseCase<GrantTypeDomain> implements GrantTypeUseCase {

    private final GrantTypeRepo repo = SeguridadCoreModule.getInstance().getImplementation(GrantTypeRepo.class);

    public GrantTypeUseCaseImpl() {
        super.setRepo(repo);
    }

}
