package org.leo.zeng.quartz.pojo;

import java.util.Map;
import org.leo.zeng.quartz.service.JobService;

/**
 * 定时任务实体
 * @author soento
 * @date 2016年6月27日 下午5:32:10
 */
public class ScheduleJob {
    /**
     * 任务名
     */
    private String jobName;
    /**
     * 任务组名
     */
    private String jobGroup;
    /**
     * 触发器名
     */
    private String triggerName;
    /**
     * 触发器组名
     */
    private String triggerGroupName;
    /**
     * 时间设置
     */
    private String cronExpression;
    /**
     * 自定义参数
     */
    private Map<String, Object> data;
    /**
     * 状态
     */
    private String status;
    /**
     * Job Class
     */
    private Class<? extends JobService> jobClass;

    /**
     * @return the jobName
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * @param jobName the jobName to set
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * @return the jobGroup
     */
    public String getJobGroup() {
        return jobGroup;
    }

    /**
     * @param jobGroup the jobGroup to set
     */
    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    /**
     * @return the triggerName
     */
    public String getTriggerName() {
        return triggerName;
    }

    /**
     * @param triggerName the triggerName to set
     */
    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    /**
     * @return the triggerGroupName
     */
    public String getTriggerGroupName() {
        return triggerGroupName;
    }

    /**
     * @param triggerGroupName the triggerGroupName to set
     */
    public void setTriggerGroupName(String triggerGroupName) {
        this.triggerGroupName = triggerGroupName;
    }

    /**
     * @return the cronExpression
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * @param cronExpression the cronExpression to set
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /**
     * @return the data
     */
    public Map<String, Object> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the jobClass
     */
    public Class<? extends JobService> getJobClass() {
        return jobClass;
    }

    /**
     * @param jobClass the jobClass to set
     */
    public void setJobClass(Class<? extends JobService> jobClass) {
        this.jobClass = jobClass;
    }
}
