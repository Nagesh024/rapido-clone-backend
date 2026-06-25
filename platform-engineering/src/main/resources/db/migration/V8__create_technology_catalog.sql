CREATE TABLE IF NOT EXISTS technology_catalog (

    id BIGSERIAL PRIMARY KEY,

    technology_name VARCHAR(255),

    version VARCHAR(100),

    status VARCHAR(100),

    owner VARCHAR(255),

    replacement_technology VARCHAR(255)
);