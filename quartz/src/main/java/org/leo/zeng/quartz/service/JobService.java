package org.leo.zeng.quartz.service;

import org.leo.zeng.quartz.support.ScheduleManager;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

/**
 * 定时任务业务基类
 */
public abstract class JobService implements Job {
    private static Logger logger = LoggerFactory.getLogger(JobService.class);
    protected ApplicationContext applicationContext;
    protected JobExecutionContext context;
    private JobDataMap data;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            this.applicationContext = (ApplicationContext) context.getScheduler().getContext().get(ScheduleManager.SPRING_APPLICATION_CONTEXT);
            this.context = context;
            this.data = context.getJobDetail().getJobDataMap();
            execute();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new JobExecutionException(e);
        }
    }

    protected Object getData(Object key) {
        return data.get(key);
    }

    public abstract void execute();
}
