# Microservice Communication Optimization

## Current Communication

* REST APIs
* HTTP Keep Alive
* Connection Reuse
* Payload Compression

## Async Communication

Implemented using Spring Async

Benefits:

* Non-blocking execution
* Improved throughput
* Reduced latency

## gRPC Consideration

Future migration path:

REST
↓
gRPC

Benefits:

* Binary Protocol
* Lower Latency
* Smaller Payloads
* Faster Service-to-Service Calls

## Optimization Summary

* Connection Reuse Enabled
* Compression Enabled
* Async Communication Enabled
* gRPC Evaluated

## Benefits

* Faster Inter-Service Communication
* Reduced Network Overhead
* Improved Scalability
