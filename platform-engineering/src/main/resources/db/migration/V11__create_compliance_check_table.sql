CREATE TABLE IF NOT EXISTS compliance_check (

    id BIGSERIAL PRIMARY KEY,

    service_name VARCHAR(255),

    microservice_standard BOOLEAN,

    api_standard BOOLEAN,

    security_standard BOOLEAN,

    deployment_standard BOOLEAN,

    status VARCHAR(100)
);