package com.jhw.module.admin.seguridad.core.module;

import com.google.inject.Singleton;
import com.jhw.module.admin.seguridad.core.usecase_def.*;
import com.jhw.module.admin.seguridad.core.usecase_impl.*;
import com.jhw.module.util.licence.core.injection.LicenceInjectionConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuracion del injection del modulo de seguridad-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SeguridadCoreInjectionConfig extends LicenceInjectionConfig {

    @Override
    protected void configure() {
        super.configure();//configura la licencia
        
        bind(RolUseCase.class).to(RolUseCaseImpl.class).in(Singleton.class);
        bind(UsuarioUseCase.class).to(UsuarioUseCaseImpl.class).in(Singleton.class);
        bind(GrantTypeUseCase.class).to(GrantTypeUseCaseImpl.class).in(Singleton.class);
        bind(ClienteUseCase.class).to(ClienteUseCaseImpl.class).in(Singleton.class);

        bind(PasswordEncoder.class).to(BCryptPasswordEncoder.class).in(Singleton.class);
    }

}
