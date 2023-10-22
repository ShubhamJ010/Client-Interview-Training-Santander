package com.coforge.springdemo.batch.executors;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserJobExecutor {

    @Autowired
    @Qualifier("importUserJob")
    private Job userJob;

    @Autowired
    private JobLauncher jobLauncher;

    @Scheduled(cron = "0 4 13 * * *")
    public void launchUserJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

        jobLauncher.run(userJob, new JobParametersBuilder().addLong("start_time", System.currentTimeMillis()).toJobParameters());

    }
}
