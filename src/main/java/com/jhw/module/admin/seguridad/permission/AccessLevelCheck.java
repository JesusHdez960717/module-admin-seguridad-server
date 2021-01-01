/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.seguridad.permission;

import com.root101.clean.core.app.services.UserResolver;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Component("AccessLevel")
public class AccessLevelCheck implements PermissionChecker {

    @Override
    public final boolean check(Object... info) {
        int needed = (int) info[0];
        int access_level = 5;//UserResolver.resolveAccessLevel();

        return access_level >= needed;
    }
}
