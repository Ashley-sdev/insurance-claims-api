# Insurance Claims Management REST API

A RESTful API simulating a simplified insurance claims management system,
built to demonstrate Java enterprise backend fundamentals relevant to
Guidewire insurance platform development.

## Tech Stack

| Technology | Purpose |
|------------|---------|
| Java 25 | Core programming language |
| Spring Boot 3.4.3 | Application framework |
| Hibernate / JPA | ORM and database interaction |
| H2 Database | Embedded SQL database |
| Gradle | Build and dependency management |
| REST APIs | HTTP-based service endpoints |
| XML | Claim report generation |
| Git & GitHub | Version control |

## Business Context

Guidewire is a leading insurance platform supporting policy administration,
claims processing, and billing. This project simulates a core component of
that ecosystem — a Claims Management API — to demonstrate understanding of
enterprise Java backend development in an insurance technology context.

## Project Phases

- [x] Phase 0: Project setup, Gradle configuration, Git workflow
- [x] Phase 1: Java fundamentals and domain modelling
- [ ] Phase 2: Database layer with Hibernate and JPA
- [ ] Phase 3: Service and Repository layers
- [ ] Phase 4: REST API Controllers
- [ ] Phase 5: Validation and Error Handling
- [ ] Phase 6: XML Report Generation
- [ ] Phase 7: Polish and final documentation

## API Endpoints (coming soon)

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/claims` | Submit a new claim |
| GET | `/api/claims` | Retrieve all claims |
| GET | `/api/claims/{id}` | Retrieve a specific claim |
| PUT | `/api/claims/{id}/status` | Update claim status |
| DELETE | `/api/claims/{id}` | Delete a claim |
| GET | `/api/claims/{id}/report` | Export claim as XML |

## Setup Instructions

### Prerequisites
- Java 17+ installed
- Git installed

### Run Locally
```bash
git clone https://github.com/Ashley-sdev/insurance-claims-api.git
cd insurance-claims-api
./gradlew bootRun
```

API will be available at: `http://localhost:8080`

## Author

**Muhle Ashley Ntuli**  
Graduate Developer | Java | Spring Boot | Insurance Technology  
[GitHub](https://github.com/Ashley-sdev)
