<<<<<<< HEAD
@echo off

echo Running Performance Tests...

curl http://localhost:8080/actuator/health

echo Collecting Metrics...

curl http://localhost:8080/actuator/metrics/http.server.requests

=======
@echo off

echo Running Performance Tests...

curl http://localhost:8080/actuator/health

echo Collecting Metrics...

curl http://localhost:8080/actuator/metrics/http.server.requests

>>>>>>> 7428535d3931939c46580f8662fc1028b5c7abd9
echo Performance Test Completed