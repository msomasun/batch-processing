package com.example.batchprocessing.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping ("/load/exceltodb")
public class LoadController {

    @Autowired
    Job job;

    @Autowired
    JobLauncher jobLauncher;

    @GetMapping
    public void load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

        Map<String,JobParameter> maps = new HashMap<>();
        maps.put("time",new JobParameter(System.currentTimeMillis()));
        JobParameters params = new JobParameters(maps);
        JobExecution jobExecution= jobLauncher.run(job,params);
        System.out.println("begin of job status: "+jobExecution.getStatus());

        while(jobExecution.isRunning()) {
            System.out.println("job is still running");
        }
        System.out.println("end of job status: "+jobExecution.getStatus());
    }
}
