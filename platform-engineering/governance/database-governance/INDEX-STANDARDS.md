# Index Standards

## Mandatory

Primary Key Index

Foreign Key Index

Search Column Index

---

## Examples

CREATE INDEX idx_ride_driver
ON ride(driver_id);

CREATE INDEX idx_user_email
ON users(email);

---

## Rules

No unused indexes

Review quarterly