package com.metalake.utils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.flink.table.api.DataTypes;

public class MysqlConvertToPaimon {
    public static String generateFlinkDDL(String body) {
        StringBuilder ddlBuilder = new StringBuilder();
        JSONArray objects = JSON.parseArray(body);
        String table = objects.getJSONObject(0).getString("table");

        ddlBuilder.append("CREATE TABLE if not exists ");
        ddlBuilder.append(table);
        ddlBuilder.append("(\n");
        for (int i = 0; i < objects.size(); i++) {
            JSONObject jsonObject = objects.getJSONObject(i);
            String field = jsonObject.getString("field");
            String type = jsonObject.getString("type");
            String key = jsonObject.getString("key");
            String comment = jsonObject.getString("comment");
            String flinkType = convertToFLinkType(type.toUpperCase());
            ddlBuilder.append("  ").append(field).append(" ").append(flinkType).append(",\n");

        }

        ddlBuilder.setLength(ddlBuilder.length() - 2); // 移除最后一个字段后面的逗号和换行符
        ddlBuilder.append("\n)");

        return ddlBuilder.toString();
    }

    public  static  String convertToFLinkType(String mysqlType) {
        if (mysqlType.startsWith("VARCHAR")) {
            return DataTypes.STRING().toString();
        } else if (mysqlType.startsWith("INT")) {
            return DataTypes.INT().toString();
        } else if (mysqlType.startsWith("BIGINT")) {
            return DataTypes.BIGINT().toString();
        } else if (mysqlType.startsWith("FLOAT")) {
            return DataTypes.FLOAT().toString();
        } else if (mysqlType.startsWith("DOUBLE")) {
            return DataTypes.DOUBLE().toString();
        } else if (mysqlType.startsWith("DECIMAL")) {
            return DataTypes.DECIMAL(10, 2).toString(); // 替换为实际的 DECIMAL 精度和范围
        } else if (mysqlType.startsWith("BOOLEAN")) {
            return DataTypes.BOOLEAN().toString();
        } else if (mysqlType.startsWith("DATE")) {
            return DataTypes.DATE().toString();
        } else if (mysqlType.startsWith("DATETIME")) {
            return DataTypes.TIMESTAMP().toString();
        } else {
            // 其他类型处理方式
            return "UNKNOWN";
        }
    }

}
