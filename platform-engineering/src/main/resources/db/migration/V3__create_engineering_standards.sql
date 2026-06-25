CREATE TABLE engineering_standards (

    id BIGSERIAL PRIMARY KEY,

    standard_name VARCHAR(255),

    category VARCHAR(100),

    description VARCHAR(5000),

    version VARCHAR(100),

    owner VARCHAR(255),

    mandatory BOOLEAN
);