# Nullam

## Introduction
Nullam is a project made with Java using Domain Driven Design & Jdbc. Application can be used to create events and to manage, edit & remove participants. Participants can be either Companies or Persons.
ER model of the database can be seen below. Database was made with H2 database engine.

![ER diagram](https://i.imgur.com/JrYVkrm.png)

## Application
Front-End: Thymeleaf, Bootstrap<br/>
Back-End: Java, Spring Boot<br/><br/>
![Demo](https://i.imgur.com/Q944T9L.png)
![Demo](https://i.imgur.com/fGQSZgt.png)
![Demo](https://i.imgur.com/SuIZLF8.png)

## File Structure:
```
|-- java
|   |-- EventManagement
|       |-- common
|           |-- primitives
|               |-- Description
|               |-- ParticipantId
|               |-- PaymentType
|           |-- DomainEvent
|           |-- Eventpublisher
|       |-- company
|           |-- jdbc
|               |-- CompaniesJdbc
|               |-- CompanyJdbc
|               |-- CompanyJdbcConfig
|               |-- CreateCompanyJdbc
|               |-- FindCompaniesFromFromEventJdbc
|               |-- FindCompaniesJdbc
|               |-- UnknownCompany
|           |-- Companies
|           |-- Company
|           |-- CompanyId
|           |-- CreateCompany
|           |-- FindCompanies
|           |-- FindCompaniesFromEvent
|           |-- LegalName
|           |-- NumberOfPartakers
|           |-- RegistryCode
|       |-- event
|           |-- jdbc
|               |-- CreateEventJdbc
|               |-- EventJdbc
|               |-- EventJdbcConfig
|               |-- EventsJdbc
|               |-- FindEventsJdbc
|               |-- UnknowsEvent
|           |-- CreteEvent
|           |-- DeleteEvent
|           |-- Event
|           |-- EventId
|           |-- EventLocation
|           |-- Events
|           |-- EventTime
|           |-- FindEvents
|           |-- Name
|       |-- person
|           |-- jdbc
|               |-- CreatePersonJdbc
|               |-- FindPersonsFromEventJdbc
|               |-- FindPersonsJdbc
|               |-- PersonJdbc
|               |-- PersonJdbcConfig
|               |-- PersonsJdbc
|               |-- UnknownPerson
|           |-- CreatePerson
|           |-- FindPersons
|           |-- FindPersonsFromEvent
|           |-- FirstName
|           |-- LastName
|           |-- Person
|           |-- PersonalCode
|           |-- PersonId
|           |-- Persons
|       |-- web
|           |-- CompanyController
|           |-- EventController
|           |-- PersonController
|           |-- PortalWebConfig
|       |-- EventManagementApplication
|       |-- ExampleDataConfig
|   |-- Resources
|       |-- static.assets
|       |-- templates
|           |-- layout
|               |-- default.html
|           |-- company.html
|           |-- event.html
|           |-- events.html
|           |-- new_event.html
|           |-- new_event_error.html
|           |-- new_participant_error.html
|           |-- person.html
|       |-- application.properties
|       |-- event-management-er-model.png
|       |-- example-data.sql
|       |-- message.properties
|       |-- schema.sql
```

## Usage
Install 
```
Download the project zip or clone the repository
```
Run the application
```
Start Development server - [http://localhost:8080](http://localhost:8080).
```
