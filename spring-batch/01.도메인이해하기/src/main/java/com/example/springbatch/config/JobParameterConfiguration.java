package com.example.springbatch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class JobParameterConfiguration {

    private final StepBuilderFactory stepBuilderFactory;
    private final JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job jobParameterJob() {
        return jobBuilderFactory.get("jobParameterJob")
                .start(jobParameterStep())
                .build();
    }

    @Bean
    public Step jobParameterStep() {
        return stepBuilderFactory.get("jobParameterStep")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

                        JobParameters jobParameters = contribution.getStepExecution().getJobExecution().getJobParameters();
                        String name = jobParameters.getString("name");
                        System.out.println(name);

                        Map<String, Object> jobParametersMap = chunkContext.getStepContext().getJobParameters();
                        System.out.println(jobParametersMap.get("name"));

                        return RepeatStatus.FINISHED;
                    }
                })
                .build();
    }
}
