package org.leo.zeng.quartz.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.leo.zeng.core.exception.ServiceException;
import org.leo.zeng.quartz.pojo.ScheduleJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;

/**
 * 定时任务管理类
 * @author soento
 * @date 2016年6月27日 下午5:32:52
 */
public class ScheduleManager {
    public final static String SPRING_APPLICATION_CONTEXT = "applicationContext";

    private JobKey getJobKey(Scheduler scheduler, ScheduleJob job) {
        JobKey jobKey = null;
        if (job.getJobGroup() != null) {
            jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
        } else {
            jobKey = JobKey.jobKey(job.getJobName());
        }
        return jobKey;
    }

    private TriggerKey getTriggerKey(Scheduler scheduler, ScheduleJob job) {
        TriggerKey triggerKey = null;
        if (job.getTriggerGroupName() != null) {
            triggerKey = TriggerKey.triggerKey(job.getTriggerName(), job.getTriggerGroupName());
        } else {
            triggerKey = TriggerKey.triggerKey(job.getTriggerName());
        }
        return triggerKey;
    }

    private CronTrigger getTrigger(Scheduler scheduler, ScheduleJob job) throws SchedulerException {
        return (CronTrigger) scheduler.getTrigger(getTriggerKey(scheduler, job));
    }

    private CronTrigger newTrigger(Scheduler scheduler, ScheduleJob job) {
        if (job.getTriggerGroupName() != null) {
            return TriggerBuilder.newTrigger().withIdentity(job.getTriggerName(), job.getTriggerGroupName()).withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpression())).build();
        } else {
            return TriggerBuilder.newTrigger().withIdentity(job.getTriggerName()).withSchedule(CronScheduleBuilder.cronSchedule(job.getCronExpression())).build();
        }
    }

    private JobDetail getJobDetail(Scheduler scheduler, ScheduleJob job) {
        try {
            JobDetail jobDetail = null;
            if (job.getJobGroup() != null) {
                jobDetail = JobBuilder.newJob(job.getJobClass()).withIdentity(job.getJobName(), job.getJobGroup()).build();
            } else {
                jobDetail = JobBuilder.newJob(job.getJobClass()).withIdentity(job.getJobName()).build();
            }
            return jobDetail;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * 添加一个定时任务
     * @param scheduler 调度员
     * @param job 调度任务
     */
    public void addJob(Scheduler scheduler, ScheduleJob job) {
        try {
            TriggerKey triggerKey = getTriggerKey(scheduler, job);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (null == trigger) {
                JobDetail jobDetail = getJobDetail(scheduler, job);
                if (job.getData() != null) {
                    jobDetail.getJobDataMap().putAll(job.getData());
                }
                trigger = newTrigger(scheduler, job);
                scheduler.scheduleJob(jobDetail, trigger);
            } else {
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * 修改一个任务
     * @param scheduler 调度员
     * @param job 调度任务
     */
    public void modifyJob(Scheduler scheduler, ScheduleJob job) {
        try {
            CronTrigger trigger = getTrigger(scheduler, job);
            if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(job.getCronExpression())) {
                removeJob(scheduler, job);
                addJob(scheduler, job);
            }
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * 移除一个任务
     * @param scheduler 调度员
     * @param job 调度任务
     */
    public void removeJob(Scheduler scheduler, ScheduleJob job) {
        try {
            // 停止触发器
            scheduler.pauseTrigger(getTriggerKey(scheduler, job));
            // 移除触发器
            scheduler.unscheduleJob(getTriggerKey(scheduler, job));
            scheduler.deleteJob(getJobKey(scheduler, job));// 删除任务
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * 立即执行一个任务
     * @param scheduler 调度员
     * @param schedule 调度任务
     */
    public void startJob(Scheduler scheduler, ScheduleJob schedule) {
        try {
            JobKey jobKey = getJobKey(scheduler, schedule);
            scheduler.triggerJob(jobKey);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * 恢复一个任务
     * @param scheduler 调度员
     * @param schedule 调度任务
     */
    public void resumeJob(Scheduler scheduler, ScheduleJob schedule) {
        try {
            JobKey jobKey = getJobKey(scheduler, schedule);
            scheduler.resumeJob(jobKey);
            scheduler.triggerJob(jobKey);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * 暂停一个任务
     * @param scheduler 调度员
     * @param schedule 调度任务
     */
    public void pauseJob(Scheduler scheduler, ScheduleJob schedule) {
        try {
            JobKey jobKey = getJobKey(scheduler, schedule);
            scheduler.pauseJob(jobKey);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * 启动所有定时任务
     * @param scheduler 调度员
     */
    public void start(Scheduler scheduler) {
        try {
            scheduler.start();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * 关闭所有任务
     * @param scheduler 调度员
     */
    public void shutdown(Scheduler scheduler) {
        try {
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * 获取所有计划中的任务列表
     * @param scheduler 调度员
     * @return 任务列表
     */
    public List<ScheduleJob> getAllJob(Scheduler scheduler) {
        try {
            GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
            Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
            List<ScheduleJob> jobList = new ArrayList<ScheduleJob>();
            for (JobKey jobKey : jobKeys) {
                List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                for (Trigger trigger : triggers) {
                    ScheduleJob job = new ScheduleJob();
                    job.setJobName(jobKey.getName());
                    job.setJobGroup(jobKey.getGroup());
                    job.setTriggerName(trigger.getKey().getName());
                    job.setTriggerGroupName(trigger.getKey().getGroup());
                    Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                    job.setStatus(triggerState.name());
                    if (trigger instanceof CronTrigger) {
                        CronTrigger cronTrigger = (CronTrigger) trigger;
                        job.setCronExpression(cronTrigger.getCronExpression());
                    }
                    jobList.add(job);
                }
            }
            return jobList;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * 获取所有正在运行的job
     * @param scheduler 调度员
     * @return 任务列表
     */
    public List<ScheduleJob> getRunningJob(Scheduler scheduler) {
        try {
            List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
            List<ScheduleJob> jobList = new ArrayList<ScheduleJob>();
            for (JobExecutionContext executingJob : executingJobs) {
                ScheduleJob job = new ScheduleJob();
                JobDetail jobDetail = executingJob.getJobDetail();
                JobKey jobKey = jobDetail.getKey();
                Trigger trigger = executingJob.getTrigger();
                job.setJobName(jobKey.getName());
                job.setJobGroup(jobKey.getGroup());
                job.setTriggerName(trigger.getKey().getName());
                job.setTriggerGroupName(trigger.getKey().getGroup());
                Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                job.setStatus(triggerState.name());
                if (trigger instanceof CronTrigger) {
                    CronTrigger cronTrigger = (CronTrigger) trigger;
                    job.setCronExpression(cronTrigger.getCronExpression());
                }
                jobList.add(job);
            }
            return jobList;
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
