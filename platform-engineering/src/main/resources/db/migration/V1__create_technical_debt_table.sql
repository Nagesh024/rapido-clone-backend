CREATE TABLE IF NOT EXISTS technical_debt (

    id BIGSERIAL PRIMARY KEY,

    title VARCHAR(255) NOT NULL,

    description VARCHAR(5000),

    category VARCHAR(100),

    risk_score INTEGER,

    business_impact INTEGER,

    technical_impact INTEGER,

    probability INTEGER,

    status VARCHAR(100),

    owner VARCHAR(255),

    identified_date DATE,

    target_resolution_date DATE
);