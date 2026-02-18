# JaCoCo Code Coverage Example

This project is a Java command-line encryption tool that supports **Shift** and **Unicode** algorithms.  
It also demonstrates **unit testing using JUnit 5** and **code coverage reporting using JaCoCo**.

---

## 🛠 Technologies

- Java
- Maven
- JUnit 5
- JaCoCo

---

## ▶️ Run Application

```bash
./mvnw exec:java -Dexec.args="-mode enc -key 5 -data Hello"
🧪 Run Tests & Generate Coverage
mvn clean test
JaCoCo report location:

## target/site/jacoco/index.html
Open this file in a browser to see coverage results.

