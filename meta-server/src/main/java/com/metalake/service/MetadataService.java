package com.metalake.service;

import com.alibaba.fastjson.JSONObject;
import com.metalake.bean.Metadata;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public abstract class MetadataService {
    protected   JdbcTemplate jdbcTemplate;
    public abstract List<Metadata> getMetadata(String dbName);
    public abstract List<String> getTables(String dbName);
    public abstract List<String> getDatabases();

    public abstract List<Metadata> getTableMeta(String dbName,String table);

    public abstract void open(JSONObject jdbcConfig);


}
