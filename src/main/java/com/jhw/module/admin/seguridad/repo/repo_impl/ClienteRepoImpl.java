package com.jhw.module.admin.seguridad.repo.repo_impl;

import com.jhw.module.admin.seguridad.core.domain.*;
import com.jhw.module.admin.seguridad.repo.entities.*;
import com.jhw.module.admin.seguridad.repo.utils.ResourcesSeguridad;
import com.jhw.utils.jpa.JPACleanCRUDRepo;
import com.jhw.module.admin.seguridad.core.repo_def.*;
import com.jhw.utils.services.ConverterService;
import javax.persistence.EntityManager;

public class ClienteRepoImpl extends JPACleanCRUDRepo<ClienteDomain, Cliente> implements ClienteRepo {

    public ClienteRepoImpl() {
        super(ResourcesSeguridad.EMF, ClienteDomain.class, Cliente.class);
    }

    @Override
    public ClienteDomain loadClientByName(String client) throws Exception {
        EntityManager em = getEntityManager();
        try {
            Cliente cliente = em.createNamedQuery("Cliente.findByNombreCliente", Cliente.class)
                    .setParameter("nombreCliente", client).getSingleResult();
            return ConverterService.convert(cliente, ClienteDomain.class);
        } finally {//lanza excepcion sino, para capturarla mas adelante y lanzar la excepcion de spring
            em.close();
        }
    }

}
