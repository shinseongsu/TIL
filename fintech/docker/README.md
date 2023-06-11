# kafka topic 보기

docker에 있는 kafka bash 들어가기

~~~
docker exec -it kafka bash
~~~

topic 리스트 보기

~~~
kafka-topics.sh --list --bootstrap-server localhost:9092
~~~

topic 생성하기

~~~
bash-5.1# kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test
Created topic test.
~~~

kafka topic 넣은 로그 보기

~~~
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic loan_request --from-beginning
~~~
