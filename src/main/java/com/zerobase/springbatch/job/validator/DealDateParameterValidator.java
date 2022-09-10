package com.zerobase.springbatch.job.validator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.util.StringUtils;

public class DealDateParameterValidator implements JobParametersValidator {
    private static final String DEAL_DATE = "dealDate";

    @Override
    public void validate(JobParameters parameters) throws JobParametersInvalidException {
        String dealDate = parameters.getString(DEAL_DATE);
        if (!StringUtils.hasText(dealDate)) {
            throw new JobParametersInvalidException(DEAL_DATE + "가 빈 문자열이거나 존재하지 않습니다.");
        }

        try {
            LocalDate.parse(dealDate);
        } catch (DateTimeParseException e) {
            throw new JobParametersInvalidException(DEAL_DATE + "가 올바른 날짜 형식이 아닙니다. yyyy-MM-dd이여야 합니다.");
        }
    }
}
