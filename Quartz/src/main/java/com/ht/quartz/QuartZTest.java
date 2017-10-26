package com.ht.quartz;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartZTest {

    /**
     * 作业调度器
     * 作业触发器
     * @param args
     */
    public static void main(String[] args){
        try{
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("helloJob").build();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger","group").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(5)).build();
            scheduler.start();
            JobDetail cacheClearJob = JobBuilder.newJob(CacheClearJob.class).withIdentity("cacheClearJob").build();
            //　每个月的26号，下午15点10分0秒执行清空缓存的操作
            Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("trigger1", "group2")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/10 10 15 26 * ? *")).build();

            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.scheduleJob(cacheClearJob, trigger1);
            System.out.println(scheduler.checkExists(new JobKey("helloJob")));
            // scheduler.clear();
        }catch(SchedulerException e){
            e.printStackTrace();
        }
    }
}
