# Doctor Management & Timeslot Management Modules

## Overview

These modules implement **Layered Architecture** as part of the Pattern Forge multi-doctor clinic appointment booking system. They handle doctor profile management and time slot scheduling operations with clear separation between presentation, business, and data access layers.

## Architecture Pattern: Layered Architecture

### Layered Architecture

Layered Architecture provides **clear separation of concerns** through well-defined layers, and these modules bussiness logic is simple

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
- **Delete Timeslot** - Remove individual time slots

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
    └── TimeslotModel.java            # JPA entity
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
├── core/                                    # Business Logic & Contracts
│   ├── domain/                              # Domain Entities & Services
│   │   ├── Appointment.java                 # Domain Entity
│   │   ├── AppointmentServiceImpl.java      # Application Service
│   │   ├── AppointmentStatus.java           # Value Object
│   │   └── AppointmentType.java             # Value Object
│   └── port/                                # Interfaces (Contracts)
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
*This module demonstrates how Hexagonal Architecture can be applied to create maintainable, testable, and flexible software that clearly separates business concerns from infrastructure details.*

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
|           └── BeanFactory.java      # Spring Configuration
├── presentation/                    # Presentation Layer
│   ├── PatientController.java       # REST Controller
│   └── PatientApiDto.java          # Data Transfer Object

```
This module demonstrates how Onion Architecture can be applied to create domain-centric, and maintainable software that protects business logic at its core like hexagonal while ensuring dependencies flow inward from infrastructure to domain.

