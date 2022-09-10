## spring-batch 예제 만들기

1. docker-compose 실행

```shell
docker-compose up -d
```

insert test

--spring.batch.job.names=lawdInsertJob -filePath=LAWN_CODE.txt

--spring.batch.job.names=aptDealInsertJob -yearMonth=2021-08

--spring.batch.job.names=aptNotificationJob -dealDate=2021-07-01