# ADR-001

## Title

Microservices Architecture

## Status

Approved

## Context

The platform requires independent deployment, scaling,
and ownership of services.

Monolithic architecture creates deployment bottlenecks.

## Decision

Adopt Microservices Architecture.

Each bounded context owns:

- Database
- APIs
- Events

Examples:

- Auth Service
- Ride Service
- Driver Service
- Payment Service
- Notification Service

## Alternatives Considered

Monolith

Modular Monolith

## Consequences

Pros:

- Independent Scaling
- Faster Releases
- Team Autonomy

Cons:

- Increased Operational Complexity
- Distributed Transactions