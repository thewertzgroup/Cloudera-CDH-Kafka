# Cloudera-CDH-Kafka

PATH=$PATH:$HOME/bin:/opt/cloudera/parcels/KAFKA-2.0.1-1.2.0.1.p0.5/lib/kafka/bin

kafka-topics --list --zookeeper master:2181

kafka-create-topic.sh --topic foo --replica 3 --zookeeper master:2181 --partition 5

mvn clean compile assembly:single

java -jar target/ClouderaCDHKafka.jar
