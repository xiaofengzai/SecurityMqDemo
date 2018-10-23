package com.enshub.config;

import org.hibernate.dialect.MySQL5Dialect;

public class MysqlDialetWithoutFk extends MySQL5Dialect {
    public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable, String[] primaryKey, boolean referencesPrimaryKey) {

        return "";
    }
}
