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
package com.root101.module.admin.seguridad.repo.entities;

import com.root101.module.admin.seguridad.repo.utils.ResourcesSeguridad;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Entity
@Table(name = "grant_type", schema = ResourcesSeguridad.SCHEMA, uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_grant_types"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrantType.findAll", query = "SELECT g FROM GrantType g"),
    @NamedQuery(name = "GrantType.findByIdGrantType", query = "SELECT g FROM GrantType g WHERE g.idGrantType = :idGrantType"),
    @NamedQuery(name = "GrantType.findByNombreGrantTypes", query = "SELECT g FROM GrantType g WHERE g.nombreGrantTypes = :nombreGrantTypes"),
    @NamedQuery(name = "GrantType.findByDescripcion", query = "SELECT g FROM GrantType g WHERE g.descripcion = :descripcion")})
public class GrantType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grant_type", nullable = false)
    private Integer idGrantType;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_grant_types", nullable = false, length = 50)
    private String nombreGrantTypes;

    @Basic(optional = false)
    @NotNull
    @Size(max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    public GrantType() {
    }

    public GrantType(Integer idGrantType) {
        this.idGrantType = idGrantType;
    }

    public GrantType(Integer idGrantType, String nombreGrantTypes, String descripcion) {
        this.idGrantType = idGrantType;
        this.nombreGrantTypes = nombreGrantTypes;
        this.descripcion = descripcion;
    }

    public Integer getIdGrantType() {
        return idGrantType;
    }

    public void setIdGrantType(Integer idGrantType) {
        this.idGrantType = idGrantType;
    }

    public String getNombreGrantTypes() {
        return nombreGrantTypes;
    }

    public void setNombreGrantTypes(String nombreGrantTypes) {
        this.nombreGrantTypes = nombreGrantTypes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrantType != null ? idGrantType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrantType)) {
            return false;
        }
        GrantType other = (GrantType) object;
        if ((this.idGrantType == null && other.idGrantType != null) || (this.idGrantType != null && !this.idGrantType.equals(other.idGrantType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jhw.module.admin.seguridad.repo.entities.GrantType[ idGrantType=" + idGrantType + " ]";
    }

}
