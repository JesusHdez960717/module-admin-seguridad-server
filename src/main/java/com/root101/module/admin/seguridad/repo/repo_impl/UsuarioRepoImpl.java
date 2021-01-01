/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.admin.seguridad.repo.repo_impl;

import com.root101.module.admin.seguridad.core.domain.*;
import com.root101.module.admin.seguridad.repo.utils.ResourcesSeguridad;
import com.root101.repo.jpa.JPACleanCRUDRepo;
import com.root101.module.admin.seguridad.core.repo_def.UsuarioRepo;
import com.root101.module.admin.seguridad.repo.entities.Usuario;
import com.root101.utils.services.ConverterService;
import javax.persistence.EntityManager;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class UsuarioRepoImpl extends JPACleanCRUDRepo<UsuarioDomain, Usuario> implements UsuarioRepo {

    public UsuarioRepoImpl() {
        super(ResourcesSeguridad.EMF, UsuarioDomain.class, Usuario.class);
    }

    @Override
    public UsuarioDomain loadUserByUsername(String username) throws Exception {
        EntityManager em = getEntityManager();
        try {
            Usuario user = em.createNamedQuery("Usuario.findByUsername", Usuario.class)
                    .setParameter("username", username).getSingleResult();
            return ConverterService.convert(user, UsuarioDomain.class);
        } finally {//lanza excepcion sino, para capturarla mas adelante y lanzar la excepcion de spring
            em.close();
        }
    }

}
