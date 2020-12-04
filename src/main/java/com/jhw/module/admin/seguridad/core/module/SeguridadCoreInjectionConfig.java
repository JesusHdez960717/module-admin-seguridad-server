package com.jhw.module.admin.seguridad.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jhw.module.admin.seguridad.core.usecase_def.*;
import com.jhw.module.admin.seguridad.core.usecase_impl.*;

/**
 * Configuracion del injection del modulo de seguridad-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SeguridadCoreInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(RolUseCase.class).to(RolUseCaseImpl.class).in(Singleton.class);
        bind(UsuarioUseCase.class).to(UsuarioUseCaseImpl.class).in(Singleton.class);
        bind(GrantTypeUseCase.class).to(GrantTypeUseCaseImpl.class).in(Singleton.class);
        bind(ClienteUseCase.class).to(ClienteUseCaseImpl.class).in(Singleton.class);
    }

}
