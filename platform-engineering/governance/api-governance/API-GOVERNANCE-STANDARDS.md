# API Governance Standards

## Purpose

Provide enterprise API design standards for all Rapido services.

---

# Mandatory Standards

## REST Naming

Use nouns only.

Correct:

GET /api/v1/rides

GET /api/v1/drivers

POST /api/v1/payments

Wrong:

GET /api/v1/getRides

POST /api/v1/createDriver

---

## Versioning

All APIs must include version.

Format:

/api/v1/resource

Example:

/api/v1/rides

/api/v1/users

/api/v1/payments

---

## Error Handling

All APIs must return standard error response.

---

## Pagination

Mandatory for collections.

Format:

?page=0&size=20

Example:

GET /api/v1/rides?page=0&size=20