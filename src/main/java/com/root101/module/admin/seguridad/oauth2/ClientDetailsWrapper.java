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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class ClientDetailsWrapper implements ClientDetails {

    public static final String SCOPES = "all";

    public final static ClientDetailsWrapper from(ClienteDomain client) {
        return new ClientDetailsWrapper(client);
    }

    private final ClienteDomain client;

    public ClientDetailsWrapper(ClienteDomain client) {
        this.client = client;
    }

    private Collection<String> split(String text) {
        String[] spl = text.split(",");
        Collection<String> l = new ArrayList<>();
        for (String str : spl) {
            l.add(str.trim().toLowerCase());
        }
        return l;
    }

    @Override
    public String getClientId() {
        return client.getNombreCliente();
    }

    @Override
    public String getClientSecret() {
        return client.getSecret();
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return Arrays.asList(() -> "");
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return new HashSet<>(split(client.getGrantTypesFk().getNombreGrantTypes()));
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return new HashSet<>(split(client.getRedirectURI()));
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return new HashSet<>(Arrays.asList(SCOPES));
    }

    @Override
    public Set<String> getResourceIds() {
        return new HashSet<>();
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return client.getTokenValidationSeconds();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return client.getRefreshTokenValidationSeconds();
    }

    @Override
    public boolean isAutoApprove(String string) {
        return true;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return new HashMap<>();
    }

}
