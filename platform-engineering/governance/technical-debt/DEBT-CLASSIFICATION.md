# Technical Debt Classification

## Critical

Must be fixed immediately.

Examples:

- Hardcoded credentials
- Security vulnerabilities
- Data corruption risks
- PCI compliance violations

---

## High

Must be fixed within 30 days.

Examples:

- Missing retry logic
- Missing idempotency
- Service reliability issues
- Single points of failure

---

## Medium

Must be fixed within 90 days.

Examples:

- Code duplication
- Poor naming
- Missing tests
- Large classes

---

## Low

Fix when capacity permits.

Examples:

- Minor refactoring
- Documentation improvements
- Logging improvements