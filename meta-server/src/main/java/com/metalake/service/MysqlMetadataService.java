package com.metalake.service;

import com.metalake.bean.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MysqlMetadataService extends MetadataService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
@Override
    public List<Metadata> getMetadata(String dbName) {
        String sql = "SELECT TABLE_SCHEMA AS `database`, TABLE_NAME AS `table`," +
                " COLUMN_NAME AS `field`, COLUMN_TYPE AS `type`, COLUMN_KEY AS `key`," +
                " IS_NULLABLE as `null_able`," +
                "COLUMN_COMMENT AS `comment`" +
                " FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA ='"+dbName+"'";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        List<Metadata> metadataList = new ArrayList<Metadata>();
        for (Map<String, Object> row : rows) {
            Metadata metadata = new Metadata();
            metadata.setDatabase((String) row.get("database"));
            metadata.setTable((String) row.get("table"));
            metadata.setField((String) row.get("field"));
            metadata.setType((String) row.get("type"));
            metadata.setKey((String) row.get("key"));
            metadata.setNullAble((String) row.get("null_able"));
            metadata.setComment((String) row.get("comment"));

            metadataList.add(metadata);
        }
        return metadataList;
    }

}
