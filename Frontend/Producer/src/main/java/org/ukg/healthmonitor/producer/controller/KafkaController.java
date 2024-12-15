package org.ukg.healthmonitor.producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ukg.healthmonitor.producer.scheduler.Scheduler;

@RestController
public class KafkaController {

    @Autowired
    Scheduler scheduler;
    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @GetMapping("/start")
    public String startHealth(){
        logger.info("Starting health monitoring");
        scheduler.startScheduler();
        return "Started health monitoring" ;
    }

    @GetMapping("/stop")
    public String stopHealth(){
        logger.info("Stopping health monitoring");
        scheduler.stopScheduler();
        return "Stopped health monitoring" ;
    }
}
