package org.gopas.springbootdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
@EnableScheduling
public class SchedulingConfig {

    // Quartz library for advanced

    @Value("${print.value:300}")
    private Integer printDelay;

    @Scheduled(fixedDelay = 30000)
    public void print() {
        System.out.println("Print called: " + Instant.now());
    }
}
