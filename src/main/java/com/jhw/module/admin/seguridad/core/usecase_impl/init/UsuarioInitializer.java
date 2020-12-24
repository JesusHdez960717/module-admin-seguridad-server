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
public class UsuarioInitializer {

    private static final UsuarioDomain usuarioDEFECTO = new UsuarioDomain("defecto", "defecto@gmail.com", "defecto", "Usuario que se crea por defecto cuando la tabla esta vacía", new RolDomain());

    /**
     * Inicia por defecto tambien el ROL
     *
     * @param usuarioUC
     * @param rolUC
     */
    public static void init(UsuarioUseCase usuarioUC, RolUseCase rolUC) {
        try {
            if (usuarioUC.count() == 0) {//si no hay ningun usuario
                RolInitializer.init(rolUC);//inicio los roles

                usuarioDEFECTO.setRolFk(rolUC.findAll().get(0));//le pongo el primer rol al berro

                usuarioUC.create(usuarioDEFECTO);
            }
        } catch (Exception e) {
        }
    }
}
