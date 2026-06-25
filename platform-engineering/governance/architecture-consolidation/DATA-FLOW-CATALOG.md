# Data Flow Catalog

## Ride Booking Flow

User
→ API Gateway
→ ride-service
→ driver-service
→ Kafka

---

## Payment Flow

ride-service
→ payment-service
→ wallet-service
→ Kafka

---

## Notification Flow

Kafka
→ notification-service

---

## Analytics Flow

Kafka
→ analytics-service