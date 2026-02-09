# Maven Medium Level Project

## Description
A Java CLI application for encryption and decryption using **Shift** and **Unicode** algorithms.  
The project is converted to **Maven** and uses **Maven Wrapper** for consistent builds.

## Tech Stack
- Java 17
- Maven
- Maven Wrapper

## Build
```bash
./mvnw clean package
Run
./mvnw exec:java -Dexec.args="-mode enc -key 5 -data Hello"
File Input
./mvnw exec:java -Dexec.args="-mode enc -key 5 -in src/main/resources/in.txt -out src/main/resources/out.txt"
