package com.jhw.module.admin.seguridad.repo.repo_impl;

import com.jhw.module.admin.seguridad.core.domain.*;
import com.jhw.module.admin.seguridad.repo.entities.*;
import com.jhw.module.admin.seguridad.repo.utils.ResourcesSeguridad;
import com.root101.repo.jpa.JPACleanCRUDRepo;
import com.jhw.module.admin.seguridad.core.repo_def.*;

public class GrantTypeRepoImpl extends JPACleanCRUDRepo<GrantTypeDomain, GrantType> implements GrantTypeRepo {

    public GrantTypeRepoImpl() {
        super(ResourcesSeguridad.EMF, GrantTypeDomain.class, GrantType.class);
    }

}
