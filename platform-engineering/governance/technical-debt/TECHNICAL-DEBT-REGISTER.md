# Technical Debt Register

| Debt ID | Category     | Description                               | Service        | Severity | Status | Owner            |
|---------|--------------|-------------------------------------------|----------------|----------|--------|------------------|
| TD-001  | Code Quality | Duplicate validation logic                | user-service   |  Medium  | Open   | Backend Team     |
| TD-002  | Security     | Hardcoded secrets                         | auth-service   | Critical | Open   | Security Team    |
| TD-003  | Architecture | Direct DB access across services          | payment-service| High     | Open   | Architecture Team|
| TD-004  | Reliability  | Missing Saga compensation listeners       | ride-service   | High     | Open   | Platform Team    |
| TD-005  | Reliability  | Missing Saga compensation listeners       | driver-service | High     | Open   | Platform Team    |
| TD-006  | Monitoring   | Incomplete distributed tracing            | api-gateway    | Medium   | Open   | SRE Team         |
| TD-007  | Security     | Vault integration not enforced everywhere | platform-wide  | High     | Open   | Security Team    |
| TD-008  | Testing      | Chaos testing not implemented             | platform-wide  | Medium   | Open   | QA Team          |

---

## Status Values

Open

Planned

In Progress

Resolved

Accepted

Deferred

# Technical Debt Registry

## Categories

- Code Quality
- Security
- Performance
- Infrastructure
- Architecture
- Documentation

## Lifecycle

OPEN
↓
IN_PROGRESS
↓
RESOLVED
↓
CLOSED

## Governance

Critical Debt:
30 Days

High Debt:
60 Days

Medium Debt:
90 Days

Low Debt:
180 Days