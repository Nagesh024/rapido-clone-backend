# Database Standards

## Primary Keys

Use UUID

Example:

UUID rideId

Never Use:

Long id

---

## Table Naming

Correct:

rides

drivers

payments

Incorrect:

RideTable

DriverData

---

## Audit Fields Mandatory

created_at

updated_at

created_by

updated_by

---

## Foreign Keys

Always Define FK Constraints

---

## Migrations

Use Flyway

No Manual Production Changes