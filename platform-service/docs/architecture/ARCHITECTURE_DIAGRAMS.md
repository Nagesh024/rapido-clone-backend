# ARCHITECTURE DIAGRAMS

Version: 1.0

---

# 1. Objective

This document contains the enterprise architecture diagrams for the Rapido Enterprise Mobility Platform.

Diagrams Included

- Logical Architecture
- Physical Architecture
- Deployment Architecture
- Event Architecture

---

# 2. Logical Architecture



Client

--> API_Gateway

API_Gateway --> Auth_Service

API_Gateway --> User_Service

API_Gateway --> Driver_Service

API_Gateway --> Ride_Service

API_Gateway --> Payment_Service

API_Gateway --> Notification_Service

API_Gateway --> Analytics_Service

API_Gateway --> Platform_Service

Platform_Service --> PostgreSQL

Ride_Service --> PostgreSQL

Driver_Service --> PostgreSQL

Payment_Service --> PostgreSQL


---

# 3. Physical Architecture


Users

--> Internet

Internet

--> LoadBalancer

LoadBalancer

--> KubernetesCluster

KubernetesCluster

--> API_Gateway

API_Gateway

--> Microservices

Microservices

--> PostgreSQL

Microservices

--> Redis

Microservices

--> Kafka

Kafka

--> Elasticsearch

Elasticsearch

--> Kibana

Prometheus

--> Grafana


---

# 4. Deployment Architecture


Developer

--> GitHub

GitHub

--> CI_CD

CI_CD

--> Docker

Docker

--> ContainerRegistry

ContainerRegistry

--> Kubernetes

Kubernetes

--> Production


---

# 5. Event Architecture

Ride_Service

--> ride_requested

ride_requested

--> Driver_Service

Driver_Service

--> ride_assigned

ride_assigned

--> Payment_Service

Payment_Service

--> payment_success

payment_success

--> Notification_Service

Notification_Service

--> notification_sent

notification_sent

--> Analytics_Service


---

# 6. Architecture Summary

| Diagram                 | Purpose               |
|-------------------------|-----------------------|
| Logical Architecture    | Service Relationships |
| Physical Architecture   | Infrastructure Layout |
| Deployment Architecture | CI/CD Deployment Flow |
| Event Architecture      | Kafka Event Flow      |

---

# 7. Conclusion

The Rapido Enterprise Mobility Platform follows a cloud-native microservices architecture.

Logical, physical, deployment, and event diagrams provide a complete architectural view of the platform.