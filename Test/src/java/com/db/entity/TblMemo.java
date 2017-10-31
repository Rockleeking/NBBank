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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sony
 */
@Entity
@Table(name = "tbl_memo", catalog = "new", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMemo.findAll", query = "SELECT t FROM TblMemo t")
    , @NamedQuery(name = "TblMemo.findByMId", query = "SELECT t FROM TblMemo t WHERE t.mId = :mId")
    , @NamedQuery(name = "TblMemo.findByMDate", query = "SELECT t FROM TblMemo t WHERE t.mDate = :mDate")
    , @NamedQuery(name = "TblMemo.findByMFrom", query = "SELECT t FROM TblMemo t WHERE t.mFrom = :mFrom")
    , @NamedQuery(name = "TblMemo.findByMTo", query = "SELECT t FROM TblMemo t WHERE t.mTo = :mTo")
    , @NamedQuery(name = "TblMemo.findByDetail", query = "SELECT t FROM TblMemo t WHERE t.detail = :detail")})
public class TblMemo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "m_Id")
    private Integer mId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "m_Date")
    @Temporal(TemporalType.DATE)
    private Date mDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "m_From")
    private String mFrom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "m_to")
    private String mTo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "detail")
    private String detail;

    public TblMemo() {
    }

    public TblMemo(Integer mId) {
        this.mId = mId;
    }

    public TblMemo(Integer mId, Date mDate, String mFrom, String mTo, String detail) {
        this.mId = mId;
        this.mDate = mDate;
        this.mFrom = mFrom;
        this.mTo = mTo;
        this.detail = detail;
    }

    public Integer getMId() {
        return mId;
    }

    public void setMId(Integer mId) {
        this.mId = mId;
    }

    public Date getMDate() {
        return mDate;
    }

    public void setMDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getMFrom() {
        return mFrom;
    }

    public void setMFrom(String mFrom) {
        this.mFrom = mFrom;
    }

    public String getMTo() {
        return mTo;
    }

    public void setMTo(String mTo) {
        this.mTo = mTo;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mId != null ? mId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMemo)) {
            return false;
        }
        TblMemo other = (TblMemo) object;
        if ((this.mId == null && other.mId != null) || (this.mId != null && !this.mId.equals(other.mId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.db.entity.TblMemo[ mId=" + mId + " ]";
    }
    
}
