package com.db.entity;

import com.db.entity.TblItems;
import com.db.entity.TblVendor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-12T22:51:19")
@StaticMetamodel(TblOrder.class)
public class TblOrder_ { 

    public static volatile SingularAttribute<TblOrder, TblVendor> vId;
    public static volatile SingularAttribute<TblOrder, Date> oDate;
    public static volatile SingularAttribute<TblOrder, TblItems> itmId;
    public static volatile SingularAttribute<TblOrder, Double> oQty;
    public static volatile SingularAttribute<TblOrder, Double> rate;
    public static volatile SingularAttribute<TblOrder, Integer> oId;

}