# Architecture Approval Matrix

| Change                   | ARB Review Required |         Mandatory Approvers           |
|--------------------------|---------------------|---------------------------------------|
| New Microservice         |          YES        |         Chief Architect               |
| New Database             |          YES        |     Chief Architect, Data Architect   |
| New Kafka Topic          |          YES        |         Chief Architect               |
| API Breaking Change      |          YES        |         Chief Architect               |
| Security Change          |          YES        |         Security Architect            |
| Payment Change           |          YES        | Security Architect, FinTech Architect |
| Kubernetes Change        |          YES        |         Platform Architect            |
| Multi-Region Change      |          YES        |         Platform Architect, SRE Lead  |
| ML Model Platform Change |          YES        |         Data Architect                |
| Dashboard Change         |          NO         |             N/A                       |
| Monitoring Change        |          NO         |             N/A                       |
| Logging Change           |          NO         |             N/A                       |

---

## Risk Classification

### Low Risk

No ARB Required

Examples:

- Dashboard updates
- Logging improvements
- Monitoring enhancements

---

### Medium Risk

ARB Recommended

Examples:

- New API
- New Kafka Event
- New Scheduled Job

---

### High Risk

ARB Mandatory

Examples:

- New Database
- New Microservice
- Security Changes
- Payment Changes
- Kubernetes Changes
- Multi-Region Deployment