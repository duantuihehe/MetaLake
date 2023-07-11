package com.metalake.bean;

public class Metadata {
    private String database;
    private String table;
    private String field;
    private String type;
    private String key;
    private String nullAble;
    private String comment;

    public String getNullAble() {
        return nullAble;
    }

    public void setNullAble(String nullAble) {
        this.nullAble = nullAble;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
// 省略getter和setter方法

    public Metadata() {
    }

    public Metadata(String database, String table, String field, String type, String key, String nullAble, String comment) {
        this.database = database;
        this.table = table;
        this.field = field;
        this.type = type;
        this.key = key;
        this.nullAble = nullAble;
        this.comment = comment;
    }



    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}