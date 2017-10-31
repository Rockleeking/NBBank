package com.db.entity;

import com.db.entity.TblDept;
import com.db.entity.TblLoginGenere;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-12T22:51:20")
@StaticMetamodel(TblBranch.class)
public class TblBranch_ { 

    public static volatile SingularAttribute<TblBranch, Integer> branchId;
    public static volatile SingularAttribute<TblBranch, String> branchCity;
    public static volatile CollectionAttribute<TblBranch, TblLoginGenere> tblLoginGenereCollection;
    public static volatile SingularAttribute<TblBranch, String> branchZone;
    public static volatile SingularAttribute<TblBranch, String> branchName;
    public static volatile SingularAttribute<TblBranch, String> brachContactNo;
    public static volatile CollectionAttribute<TblBranch, TblDept> tblDeptCollection;

}