package com.ht.common;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob implements Job{
    /**
     * 定时调度的方法
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("我是被定时调度的方法啊，当前时间为："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SS").format(new Date()));
    }
}
