package com.example.springbatch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JobStepExecutionConfiguration {

    private final StepBuilderFactory stepBuilderFactory;
    private final JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job stepExecutionJob() {
        return jobBuilderFactory.get("stepExecutionJob")
                .start(stepExecutionStep1())
                .next(stepExecutionStep2())
                .build();
    }

    @Bean
    public Step stepExecutionStep1() {
        return stepBuilderFactory.get("stepExecutionStep1")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("step1 execute start");
                    throw new RuntimeException("step1 has failed");
                })
                .build();
    }

    @Bean
    public Step stepExecutionStep2() {
        return stepBuilderFactory.get("stepExecutionStep2")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("step2 has executed");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}
