# Kafka Demo Spring Boot Project

This project demonstrates how to send and receive messages using Apache Kafka with Spring Boot.

## Features
- REST endpoint to send messages to Kafka
- Kafka listener to receive messages

## Requirements
- Java 17+
- Maven
- Kafka running locally on port 9092

## How to Run
1. Start your local Kafka broker on port 9092.
2. Build and run the Spring Boot application:
3. Send a message using curl or Postman:
   ```sh
   curl -X POST http://localhost:8080/api/kafka/send -H "Content-Type: text/plain" -d "Hello Kafka!"
   ```
4. Check the application logs to see the received message.

## Configuration
Kafka properties are set in `src/main/resources/application.properties`.

## Files
- `KafkaProducerController.java`: REST controller to send messages
- `KafkaConsumerService.java`: Kafka listener to receive messages
- `application.properties`: Kafka and topic configuration
