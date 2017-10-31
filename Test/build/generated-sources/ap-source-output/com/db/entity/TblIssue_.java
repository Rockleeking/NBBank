package com.db.entity;

import com.db.entity.TblRequestation;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-12T22:51:19")
@StaticMetamodel(TblIssue.class)
public class TblIssue_ { 

    public static volatile SingularAttribute<TblIssue, Integer> iId;
    public static volatile SingularAttribute<TblIssue, Double> rate;
    public static volatile SingularAttribute<TblIssue, Integer> iQty;
    public static volatile SingularAttribute<TblIssue, Date> iDate;
    public static volatile SingularAttribute<TblIssue, TblRequestation> reqId;

}