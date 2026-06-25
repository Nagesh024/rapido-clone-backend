CREATE TABLE IF NOT EXISTS audit_log (

    id BIGSERIAL PRIMARY KEY,

    event_type VARCHAR(100),

    entity_name VARCHAR(255),

    performed_by VARCHAR(255),

    event_time TIMESTAMP,

    details VARCHAR(5000)
);