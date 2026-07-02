# SOAK_TEST_REPORT

## Objective

Evaluate long-running stability of the Rapido platform by monitoring resource utilization and database growth under continuous workload.

## Test Environment

* Platform: Rapido Clone Microservices
* Database: PostgreSQL
* Messaging: Kafka, RabbitMQ
* Cache: Redis
* Monitoring: Docker Stats
* Load Tool: k6

## Baseline

* Services Status: UP
* Database Size: 7519 kB
* PostgreSQL Memory: 50.3 MiB

## Continuous Workload

A continuous workload was executed using k6 while all platform services remained active. Resource utilization and database size were monitored throughout the execution.

## Resource Observations

* No service crashes observed.
* PostgreSQL remained healthy.
* Database growth remained controlled.
* Notification service exhibited higher CPU utilization and should be monitored further during extended production testing.
* No obvious memory leak was observed during the validation period.

## Conclusion

The platform remained stable throughout the soak test validation. A full 24-hour soak test is recommended before production deployment to validate long-duration stability, memory usage trends, and database growth under sustained workload.
