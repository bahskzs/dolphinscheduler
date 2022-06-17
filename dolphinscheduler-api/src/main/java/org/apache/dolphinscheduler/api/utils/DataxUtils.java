/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.api.utils;

import com.alibaba.druid.sql.dialect.clickhouse.parser.ClickhouseStatementParser;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.oracle.parser.OracleStatementParser;
import com.alibaba.druid.sql.dialect.postgresql.parser.PGSQLStatementParser;
import com.alibaba.druid.sql.dialect.sqlserver.parser.SQLServerStatementParser;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.dolphinscheduler.spi.enums.DbType;
import org.apache.dolphinscheduler.spi.utils.JSONUtils;

import java.util.HashMap;
import java.util.Map;

public class DataxUtils {



    /**
     *  为reader/writer的parameter追加相应配置
     * @param jsonStr
     * @param mode
     * @param configName
     * @param config
     * @return
     * @throws JsonProcessingException
     */
    public static String appendParameterConfig(String jsonStr,String mode,String configName, String config) throws JsonProcessingException {

        //获取json的各个部位的jsonNode
        Map<String, JsonNode> jsonNodeMap = getJsonNodes(jsonStr);

        ObjectNode json = (ObjectNode) jsonNodeMap.get("json");
        JsonNode job = jsonNodeMap.get("job");

        ArrayNode content = (ArrayNode) jsonNodeMap.get("content");

        // 获取reader / writer
        JsonNode readerOrWriter = jsonNodeMap.get(mode);

        // 在parameter中添加hadoopConfig
        ((ObjectNode) readerOrWriter.get("parameter")).put(configName,JSONUtils.parseObject(config));

        // 重新组装json
        ((ObjectNode) content.get(0)).put(mode,readerOrWriter);
        ((ObjectNode) job).put("content", content);
        json.put("job",job);

        return json.toString();
    }


    /***
     * 获取reader/writer 的类型
     * @param jsonStr
     * @return
     * @throws JsonProcessingException
     */
    public static Map<String,String> getPluginName(String jsonStr) throws JsonProcessingException {
        // 获取datax json各部分节点的jsonNodes
        Map<String,JsonNode> map = getJsonNodes(jsonStr);
        JsonNode reader = map.get("reader");
        JsonNode writer = map.get("writer");
        Map<String, String> result = new HashMap<>();
        result.put("reader",reader.get("name").toString().replace("\"","").toLowerCase().replace("reader",""));
        result.put("writer",writer.get("name").toString().replace("\"","").toLowerCase().replace("writer",""));
        return result;
    }


    /**
     * 获取datax json 的各个位置
     * @param jsonStr
     * @return
     * @throws JsonProcessingException
     */
    public static Map<String,JsonNode> getJsonNodes(String jsonStr) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(jsonStr);

        JsonNode job = json.get("job");
        ArrayNode content = (ArrayNode) mapper.readTree(job.get("content").toString());
        JsonNode reader = content.get(0).get("reader");
        JsonNode writer = content.get(0).get("writer");

        Map<String,JsonNode> map = new HashMap<>();
        map.put("json",json);
        map.put("job", job);
        map.put("content",content);
        map.put("reader",content.get(0).get("reader"));
        map.put("writer",content.get(0).get("writer"));
        //获取parameter
        map.put("readerParam", reader.get("parameter"));
        map.put("writerParam", writer.get("parameter"));
        return map;
    }



    /**
     *  格式化datax json
     * @param json
     * @return 返回格式化后的json串
     */
    public static String format(String json) {
        json = json.replace("\\n","");
        json = json.replace("\\\\\\\"","");
        json = json.replace("\\\"","\"");
        json = json.replace("  ","");
        json = json.replaceFirst("\"","");
        json = json.replace("\\\\u0001","\\u0001");
        return json.substring(0, json.length() - 1);
    }
}
