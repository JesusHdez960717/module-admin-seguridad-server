package com.jhw.module.admin.seguridad.repo.repo_impl;

import com.jhw.module.admin.seguridad.core.domain.*;
import com.jhw.module.admin.seguridad.repo.entities.*;
import com.jhw.module.admin.seguridad.repo.utils.ResourcesSeguridad;
import com.jhw.utils.jpa.JPACleanCRUDRepo;
import com.jhw.module.admin.seguridad.core.repo_def.*;

public class ClienteRepoImpl extends JPACleanCRUDRepo<ClienteDomain, Cliente> implements ClienteRepo {

    public ClienteRepoImpl() {
        super(ResourcesSeguridad.EMF, ClienteDomain.class, Cliente.class);
    }

}
