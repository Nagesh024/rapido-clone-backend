INSERT INTO portal_modules(module_name,description,status)
VALUES
('Dashboard','Platform Overview','ACTIVE'),

('Service Catalog','Service Registry','ACTIVE'),

('Deployments','Deployment Management','ACTIVE'),

('Environments','Environment Management','ACTIVE'),

('Monitoring','Prometheus Grafana Integration','ACTIVE'),

('Documentation','Developer Documentation','ACTIVE');


INSERT INTO security_controls
(control_name, category, description, mandatory, compliance_level)
VALUES
('OAuth2 Authentication',
 'AUTHENTICATION',
 'OAuth2 with JWT tokens',
 true,
 'CRITICAL');

INSERT INTO security_controls
(control_name, category, description, mandatory, compliance_level)
VALUES
('Vault Secrets Management',
 'SECRETS',
 'Secrets stored in Vault',
 true,
 'CRITICAL');
 
 INSERT INTO dependency_inventory
(
dependency_name,
version,
license_type,
vulnerability_count,
status,
approved
)
VALUES
(
'Spring Boot',
'3.3.5',
'Apache 2.0',
0,
'ACTIVE',
true
);


INSERT INTO dependency_inventory
(
dependency_name,
version,
license_type,
vulnerability_count,
status,
approved
)
VALUES
(
'Kafka Client',
'3.8.0',
'Apache 2.0',
0,
'ACTIVE',
true
);

INSERT INTO technology_catalog
(
technology_name,
version,
status,
owner,
replacement_technology
)
VALUES
(
'Java',
'17',
'ACTIVE',
'Platform Engineering',
NULL
);

INSERT INTO technology_catalog
(
technology_name,
version,
status,
owner,
replacement_technology
)
VALUES
(
'Java',
'11',
'DEPRECATED',
'Platform Engineering',
'Java 17'
);