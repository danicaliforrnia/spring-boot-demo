<p align="center">
    <h1>Profile Matcher</h1>

<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li>
      <a href="#usage">Usage</a>
      <ul>
        <li><a href="#directory-structure">Directory structure</a></li>
        <li><a href="#run-project-locally">Run Project locally</a></li>
        <li><a href="#create-a-new-database-migration">Create a new database migration</a></li>
        <li><a href="#update-database-and-prisma-client">Update database and Prisma client</a></li>
        <li><a href="#create-a-new-seed">Create a new seed</a></li>
        <li><a href="#create-a-new-app">Create a new app</a></li>
        <li><a href="#create-a-new-lib">Create a new lib</a></li>
        <li><a href="#openapi-spec-and-swagger">OpenAPI spec and Swagger</a></li>
      </ul>
    </li>
    <li>
      <a href="#cloud-environment">Cloud Environment</a>
      <ul>
        <li><a href="#infrastructure">Infrastructure</a></li>
        <li><a href="#iac-with-terraform">IaC with Terraform</a></li>
        <li><a href="#provisioning-with-ansible">Provisioning with Ansible</a></li>
        <li><a href="#ci-cd-pipelines">CI/CD Pipelines</a></li>
      </ul>
    </li>
  </ol>
</details>

## About The Project

This is a sample project for a simple service that will serve as a very simple user profile matcher.

### Built With

- [Java 21](https://jdk.java.net/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [PostgresSQL](https://www.postgresql.org/)
- [Docker and Docker Compose](https://www.docker.com/)

## Getting Started

### Prerequisites

To run this project locally, you'll need:

- **Java 21** at least, that can be downloaded in official sources.
- **Postgres** database, that can be created when running the service by using the spring boot
  `spring-boot-docker-compose`
  package or by using the [`compose.yml`](compose.yaml) file.
-

### Installation

1. Clone the repo

   ```sh
    git clone https://github.com/danicaliforrnia/spring-boot-demo.git
   ```

2. Copy the `.env.sample` file at the root and paste it in the same directory (renaming it as `.env`). This `.env` file
   contains database environment variables used by the `compose.yml` and also, optionally, the application yaml file.

3. Copy the [`application-sample.yml`](src/main/resources/application-local-sample.yml) and paste it in the same
   folder (renaming it as `application-local.yml`).
   This file contains the properties to run the application.

4. Run the application specifying the active profiles as `-Dspring.profiles.active=default,local`

## Usage

### Directory structure

The project has the following structure:

    spring-boot-demo
    ├── src/main
       ├── java/com.dstefanelli.springbootdemo
            ├── application
            ├── domain
            ├── infrastructure
            ├── presentation
       ├── resources
            ├── db/migration
            ├── application.yml
            ├── application-local.yml
    ├── src/test
    ├── compose.yml


- `src/main/java/com.dstefanelli.springbootdemo`:
  - `application`:
  - `domain`:
  - `infrastructure`:
  - `presentation`:
- `src/main/resources`:
  - `db/migration`:
  - `application.yml`:
  - `application-local.yml`:
- `compose.yml`:
    
### Adding a new migration

Lorem ipsum dolor sit amet consectetur adipiscing elit placerat non luctus accumsan eleifend at, pharetra ad dictumst quisque integer eu lacinia est sapien dictum sagittis suspendisse
