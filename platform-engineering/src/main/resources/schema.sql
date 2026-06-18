CREATE TABLE IF NOT EXISTS audit_events
(
    id BIGSERIAL PRIMARY KEY,
    event_type VARCHAR(255),
    actor VARCHAR(255),
    action VARCHAR(255),
    created_at TIMESTAMP
);