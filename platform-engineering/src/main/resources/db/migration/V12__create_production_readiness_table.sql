CREATE TABLE IF NOT EXISTS production_readiness_assessment (

    id BIGSERIAL PRIMARY KEY,

    service_name VARCHAR(255),

    monitoring_score INTEGER,

    security_score INTEGER,

    performance_score INTEGER,

    scalability_score INTEGER,

    disaster_recovery_score INTEGER,

    compliance_score INTEGER,

    total_score INTEGER,

    status VARCHAR(100)
);