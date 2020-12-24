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
public class ClienteInitializer {

    private static final ClienteDomain cleinteDEFAULT = new ClienteDomain("client1", "secret1", "http://localhost:9090", 43200, 43200, "Cliente por defecto", new GrantTypeDomain());

    /**
     * Inicia por defecto tambien el ROL
     *
     * @param clienteUC
     * @param grantTypeUC
     */
    public static void init(ClienteUseCase clienteUC, GrantTypeUseCase grantTypeUC) {
        try {
            if (clienteUC.count() == 0) {//si no hay ningun usuario
                GrantTypeInitializer.init(grantTypeUC);//inicio los roles

                cleinteDEFAULT.setGrantTypesFk(grantTypeUC.findAll().get(0));//le pongo el primer rol al berro

                clienteUC.create(cleinteDEFAULT);
            }
        } catch (Exception e) {
        }
    }
}
