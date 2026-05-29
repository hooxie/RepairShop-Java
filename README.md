## About the Project

**RepairShop-Java** is a full-stack, enterprise-style web application built with the **Spring Boot** framework to manage automotive repair shops, mechanics, and customer vehicles. Designed with clean architecture in mind, the project showcases the implementation of a robust multi-layered system separating domain logic, data persistence, and user interfaces.

### Key Features
* **Multi-Layered Architecture:** Clear separation of concerns utilizing Controller, Service, and Repository layers.
* **Flexible Data Persistence:** Supports multiple DAO approaches, including Spring Data JPA for MySQL database connectivity, in-memory storage (`SampleData`), and dummy configurations.
* **Dual Interface Support:** Features a dynamic web UI powered by **Thymeleaf** templates alongside a comprehensive **REST API** for external system integrations.
* **Spring Security & Validation:** Includes dedicated security configurations and robust server-side validation for business entities.
* **Docker Support:** Containerized environment ready for deployment using `docker-compose` to spin up the application and its MySQL database seamlessly.
