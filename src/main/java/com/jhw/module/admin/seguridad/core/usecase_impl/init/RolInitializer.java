/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.seguridad.core.usecase_impl.init;

import com.jhw.module.admin.seguridad.core.domain.*;
import com.jhw.module.admin.seguridad.core.usecase_def.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RolInitializer {

    private static final RolDomain roleDEFAULT = new RolDomain("DEFAULT", 100, "Rol por defecto cuando la tabla está vacía");

    public static void init(RolUseCase rolUC) throws Exception {
        if (rolUC.count() == 0) {//si no hay ningun usuario
            rolUC.create(roleDEFAULT);
        }
    }
}
