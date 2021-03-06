# Cloudera-CDH-Kafka

https://cwiki.apache.org/confluence/display/KAFKA/0.8.0+Producer+Example

PATH=$PATH:$HOME/bin:/opt/cloudera/parcels/CDH/lib/zookeeper/bin/:/opt/cloudera/parcels/KAFKA/lib/kafka/bin/

kafka-topics --list --zookeeper master:2181

kafka-topics --create --zookeeper master:2181  --topic foo --partitions 5 --replication-factor 3

kafka-topics --zookeeper master:2181 --describe --topic foo

mvn clean compile assembly:single

java -jar target/ClouderaCDHKafka.jar

```
bin/kafka-console-producer.sh --zookeeper localhost:2181 --topic test 
This is a message
This is another message
```
```
> bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic test --from-beginning
This is a message
This is another message
```

```
time java -jar ClouderaCDHKafka.jar 100 >/dev/null 

real	0m1.373s
user	0m1.397s
sys	0m0.082s
```
```
time java -jar ClouderaCDHKafka.jar 1000 >/dev/null 

real	0m4.340s
user	0m3.875s
sys	0m0.173s
```
```
time java -jar ClouderaCDHKafka.jar 10000 >/dev/null 

real	0m17.640s
user	0m10.422s
sys	0m0.536s
```
```
time java -jar ClouderaCDHKafka.jar 100000 >/dev/null 

real	1m13.582s
user	0m29.265s
sys	0m3.180s
```

```
for j in 1 2 3 4 5 6 7 8 9 10
do 
  for i in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
  do 
    java -jar ClouderaCDHKafka.jar 1000000 > /dev/null 2>&1 & 
  done
done
```

![](https://github.com/thewertzgroup/Cloudera-CDH-Kafka/blob/master/images/KafkaLoad-0a.png)

![](https://github.com/thewertzgroup/Cloudera-CDH-Kafka/blob/master/images/KafkaLoad-0b.png)
