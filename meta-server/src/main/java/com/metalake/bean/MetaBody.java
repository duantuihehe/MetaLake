package com.metalake.bean;

import com.alibaba.fastjson.JSONObject;


public class MetaBody {
    private String dbName;
    private String table;
    private JSONObject jdbcConfig;
    private String serviceClassName;

    public MetaBody() {
    }

    public MetaBody(String dbName, String table, JSONObject jdbcConfig, String serviceClassName) {
        this.dbName = dbName;
        this.table = table;
        this.jdbcConfig = jdbcConfig;
        this.serviceClassName = serviceClassName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public JSONObject getJdbcConfig() {
        return jdbcConfig;
    }

    public void setJdbcConfig(JSONObject jdbcConfig) {
        this.jdbcConfig = jdbcConfig;
    }

    public String getServiceClassName() {
        return serviceClassName;
    }

    public void setServiceClassName(String serviceClassName) {
        this.serviceClassName = serviceClassName;
    }

    @Override
    public String toString() {
        return "MetaBody{" +
                "dbName='" + dbName + '\'' +
                ", table='" + table + '\'' +
                ", jdbcConfig=" + jdbcConfig +
                ", serviceClassName='" + serviceClassName + '\'' +
                '}';
    }
}
