package com.zerobase.springbatch.job.lawd;

import static com.zerobase.springbatch.job.lawd.LawdFieldSetMapper.EXIST;
import static com.zerobase.springbatch.job.lawd.LawdFieldSetMapper.LAWD_CD;
import static com.zerobase.springbatch.job.lawd.LawdFieldSetMapper.LAWD_DONG;

import com.zerobase.springbatch.job.validator.FilePathParameterValidator;
import com.zerobase.springbatch.core.entity.Lawd;
import com.zerobase.springbatch.core.service.LawdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class LawdInsertJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final LawdService lawdService;

    @Bean
    public Job LawdInsertJob(Step lawdInsertStep) {
        return jobBuilderFactory.get("lawdInsertJob")
            .incrementer(new RunIdIncrementer())
            .validator(new FilePathParameterValidator())
            .start(lawdInsertStep)
            .build();
    }

    @JobScope
    @Bean
    public Step lawdInsertStep(FlatFileItemReader<Lawd> lawdFileItemReader,
                                ItemWriter<Lawd> lawdItemWriter) {
        return stepBuilderFactory.get("lawdInsertStep")
            .<Lawd, Lawd>chunk(1000)
            .reader(lawdFileItemReader)
            .writer(lawdItemWriter)
            .build();
    }

    @Bean
    @StepScope
    public FlatFileItemReader<Lawd> lawdFileItemReader(@Value("#{jobParameters['filePath']}") String filePath) {
        return new FlatFileItemReaderBuilder<Lawd>()
            .name("lawdFileItemReader")
            .delimited()
            .delimiter("\t")
            .names(LAWD_CD, LAWD_DONG, EXIST)
            .linesToSkip(1)
            .fieldSetMapper(new LawdFieldSetMapper())
            .resource(new ClassPathResource(filePath))
            .build();
    }

    @Bean
    @StepScope
    public ItemWriter<Lawd> lawdItemWriter() {
        return items -> items.forEach(lawdService::upsert);
    }

}
