package com.ht.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author 曾志湖
 * @date 2018/3/15 8:09
 */
public class MoneyJob implements Job{

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("发送提醒……");
    }
}
