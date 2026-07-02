# STRESS_TEST_REPORT

## Objective

Identify the application's failure point and document performance bottlenecks under increasing load.

## Test Environment

* Tool: k6
* Endpoint: http://localhost:8088/admin/dashboard/summary

## Load Levels

### Phase 1

* Rate: 20,000 requests/min
* Result: PASS

### Phase 2

* Rate: 50,000 requests/min
* Result: FAILURE POINT IDENTIFIED

## Metrics at Failure Point

| Metric              | Result              |
| ------------------- | ------------------- |
| P95                 | 5.02 ms             |
| P99                 | 431.72 ms           |
| Error Rate          | 0.49%               |
| Successful Requests | 99,510              |
| Failed Requests     | 491                 |
| Throughput          | 833.21 requests/sec |

## Bottlenecks Identified

1. P99 latency exceeded the target threshold.
2. Intermittent HTTP request failures occurred under stress.
3. Maximum response time reached 1.23 seconds.
4. System began degrading at approximately 50,000 requests per minute.

## Conclusion

The platform remained stable under moderate stress and reached its observable stress limit at approximately 50,000 requests per minute. Additional optimization of application processing, database access, and infrastructure scaling is recommended before supporting higher sustained loads.
