# ADR-002

## Title

Kafka Event Driven Architecture

## Status

Approved

## Context

Synchronous communication creates tight coupling.

## Decision

Use Apache Kafka as enterprise messaging platform.

Events:

- RideCreated
- DriverAssigned
- PaymentCompleted
- NotificationSent

## Alternatives Considered

RabbitMQ

ActiveMQ

REST Only

## Consequences

Pros:

- Scalability
- Loose Coupling
- Event Replay

Cons:

- Operational Complexity
- Eventual Consistency