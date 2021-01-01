package com.jhw.module.admin.seguridad.repo.module;

import com.root101.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jhw.module.admin.seguridad.repo.utils.ResourcesSeguridad;

/**
 * Modulo de Seguridad-Repo-Server.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SeguridadRepoModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new SeguridadRepoInjectionConfig());

    private static SeguridadRepoModule INSTANCE;

    private SeguridadRepoModule() {
        ResourcesSeguridad.initEMF();
    }

    public static SeguridadRepoModule getInstance() {
        if (INSTANCE == null) {
            throw new NullPointerException("El modulo de Seguridad Repo Server no se ha inicializado");
        }
        return INSTANCE;
    }

    public static SeguridadRepoModule init() {
        INSTANCE = new SeguridadRepoModule();
        return getInstance();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "Seguridad Repo Server Module";
    }

}
