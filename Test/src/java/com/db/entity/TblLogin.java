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
@Table(name = "tbl_login", catalog = "new", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblLogin.findAll", query = "SELECT t FROM TblLogin t")
    , @NamedQuery(name = "TblLogin.findByLid", query = "SELECT t FROM TblLogin t WHERE t.lid = :lid")
    , @NamedQuery(name = "TblLogin.findByUser", query = "SELECT t FROM TblLogin t WHERE t.user = :user")
    , @NamedQuery(name = "TblLogin.findByPwd", query = "SELECT t FROM TblLogin t WHERE t.pwd = :pwd")})
public class TblLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "L_id")
    private Integer lid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "user")
    private String user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pwd")
    private String pwd;
    @JoinColumn(name = "genere", referencedColumnName = "genere")
    @OneToOne(optional = false)
    private TblLoginGenere genere;

    public TblLogin() {
    }

    public TblLogin(Integer lid) {
        this.lid = lid;
    }

    public TblLogin(Integer lid, String user, String pwd) {
        this.lid = lid;
        this.user = user;
        this.pwd = pwd;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public TblLoginGenere getGenere() {
        return genere;
    }

    public void setGenere(TblLoginGenere genere) {
        this.genere = genere;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lid != null ? lid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblLogin)) {
            return false;
        }
        TblLogin other = (TblLogin) object;
        if ((this.lid == null && other.lid != null) || (this.lid != null && !this.lid.equals(other.lid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.db.entity.TblLogin[ lid=" + lid + " ]";
    }
    
}
