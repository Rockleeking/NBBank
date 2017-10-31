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
@Table(name = "tbl_issue", catalog = "new", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblIssue.findAll", query = "SELECT t FROM TblIssue t")
    , @NamedQuery(name = "TblIssue.findByIId", query = "SELECT t FROM TblIssue t WHERE t.iId = :iId")
    , @NamedQuery(name = "TblIssue.findByIDate", query = "SELECT t FROM TblIssue t WHERE t.iDate = :iDate")
    , @NamedQuery(name = "TblIssue.findByIQty", query = "SELECT t FROM TblIssue t WHERE t.iQty = :iQty")
    , @NamedQuery(name = "TblIssue.findByRate", query = "SELECT t FROM TblIssue t WHERE t.rate = :rate")})
public class TblIssue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "i_Id")
    private Integer iId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "i_Date")
    @Temporal(TemporalType.DATE)
    private Date iDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "i_Qty")
    private int iQty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Rate")
    private double rate;
    @JoinColumn(name = "req_Id", referencedColumnName = "req_Id")
    @ManyToOne(optional = false)
    private TblRequestation reqId;

    public TblIssue() {
    }

    public TblIssue(Integer iId) {
        this.iId = iId;
    }

    public TblIssue(Integer iId, Date iDate, int iQty, double rate) {
        this.iId = iId;
        this.iDate = iDate;
        this.iQty = iQty;
        this.rate = rate;
    }

    public Integer getIId() {
        return iId;
    }

    public void setIId(Integer iId) {
        this.iId = iId;
    }

    public Date getIDate() {
        return iDate;
    }

    public void setIDate(Date iDate) {
        this.iDate = iDate;
    }

    public int getIQty() {
        return iQty;
    }

    public void setIQty(int iQty) {
        this.iQty = iQty;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public TblRequestation getReqId() {
        return reqId;
    }

    public void setReqId(TblRequestation reqId) {
        this.reqId = reqId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iId != null ? iId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblIssue)) {
            return false;
        }
        TblIssue other = (TblIssue) object;
        if ((this.iId == null && other.iId != null) || (this.iId != null && !this.iId.equals(other.iId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.db.entity.TblIssue[ iId=" + iId + " ]";
    }
    
}
