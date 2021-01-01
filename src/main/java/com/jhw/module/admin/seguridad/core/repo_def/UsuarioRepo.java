package com.jhw.module.admin.seguridad.core.repo_def;

import com.root101.clean.core.app.repo.CRUDRepository;
import com.jhw.module.admin.seguridad.core.domain.*;

public interface UsuarioRepo extends CRUDRepository<UsuarioDomain> {

    public UsuarioDomain loadUserByUsername(String username) throws Exception;

}
