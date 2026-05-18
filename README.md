\# Rapido Clone Backend



Production-ready Java Spring Boot microservices backend for a Rapido-like ride booking platform.



\## Tech Stack



\- Java 17

\- Spring Boot 3.x

\- PostgreSQL

\- Docker

\- Docker Compose

\- Maven

\- REST APIs

\- Spring Security



\## Current Services



\- auth-service



\## Run Project



```bash

docker compose up --build

```



\## Health API



```bash

http://localhost:8081/health

```



\## Login



Username: admin



Password: admin

## Day 7 – API Gateway, Eureka, JWT Security & Request Tracing

Implemented enterprise-level microservices architecture with:

- Eureka Discovery Server for service registration
- API Gateway for centralized routing
- JWT authentication using auth-service
- Protected APIs through API Gateway
- Notification-service integration through gateway
- PostgreSQL database integration
- Request Logging Filter
- Correlation ID tracing
- Redis container setup for future rate limiting

### Running Services

| Service | Port |
|---|---|
| Eureka Server | 8761 |
| API Gateway | 8080 |
| Auth Service | 8081 |
| Notification Service | 8086 |
| Redis | 6379 |

### Tested APIs

- `POST /api/auth/register`
- `POST /api/auth/login`
- `GET /notifications/health`
- `POST /notifications/send`

### Architecture Flow

Client → API Gateway → JWT Filter → Logging Filter → Correlation ID → Microservice → PostgreSQL

