/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sony
 */
@Entity
@Table(name = "tbl_order", catalog = "new", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblOrder.findAll", query = "SELECT t FROM TblOrder t")
    , @NamedQuery(name = "TblOrder.findByOId", query = "SELECT t FROM TblOrder t WHERE t.oId = :oId")
    , @NamedQuery(name = "TblOrder.findByODate", query = "SELECT t FROM TblOrder t WHERE t.oDate = :oDate")
    , @NamedQuery(name = "TblOrder.findByOQty", query = "SELECT t FROM TblOrder t WHERE t.oQty = :oQty")
    , @NamedQuery(name = "TblOrder.findByRate", query = "SELECT t FROM TblOrder t WHERE t.rate = :rate")})
public class TblOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "o_Id")
    private Integer oId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "o_Date")
    @Temporal(TemporalType.DATE)
    private Date oDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "o_Qty")
    private double oQty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate")
    private double rate;
    @JoinColumn(name = "v_Id", referencedColumnName = "v_Id")
    @ManyToOne(optional = false)
    private TblVendor vId;
    @JoinColumn(name = "itm_Id", referencedColumnName = "itm_Id")
    @ManyToOne(optional = false)
    private TblItems itmId;

    public TblOrder() {
    }

    public TblOrder(Integer oId) {
        this.oId = oId;
    }

    public TblOrder(Integer oId, Date oDate, double oQty, double rate) {
        this.oId = oId;
        this.oDate = oDate;
        this.oQty = oQty;
        this.rate = rate;
    }

    public Integer getOId() {
        return oId;
    }

    public void setOId(Integer oId) {
        this.oId = oId;
    }

    public Date getODate() {
        return oDate;
    }

    public void setODate(Date oDate) {
        this.oDate = oDate;
    }

    public double getOQty() {
        return oQty;
    }

    public void setOQty(double oQty) {
        this.oQty = oQty;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public TblVendor getVId() {
        return vId;
    }

    public void setVId(TblVendor vId) {
        this.vId = vId;
    }

    public TblItems getItmId() {
        return itmId;
    }

    public void setItmId(TblItems itmId) {
        this.itmId = itmId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oId != null ? oId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOrder)) {
            return false;
        }
        TblOrder other = (TblOrder) object;
        if ((this.oId == null && other.oId != null) || (this.oId != null && !this.oId.equals(other.oId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.db.entity.TblOrder[ oId=" + oId + " ]";
    }
    
}
