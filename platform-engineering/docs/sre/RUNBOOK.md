# Production Runbook

## Service Down

### Symptoms

* Application unavailable
* Health endpoint fails

### Verification

curl http://localhost:8088/actuator/health

### Recovery

1. Restart application
2. Verify database connectivity
3. Verify Prometheus metrics
4. Verify Grafana dashboard

---

## Database Down

### Verification

curl http://localhost:8088/actuator/health

Check:

db.status = UP

### Recovery

1. Restart PostgreSQL
2. Verify connections
3. Validate application startup

---

## Kubernetes Pod Failure

### Verification

kubectl get pods -A

### Recovery

1. Verify replacement pod created
2. Confirm pod reaches Running state
3. Verify application health
