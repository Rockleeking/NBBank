package com.db.entity;

import com.db.entity.TblBranch;
import com.db.entity.TblLogin;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-12T22:51:20")
@StaticMetamodel(TblLoginGenere.class)
public class TblLoginGenere_ { 

    public static volatile SingularAttribute<TblLoginGenere, TblBranch> branchId;
    public static volatile SingularAttribute<TblLoginGenere, TblLogin> tblLogin;
    public static volatile SingularAttribute<TblLoginGenere, Integer> lgenereId;
    public static volatile SingularAttribute<TblLoginGenere, String> type;
    public static volatile SingularAttribute<TblLoginGenere, Character> genere;

}