package com.jhw.module.admin.seguridad.core.usecase_impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.admin.seguridad.core.domain.*;
import com.jhw.module.admin.seguridad.core.module.SeguridadCoreModule;
import com.jhw.module.admin.seguridad.core.usecase_def.*;
import com.jhw.module.admin.seguridad.core.repo_def.*;

public class RolUseCaseImpl extends DefaultCRUDUseCase<RolDomain> implements RolUseCase {

    private final RolRepo repo = SeguridadCoreModule.getInstance().getImplementation(RolRepo.class);

    public RolUseCaseImpl() {
        super.setRepo(repo);
    }

}
