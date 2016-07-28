# Cloudera-CDH-Kafka

https://cwiki.apache.org/confluence/display/KAFKA/0.8.0+Producer+Example

PATH=$PATH:$HOME/bin:/opt/cloudera/parcels/KAFKA-2.0.1-1.2.0.1.p0.5/lib/kafka/bin

kafka-topics --list --zookeeper master:2181

kafka-topics --create --zookeeper master:2181  --topic foo --partitions 5 --replication-factor 3

kafka-topics --zookeeper master:2181 --describe --topic foo

mvn clean compile assembly:single

java -jar target/ClouderaCDHKafka.jar
