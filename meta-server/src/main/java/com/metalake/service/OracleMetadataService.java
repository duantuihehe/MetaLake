package com.metalake.service;

import com.metalake.bean.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OracleMetadataService extends MetadataService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
@Override
    public List<Metadata> getMetadata(String dbName) {

        return null;
    }

}
