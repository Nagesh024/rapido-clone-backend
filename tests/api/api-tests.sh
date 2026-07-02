#!/bin/bash

echo "Running API Tests"

curl http://localhost:8080/actuator/health

curl http://localhost:8082/actuator/health

echo "API Tests Passed"