/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sony
 */
@Entity
@Table(name = "tbl_requestation", catalog = "new", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRequestation.findAll", query = "SELECT t FROM TblRequestation t")
    , @NamedQuery(name = "TblRequestation.findByReqId", query = "SELECT t FROM TblRequestation t WHERE t.reqId = :reqId")
    , @NamedQuery(name = "TblRequestation.findByReqDate", query = "SELECT t FROM TblRequestation t WHERE t.reqDate = :reqDate")
    , @NamedQuery(name = "TblRequestation.findByQty", query = "SELECT t FROM TblRequestation t WHERE t.qty = :qty")})
public class TblRequestation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "req_Id")
    private Integer reqId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "req_Date")
    @Temporal(TemporalType.DATE)
    private Date reqDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private double qty;
    @JoinColumn(name = "itm_Id", referencedColumnName = "itm_Id")
    @ManyToOne(optional = false)
    private TblItems itmId;
    @JoinColumn(name = "dept_Id", referencedColumnName = "dept_Id")
    @ManyToOne(optional = false)
    private TblDept deptId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reqId")
    private Collection<TblIssue> tblIssueCollection;

    public TblRequestation() {
    }

    public TblRequestation(Integer reqId) {
        this.reqId = reqId;
    }

    public TblRequestation(Integer reqId, Date reqDate, double qty) {
        this.reqId = reqId;
        this.reqDate = reqDate;
        this.qty = qty;
    }

    public Integer getReqId() {
        return reqId;
    }

    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public TblItems getItmId() {
        return itmId;
    }

    public void setItmId(TblItems itmId) {
        this.itmId = itmId;
    }

    public TblDept getDeptId() {
        return deptId;
    }

    public void setDeptId(TblDept deptId) {
        this.deptId = deptId;
    }

    @XmlTransient
    public Collection<TblIssue> getTblIssueCollection() {
        return tblIssueCollection;
    }

    public void setTblIssueCollection(Collection<TblIssue> tblIssueCollection) {
        this.tblIssueCollection = tblIssueCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reqId != null ? reqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRequestation)) {
            return false;
        }
        TblRequestation other = (TblRequestation) object;
        if ((this.reqId == null && other.reqId != null) || (this.reqId != null && !this.reqId.equals(other.reqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.db.entity.TblRequestation[ reqId=" + reqId + " ]";
    }
    
}
