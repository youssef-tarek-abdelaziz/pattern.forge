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

