# API Standards

## URL Naming

Correct:

/api/v1/rides

/api/v1/drivers

/api/v1/payments

Incorrect:

/getRide

/createDriver

---

## HTTP Methods

GET    -> Read

POST   -> Create

PUT    -> Update

DELETE -> Delete

PATCH  -> Partial Update

---

## Response Format

{
  "success": true,
  "data": {},
  "timestamp": "2026-06-22T10:00:00Z"
}

---

## Error Format

{
  "success": false,
  "errorCode": "RIDE_NOT_FOUND",
  "message": "Ride not found"
}