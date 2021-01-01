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
package com.root101.module.admin.seguridad.core.usecase_impl.init;

import com.root101.module.admin.seguridad.core.domain.*;
import com.root101.module.admin.seguridad.core.usecase_def.*;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
