package org.ukg.healthmonitor.producer.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.ukg.healthmonitor.producer.controller.KafkaController;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class Scheduler {

    private static AtomicBoolean isRunning = new AtomicBoolean(false);
    Random random = new Random();
    private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);

    @Scheduled(fixedRate = 1000)
    public void generateEvent(){
        if(isRunning.get()){
            int temperature = random.nextInt(30,70);
            int heartRate = random.nextInt(200);

            logger.info("Temperature: {}°C", temperature);
            logger.info("Heart rate: {} beats per minute", heartRate);
        }
    }

    public void startScheduler(){
        isRunning.set(true);
        logger.info("Scheduler started");
    }

    public void stopScheduler(){
        isRunning.set(false);
        logger.info("Scheduler stopped");
    }
}
