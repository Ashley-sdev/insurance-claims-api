# Insurance Claims Management REST API

![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-brightgreen)
![Gradle](https://img.shields.io/badge/Gradle-Build%20Tool-blue)
![H2](https://img.shields.io/badge/H2-Database-lightblue)
![Status](https://img.shields.io/badge/Status-Complete-success)

A RESTful API simulating a simplified insurance claims management system,
built to demonstrate Java enterprise backend fundamentals directly relevant
to Guidewire ClaimCenter development.

---

## Business Context

[Guidewire ClaimCenter](https://www.guidewire.com) is the industry-leading
claims management platform used by insurers worldwide. It manages the full
lifecycle of an insurance claim — from First Notice of Loss (FNOL) through
investigation, adjudication, and settlement to closure.

This project simulates a core subset of that functionality, demonstrating
understanding of:
- Insurance claim lifecycle management
- RESTful web service design
- Enterprise Java backend architecture
- XML-based system integration patterns

---

## Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 25 | Core programming language |
| Spring Boot | 3.4.3 | Application framework |
| Hibernate / JPA | 7.x | ORM and database interaction |
| H2 Database | 2.x | Embedded SQL database |
| Gradle | 8.x | Build and dependency management |
| JAXB | 4.x | XML report generation |
| Git & GitHub | - | Version control |

---

## Architecture
```
┌─────────────────────────────────────────┐
│           REST API Layer                │
│         (ClaimController)               │
│     HTTP requests and responses         │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│           Service Layer                 │
│           (ClaimService)                │
│        Business logic lives here        │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│         Repository Layer                │
│        (ClaimRepository)                │
│    Spring Data JPA - database access    │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│           H2 Database                   │
│         CLAIMS table                    │
│    In-memory SQL database               │
└─────────────────────────────────────────┘
```

---

## Claim Lifecycle
```
SUBMITTED → UNDER_REVIEW → APPROVED → CLOSED
                        → REJECTED → CLOSED
```

| Status | ClaimCenter Equivalent |
|--------|----------------------|
| SUBMITTED | First Notice of Loss (FNOL) received |
| UNDER_REVIEW | Assigned to adjuster, investigation in progress |
| APPROVED | Claim validated and approved for settlement |
| REJECTED | Claim denied after adjudication |
| CLOSED | Settlement complete, claim closed |

---

## API Endpoints

| Method | Endpoint | Description | Response |
|--------|----------|-------------|----------|
| POST | `/api/claims` | Submit a new claim (FNOL) | 201 Created |
| GET | `/api/claims` | Retrieve all claims | 200 OK |
| GET | `/api/claims/{id}` | Retrieve a specific claim | 200 OK |
| PUT | `/api/claims/{id}/status` | Update claim status | 200 OK |
| DELETE | `/api/claims/{id}` | Delete a claim | 204 No Content |
| GET | `/api/claims/{id}/report` | Export claim as XML | 200 OK |

---

## Sample Request and Response

### Submit a Claim (POST)

**Request:**
```json
{
    "policyholderName": "Sipho Dlamini",
    "description": "Motor vehicle accident on N1 highway near Midrand.",
    "claimAmount": 45000.00
}
```

**Response (201 Created):**
```json
{
    "id": 1,
    "claimNumber": "CLM-1773119941905",
    "policyholderName": "Sipho Dlamini",
    "description": "Motor vehicle accident on N1 highway near Midrand.",
    "claimAmount": 45000.00,
    "status": "SUBMITTED",
    "createdAt": "2026-03-10T07:19:01",
    "updatedAt": "2026-03-10T07:19:01"
}
```

### XML Report (GET /api/claims/1/report)
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<claimReport>
    <claimNumber>CLM-1773119941905</claimNumber>
    <policyholderName>Sipho Dlamini</policyholderName>
    <description>Motor vehicle accident on N1 highway near Midrand.</description>
    <claimAmount>45000.00</claimAmount>
    <status>SUBMITTED</status>
    <createdAt>2026-03-10T07:19:01</createdAt>
    <updatedAt>2026-03-10T07:19:01</updatedAt>
</claimReport>
```

### Error Response (404)
```json
{
    "status": 404,
    "error": "Claim Not Found",
    "message": "Claim not found with id: 999",
    "timestamp": "2026-03-10T07:19:01"
}
```

---

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Git

### Run Locally
```bash
git clone https://github.com/Ashley-sdev/insurance-claims-api.git
cd insurance-claims-api
./gradlew bootRun
```

API runs at: `http://localhost:8080`

### View Database Console

Navigate to `http://localhost:8080/h2-console`

- JDBC URL: `jdbc:h2:mem:claimsdb`
- Username: `sa`
- Password: *(leave empty)*

### Run SQL Query
```sql
SELECT * FROM CLAIMS;
```

---

## Project Phases

- [x] Phase 0: Project setup, Gradle configuration, Git workflow
- [x] Phase 1: Java fundamentals and domain modelling
- [x] Phase 2: Repository, Service layer, DTOs and Exception handling
- [x] Phase 3: REST API Controllers
- [x] Phase 4: Validation and Error Handling
- [x] Phase 5: XML Report Generation
- [x] Phase 6: Polish and final documentation

---

## What I Learned

- Java OOP principles applied in a real enterprise context
- Spring Boot dependency injection and layered architecture
- Hibernate ORM — mapping Java classes to SQL tables automatically
- REST API design with proper HTTP status codes
- XML generation using JAXB for enterprise system integration
- Gradle build tool configuration
- Professional Git workflow with meaningful commits
- Guidewire ClaimCenter domain knowledge and claim lifecycle

---

## Author

**Muhle Ashley Ntuli**
Graduate Developer | Java | Spring Boot | Insurance Technology

- GitHub: [Ashley-sdev](https://github.com/Ashley-sdev)
- LinkedIn: [Muhle Ashley Ntuli](https://www.linkedin.com/in/muhle-ntuli-9a7638342)
- Portfolio: (https://my-portfolio-website-sf9a.vercel.app/)