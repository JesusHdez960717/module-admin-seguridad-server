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
package com.root101.module.admin.seguridad.rest;

import com.root101.spring.server.RESTServiceTemplate;
import static com.root101.module.admin.seguridad.rest.ModuleAdminSeguridadRESTConstants.*;
import com.root101.module.admin.seguridad.core.domain.*;
import com.root101.module.admin.seguridad.core.usecase_def.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@RestController
@RequestMapping(value = ROL_GENERAL_PATH)
public class RolRESTService extends RESTServiceTemplate<RolDomain> implements RolUseCase {

    private final RolUseCase rolUC = A_ModuleAdminSeguridadRESTConfig.rolUC;

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
