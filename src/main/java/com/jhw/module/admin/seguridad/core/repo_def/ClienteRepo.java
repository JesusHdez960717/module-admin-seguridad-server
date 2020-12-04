package com.jhw.module.admin.seguridad.core.repo_def;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.module.admin.seguridad.core.domain.*;

public interface ClienteRepo extends CRUDRepository<ClienteDomain> {

    public ClienteDomain loadClientByName(String client) throws Exception;

}
