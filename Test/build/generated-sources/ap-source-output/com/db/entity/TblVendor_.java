package com.db.entity;

import com.db.entity.TblOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-12T22:51:19")
@StaticMetamodel(TblVendor.class)
public class TblVendor_ { 

    public static volatile SingularAttribute<TblVendor, Integer> vId;
    public static volatile SingularAttribute<TblVendor, String> vName;
    public static volatile CollectionAttribute<TblVendor, TblOrder> tblOrderCollection;
    public static volatile SingularAttribute<TblVendor, String> vZone;
    public static volatile SingularAttribute<TblVendor, String> vCity;

}