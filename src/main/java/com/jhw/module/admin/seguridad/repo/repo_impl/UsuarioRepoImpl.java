package com.jhw.module.admin.seguridad.repo.repo_impl;

import com.jhw.module.admin.seguridad.core.domain.*;
import com.jhw.module.admin.seguridad.repo.entities.*;
import com.jhw.module.admin.seguridad.repo.utils.ResourcesSeguridad;
import com.jhw.utils.jpa.JPACleanCRUDRepo;
import com.jhw.module.admin.seguridad.core.repo_def.UsuarioRepo;
import com.jhw.utils.services.ConverterService;
import javax.persistence.EntityManager;

public class UsuarioRepoImpl extends JPACleanCRUDRepo<UsuarioDomain, Usuario> implements UsuarioRepo {

    public UsuarioRepoImpl() {
        super(ResourcesSeguridad.EMF, UsuarioDomain.class, Usuario.class);
    }

    @Override
    public UsuarioDomain loadUserByUsername(String username) throws Exception {
        EntityManager em = getEntityManager();
        try {
            Usuario user = em.createNamedQuery("Usuario.findByUsername", Usuario.class).getSingleResult();
            return ConverterService.convert(user, UsuarioDomain.class);
        } finally {//lanza excepcion sino, para capturarla mas adelante y lanzar la excepcion de spring
            em.close();
        }
    }

}
