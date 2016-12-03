package org.leo.zeng.quartz.config;

import java.util.List;
import org.leo.zeng.quartz.pojo.ScheduleJob;

public class ScheduleConfigure {
    private List<ScheduleJob> startups;

    public List<ScheduleJob> getStartups() {
        return startups;
    }

    public void setStartups(List<ScheduleJob> startups) {
        this.startups = startups;
    }
}
