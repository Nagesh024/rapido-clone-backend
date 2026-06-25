CREATE TABLE IF NOT EXISTS risk_register (

    id BIGSERIAL PRIMARY KEY,

    risk VARCHAR(1000),

    impact INTEGER,

    likelihood INTEGER,

    mitigation VARCHAR(5000),

    owner VARCHAR(255)
);