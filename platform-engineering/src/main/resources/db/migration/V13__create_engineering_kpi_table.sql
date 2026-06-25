CREATE TABLE IF NOT EXISTS engineering_kpi (

    id BIGSERIAL PRIMARY KEY,

    service_name VARCHAR(255),

    deployment_frequency INTEGER,

    change_failure_rate DOUBLE PRECISION,

    lead_time_hours DOUBLE PRECISION,

    mttr_hours DOUBLE PRECISION,

    availability DOUBLE PRECISION
);