/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.entity;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sony
 */
@Entity
@Table(name = "tbl_login_genere", catalog = "new", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblLoginGenere.findAll", query = "SELECT t FROM TblLoginGenere t")
    , @NamedQuery(name = "TblLoginGenere.findByLgenereId", query = "SELECT t FROM TblLoginGenere t WHERE t.lgenereId = :lgenereId")
    , @NamedQuery(name = "TblLoginGenere.findByType", query = "SELECT t FROM TblLoginGenere t WHERE t.type = :type")
    , @NamedQuery(name = "TblLoginGenere.findByGenere", query = "SELECT t FROM TblLoginGenere t WHERE t.genere = :genere")})
public class TblLoginGenere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "L_genere_Id")
    private Integer lgenereId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "genere")
    private Character genere;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "genere")
    private TblLogin tblLogin;
    @JoinColumn(name = "branch_id", referencedColumnName = "branch_Id")
    @ManyToOne(optional = false)
    private TblBranch branchId;

    public TblLoginGenere() {
    }

    public TblLoginGenere(Integer lgenereId) {
        this.lgenereId = lgenereId;
    }

    public TblLoginGenere(Integer lgenereId, String type, Character genere) {
        this.lgenereId = lgenereId;
        this.type = type;
        this.genere = genere;
    }

    public Integer getLgenereId() {
        return lgenereId;
    }

    public void setLgenereId(Integer lgenereId) {
        this.lgenereId = lgenereId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Character getGenere() {
        return genere;
    }

    public void setGenere(Character genere) {
        this.genere = genere;
    }

    public TblLogin getTblLogin() {
        return tblLogin;
    }

    public void setTblLogin(TblLogin tblLogin) {
        this.tblLogin = tblLogin;
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
        hash += (lgenereId != null ? lgenereId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblLoginGenere)) {
            return false;
        }
        TblLoginGenere other = (TblLoginGenere) object;
        if ((this.lgenereId == null && other.lgenereId != null) || (this.lgenereId != null && !this.lgenereId.equals(other.lgenereId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.db.entity.TblLoginGenere[ lgenereId=" + lgenereId + " ]";
    }
    
}
