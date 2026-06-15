# Cost Optimization Report

## Project

Rapido Clone Platform

---

# Infrastructure Components

## Kubernetes

Current Configuration

- Min Pods: 3
- Max Pods: 20

Potential Waste

- Idle Pods During Low Traffic
- Over-Provisioned CPU
- Over-Provisioned Memory

Optimization

- Use HPA
- Scale to Zero for Non-Critical Services
- Right Size Resources

---

# Database Cost

Technology

- PostgreSQL

Current Database Size

- 654 MB

Potential Cost Drivers

- Large Tables
- Unused Indexes
- Excessive Storage Growth

Optimization

- Partition Large Tables
- Archive Old Data
- Read Replicas for Scale

---

# Redis Cost

Purpose

- Session Cache
- Driver Location Cache
- Ride Tracking

Optimization

- TTL Policies
- Cache Eviction Strategy
- Remove Stale Keys

Target Cache Hit Ratio

- >90%

---

# Kafka Cost

Potential Cost Drivers

- Large Retention Periods
- Excessive Partitions
- Replication Overhead

Optimization

- Reduce Retention
- Compress Messages
- Tune Partition Counts

---

# Elasticsearch Cost

Potential Cost Drivers

- Excessive Shards
- High Replica Count

Optimization

- Use Appropriate Shard Count
- Lifecycle Management
- Archive Old Indices

---

# Network Cost

Potential Cost Drivers

- Large Payloads
- Frequent Requests

Optimization

- Compression
- Keep Alive
- CDN Strategy

---

# Storage Cost

Current Storage

- PostgreSQL
- Elasticsearch
- Kafka Logs

Optimization

- Data Archiving
- Compression
- Tiered Storage

---

# Estimated Cost Per 1 Million Rides

| Component | Estimated Cost |
|------------|---------------|
| Compute | $20 |
| Database | $10 |
| Cache | $3 |
| Messaging | $5 |
| Search | $7 |
| Network | $5 |
| Storage | $5 |

Total:

$55 per 1 Million Rides

---

# Recommendations

- Increase Cache Usage
- Use Read Replicas
- Enable Auto Scaling
- Optimize Storage Retention
- Reduce Network Payload Size

---

# Conclusion

Cost can be reduced through
auto-scaling,
compression,
caching,
and storage lifecycle management.