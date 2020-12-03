package com.jhw.module.admin.seguridad.repo.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jhw.module.admin.seguridad.repo.repo_impl.RolRepoImpl;
import com.jhw.module.admin.seguridad.repo.repo_impl.UsuarioRepoImpl;
import com.jhw.module.admin.seguridad.core.repo_def.RolRepo;
import com.jhw.module.admin.seguridad.core.repo_def.UsuarioRepo;

/**
 * Configuracion del injection del modulo de Gastos-Repo-Server.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SeguridadRepoInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(RolRepo.class).to(RolRepoImpl.class).in(Singleton.class);
        bind(UsuarioRepo.class).to(UsuarioRepoImpl.class).in(Singleton.class);
    }

}
