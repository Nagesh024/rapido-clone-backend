# ARB RACI Matrix

| Activity              | Chief Architect | Backend Lead | DevOps Lead | Security Lead | Product Owner | QA Lead |
|-----------------------|-----------------|--------------|-------------|---------------|---------------|---------|
| Architecture Approval |        A        |      R       |      C      |     C         |       C       |    C    |
| Security Review       |        C        |      C       |      C      |    A/R        |       I       |    I    |
| Scalability Review    |        A        |      R       |      R      |     C         |       I       |    C    |
| Technology Selection  |        A        |      R       |      R      |     C         |       C       |    I    |
| Production Approval   |        A        |      C       |      C      |     C         |       C       |    R    |
| Risk Assessment       |        A        |      C       |      C      |     R         |       I       |    C    |
| Compliance Review     |        C        |      I       |      I      |    A/R        |       I       |    C    |

Legend:

A = Accountable
R = Responsible
C = Consulted
I = Informed

| Activity                     | CTO | Chief Architect | Product Owner | Security Lead | DevOps Lead | SRE Lead | QA Lead |
| ---------------------------- | --- | --------------- | ------------- | ------------- | ----------- | -------- | ------- |
| Architecture Approval        | A   | R               | C             | C             | C           | C        | I       |
| Security Certification       | I   | C               | I             | A/R           | C           | C        | I       |
| Infrastructure Certification | I   | C               | I             | C             | A/R         | C        | I       |
| Monitoring Certification     | I   | C               | I             | I             | C           | A/R      | I       |
| Functional Certification     | I   | I               | C             | I             | I           | I        | A/R     |
| Performance Certification    | I   | C               | I             | I             | C           | A/R      | C       |
| Risk Acceptance              | A   | R               | C             | C             | C           | C        | C       |
| Go-Live Decision             | A   | R               | C             | C             | C           | C        | C       |
| Launch Certification         | A   | R               | C             | C             | C           | C        | C       |
| Emergency Rollback Approval  | A   | C               | I             | I             | R           | R        | I       |
