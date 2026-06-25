# Pagination Policy

Mandatory for all list APIs.

Example:

GET /api/v1/rides?page=0&size=20

Response:

{
  "content":[...],
  "page":0,
  "size":20,
  "totalElements":1000,
  "totalPages":50
}