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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cliente", schema = ResourcesSeguridad.SCHEMA, uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_cliente"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByNombreCliente", query = "SELECT c FROM Cliente c WHERE c.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "Cliente.findBySecret", query = "SELECT c FROM Cliente c WHERE c.secret = :secret"),
    @NamedQuery(name = "Cliente.findByRedirectURI", query = "SELECT c FROM Cliente c WHERE c.redirectURI = :redirectURI"),
    @NamedQuery(name = "Cliente.findByTokenValidationSeconds", query = "SELECT c FROM Cliente c WHERE c.tokenValidationSeconds = :tokenValidationSeconds"),
    @NamedQuery(name = "Cliente.findByRefreshTokenValidationSeconds", query = "SELECT c FROM Cliente c WHERE c.refreshTokenValidationSeconds = :refreshTokenValidationSeconds"),
    @NamedQuery(name = "Cliente.findByDescripcion", query = "SELECT c FROM Cliente c WHERE c.descripcion = :descripcion")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_cliente", nullable = false, length = 100)
    private String nombreCliente;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "secret", nullable = false, length = 64)
    private String secret;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "redirectURI", nullable = false, length = 100)
    private String redirectURI;

    @Basic(optional = false)
    @NotNull
    @Column(name = "tokenValidationSeconds", nullable = false)
    private int tokenValidationSeconds;

    @Basic(optional = false)
    @NotNull
    @Column(name = "refreshTokenValidationSeconds", nullable = false)
    private int refreshTokenValidationSeconds;

    @Basic(optional = false)
    @NotNull
    @Size(max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @JoinColumn(name = "grant_types_fk", referencedColumnName = "id_grant_type", nullable = false)
    @ManyToOne(optional = false)
    private GrantType grantTypesFk;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nombreCliente, String secret, String redirectURI, int tokenValidationSeconds, int refreshTokenValidationSeconds, String descripcion) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.secret = secret;
        this.redirectURI = redirectURI;
        this.tokenValidationSeconds = tokenValidationSeconds;
        this.refreshTokenValidationSeconds = refreshTokenValidationSeconds;
        this.descripcion = descripcion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getRedirectURI() {
        return redirectURI;
    }

    public void setRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
    }

    public int getTokenValidationSeconds() {
        return tokenValidationSeconds;
    }

    public void setTokenValidationSeconds(int tokenValidationSeconds) {
        this.tokenValidationSeconds = tokenValidationSeconds;
    }

    public int getRefreshTokenValidationSeconds() {
        return refreshTokenValidationSeconds;
    }

    public void setRefreshTokenValidationSeconds(int refreshTokenValidationSeconds) {
        this.refreshTokenValidationSeconds = refreshTokenValidationSeconds;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public GrantType getGrantTypesFk() {
        return grantTypesFk;
    }

    public void setGrantTypesFk(GrantType grantTypesFk) {
        this.grantTypesFk = grantTypesFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jhw.module.admin.seguridad.repo.entities.Cliente[ idCliente=" + idCliente + " ]";
    }

}
