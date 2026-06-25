# Rollback Automation

## Supported Scenarios

### Failed Deployment

Trigger:
Deployment Failure

Action:
kubectl rollout undo

Status:
SUPPORTED

---

### High Error Rate

Trigger:
Error Rate > 5%

Action:
Automatic Rollback

Status:
SUPPORTED

---

### Critical Incident

Trigger:
P1 Incident

Action:
Immediate Rollback

Status:
SUPPORTED