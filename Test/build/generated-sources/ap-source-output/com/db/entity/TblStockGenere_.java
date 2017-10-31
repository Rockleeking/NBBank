package com.db.entity;

import com.db.entity.TblItems;
import com.db.entity.TblStock;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-12T22:51:19")
@StaticMetamodel(TblStockGenere.class)
public class TblStockGenere_ { 

    public static volatile SingularAttribute<TblStockGenere, String> gName;
    public static volatile CollectionAttribute<TblStockGenere, TblItems> tblItemsCollection;
    public static volatile SingularAttribute<TblStockGenere, String> meta;
    public static volatile CollectionAttribute<TblStockGenere, TblStock> tblStockCollection;

}