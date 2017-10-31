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
@Table(name = "tbl_dept", catalog = "new", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDept.findAll", query = "SELECT t FROM TblDept t")
    , @NamedQuery(name = "TblDept.findByDeptId", query = "SELECT t FROM TblDept t WHERE t.deptId = :deptId")
    , @NamedQuery(name = "TblDept.findByDeptName", query = "SELECT t FROM TblDept t WHERE t.deptName = :deptName")
    , @NamedQuery(name = "TblDept.findByDetail", query = "SELECT t FROM TblDept t WHERE t.detail = :detail")})
public class TblDept implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dept_Id")
    private Integer deptId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "dept_Name")
    private String deptName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "detail")
    private String detail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptId")
    private Collection<TblRequestation> tblRequestationCollection;
    @JoinColumn(name = "branch_Id", referencedColumnName = "branch_Id")
    @ManyToOne(optional = false)
    private TblBranch branchId;

    public TblDept() {
    }

    public TblDept(Integer deptId) {
        this.deptId = deptId;
    }

    public TblDept(Integer deptId, String deptName, String detail) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.detail = detail;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

    public TblBranch getBranchId() {
        return branchId;
    }

    public void setBranchId(TblBranch branchId) {
        this.branchId = branchId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptId != null ? deptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDept)) {
            return false;
        }
        TblDept other = (TblDept) object;
        if ((this.deptId == null && other.deptId != null) || (this.deptId != null && !this.deptId.equals(other.deptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.db.entity.TblDept[ deptId=" + deptId + " ]";
    }
    
}
