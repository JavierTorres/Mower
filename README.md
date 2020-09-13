# SEAT:CODE Technical Challenge

## Table of Contents

- [Features](#features)
- [FAQ](#faq)
- [Run](#run)

---

## Features

- Kotlin
- REST API
- Swagger
- DDD
- Hexagonal Architecture
- Tests

---

## FAQ

- **What happens when typing an instruction to move the mower'position outside of the plateau?**
    - No problem! It just returns the last valid mower'position.

- **Is the system case-sensitive when processing the direction o instructions ?**
    - Don't worry, it's not case-sensitive.

---

## Run

First, build it using Gradle then run the jar file:
```
./gradlew build
```

Then, run the jar file:

```
java -jar build/libs/mower-0.0.1-SNAPSHOT.jar
```

Finally, explore the API using the Swagger UI: `http://localhost:8080/swagger-ui.htm`