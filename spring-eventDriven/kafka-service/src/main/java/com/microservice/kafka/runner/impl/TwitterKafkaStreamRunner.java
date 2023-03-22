package com.microservice.kafka.runner.impl;

import com.microservice.kafka.config.TwitterKafkaConfigration;
import com.microservice.kafka.listener.TwitterKafkaStatusListener;
import com.microservice.kafka.runner.StreamRunner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import twitter4j.FilterQuery;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import javax.annotation.PreDestroy;
import java.util.Arrays;

@Component
@Slf4j
@RequiredArgsConstructor
public class TwitterKafkaStreamRunner implements StreamRunner {

    private final TwitterKafkaConfigration twitterKafkaConfigration;
    private final TwitterKafkaStatusListener twitterKafkaStatusListener;

    private TwitterStream twitterStream;

    @Override
    public void start() throws TwitterException {
        twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(twitterKafkaStatusListener);

        addFilter();
    }

    @PreDestroy
    public void shutDown() {
        if (twitterStream !=  null) {
            log.info("Closing witter stream!");
            twitterStream.shutdown();
        }
    }

    private void addFilter() {
        String[] keywords = twitterKafkaConfigration.getTwitterKeywords().toArray(new String[0]);
        FilterQuery filterQuery = new FilterQuery(keywords);
        twitterStream.filter(filterQuery);
        log.info("Started Filtering twitter stream for keywords : {}", Arrays.toString(keywords));
    }
}
