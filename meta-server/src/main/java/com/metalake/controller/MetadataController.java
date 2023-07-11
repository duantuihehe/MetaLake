package com.metalake.controller;

import com.metalake.bean.Metadata;
import com.metalake.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/metadata")
public class MetadataController {

    @Autowired
    private MetadataService metadataService;

    @GetMapping
    public List<Metadata> getMetadata(@RequestParam(defaultValue = "test") String dbName) {
        System.out.println(dbName);

        return metadataService.getMetadata(dbName);
    }

}