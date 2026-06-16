@echo off

echo Running Performance Tests...

curl http://localhost:8080/actuator/health

echo Collecting Metrics...

curl http://localhost:8080/actuator/metrics/http.server.requests

echo Performance Test Completed