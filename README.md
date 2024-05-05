To Start Zookeeper:
-------------------
Run the following command in the command prompt (assuming Kafka bin/windows directory):
zookeeper-server-start.bat ..\..\config\zookeeper.properties

Zookeeper is a centralized service for maintaining configuration information, providing distributed synchronization, and naming.

To Start Kafka Broker (Kafka Server):
--------------------------------------
Run the following command in the command prompt (assuming Kafka bin/windows directory):
kafka-server-start.bat ..\..\config\server.properties

The Kafka broker is the central component of Kafka. It handles the message storage, replication, and serving consumers.

To Create a Topic:
------------------
Run the following command in the command prompt:
kafka-topics.bat --create --topic my-topic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 3

Topics in Kafka are categories or feeds to which messages are published by producers and from which messages are consumed by consumers.

To Produce Data to a Topic:
---------------------------
Run the following command in the command prompt:
kafka-console-producer.bat --broker-list localhost:9092 --topic my-topic

This command allows you to write data to a Kafka topic from the console. Producers publish messages to Kafka topics.

To Consume Data from a Topic:
------------------------------
Run the following command in the command prompt:
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my-topic --from-beginning

Consumers read messages from Kafka topics. This command reads data from the beginning of the topic.

Note: When a Kafka console consumer is started, a consumer group ID is assigned to it by default, such as "console-consumer-2682".

Additional Commands and Details:
--------------------------------
- To list all topics in the Kafka cluster:
  kafka-topics.bat --bootstrap-server=localhost:9092 --list

- To list all consumer groups in the Kafka cluster:
  kafka-consumer-groups.bat --bootstrap-server=localhost:9092 --list

- To see the details of partitions for a specific topic:
  kafka-topics.bat --describe --topic my-topic --bootstrap-server=localhost:9092

- To manually assign a consumer group ID to a consumer:
  kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my-topic --group my-consumer-group

These commands provide administrative functionalities such as listing topics, consumer groups, and viewing partition details.


1. Describe Consumer Group Details:
-----------------------------------
To view detailed information about a specific consumer group, including the lag of each consumer within the group:
kafka-consumer-groups.bat --bootstrap-server=localhost:9092 --group my-consumer-group --describe

This command provides insights into the consumers within the specified consumer group, their current lag, and other related details.

2. Alter Topic Configuration:
------------------------------
To modify the configuration of an existing topic, such as changing the number of partitions or replication factor:
kafka-topics.bat --alter --topic my-topic --bootstrap-server localhost:9092 --partitions 5

This command allows you to dynamically adjust the configuration of a topic without needing to delete and recreate it.

3. Offset Management:
---------------------
To reset offsets for a consumer group to a specific offset or to the earliest or latest available offset:
kafka-consumer-groups.bat --bootstrap-server=localhost:9092 --group my-consumer-group --reset-offsets --to-earliest --execute --topic my-topic

This command is useful for managing consumer group offsets, especially when reprocessing data or handling consumer group rebalances.

4. List Consumer Group Offsets:
-------------------------------
To list the current offset positions for each partition of a topic within a consumer group:
kafka-consumer-groups.bat --bootstrap-server=localhost:9092 --group my-consumer-group --describe

This command provides detailed information about the offset position for each partition within the specified consumer group.

5. Delete Topic:
---------------
To delete an existing topic from the Kafka cluster:
kafka-topics.bat --bootstrap-server localhost:9092 --delete --topic my-topic

Use this command with caution as it permanently removes the topic and its associated data from the Kafka cluster.

6. Mirror Maker:
----------------
To replicate data from one Kafka cluster to another in a separate data center or environment:
kafka-mirror-maker.bat --consumer.config source-cluster-consumer.properties --producer.config target-cluster-producer.properties --whitelist='.*'

Mirror Maker is used for disaster recovery, data migration, or multi-datacenter replication scenarios.

These additional Kafka commands provide advanced functionalities for managing topics, consumers, offsets, and data replication across Kafka clusters.
