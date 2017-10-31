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
@Table(name = "tbl_branch", catalog = "new", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblBranch.findAll", query = "SELECT t FROM TblBranch t")
    , @NamedQuery(name = "TblBranch.findByBranchId", query = "SELECT t FROM TblBranch t WHERE t.branchId = :branchId")
    , @NamedQuery(name = "TblBranch.findByBranchName", query = "SELECT t FROM TblBranch t WHERE t.branchName = :branchName")
    , @NamedQuery(name = "TblBranch.findByBranchCity", query = "SELECT t FROM TblBranch t WHERE t.branchCity = :branchCity")
    , @NamedQuery(name = "TblBranch.findByBranchZone", query = "SELECT t FROM TblBranch t WHERE t.branchZone = :branchZone")
    , @NamedQuery(name = "TblBranch.findByBrachContactNo", query = "SELECT t FROM TblBranch t WHERE t.brachContactNo = :brachContactNo")})
public class TblBranch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "branch_Id")
    private Integer branchId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "branch_Name")
    private String branchName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "branch_City")
    private String branchCity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "branch_Zone")
    private String branchZone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "brach_contact_no")
    private String brachContactNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchId")
    private Collection<TblDept> tblDeptCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchId")
    private Collection<TblLoginGenere> tblLoginGenereCollection;

    public TblBranch() {
    }

    public TblBranch(Integer branchId) {
        this.branchId = branchId;
    }

    public TblBranch(Integer branchId, String branchName, String branchCity, String branchZone, String brachContactNo) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchCity = branchCity;
        this.branchZone = branchZone;
        this.brachContactNo = brachContactNo;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCity() {
        return branchCity;
    }

    public void setBranchCity(String branchCity) {
        this.branchCity = branchCity;
    }

    public String getBranchZone() {
        return branchZone;
    }

    public void setBranchZone(String branchZone) {
        this.branchZone = branchZone;
    }

    public String getBrachContactNo() {
        return brachContactNo;
    }

    public void setBrachContactNo(String brachContactNo) {
        this.brachContactNo = brachContactNo;
    }

    @XmlTransient
    public Collection<TblDept> getTblDeptCollection() {
        return tblDeptCollection;
    }

    public void setTblDeptCollection(Collection<TblDept> tblDeptCollection) {
        this.tblDeptCollection = tblDeptCollection;
    }

    @XmlTransient
    public Collection<TblLoginGenere> getTblLoginGenereCollection() {
        return tblLoginGenereCollection;
    }

    public void setTblLoginGenereCollection(Collection<TblLoginGenere> tblLoginGenereCollection) {
        this.tblLoginGenereCollection = tblLoginGenereCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchId != null ? branchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBranch)) {
            return false;
        }
        TblBranch other = (TblBranch) object;
        if ((this.branchId == null && other.branchId != null) || (this.branchId != null && !this.branchId.equals(other.branchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.db.entity.TblBranch[ branchId=" + branchId + " ]";
    }
    
}
