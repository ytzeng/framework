package org.leo.zeng.quartz.listener;

import java.util.List;
import org.leo.zeng.quartz.config.ScheduleConfigure;
import org.leo.zeng.quartz.pojo.ScheduleJob;
import org.leo.zeng.quartz.support.ScheduleManager;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ScheduleListener implements ApplicationListener<ContextRefreshedEvent> {
    private static Logger logger = LoggerFactory.getLogger(ScheduleListener.class);
    @Autowired
    private ScheduleConfigure configure;
    @Autowired
    private ScheduleManager manager;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() != null) {
            return;
        }
        logger.info(">>>>>>>>>>>>>>>>>>>>>> Schedule jobs init start");
        Scheduler scheduler = event.getApplicationContext().getBean(Scheduler.class);
        List<ScheduleJob> list = manager.getAllJob(scheduler);
        if (list != null && !list.isEmpty()) {
            for (ScheduleJob job : list) {
                manager.removeJob(scheduler, job);
                logger.info("****************** remove job:" + job.getJobName());
            }
        }
        List<ScheduleJob> jobs = configure.getStartups();
        if (jobs != null && !jobs.isEmpty()) {
            for (ScheduleJob job : jobs) {
                manager.addJob(scheduler, job);
                logger.info("****************** add job:" + job.getJobName());
            }

        }
        logger.info("<<<<<<<<<<<<<<<<<<<<<< Schedule jobs init end");
    }

}
