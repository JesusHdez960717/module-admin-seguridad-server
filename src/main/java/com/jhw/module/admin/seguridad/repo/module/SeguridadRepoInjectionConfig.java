package com.jhw.module.admin.seguridad.repo.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jhw.module.admin.seguridad.core.repo_def.*;
import com.jhw.module.admin.seguridad.repo.repo_impl.*;

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
        bind(ClienteRepo.class).to(ClienteRepoImpl.class).in(Singleton.class);
        bind(GrantTypeRepo.class).to(GrantTypeRepoImpl.class).in(Singleton.class);
    }

}
