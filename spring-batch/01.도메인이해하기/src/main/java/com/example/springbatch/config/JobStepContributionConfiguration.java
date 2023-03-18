package com.example.springbatch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JobStepContributionConfiguration {

    private final StepBuilderFactory stepBuilderFactory;
    private final JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job stepContributionJob() {
        return jobBuilderFactory.get("stepContributionJob")
                .start(stepContributionStep())
                .build();
    }

    @Bean
    public Step stepContributionStep() {
        return stepBuilderFactory.get("stepContributionStep")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        String jobName = contribution.getStepExecution().getJobExecution().getJobInstance().getJobName();
                        System.out.println("jobName : " + jobName);
                        System.out.println(">> step1 has executed");
                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }

}
