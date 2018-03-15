package com.ht.job;

import org.springframework.stereotype.Component;

/**
 * @author 曾志湖
 * @date 2018/3/15 9:24
 */
@Component
public class AlertJob {

    public void run() {
        System.out.println("警告！！！");
    }

}
