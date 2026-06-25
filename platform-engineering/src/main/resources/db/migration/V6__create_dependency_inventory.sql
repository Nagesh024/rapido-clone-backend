CREATE TABLE dependency_inventory (

    id BIGSERIAL PRIMARY KEY,

    dependency_name VARCHAR(255),

    version VARCHAR(100),

    license_type VARCHAR(100),

    vulnerability_count INTEGER,

    status VARCHAR(100),

    approved BOOLEAN
);