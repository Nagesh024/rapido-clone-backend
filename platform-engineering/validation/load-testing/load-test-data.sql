INSERT INTO risk_register
(risk, impact, likelihood, mitigation, owner)

SELECT

'Risk-' || g,

5,

5,

'Mitigation-' || g,

'Platform Team'

FROM generate_series(1,10000) g;


INSERT INTO technical_debt
(
title,
description,
category,
risk_score,
business_impact,
technical_impact,
probability,
status,
owner
)

SELECT

'Debt-' || g,

'Technical Debt Description',

'ARCHITECTURE',

50,

5,

5,

5,

'OPEN',

'Engineering Team'

FROM generate_series(1,50000) g;


INSERT INTO architecture_decision_record
(title, status)

SELECT

'ADR-' || g,

'APPROVED'

FROM generate_series(1,500) g;