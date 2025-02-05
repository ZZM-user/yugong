package com.taobao.yugong.common.model;

/**
 * @author agapple 2011-9-2 上午11:36:21
 */
public enum DbType {

    /**
     * mysql DB
     */
    MYSQL("com.mysql.jdbc.Driver"),
    /**
     * drds DB
     */
    DRDS("com.mysql.jdbc.Driver"),
    /**
     * oracle DB
     */
    ORACLE("oracle.jdbc.driver.OracleDriver"),
    SqlServer("com.microsoft.sqlserver.jdbc.SQLServerDriver"),
    
    POSTGRESQL("org.postgresql.Driver");

    private String driver;

    DbType(String driver){
        this.driver = driver;
    }

    public String getDriver() {
        return driver;
    }

    public boolean isMysql() {
        return this.equals(DbType.MYSQL);
    }

    public boolean isDRDS() {
        return this.equals(DbType.DRDS);
    }

    public boolean isOracle() {
        return this.equals(DbType.ORACLE);
    }

    public boolean isSqlServer() {
        return this.equals(DbType.SqlServer);
    }
    
    public boolean isPostgreSQL(){return this.equals(DbType.POSTGRESQL);}

}
