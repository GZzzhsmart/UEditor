package com.ht.job;

import org.springframework.stereotype.Component;


@Component
public class CacheClearJob {

    public void run() {
        System.out.println("清空缓存");
    }

}
