CREATE TABLE database_standards (

    id BIGSERIAL PRIMARY KEY,

    standard_name VARCHAR(255),

    category VARCHAR(255),

    description VARCHAR(5000),

    mandatory BOOLEAN
);