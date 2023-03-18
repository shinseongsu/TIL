package com.example.springbatch.support;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class JobRunner implements ApplicationRunner {

//    @Autowired
//    private JobLauncher jobLauncher;
//
//    @Autowired
//    private Job job;

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        JobParameters jobParameters = new JobParametersBuilder()
//                .addString("name", "user1")
//                .toJobParameters();
//
//        jobLauncher.run(job, jobParameters);
    }
}
