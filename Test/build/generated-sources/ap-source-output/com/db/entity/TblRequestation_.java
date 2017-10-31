package com.db.entity;

import com.db.entity.TblDept;
import com.db.entity.TblIssue;
import com.db.entity.TblItems;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-12T22:51:19")
@StaticMetamodel(TblRequestation.class)
public class TblRequestation_ { 

    public static volatile SingularAttribute<TblRequestation, TblItems> itmId;
    public static volatile SingularAttribute<TblRequestation, Date> reqDate;
    public static volatile CollectionAttribute<TblRequestation, TblIssue> tblIssueCollection;
    public static volatile SingularAttribute<TblRequestation, Double> qty;
    public static volatile SingularAttribute<TblRequestation, TblDept> deptId;
    public static volatile SingularAttribute<TblRequestation, Integer> reqId;

}