@echo off

FOR /L %%i IN (1,1,100) DO (
start /B curl -X POST http://localhost:8084/rides/request ^
-H "Content-Type: application/json" ^
-d "{\"riderId\":%%i,\"pickupLatitude\":17.3850,\"pickupLongitude\":78.4867,\"dropLatitude\":17.4500,\"dropLongitude\":78.5000}"
)

pause