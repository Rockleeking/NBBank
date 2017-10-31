package com.db.entity;

import com.db.entity.TblLoginGenere;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-12T22:51:20")
@StaticMetamodel(TblLogin.class)
public class TblLogin_ { 

    public static volatile SingularAttribute<TblLogin, Integer> lid;
    public static volatile SingularAttribute<TblLogin, String> pwd;
    public static volatile SingularAttribute<TblLogin, String> user;
    public static volatile SingularAttribute<TblLogin, TblLoginGenere> genere;

}