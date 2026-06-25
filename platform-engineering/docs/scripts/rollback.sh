#!/bin/bash

echo "================================="
echo "ROLLBACK AUTOMATION STARTED"
echo "================================="

echo "Checking deployment status..."

kubectl rollout undo deployment/platform-canary -n canary

echo "Rollback completed."

echo "Verifying deployment..."

kubectl rollout status deployment/platform-canary -n canary

echo "================================="
echo "ROLLBACK SUCCESSFUL"
echo "================================="