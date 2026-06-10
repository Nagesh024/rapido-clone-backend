# Analytics Service Architecture

## Overview

The Analytics Service is responsible for collecting ride platform events, processing them through ETL pipelines, storing them in an analytics warehouse, generating KPIs, dashboards, reports, and audit trails.

---

# Warehouse Design

## Fact Tables

### fact_rides

Stores ride-level analytics data.

| Column     | Type      |
| ---------- | --------- |
| ride_id    | BIGINT    |
| user_id    | BIGINT    |
| driver_id  | BIGINT    |
| fare       | NUMERIC   |
| distance   | NUMERIC   |
| status     | VARCHAR   |
| created_at | TIMESTAMP |

### fact_payments

Stores payment analytics.

### fact_notifications

Stores notification analytics.

---

## Dimension Tables

### dim_users

User profile analytics.

### dim_drivers

Driver profile analytics.

### dim_locations

City and location analytics.

### dim_time

Time-based aggregations.

---

# ETL Flow

Kafka Event
→ Validation
→ Transformation
→ Analytics Warehouse
→ KPI Aggregation
→ Dashboard APIs
→ Reporting

Events Consumed:

* ride-completed
* payment-success
* driver-status-updated
* notification-sent

---

# KPI Definitions

## Total Rides

Count of all rides.

## Completed Rides

Count of rides with COMPLETED status.

## Cancelled Rides

Count of rides with CANCELLED status.

## Revenue

Sum of ride fares.

## Driver Utilization

Completed Ride Hours / Online Hours

## Average Ride Duration

Average ride duration across all rides.

---

# Reporting Architecture

Supported Reports:

* CSV Reports
* Excel Reports
* PDF Reports

Generated Endpoints:

* /analytics/report/csv
* /analytics/report/excel
* /analytics/report/pdf

---

# Audit Architecture

Audit events stored in:

audit_events

Tracked Events:

* RIDE_COMPLETED
* PAYMENT_SUCCESS
* DRIVER_STATUS_UPDATED
* NOTIFICATION_SENT

APIs:

* /analytics/audit
* /analytics/audit/search
* /analytics/audit/page
* /analytics/audit/metrics
* /analytics/audit/trends
* /analytics/audit/distribution
* /analytics/audit/export

---

# Monitoring

Tracked Metrics:

* ETL Latency
* Failed Jobs
* Revenue Growth
* Warehouse Growth
* Query Latency

---

# Health Summary

Endpoint:

GET /analytics/health-summary

Provides:

* Analytics Status
* Total Rides
* Total Revenue
* Total Audit Events

---

# Conclusion

Analytics Service successfully implements ETL processing, warehouse storage, KPI aggregation, dashboard analytics, audit tracking, reporting, and monitoring capabilities.
