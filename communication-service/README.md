# Communication Service - Rapido Clone Backend

## Overview

Communication Service provides real-time communication features for the Rapido Clone Backend system.

This service supports:

- Real-time WebSocket chat
- Typing indicators
- Read receipts
- Call signaling
- Call status management
- Redis Pub/Sub integration
- Message retry queue
- JWT WebSocket security
- Ride participant authorization
- PostgreSQL persistence
- Docker deployment
- Actuator monitoring
- Prometheus metrics

---

# Tech Stack

- Java 17
- Spring Boot 3.5.14
- Spring WebSocket
- Spring Security
- Spring Data JPA
- PostgreSQL
- Redis
- Docker
- Prometheus
- Maven

---

# Features

## Real-Time Chat

- WebSocket based communication
- Topic-based ride chat
- Database message persistence
- Offline message storage

## Typing Indicators

Users receive typing status instantly.

## Read Receipts

Messages update read status in real-time.

## Call Signaling

Supports:

- OFFER
- ACCEPT
- REJECT
- CALL_END
- MISSED calls

## Call Timeout Handling

Calls automatically marked MISSED after timeout.

## JWT Security

WebSocket connections validated using JWT token authentication.

## Ride Authorization

Only ride participants can access ride communication channels.

## Redis Pub/Sub

Distributed message publishing support.

## Retry Queue System

Failed Redis messages are stored and retried later.

---

# Project Structure

```text
src/main/java/com/rapido/communication_service
│
├── config
├── controller
├── dto
├── entity
├── repository
├── security
├── service
├── websocket
├── redis
└── exception