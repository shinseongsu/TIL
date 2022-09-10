package com.zerobase.springbatch.job.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.zerobase.springbatch.adapter.FakeSendService;
import com.zerobase.springbatch.BatchTestConfig;
import com.zerobase.springbatch.core.dto.AptDto;
import com.zerobase.springbatch.core.entity.AptNotification;
import com.zerobase.springbatch.core.entity.Lawd;
import com.zerobase.springbatch.core.repository.AptNotificationRepository;
import com.zerobase.springbatch.core.repository.LawdRepository;
import com.zerobase.springbatch.core.service.AptDealService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBatchTest
@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = {AptNotificationJobConfig.class, BatchTestConfig.class})
public class AptNotificationJobConfigTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private AptNotificationRepository aptNotificationRepository;

    @MockBean
    private AptDealService aptDealService;

    @MockBean
    private LawdRepository lawdRepository;

    @MockBean
    private FakeSendService fakeSendService;

    @AfterEach
    public void tearDown() {
        aptNotificationRepository.deleteAll();
    }

    @Test
    public void success() throws Exception {
        // given
        LocalDate dealDate = LocalDate.now().minusDays(1);
        String guLawdCd = "11110";
        String email = "abc@gmail.com";
        String anotherEmail = "efg@gmail.com";

        givenAptNotification(guLawdCd, email, true);
        givenAptNotification(guLawdCd, anotherEmail, false);
        givenLawdCd(guLawdCd);
        givenAptDeal(guLawdCd, dealDate);

        // when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob(
            new JobParameters(Maps.newHashMap("dealDate", new JobParameter(dealDate.toString())))
        );

        // then
        assertEquals(jobExecution.getExitStatus(), ExitStatus.COMPLETED);
        verify(fakeSendService, times(1)).send(eq(email), anyString());
        verify(fakeSendService, never()).send(eq(anotherEmail), anyString());
    }

    private void givenAptNotification(String guLawdCd, String email, boolean enabled) {
        AptNotification notification = new AptNotification();
        notification.setEmail(email);
        notification.setGuLawdCd(guLawdCd);
        notification.setEnabled(enabled);
        notification.setCreatedAt(LocalDateTime.now());
        notification.setUpdatedAt(LocalDateTime.now());
        aptNotificationRepository.save(notification);
    }

    private void givenLawdCd(String guLawdCd) {
        String lawdCd = guLawdCd + "00000";
        Lawd lawd = new Lawd();
        lawd.setLawdCd(lawdCd);
        lawd.setLawdDong("경기도 성남시 분당구");
        lawd.setExist(true);
        lawd.setCreatedAt(LocalDateTime.now());
        lawd.setUpdatedAt(LocalDateTime.now());
        when(lawdRepository.findByLawdCd(lawdCd))
            .thenReturn(Optional.of(lawd));
    }

    private void givenAptDeal(String guLawdCd, LocalDate dealDate) {
        when(aptDealService.findByGuLawdCdAndDealDate(guLawdCd, dealDate))
            .thenReturn(Arrays.asList(
                new AptDto("IT아파트", 2000000000L),
                new AptDto("탄천아파트", 1500000000L)
            ));
    }

}
