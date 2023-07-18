package com.metalake.controller;

import com.alibaba.fastjson.JSON;
import com.metalake.bean.MetaBody;
import com.metalake.bean.Metadata;
import com.metalake.service.MetadataService;
import com.metalake.utils.MysqlConvertToPaimon;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/api/metadata")
public class MetadataController {

    private MetadataService metadataService;

    @PostMapping("/getAllMeta")
    public List<Metadata> getMetadata(@RequestBody String body) {
        MetaBody metaBody = JSON.parseObject(body, MetaBody.class);
        getService(metaBody);
        return metadataService.getMetadata(metaBody.getDbName());
    }

    @PostMapping("/getTables")
    public List<String> getTables(@RequestBody String body) {
        MetaBody metaBody = JSON.parseObject(body, MetaBody.class);
        getService(metaBody);
        return metadataService.getTables(metaBody.getDbName());
    }

    @PostMapping("/getTableMeta")
    public List<Metadata> getTableMeta(@RequestBody String body) {
        MetaBody metaBody = JSON.parseObject(body, MetaBody.class);
        getService(metaBody);
        return metadataService.getTableMeta(metaBody.getDbName(),metaBody.getTable());
    }
    @PostMapping("/getDatabases")
    public List<String> getDatabases(@RequestBody String body) {
        MetaBody metaBody = JSON.parseObject(body, MetaBody.class);
        getService(metaBody);
        return metadataService.getDatabases();
    }

    @PostMapping("/getDDL")
    public String getTableDDL(@RequestBody String body) {
        String s = MysqlConvertToPaimon.generateFlinkDDL(body);
        return s;
    }
    private void getService(MetaBody metaBody) {
        String serviceClassName = metaBody.getServiceClassName();
        try {
            metadataService = (MetadataService) Class.forName(serviceClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        metadataService.open(metaBody.getJdbcConfig());
    }
}