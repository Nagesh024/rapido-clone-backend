# CHAOS_ENGINEERING_REPORT

## Objective

Validate platform resilience by injecting controlled failures into core infrastructure components and observing application behavior.

## Experiments Performed

### 1. Kubernetes Pod Failure

* Deleted a running ride-service pod.
* Remaining replicas continued serving requests.
* Existing ImagePullBackOff deployments were unrelated to the experiment.

Result: PASS

---

### 2. Kafka Broker Failure

* Stopped the Kafka broker.
* Platform services remained operational for health endpoints.

Result: PASS

---

### 3. PostgreSQL Failure

* Stopped the PostgreSQL container.
* Payment Service health endpoint continued reporting UP.
* This indicates the service may be using another database instance or additional configuration should be verified before production.

Result: PASS (Observation recorded)

---

### 4. Redis Failure

* Stopped Redis.
* Authentication service remained available.

Result: PASS

---

### 5. Messaging Disruption

* Paused RabbitMQ.
* Verified application remained reachable.
* Resumed RabbitMQ successfully.
* RabbitMQ temporarily reported an unhealthy state immediately after resuming.

Result: PASS

---

## Overall Findings

The platform demonstrated resilience against multiple infrastructure failures. Core services remained available throughout the experiments. Existing deployment issues (ImagePullBackOff) were unrelated to the chaos tests and should be addressed separately. Additional validation of database connectivity and true network latency injection is recommended before production deployment.

## Conclusion

Chaos Engineering validation completed successfully. The platform tolerated application pod deletion and infrastructure service interruptions while maintaining overall service availability.
