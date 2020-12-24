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
@RequestMapping(value = ROL_GENERAL_PATH)
public class RolRESTService extends RESTServiceTemplate<RolDomain> implements RolUseCase {

    private final RolUseCase rolUC = A_ModuleAdminSeguridad.rolUC;

    public RolRESTService() {
        setUseCase(rolUC);
    }

    /*
    @Override
    @GetMapping(COLUMNA_FIND_FIRST_PATH)
    public ColumnaDomain findFirst() throws Exception {
        return rolUC.findFirst();
    }

    @Override
    @GetMapping(COLUMNA_FIND_LAST_PATH)
    public ColumnaDomain findLast() throws Exception {
        return rolUC.findLast();
    }
    */
    
}
