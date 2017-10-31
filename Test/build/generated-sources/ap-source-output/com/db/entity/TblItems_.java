package com.db.entity;

import com.db.entity.TblOrder;
import com.db.entity.TblRequestation;
import com.db.entity.TblStock;
import com.db.entity.TblStockGenere;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-12T22:51:19")
@StaticMetamodel(TblItems.class)
public class TblItems_ { 

    public static volatile SingularAttribute<TblItems, Integer> itmId;
    public static volatile CollectionAttribute<TblItems, TblOrder> tblOrderCollection;
    public static volatile SingularAttribute<TblItems, TblStockGenere> meta;
    public static volatile SingularAttribute<TblItems, String> itmName;
    public static volatile CollectionAttribute<TblItems, TblStock> tblStockCollection;
    public static volatile SingularAttribute<TblItems, String> detail;
    public static volatile CollectionAttribute<TblItems, TblRequestation> tblRequestationCollection;

}