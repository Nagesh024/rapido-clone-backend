# ADR-005

## Title

OAuth2 Security Architecture

## Status

Approved

## Context

Need centralized authentication and authorization.

## Decision

Adopt OAuth2 + OpenID Connect.

Provider:

Spring Authorization Server

Token Type:

JWT RS256

## Alternatives Considered

Session Authentication

Custom Token Solution

## Consequences

Pros:

- Industry Standard
- Secure APIs
- Federated Identity

Cons:

- Additional Complexity