#!/bin/bash

echo "Starting Emergency Rollback"

echo "Switching traffic to Blue Environment"

kubectl patch service rapido-gateway \
-p '{"spec":{"selector":{"version":"blue"}}}'

echo "Verifying deployment"

kubectl get pods -n rapido-prod

echo "Rollback completed successfully"