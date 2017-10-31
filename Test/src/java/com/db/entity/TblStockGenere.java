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
@Table(name = "tbl_stock_genere", catalog = "new", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblStockGenere.findAll", query = "SELECT t FROM TblStockGenere t")
    , @NamedQuery(name = "TblStockGenere.findByGName", query = "SELECT t FROM TblStockGenere t WHERE t.gName = :gName")
    , @NamedQuery(name = "TblStockGenere.findByMeta", query = "SELECT t FROM TblStockGenere t WHERE t.meta = :meta")})
public class TblStockGenere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "g_Name")
    private String gName;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "meta")
    private String meta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meta")
    private Collection<TblStock> tblStockCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meta")
    private Collection<TblItems> tblItemsCollection;

    public TblStockGenere() {
    }

    public TblStockGenere(String meta) {
        this.meta = meta;
    }

    public TblStockGenere(String meta, String gName) {
        this.meta = meta;
        this.gName = gName;
    }

    public String getGName() {
        return gName;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    @XmlTransient
    public Collection<TblStock> getTblStockCollection() {
        return tblStockCollection;
    }

    public void setTblStockCollection(Collection<TblStock> tblStockCollection) {
        this.tblStockCollection = tblStockCollection;
    }

    @XmlTransient
    public Collection<TblItems> getTblItemsCollection() {
        return tblItemsCollection;
    }

    public void setTblItemsCollection(Collection<TblItems> tblItemsCollection) {
        this.tblItemsCollection = tblItemsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (meta != null ? meta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblStockGenere)) {
            return false;
        }
        TblStockGenere other = (TblStockGenere) object;
        if ((this.meta == null && other.meta != null) || (this.meta != null && !this.meta.equals(other.meta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.db.entity.TblStockGenere[ meta=" + meta + " ]";
    }
    
}
