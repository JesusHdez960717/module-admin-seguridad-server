/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.seguridad.rest;

import static com.jhw.module.admin.seguridad.core.ModuleAdminSeguridadConstants.*;
import com.jhw.module.admin.seguridad.core.domain.*;
import com.jhw.module.admin.seguridad.core.usecase_def.*;
import com.jhw.utils.spring.server.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@RestController
@RequestMapping(value = USUARIO_GENERAL_PATH)
public class UsuarioRESTService extends RESTServiceTemplate<UsuarioDomain> implements UsuarioUseCase {

    private final UsuarioUseCase usuarioUC = A_ModuleAdminSeguridad.usuarioUC;

    public UsuarioRESTService() {
        setUseCase(usuarioUC);
    }

    @Override
    @GetMapping(USUARIO_FIND_BY_USERNAME)
    public UsuarioDomain loadUserByUsername(String username) throws Exception {
        return usuarioUC.loadUserByUsername(username);
    }

}
