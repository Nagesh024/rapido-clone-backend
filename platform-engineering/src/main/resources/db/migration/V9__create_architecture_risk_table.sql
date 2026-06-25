CREATE TABLE IF NOT EXISTS architecture_risk (

    id BIGSERIAL PRIMARY KEY,

    title VARCHAR(255),

    description TEXT,

    category VARCHAR(100),

    impact INTEGER,

    likelihood INTEGER,

    risk_score INTEGER,

    severity VARCHAR(100),

    owner VARCHAR(255)
);