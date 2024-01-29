# Order Management App

## Overview

The Order Management App is a distributed application built on a microservices architecture. It consists of several services including Order Service, Inventory Service, Discovery Service, Config Server, Notification Service, Gateway Service, and Keycloak Service. This setup allows for better scalability, maintainability, and independent deployment of each service.

## Microservices (still in progress)

### 1. Order Service

- Manages order creation, processing, and status tracking.
- Utilizes a PostgreSQL database for storing order-related information.

### 2. Inventory Service

- Handles inventory management, product availability, and stock tracking.
- Uses a PostgreSQL database to store product and inventory details.

### 3. Discovery Service

- Keeps track of registered services and aids in service discovery.
- Enables dynamic routing and load balancing between services.

### 4. Config Server

- Centralized configuration management for all services.
- Services fetch their configuration from the Config Server.

### 5. Notification Service

- Sends email notifications to users regarding their orders.
- Integrates with external email services.

### 6. Gateway Service

- Acts as the API gateway to facilitate communication between microservices.
- Provides a single entry point for external clients and handles routing to the appropriate services.
- Enhances security through authentication and authorization mechanisms.

### 7. Keycloak Service (in progress)

- Manages user authentication and authorization.
- Provides a secure identity and access management solution for the application.

## Technologies Used

- **Microservices Framework:**
  - Spring Cloud (for service discovery, configuration, and communication)

- **Backend:**
  - Java Spring Boot

- **Databases:**
  - PostgreSQL (for Order Service and Inventory Service)
