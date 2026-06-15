# DISASTER RECOVERY RUNBOOK

## Disaster Recovery Objectives

| Objective | Target               |
| --------- | -------------------- |
| RTO       | Less than 15 Minutes |
| RPO       | Less than 5 Minutes  |

---

# Emergency Contacts

| Team          | Contact                                                     |
| ------------- | ----------------------------------------------------------- |
| Platform Team | [platform-team@rapido.com](mailto:platform-team@rapido.com) |
| Database Team | [database-team@rapido.com](mailto:database-team@rapido.com) |
| SRE Team      | [sre-team@rapido.com](mailto:sre-team@rapido.com)           |
| Security Team | [security-team@rapido.com](mailto:security-team@rapido.com) |

---

# Recovery Steps

## Step 1 — Verify Incident

Check:

* Region Health
* Database Health
* Kafka Health
* Redis Health

Commands:

curl http://localhost:8080/dashboard/dr

curl http://localhost:8080/monitoring/health

---

## Step 2 — Trigger Failover

Command:

curl http://localhost:8080/failover

Expected:

Failover Completed

---

## Step 3 — Verify Secondary Region

Verify:

* API Gateway
* Authentication Service
* Ride Service
* Payment Service
* Notification Service

Command:

kubectl get pods -A

All services should be Running.

---

## Step 4 — Verify Database Replication

Primary:

SELECT COUNT(*) FROM rides;

Replica:

SELECT COUNT(*) FROM rides;

Expected:

Row counts match.

---

## Step 5 — Validate Backups

Commands:

curl http://localhost:8080/backup/validate

Expected:

Backup Validation Successful

---

## Step 6 — Restore If Needed

Command:

java -cp target/classes com.rapido.backupservice.cli.CliRunner restore-database

Expected:

Database Restore Completed

---

# Failover Procedures

Primary Region Failure

↓

Health Check Failure

↓

Traffic Redirected

↓

Secondary Region Activated

↓

Service Validation

↓

Recovery Complete

---

# Validation Checklist

* [ ] Region Failover Successful
* [ ] Database Reachable
* [ ] Redis Reachable
* [ ] Kafka Reachable
* [ ] Backup Available
* [ ] Restore Tested
* [ ] Data Consistency Verified
* [ ] Dashboard Healthy
* [ ] Alerts Operational
* [ ] Audit Logs Available

---

# Disaster Recovery Success Criteria

* RTO less than 15 minutes
* RPO less than 5 minutes
* No critical service outage
* Data consistency maintained
* Recovery validated successfully
