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
public class GrantTypeInitializer {

    private static final GrantTypeDomain grantDEFAULT = new GrantTypeDomain("password, refresh_token", "Password con refresh_token, Grant type por defecto");

    public static void init(GrantTypeUseCase grantTypeUC) throws Exception {
        if (grantTypeUC.count() == 0) {//si no hay ningun usuario
            grantTypeUC.create(grantDEFAULT);
        }
    }
}
