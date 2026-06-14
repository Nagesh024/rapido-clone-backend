# SEARCH ARCHITECTURE

## Overview

The Search Service provides intelligent search capabilities for the Rapido Clone platform. It enables driver discovery, location search, autocomplete suggestions, fuzzy matching, recommendation generation, analytics tracking, and trending searches.

### Core Components

* Spring Boot
* Elasticsearch
* Kafka
* PostgreSQL
* Redis
* Docker

---

# Index Strategy

## Driver Index (drivers)

Stores searchable driver information.

Fields:

* driverId
* location (GeoPoint)
* status
* rating

Example:

```json
{
  "driverId": "1001",
  "status": "AVAILABLE",
  "rating": 4.8,
  "location": {
    "lat": 17.4,
    "lon": 78.5
  }
}
```

## Location Index (locations)

Stores searchable places and landmarks.

Fields:

* id
* name
* city
* type

Example:

```json
{
  "id": "4",
  "name": "Charminar",
  "city": "Hyderabad",
  "type": "LANDMARK"
}
```

---

# Ranking Algorithm

Drivers are ranked based on multiple factors.

Ranking Score:

Driver Score =
(Rating × 50%)
+
(Proximity × 30%)
+
(Availability × 20%)

Factors:

1. Driver Rating
2. Distance from Rider
3. Driver Availability

Higher score drivers appear first in search results.

---

# Recommendation Logic

Recommendations are generated using:

* User search history
* Trending locations
* Popular destinations
* Frequently searched places

Example:

Search History:

* Airport
* Railway Station

Recommended Results:

* Airport
* Railway Station
* Charminar
* Inorbit Mall

---

# Caching Strategy

Caching Layer: Redis

Cached Data:

1. Autocomplete Results
2. Trending Searches
3. Recommendation Results

Benefits:

* Faster response times
* Reduced Elasticsearch load
* Improved scalability
* Better user experience

---

# Search Flow

User Request
↓
Search Service
↓
Redis Cache Check
↓
Elasticsearch Query
↓
Ranking Engine
↓
Response Returned

---

# Analytics Tracking

Tracked Events:

* Search Executed
* Autocomplete Request
* Fuzzy Search Request
* Recommendation Click
* Trending Search Query

Storage:

* PostgreSQL
* Kafka Event Stream

---

# Technologies Used

* Spring Boot
* Elasticsearch
* Kafka
* PostgreSQL
* Redis
* Docker
* Maven

---

# Conclusion

The Search-Driven Intelligent Platform provides scalable, high-performance search capabilities through Elasticsearch indexing, intelligent ranking, recommendation logic, caching strategies, analytics tracking, and event-driven architecture.
