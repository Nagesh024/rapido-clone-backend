CREATE TABLE security_controls (

    id BIGSERIAL PRIMARY KEY,

    control_name VARCHAR(255),

    category VARCHAR(255),

    description VARCHAR(5000),

    mandatory BOOLEAN,

    compliance_level VARCHAR(255)
);