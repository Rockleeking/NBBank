/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.entity;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sony
 */
@Entity
@Table(name = "tbl_stock", catalog = "new", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblStock.findAll", query = "SELECT t FROM TblStock t")
    , @NamedQuery(name = "TblStock.findBySId", query = "SELECT t FROM TblStock t WHERE t.sId = :sId")
    , @NamedQuery(name = "TblStock.findByMinQty", query = "SELECT t FROM TblStock t WHERE t.minQty = :minQty")
    , @NamedQuery(name = "TblStock.findByRemQty", query = "SELECT t FROM TblStock t WHERE t.remQty = :remQty")
    , @NamedQuery(name = "TblStock.findByRate", query = "SELECT t FROM TblStock t WHERE t.rate = :rate")})
public class TblStock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "s_Id")
    private Integer sId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "min_Qty")
    private double minQty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rem_Qty")
    private double remQty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate")
    private double rate;
    @JoinColumn(name = "itm_Id", referencedColumnName = "itm_Id")
    @ManyToOne(optional = false)
    private TblItems itmId;
    @JoinColumn(name = "meta", referencedColumnName = "meta")
    @ManyToOne(optional = false)
    private TblStockGenere meta;

    public TblStock() {
    }

    public TblStock(Integer sId) {
        this.sId = sId;
    }

    public TblStock(Integer sId, double minQty, double remQty, double rate) {
        this.sId = sId;
        this.minQty = minQty;
        this.remQty = remQty;
        this.rate = rate;
    }

    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public double getMinQty() {
        return minQty;
    }

    public void setMinQty(double minQty) {
        this.minQty = minQty;
    }

    public double getRemQty() {
        return remQty;
    }

    public void setRemQty(double remQty) {
        this.remQty = remQty;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public TblItems getItmId() {
        return itmId;
    }

    public void setItmId(TblItems itmId) {
        this.itmId = itmId;
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
        hash += (sId != null ? sId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblStock)) {
            return false;
        }
        TblStock other = (TblStock) object;
        if ((this.sId == null && other.sId != null) || (this.sId != null && !this.sId.equals(other.sId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.db.entity.TblStock[ sId=" + sId + " ]";
    }
    
}
