# Kafka
A Springboot Project with Kafka demonstrating their integration, setup and usage

Steps to simulate the project

1. Download and install kafka and zookeeper servers
2. Start the Zookeper server from kafka directory on port 2181 using below command
    .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
3. Start the Kafka server on port 9092 using below command
    .\bin\windows\kafka-server-start.bat .\config\server.properties
4. Run the application as springboot application
5. Send the message on the webservice on below url
    http://localhost:8081/api/v1/kafka/publish?message=<Message>
    e.g: http://localhost:8081/api/v1/kafka/publish?message=Test5
6. Verify the message on teminal log or on command prompt using below command 
    .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic kafkaTopic1 --from-beginning