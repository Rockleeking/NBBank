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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_items", catalog = "new", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblItems.findAll", query = "SELECT t FROM TblItems t")
    , @NamedQuery(name = "TblItems.findByItmId", query = "SELECT t FROM TblItems t WHERE t.itmId = :itmId")
    , @NamedQuery(name = "TblItems.findByItmName", query = "SELECT t FROM TblItems t WHERE t.itmName = :itmName")
    , @NamedQuery(name = "TblItems.findByDetail", query = "SELECT t FROM TblItems t WHERE t.detail = :detail")})
public class TblItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itm_Id")
    private Integer itmId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "itm_Name")
    private String itmName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "detail")
    private String detail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itmId")
    private Collection<TblRequestation> tblRequestationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itmId")
    private Collection<TblStock> tblStockCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itmId")
    private Collection<TblOrder> tblOrderCollection;
    @JoinColumn(name = "meta", referencedColumnName = "meta")
    @ManyToOne(optional = false)
    private TblStockGenere meta;

    public TblItems() {
    }

    public TblItems(Integer itmId) {
        this.itmId = itmId;
    }

    public TblItems(Integer itmId, String itmName, String detail) {
        this.itmId = itmId;
        this.itmName = itmName;
        this.detail = detail;
    }

    public Integer getItmId() {
        return itmId;
    }

    public void setItmId(Integer itmId) {
        this.itmId = itmId;
    }

    public String getItmName() {
        return itmName;
    }

    public void setItmName(String itmName) {
        this.itmName = itmName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @XmlTransient
    public Collection<TblRequestation> getTblRequestationCollection() {
        return tblRequestationCollection;
    }

    public void setTblRequestationCollection(Collection<TblRequestation> tblRequestationCollection) {
        this.tblRequestationCollection = tblRequestationCollection;
    }

    @XmlTransient
    public Collection<TblStock> getTblStockCollection() {
        return tblStockCollection;
    }

    public void setTblStockCollection(Collection<TblStock> tblStockCollection) {
        this.tblStockCollection = tblStockCollection;
    }

    @XmlTransient
    public Collection<TblOrder> getTblOrderCollection() {
        return tblOrderCollection;
    }

    public void setTblOrderCollection(Collection<TblOrder> tblOrderCollection) {
        this.tblOrderCollection = tblOrderCollection;
    }

    public TblStockGenere getMeta() {
        return meta;
    }

    public void setMeta(TblStockGenere meta) {
        this.meta = meta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itmId != null ? itmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblItems)) {
            return false;
        }
        TblItems other = (TblItems) object;
        if ((this.itmId == null && other.itmId != null) || (this.itmId != null && !this.itmId.equals(other.itmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.db.entity.TblItems[ itmId=" + itmId + " ]";
    }
    
}
