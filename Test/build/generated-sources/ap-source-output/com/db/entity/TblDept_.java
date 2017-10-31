package com.db.entity;

import com.db.entity.TblBranch;
import com.db.entity.TblRequestation;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-12T22:51:19")
@StaticMetamodel(TblDept.class)
public class TblDept_ { 

    public static volatile SingularAttribute<TblDept, String> deptName;
    public static volatile SingularAttribute<TblDept, TblBranch> branchId;
    public static volatile SingularAttribute<TblDept, Integer> deptId;
    public static volatile SingularAttribute<TblDept, String> detail;
    public static volatile CollectionAttribute<TblDept, TblRequestation> tblRequestationCollection;

}