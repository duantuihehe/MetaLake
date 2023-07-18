package com.metalake.service;

import com.alibaba.fastjson.JSONObject;
import com.metalake.bean.Metadata;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MysqlMetadataService extends MetadataService {
@Override
    public List<Metadata> getMetadata(String dbName) {
        String sql = "SELECT TABLE_SCHEMA AS `database`, TABLE_NAME AS `table`," +
                " COLUMN_NAME AS `field`, COLUMN_TYPE AS `type`, COLUMN_KEY AS `key`," +
                " IS_NULLABLE as `null_able`," +
                " ORDINAL_POSITION as `position`," +
                "COLUMN_COMMENT AS `comment`" +
                " FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA ='"+dbName+"'";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        return row2Meta(rows);
    }

    @Override
    public List<String> getTables(String dbName) {
        String sql = "SELECT \n" +
                "distinct TABLE_NAME AS `table`\n" +
                "FROM \n" +
                "INFORMATION_SCHEMA.COLUMNS\n" +
                "WHERE TABLE_SCHEMA ='"+dbName+"'";
        List<String> strings = jdbcTemplate.queryForList(sql, String.class);
        return strings;
    }

    @Override
    public List<String> getDatabases(){
        String sql = "SELECT \n" +
                "distinct TABLE_SCHEMA AS `database`\n" +
                "FROM \n" +
                "INFORMATION_SCHEMA.COLUMNS\n";
        List<String> strings = jdbcTemplate.queryForList(sql, String.class);
        return strings;
    }

    @Override
    public List<Metadata> getTableMeta(String dbName, String table) {
        String sql = "SELECT TABLE_SCHEMA AS `database`, TABLE_NAME AS `table`," +
                " COLUMN_NAME AS `field`, COLUMN_TYPE AS `type`, COLUMN_KEY AS `key`," +
                " IS_NULLABLE as `null_able`," +
                " ORDINAL_POSITION as `position`," +
                "COLUMN_COMMENT AS `comment`" +
                " FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA ='"+dbName+"' and TABLE_NAME='"+table+"'";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        return row2Meta(rows);
    }

    @Override
    public void open(JSONObject jdbcConfig) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcConfig.getOrDefault("driverClassName","com.mysql.jdbc.Driver").toString());
        dataSource.setUrl(jdbcConfig.getString("url"));
        dataSource.setUsername(jdbcConfig.getString("username"));
        dataSource.setPassword(jdbcConfig.getString("password"));
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    private List<Metadata> row2Meta(List<Map<String, Object>> rows){
        List<Metadata> metadataList = new ArrayList<Metadata>();
        for (Map<String, Object> row : rows) {
            Metadata metadata = new Metadata();
            metadata.setDatabase((String) row.get("database"));
            metadata.setTable((String) row.get("table"));
            metadata.setField((String) row.get("field"));
            metadata.setType((String) row.get("type"));
            metadata.setKey((String) row.get("key"));
            metadata.setNullAble((String) row.get("null_able"));
            metadata.setPoistion(new BigInteger(row.get("position").toString()).intValue());
            metadata.setComment((String) row.get("comment"));

            metadataList.add(metadata);
        }
        return metadataList;
    }

}
