package com.jhw.module.admin.seguridad.core.module;

import com.clean.core.app.modules.AbstractModule;
import com.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jhw.module.admin.seguridad.repo.module.SeguridadRepoModule;

/**
 * Modulo de Seguridad-Core-Server
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SeguridadCoreModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new SeguridadCoreInjectionConfig());

    private static SeguridadCoreModule INSTANCE;

    public static SeguridadCoreModule getInstance() {
        if (INSTANCE == null) {
            throw new NullPointerException("El modulo de Seguridad-Core-Server no se ha inicializado");
        }
        return INSTANCE;
    }

    public static SeguridadCoreModule init() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        INSTANCE = new SeguridadCoreModule();
        INSTANCE.registerModule(SeguridadRepoModule.init());
        return getInstance();
    }

    public static SeguridadCoreModule init(AbstractModule repoModule) {
        INSTANCE = new SeguridadCoreModule();
        INSTANCE.registerModule(repoModule);
        return getInstance();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "Seguridad Core Server Module";
    }

}
