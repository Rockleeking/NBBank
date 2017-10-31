package com.db.entity;

import com.db.entity.TblItems;
import com.db.entity.TblStockGenere;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-12T22:51:19")
@StaticMetamodel(TblStock.class)
public class TblStock_ { 

    public static volatile SingularAttribute<TblStock, TblItems> itmId;
    public static volatile SingularAttribute<TblStock, Double> rate;
    public static volatile SingularAttribute<TblStock, Double> remQty;
    public static volatile SingularAttribute<TblStock, TblStockGenere> meta;
    public static volatile SingularAttribute<TblStock, Integer> sId;
    public static volatile SingularAttribute<TblStock, Double> minQty;

}