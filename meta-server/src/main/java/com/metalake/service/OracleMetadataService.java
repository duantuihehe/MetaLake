package com.metalake.service;

import com.alibaba.fastjson.JSONObject;
import com.metalake.bean.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OracleMetadataService extends MetadataService {

@Override
    public List<Metadata> getMetadata(String dbName) {
    System.out.println("oracle:"+dbName);

        return null;
    }

    @Override
    public List<String> getTables(String dbName) {
        return null;
    }

    @Override
    public List<String> getDatabases() {
        return null;
    }

    @Override
    public List<Metadata> getTableMeta(String dbName, String table) {
        return null;
    }

    @Override
    public void open(JSONObject jdbcConfig) {

    }

}
