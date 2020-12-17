/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.seguridad.service;

import com.clean.core.app.services.UserResolver;
import com.clean.core.app.services.UserResolverService;
import com.jhw.module.admin.seguridad.core.domain.UsuarioDomain;
import com.jhw.module.admin.seguridad.oauth2.JwtUserResolver;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class UserResolverServiceImplementation implements UserResolverService<UsuarioDomain> {

    public static UserResolverServiceImplementation init() {
        UserResolverServiceImplementation resolver = new UserResolverServiceImplementation();
        UserResolver.registerUserResolverService(resolver);
        return resolver;
    }

    private UserResolverServiceImplementation() {
    }

    @Override
    public UsuarioDomain resolveUser() throws Exception {
        return JwtUserResolver.getINSTANCE().resolveUser();
    }

}
