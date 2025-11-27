# Running Kafka Locally on Windows

Follow these steps to set up and run Apache Kafka on your Windows system.

## 1. Download Kafka

- Download the Kafka binaries from the [official Apache Kafka website](https://dlcdn.apache.org/kafka/4.1.1/kafka_2.13-4.1.1.tgz).

## 2. Extract Kafka

- Extract the downloaded `.tgz` archive to `C:\` (you should have a folder like `C:\kafka_2.13-4.1.1`).

## 3. Open PowerShell

- Launch PowerShell and navigate to the Kafka directory:

  ```powershell
  cd C:\kafka_2.13-4.1.1\
  ```

## 4. Generate a Unique Storage ID

- Run the following command to generate a unique ID for Kafka's storage configuration:

  ```powershell
  .\bin\windows\kafka-storage.bat random-uuid
  ```

- Copy the generated UUID (ignore any errors or warnings).

## 5. Format the Storage Directory

- Initialize the message storage engine by running:

  ```powershell
  .\bin\windows\kafka-storage.bat format -t <GENERATED_UUID> -c .\config\server.properties --standalone
  ```

  > Replace `<GENERATED_UUID>` with the UUID you copied in the previous step.

## 6. Start the Kafka Server

- Start the Kafka server with:

  ```powershell
  .\bin\windows\kafka-server-start.bat .\config\server.properties
  ```

## 7. Stop the Kafka Server

- To stop the Kafka server, use:

  ```powershell
  .\bin\windows\kafka-server-stop.bat
  ```

---

**Note:**  
- Make sure you have Java installed and configured in your system's PATH.
- For more details, refer to the [official Kafka documentation](https://kafka.apache.org/documentation/).