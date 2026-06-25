# Risk Register

| Risk ID  | Category      |           Description                   | Probability| Impact   | Severity| Owner             | Status |
|----------|---------------|-----------------------------------------|------------|----------|---------|-------------------|--------|
| RISK-001 | Security      | Vault unavailable                       |    Medium  | High     | High    | Security Team     | Open   |
| RISK-002 | Reliability   | Kafka cluster failure                   |    Medium  | High     | High    | Platform Team     | Open   |
| RISK-003 | Availability  | PostgreSQL outage                       |    Medium  | Critical | Critical| DBA Team          | Open   |
| RISK-004 | Compliance    | PCI-DSS audit failure                   |    Low     | Critical | High    | Compliance Team   | Open   |
| RISK-005 | Scalability   | Driver matching performance degradation |    Medium  | High     | High    | Architecture Team | Open   |
| RISK-006 | Reliability   | Missing Saga compensation workflow      |    Medium  | High     | High    | Platform Team     | Open   |
| RISK-007 | Observability | Distributed tracing incomplete          |    Medium  | Medium   | Medium  | SRE Team          | Open   |
| RISK-008 | Security      | Secrets not fully migrated to Vault     |    Medium  | High     | High    | Security Team     | Open   |
| RISK-009 | Testing       | Chaos testing not implemented           |    Medium  | Medium   | Medium  | QA Team           | Open   |
| RISK-010 | Scalability   | Surge pricing engine load risk          |    Medium  | High     | High    | Architecture Team | Open   |
| RISK-011 | Security      | JWT signing key exposed                 |    Low     | Critical | High    | Security Team     | Open   |