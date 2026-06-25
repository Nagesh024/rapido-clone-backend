# Migration Strategy

## Tool

Flyway Mandatory

---

## Rules

Never modify existing migration

Create new version

Correct:

V4__add_index.sql

V5__create_table.sql

Wrong:

Modify V1

Modify V2

---

## Rollback

Every migration requires rollback plan.