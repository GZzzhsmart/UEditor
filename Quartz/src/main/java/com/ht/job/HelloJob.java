package com.ht.job;

import org.springframework.stereotype.Component;


@Component
public class HelloJob {

    public void run() {
        System.out.println("hello!");
    }

}
