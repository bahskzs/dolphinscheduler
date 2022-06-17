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

package org.apache.dolphinscheduler.api.configuration;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CustomHadoopConfiguration {

    @Value("${hadoop.ha}")
    private String mode;

    @Value("${hadoop.nameNodes}")
    private String nameNodes;

    @Value("${hadoop.nameService}")
    private String nameService;

    @Value("${hadoop.address}")
    private String address;

    private static final String PROXY = "org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider";

    protected Map<String, Object> values = new HashMap<>();

    public Map<String, Object> getParameters() {
        if (StringUtils.equals("true", mode)) {
            values.put("dfs.nameservices", nameService);
            values.put("dfs.ha.namenodes." + nameService, nameNodes);
            values.put("dfs.client.failover.proxy.provider." + nameService, PROXY);

            String[] nodeArr = address.split(",");
            String[] nameNodeArr = nameNodes.split(",");

            for (int i = 0; i < nodeArr.length; i++) {
                String node = nodeArr[i];
                String nameNode = nameNodeArr[i];
                values.put("dfs.namenode.rpc-address." + nameService + "." + nameNode, node);
            }
        }
        return values;
    }


}
