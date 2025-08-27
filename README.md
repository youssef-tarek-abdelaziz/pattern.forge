# Doctor Management & Timeslot Management Modules

## Overview

These modules implement **Layered Architecture** as part of the Pattern Forge multi-doctor clinic appointment booking system. They handle doctor profile management and time slot scheduling operations with clear separation between presentation, business, and data access layers.

## Architecture Pattern: Layered Architecture

### Layered Architecture

Layered Architecture provides clear separation of concerns through well-defined layers, and these modules bussiness logic is simple

## Module 1: Doctor Management

### **Package Structure**
```
doctorManagement/
├── controller/
│   ├── DoctorController.java           # REST API endpoints
│   └── DoctorApiDto.java              # Data Transfer Object
├── service/
│   ├── DoctorService.java             # Service interface
│   └── DoctorServiceImpl.java         # Business logic implementation
├── repository/
│   └── DoctorRepository.java          # JPA repository interface
├── domain/
│   └── DoctorModel.java               # JPA entity
└── enums/
    └── DoctorSpecialty.java           # Specialty enumeration
```

## Module 2: Timeslot Management

### **Functionality**
- **Assign Timeslots to Doctor** - Create multiple time slots for a specific doctor
- **Delete Timeslot** - Soft delete for the reserved time slots

### **Package Structure**
```
timeslotManagement/
├── controller/
│   ├── TimeslotController.java        # REST API endpoints
│   └── TimeslotApiDto.java           # Data Transfer Object
├── service/
│   ├── TimeslotService.java          # Service interface
│   └── TimeslotServiceImpl.java      # Business logic implementation
├── repository/
│   └── TimeslotRepository.java       # JPA repository interface
└── domain/
|   └── TimeslotModel.java            # JPA entity
└── contract/
    └── TimeslotApi.java            # Timeslot Contract
    └── TimeslotApiImpl.java        # Timeslot Contract Implementation


```
## API Endpoints

### **Doctor Management APIs**
```http
POST /api/doctor                    # Add new doctor
PUT /api/doctor                     # Update doctor information  
GET /api/doctor/all                 # Get all doctors
```

### **Timeslot Management APIs**
```http
POST /api/timeslot/{doctorId}       # Assign timeslots to doctor
DELETE /api/timeslot/{timeslotId}   # Delete specific timeslot
```

# Appointment Lifecycle Management Module

## Overview

The **Appointment Lifecycle Management** module is implemented using **Hexagonal Architecture** (Ports & Adapters pattern) as part of the Pattern Forge multi-doctor clinic appointment booking system. This module handles the complete lifecycle of medical appointments, from viewing doctor schedules to managing appointment status changes.

## Architecture Pattern: Hexagonal (Ports & Adapters)

### Hexagonal Architecture

Hexagonal Architecture ensures that the business logic is completely isolated from external concerns like databases, web frameworks, and other infrastructure. 

## Module Structure

```
appointmentManagement/
├── core/                                    # Business Logic
│   ├── domain/                              # Domain Entities & Services
│   │   ├── Appointment.java                 # Domain Entity
│   │   ├── AppointmentServiceImpl.java      # Service
│   │   ├── AppointmentStatus.java           # Value Object
│   │   └── AppointmentType.java             # Value Object
│   └── port/                                # Interfaces (Ports)
│       ├── in/AppointmentService.java       # Input Port
│       └── out/AppointmentRepository.java   # Output Port
└── shell/                                   # Infrastructure & Adapters
    ├── adapter/
    │   ├── in/web/AppointmentController.java    # REST Adapter
    │   └── out/persistence/AppointmentPostgresRepo.java  # Database Adapter
    ├── config/BeansFactory.java            # Spring Configuration
    ├── model/                               # JPA Entities
    │   ├── AppointmentModel.java
    │   ├── DoctorModel.java
    │   ├── PatientModel.java
    │   └── TimeSlotModel.java
    └── repository/AppointmentJpaRepo.java   # JPA Repository Interface
```
*This module demonstrates how Hexagonal Architecture can be applied to create maintainable, and flexible software that clearly separates business concerns from infrastructure details.*

### **Appointment Management APIs**
```http
GET /api/appointment/{doctorId}                           # Get doctor's appointments
GET /api/appointment/{doctorId}?to={datetime}             # Get appointments before date
POST /api/appointment/{id}/{doctorId}/status/{status}     # Change appointment status
```

# Patient Management Module

## Overview

The **Patient Management** module is implemented using **Onion Architecture** as part of the Pattern Forge multi-doctor clinic appointment booking system. This module handles patient registration, information management, and serves as the foundation for patient-related operations across the clinic system.

## Architecture Pattern: Onion Architecture

### Onion Architecture

Onion Architecture provides the same features of hexagonal architecture pattern with isloation for business logic in shape of layes.

## Module Structure

```
patientManagement/
├── domain/                          # Core Domain Layer
│   ├── Patient.java                 # Domain Entity (Aggregate Root)
│   ├── Name.java                    # Value Object
│   ├── Email.java                   # Value Object  
│   └── PhoneNumber.java             # Value Object
├── application/                     # Application Layer
│   └── PatientApplicationService.java  # Application Service
├── port/                           # Contracts/Interfaces
│   └── PatientRepository.java       # Output Port
├── infrastructure/                  # Infrastructure Layer
│   ├── adapter/
│   │   └── PatientPostgresRepository.java  # Database Adapter
│   └── persistence/
│   |   ├── PatientJpaRepository.java      # JPA Repository Interface
│   |   └── PatientModel.java              # JPA Entity
|   └── config/
|           └── PatientBeanFactory.java      # Spring Configuration
├── presentation/                    # Presentation Layer
│   ├── PatientController.java       # REST Controller
│   └── PatientApiDto.java          # Data Transfer Object
├── contract/                    
│   ├── PatientAPI.java             # Patient Contract
│   └── PatientApiDto.java          # Patient Contract Implementation

```
This module demonstrates how Onion Architecture can be applied to create domain-centric, and maintainable software that protects business logic at its core like hexagonal while ensuring dependencies flow inward from infrastructure to domain.
# Patient Management API

```http
POST /api/patient/register          # Register new patient
```
# Appointment Booking Module

## Overview

The **Appointment Booking** module is implemented using **Clean Architecture** as part of the Pattern Forge multi-doctor clinic appointment booking system. This module handles the core business logic for booking medical appointments, ensuring patient-doctor appointment scheduling with proper validation and business rule enforcement.

**Architecture Pattern**: Clean Architecture

## Clean Architecture

Clean Architecture is like the onion architecture but it takes the single responsipility pricinciple to the next level by the concept of usecases. 
As a domain centric model, the business logic is completely independent of external frameworks, databases.

## Module Structure

```
appointmentBooking/
├── entities/                                    # Enterprise Business Rules
│   ├── Appointment.java                         # Core Business Entity
│   ├── AppointmentStatus.java                   # Value Object
│   └── AppointmentType.java                     # Value Object
├── usecases/                                    # Application Business Rules
│   ├── BookAppointmentUseCase.java             # Use Case Interface
│   ├── BookAppointmentUseCaseImpl.java         # Use Case Implementation
│   └── gateway/                                 # Gateway Interfaces (Output Ports)
│       ├── AppointmentGateway.java             # Appointment Persistence Contract
│       ├── PatientGateway.java                 # Patient Validation Contract
│       └── TimeslotGateway.java                # Timeslot Management Contract
├── adapter/                                     # Interface Adapters
│   ├── controller/                              # Web Controllers (Input Adapters)
│   │   ├── AppointmentBookingController.java   # REST API Controller
│   │   └── BookAppointmentApiDto.java          # API Request DTO
│   ├── gatewayAdapters/                        # Gateway Implementations (Output Adapters)
│   │   ├── AppointmentPostgresGateway.java     # Database Adapter
│   │   ├── PatientApiGateway.java              # Patient Module Integration
│   │   ├── TimeslotApiGateway.java             # Timeslot Module Integration
│   │   └── dto/                                 # External API DTOs
│   │       ├── PatientApiDto.java
│   │       └── TimeslotApiDto.java
│   └── persistence/                             # Database Models & Repositories
│       ├── AppointmentBookingModel.java        # JPA Entity
│       └── AppointmentBookingRepository.java   # JPA Repository Interface
└── config/
    └── AppointmentBookingBeanFactory.java      # Dependency Injection Configuration
```
### Cross-Module Integration
- **Patient Management**: Validates patient existence via `PatientGateway`
- **Timeslot Management**: Checks availability and reserves slots via `TimeslotGateway`
- **Notification System**: Ready for integration via domain events

## API Endpoints

```http
POST /api/appointment/booking    # Book a new appointment
```

**Request Body:**
```json
{
  "slotId": "uuid",
  "patientId": "uuid", 
  "appointmentType": "CONSULTATION|FOLLOWUP"
}
```

## Dependencies

The module integrates with other Pattern Forge modules through well-defined contracts:

- **Patient Management Module**: Patient existence validation
- **Timeslot Management Module**: Slot availability and reservation
- **Notification Module**: Appointment confirmation (ready for integration)

*This module demonstrates how Clean Architecture can be applied to create robust, maintainable appointment booking functionality that clearly separates business logic from infrastructure concerns while enabling seamless integration with other system modules.*
