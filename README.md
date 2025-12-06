# 🏨 Hotel Search API

### Hexagonal Architecture • Spring Boot 3 • Kafka • MongoDB • Docker • CI/CD Ready

The **Hotel Search API** is a clean, production-grade microservice built
using **Hexagonal Architecture (Ports & Adapters)**, leveraging
**Kafka** for event streaming and **MongoDB** for persistence.\
Designed to simulate a real enterprise backend + DevOps workflow.

------------------------------------------------------------------------

## 🚀 Tech Stack

-   **Java 21**
-   **Spring Boot 3.5.x**
-   **Hexagonal Architecture**
-   **Apache Kafka**
-   **MongoDB**
-   **MapStruct**
-   **Docker + Docker Compose**
-   **JUnit 5 + Mockito**
-   **GitHub Actions (CI/CD -- upcoming)**

------------------------------------------------------------------------

## 🧱 Project Architecture (Hexagonal)

    src/main/java
    └── com.avoris.tec.hotelsearch
        ├── domain
        │   ├── model
        │   └── ports
        │       ├── in
        │       └── out
        ├── application
        ├── adapters
        │   ├── in
        │   │   ├── controller
        │   │   ├── dto
        │   │   └── mapper
        │   └── out
        │       ├── kafka
        │       └── mongo
        └── config

### 🔎 Principles

-   **Domain** contains business rules, completely independent from
    frameworks.\
-   **Ports** define what the domain needs (outbound) and what external
    actors may request (inbound).\
-   **Adapters** implement those ports (REST, Kafka, MongoDB...).\
-   **Application layer** orchestrates use cases.

------------------------------------------------------------------------

## 📡 REST API

### **POST /search**

Registers a hotel search and publishes it to Kafka.

#### Request

``` json
{
  "hotelId": "HOTEL123",
  "checkIn": "2025-01-01",
  "checkOut": "2025-01-03",
  "ages": [30, 25]
}
```

#### Response

``` json
{
  "searchId": "c482fa91-1aab-4f64-a92c-3fb122c28980"
}
```

------------------------------------------------------------------------

### **GET /count**

Returns the total number of search records stored in MongoDB.

#### Response

``` json
{
  "total": 42
}
```

------------------------------------------------------------------------

## 🐳 Local Environment (Docker)

Start Kafka + MongoDB + AKHQ:

``` bash
docker-compose up -d
```

Services included: - **Kafka Broker** - **Zookeeper** - **MongoDB** -
**Mongo Express** - **AKHQ** (Kafka UI)

------------------------------------------------------------------------

## 🧪 Testing

### Unit Tests

-   Domain model tests\
-   Mapper tests (MapStruct)\
-   Application use-case tests

### Integration Tests

-   **MongoDB integration (TestContainers)**\
-   **Kafka integration (TestContainers)**\
-   **Controller tests with MockMvc**

Run all tests:

``` bash
mvn test
```

------------------------------------------------------------------------

## 🏗️ Build & Run

### Run locally

``` bash
mvn spring-boot:run
```

### Build JAR

``` bash
mvn clean package
```

------------------------------------------------------------------------

## 📌 Upcoming DevOps Roadmap

-   🔧 GitFlow branching strategy (`main`, `develop`, `feature/*`)
-   🔨 GitHub Actions CI/CD pipelines:
    -   Build + Test
    -   Docker image build
    -   Push to GitHub Container Registry
    -   Deployment automation
-   📦 Kubernetes deployment (kind/minikube)
-   📊 Observability (Prometheus + Grafana)
-   🔐 Secrets management & configuration profiles

------------------------------------------------------------------------

## 👤 Author

Developed for advanced practice in: - Hexagonal Architecture\
- Kafka Event-Driven systems\
- Spring Boot enterprise patterns\
- Real DevOps pipelines (GitHub Actions, Docker, Kubernetes)

------------------------------------------------------------------------

## ⭐ License

Educational and open use.
