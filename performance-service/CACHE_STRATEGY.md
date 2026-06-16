# Cache Strategy Review

## Data Classification

### Hot Data
Frequently accessed data

Examples:
- Active Drivers
- Active Rides
- Ride Tracking Locations
- User Sessions

TTL:
60 Seconds

---

### Warm Data
Moderately accessed data

Examples:
- Ride History
- Payment History
- User Profiles

TTL:
30 Minutes

---

### Cold Data
Rarely accessed data

Examples:
- Archived Trips
- Analytics Reports
- Historical Data

TTL:
24 Hours

---

## Cache Patterns

### Cache Aside

Application
    ↓
Redis
    ↓
Database

Benefits:
- Reduced DB Load
- Faster Reads

---

### Write Through

Application
    ↓
Redis
    ↓
Database

Benefits:
- Consistent Data
- Faster Reads

---

## Target

Cache Hit Ratio > 90%