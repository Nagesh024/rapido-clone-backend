# Platform Disaster Recovery Runbook

## GitOps Recovery

Restore GitOps manifests:

xcopy disaster-recovery\backups\gitops-backup gitops /E /I /Y

## Terraform Recovery

Restore Terraform configuration:

xcopy disaster-recovery\terraform-backup terraform /E /I /Y

## Database Recovery

psql -U postgres platform_engineering < platform_backup.sql

## Validation

Verify:

kubectl get pods
kubectl get svc
curl http://localhost:8088/actuator/health