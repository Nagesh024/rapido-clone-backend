# EVENT-DRIVEN MICROSERVICES ARCHITECTURE (RAPIDO CLONE)

## Overview
This project implements an event-driven microservices architecture using Kafka and Saga Pattern for distributed transaction management in a ride booking system.

The system consists of:
- Ride Service
- Payment Service
- Notification Service

Communication between services is handled asynchronously using Kafka events.

---

## 🧩 Microservices

### 1. Ride Service
- Responsible for ride creation and lifecycle
- Produces ride request events

### 2. Payment Service
- Processes payments for rides
- Consumes ride events and publishes payment status

### 3. Notification Service
- Sends notifications to users
- Consumes ride and payment events

---

## 📌 Kafka Topics

| Topic Name              | Description                          |
|------------------------|--------------------------------------|
| ride-events            | Ride request and updates             |
| payment-events         | Payment processing events            |
| notification-events    | Notification messages                |
| saga-events            | Saga orchestration events           |
| dlq-events             | Failed events for manual processing |

---

## 🔄 Event Flow (Saga Pattern)

### Step 1: Ride Creation
Ride Service publishes:
- RideRequestedEvent → Kafka topic `ride-events`

### Step 2: Payment Processing
Payment Service consumes:
- RideRequestedEvent  
Then publishes:
- PaymentProcessedEvent OR PaymentFailedEvent

### Step 3: Notification
Notification Service consumes:
- PaymentProcessedEvent  
Sends user notification

---

## ⚙️ Saga Orchestration Flow

Ride Booking Saga:

1. Ride Requested
2. Payment Initiated
3. Payment Success → Continue flow
4. Payment Failure → Trigger Compensation

---

## 🔁 Compensation Flow

If payment fails:

- CancelRideEvent is triggered
- Ride status is rolled back
- User notified about failure

---

## 🔄 Retry Policy

- Maximum retries: 3
- Retry delay: Exponential backoff
- Retry handled at consumer level

---

## ❌ Dead Letter Queue (DLQ)

If event processing fails after retries:

- Event is moved to DLQ topic
- Topic: `dlq-events`
- Used for manual inspection and replay

---

## 📊 Logging Strategy

The system logs the following events:

- Event Published
- Event Consumed
- Saga Started
- Saga Completed
- Compensation Triggered
- DLQ Event Created

Logs are used for monitoring and debugging distributed workflows.

---

## 🔐 Security Model

### Kafka Security
- Topic-level access control enabled (ACLs)
- Producer and Consumer permissions restricted

### Service Security
- Services secured using Spring Security
- JWT authentication applied for API access

---

## 🚀 Failure Handling Scenarios

### 1. Payment Service Failure
- Service crash simulated using Docker stop
- Events retried after restart

### 2. Kafka Broker Failure
- Kafka restart handled using persistence logs
- No data loss due to durability

### 3. Consumer Failure
- Events remain in topic until consumer recovery

---

## 📦 Technologies Used

- Spring Boot
- Apache Kafka
- Docker
- PostgreSQL
- Spring Security
- Microservices Architecture

---

## 📈 Key Features

- Event-driven communication
- Saga pattern implementation
- Fault tolerance
- Retry mechanism
- DLQ support
- Scalable architecture

---

## 🎯 Conclusion

This architecture ensures:
- Loose coupling between services
- High scalability
- Fault tolerance
- Reliable distributed transaction handling using Saga Pattern