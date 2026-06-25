CREATE TABLE IF NOT EXISTS architecture_review (

    id BIGSERIAL PRIMARY KEY,

    service_name VARCHAR(255),

    reviewer VARCHAR(255),

    comments VARCHAR(5000),

    status VARCHAR(100)
);