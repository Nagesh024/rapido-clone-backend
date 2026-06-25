CREATE TABLE IF NOT EXISTS production_certification (

    id BIGSERIAL PRIMARY KEY,

    service_name VARCHAR(255),

    security_validated BOOLEAN,

    performance_validated BOOLEAN,

    monitoring_validated BOOLEAN,

    recovery_validated BOOLEAN,

    compliance_validated BOOLEAN,

    documentation_validated BOOLEAN,

    certification_status VARCHAR(100)
);