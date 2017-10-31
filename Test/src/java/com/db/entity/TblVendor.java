/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sony
 */
@Entity
@Table(name = "tbl_vendor", catalog = "new", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblVendor.findAll", query = "SELECT t FROM TblVendor t")
    , @NamedQuery(name = "TblVendor.findByVId", query = "SELECT t FROM TblVendor t WHERE t.vId = :vId")
    , @NamedQuery(name = "TblVendor.findByVName", query = "SELECT t FROM TblVendor t WHERE t.vName = :vName")
    , @NamedQuery(name = "TblVendor.findByVCity", query = "SELECT t FROM TblVendor t WHERE t.vCity = :vCity")
    , @NamedQuery(name = "TblVendor.findByVZone", query = "SELECT t FROM TblVendor t WHERE t.vZone = :vZone")})
public class TblVendor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "v_Id")
    private Integer vId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "v_Name")
    private String vName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "v_City")
    private String vCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "v_Zone")
    private String vZone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vId")
    private Collection<TblOrder> tblOrderCollection;

    public TblVendor() {
    }

    public TblVendor(Integer vId) {
        this.vId = vId;
    }

    public TblVendor(Integer vId, String vName, String vCity, String vZone) {
        this.vId = vId;
        this.vName = vName;
        this.vCity = vCity;
        this.vZone = vZone;
    }

    public Integer getVId() {
        return vId;
    }

    public void setVId(Integer vId) {
        this.vId = vId;
    }

    public String getVName() {
        return vName;
    }

    public void setVName(String vName) {
        this.vName = vName;
    }

    public String getVCity() {
        return vCity;
    }

    public void setVCity(String vCity) {
        this.vCity = vCity;
    }

    public String getVZone() {
        return vZone;
    }

    public void setVZone(String vZone) {
        this.vZone = vZone;
    }

    @XmlTransient
    public Collection<TblOrder> getTblOrderCollection() {
        return tblOrderCollection;
    }

    public void setTblOrderCollection(Collection<TblOrder> tblOrderCollection) {
        this.tblOrderCollection = tblOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vId != null ? vId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblVendor)) {
            return false;
        }
        TblVendor other = (TblVendor) object;
        if ((this.vId == null && other.vId != null) || (this.vId != null && !this.vId.equals(other.vId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.db.entity.TblVendor[ vId=" + vId + " ]";
    }
    
}
