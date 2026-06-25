CREATE TABLE dependency_scan_results (

    id BIGSERIAL PRIMARY KEY,

    dependency_name VARCHAR(255),

    vulnerability_id VARCHAR(255),

    severity VARCHAR(100),

    cvss_score DOUBLE PRECISION,

    build_blocked BOOLEAN
);