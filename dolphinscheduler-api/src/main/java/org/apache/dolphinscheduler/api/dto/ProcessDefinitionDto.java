package org.apache.dolphinscheduler.api.dto;/*
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


import org.apache.commons.lang3.StringUtils;
import org.apache.dolphinscheduler.common.enums.Flag;
import org.apache.dolphinscheduler.common.enums.ReleaseState;
import org.apache.dolphinscheduler.common.process.Property;
import org.apache.dolphinscheduler.common.utils.JSONUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.dolphinscheduler.dao.entity.TaskDefinition;
import org.apache.dolphinscheduler.dao.entity.TaskDefinitionLog;

/**
 * process definition
 */
public class ProcessDefinitionDto {

    private int status = 0;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ProcessDefinitionDto(int status, int id, long code, String name, int version, ReleaseState releaseState, long projectCode, String description, String globalParams, List<Property> globalParamList, Map<String, String> globalParamMap, Date createTime, Date updateTime, Flag flag, int userId, String userName, String projectName, String locations, ReleaseState scheduleReleaseState, int timeout, int tenantId, String tenantCode, String modifyBy, int warningGroupId, List<TaskDefinitionLog> taskDefinitionList) {
        this.status = status;
        this.id = id;
        this.code = code;
        this.name = name;
        this.version = version;
        this.releaseState = releaseState;
        this.projectCode = projectCode;
        this.description = description;
        this.globalParams = globalParams;
        this.globalParamList = globalParamList;
        this.globalParamMap = globalParamMap;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.flag = flag;
        this.userId = userId;
        this.userName = userName;
        this.projectName = projectName;
        this.locations = locations;
        this.scheduleReleaseState = scheduleReleaseState;
        this.timeout = timeout;
        this.tenantId = tenantId;
        this.tenantCode = tenantCode;
        this.modifyBy = modifyBy;
        this.warningGroupId = warningGroupId;
        this.taskDefinitionList = taskDefinitionList;
    }

    /**
     * id
     */

    private int id;

    /**
     * code
     */
    private long code;

    /**
     * name
     */
    private String name;

    /**
     * version
     */
    private int version;

    /**
     * release state : online/offline
     */
    private ReleaseState releaseState;

    /**
     * project code
     */
    private long projectCode;

    /**
     * description
     */
    private String description;

    /**
     * user defined parameters
     */
    private String globalParams;

    /**
     * user defined parameter list
     */

    private List<Property> globalParamList;

    /**
     * user define parameter map
     */

    private Map<String, String> globalParamMap;

    /**
     * create time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * update time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * process is valid: yes/no
     */
    private Flag flag;

    /**
     * process user id
     */
    private int userId;

    /**
     * user name
     */

    private String userName;

    /**
     * project name
     */

    private String projectName;

    /**
     * locations array for web
     */
    private String locations;

    /**
     * schedule release state : online/offline
     */

    private ReleaseState scheduleReleaseState;

    /**
     * process warning time out. unit: minute
     */
    private int timeout;

    /**
     * tenant id
     */
    private int tenantId;

    /**
     * tenant code
     */

    private String tenantCode;

    /**
     * modify user name
     */

    private String modifyBy;

    /**
     * warningGroupId
     */

    private int warningGroupId;

    private List<TaskDefinitionLog> taskDefinitionList;

    public List<TaskDefinitionLog> getTaskDefinitionList() {
        return taskDefinitionList;
    }

    public void setTaskDefinitionList(List<TaskDefinitionLog> taskDefinitionList) {
        this.taskDefinitionList = taskDefinitionList;
    }

    @Override
    public String toString() {
        return "ProcessDefinitionDto{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", releaseState=" + releaseState +
                ", projectCode=" + projectCode +
                ", description='" + description + '\'' +
                ", globalParams='" + globalParams + '\'' +
                ", globalParamList=" + globalParamList +
                ", globalParamMap=" + globalParamMap +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", flag=" + flag +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", locations='" + locations + '\'' +
                ", scheduleReleaseState=" + scheduleReleaseState +
                ", timeout=" + timeout +
                ", tenantId=" + tenantId +
                ", tenantCode='" + tenantCode + '\'' +
                ", modifyBy='" + modifyBy + '\'' +
                ", warningGroupId=" + warningGroupId +
                ", taskDefinitionList=" + taskDefinitionList +
                '}';
    }

    public ProcessDefinitionDto(int id, long code, String name, int version, ReleaseState releaseState, long projectCode, String description, String globalParams, List<Property> globalParamList, Map<String, String> globalParamMap, Date createTime, Date updateTime, Flag flag, int userId, String userName, String projectName, String locations, ReleaseState scheduleReleaseState, int timeout, int tenantId, String tenantCode, String modifyBy, int warningGroupId, List<TaskDefinitionLog> taskDefinitionList) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.version = version;
        this.releaseState = releaseState;
        this.projectCode = projectCode;
        this.description = description;
        this.globalParams = globalParams;
        this.globalParamList = globalParamList;
        this.globalParamMap = globalParamMap;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.flag = flag;
        this.userId = userId;
        this.userName = userName;
        this.projectName = projectName;
        this.locations = locations;
        this.scheduleReleaseState = scheduleReleaseState;
        this.timeout = timeout;
        this.tenantId = tenantId;
        this.tenantCode = tenantCode;
        this.modifyBy = modifyBy;
        this.warningGroupId = warningGroupId;
        this.taskDefinitionList = taskDefinitionList;
    }

    public ProcessDefinitionDto() {
    }

    public ProcessDefinitionDto(long projectCode,
                             String name,
                             long code,
                             String description,
                             String globalParams,
                             String locations,
                             int timeout,
                             int userId,
                             int tenantId) {
        set(projectCode, name, description, globalParams, locations, timeout, tenantId);
        this.code = code;
        this.userId = userId;
        Date date = new Date();
        this.createTime = date;
        this.updateTime = date;
    }

    public void set(long projectCode,
                    String name,
                    String description,
                    String globalParams,
                    String locations,
                    int timeout,
                    int tenantId) {
        this.projectCode = projectCode;
        this.name = name;
        this.description = description;
        this.globalParams = globalParams;
        this.locations = locations;
        this.timeout = timeout;
        this.tenantId = tenantId;
        this.flag = Flag.YES;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReleaseState getReleaseState() {
        return releaseState;
    }

    public void setReleaseState(ReleaseState releaseState) {
        this.releaseState = releaseState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getGlobalParams() {
        return globalParams;
    }

    public void setGlobalParams(String globalParams) {
        this.globalParamList = JSONUtils.toList(globalParams, Property.class);
        if (this.globalParamList == null) {
            this.globalParamList = new ArrayList<>();
        }
        this.globalParams = globalParams;
    }

    public List<Property> getGlobalParamList() {
        return globalParamList;
    }

    public void setGlobalParamList(List<Property> globalParamList) {
        this.globalParamList = globalParamList;
    }

    public Map<String, String> getGlobalParamMap() {
        if (globalParamMap == null && StringUtils.isNotEmpty(globalParams)) {
            List<Property> propList = JSONUtils.toList(globalParams, Property.class);
            globalParamMap = propList.stream().collect(Collectors.toMap(Property::getProp, Property::getValue));
        }

        return globalParamMap;
    }

    public void setGlobalParamMap(Map<String, String> globalParamMap) {
        this.globalParamMap = globalParamMap;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public ReleaseState getScheduleReleaseState() {
        return scheduleReleaseState;
    }

    public void setScheduleReleaseState(ReleaseState scheduleReleaseState) {
        this.scheduleReleaseState = scheduleReleaseState;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(long projectCode) {
        this.projectCode = projectCode;
    }

    public int getWarningGroupId() {
        return warningGroupId;
    }

    public void setWarningGroupId(int warningGroupId) {
        this.warningGroupId = warningGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProcessDefinitionDto that = (ProcessDefinitionDto) o;
        return projectCode == that.projectCode
                && userId == that.userId
                && timeout == that.timeout
                && tenantId == that.tenantId
                && Objects.equals(name, that.name)
                && releaseState == that.releaseState
                && Objects.equals(description, that.description)
                && Objects.equals(globalParams, that.globalParams)
                && flag == that.flag
                && Objects.equals(locations, that.locations);
    }

}