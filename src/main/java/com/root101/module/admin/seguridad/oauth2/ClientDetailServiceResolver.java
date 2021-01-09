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
package com.root101.module.admin.seguridad.oauth2;

import com.root101.module.admin.seguridad.core.domain.ClienteDomain;
import com.root101.module.admin.seguridad.core.usecase_def.ClienteUseCase;
import com.root101.module.admin.seguridad.rest.A_ModuleAdminSeguridadRESTConfig;
import com.root101.module.authorization_server.oauth2.client.ClientDetailServiceAdapter;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Component
public class ClientDetailServiceResolver implements ClientDetailServiceAdapter<ClienteDomain> {

    private final ClienteUseCase clienteUC = A_ModuleAdminSeguridadRESTConfig.clienteUC;

    @Override
    public ClienteDomain loadClientByClientId(String clientId) throws Exception {
        return clienteUC.loadClientByName(clientId);
    }

    @Override
    public ClientDetails convert(ClienteDomain client) {
        return ClientDetailsWrapper.from(client);
    }

}
