# Movie Database CRUD App

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-brightgreen?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-25-blue?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

A simple web application for managing a movie database. Built with Spring Boot, JPA, and jte templates.

---

## Tech Stack

| Technology | Version | Purpose |
|------------|--------|---------|
| Spring Boot | 4.0.3 | Framework |
| Java | 25 | Language |
| Spring Data JPA | - | Database access |
| MySQL | 8+ | Database |
| jte | 3.2.3 | Server-side templating |
| Docker Compose | - | Database container |

---

## Features

- **Create** new movies with validation
- **Read** movie list with pagination
- **Update** existing movies
- **Delete** movies
- **Search** movies by title, director, or year
- Form validation with error messages
- Responsive UI with TailwindCSS

---

## Getting Started

### Prerequisites

- Java 25
- Maven 3.8+
- MySQL 8+ **OR** Docker Compose

### 1. Clone the repository

```bash
git clone <repository-url>
cd springboot-crud-webapp
```

### 2. Set up the database

**Option A: Using Docker Compose (recommended)**

```bash
docker compose up -d
```

**Option B: External MySQL**

Create a database named `movie_db`:

```sql
CREATE DATABASE movie_db;
```

### 3. Configure environment variables

Create a `.env` file in the project root:

```env
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/movie_db
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=your_password
```

> **Default password for Docker:** `rootpassword`

### 4. Run the application

```bash
mvn spring-boot:run
```

The app starts at: **http://localhost:8080**

---

## Database Schema

### Movie Entity

| Field | Type | Constraints |
|-------|------|------------|
| id | Long | Primary Key, Auto-generated |
| title | String | Not blank, Unique with releaseDate |
| description | String | Not blank |
| releaseDate | LocalDate | Past or present |
| director | String | Not blank |
| duration | Integer | Min 1 minute |

---

## API Endpoints

### Web Interface

| Method | Path | Description |
|--------|------|-------------|
| GET | `/movies` | List all movies (paginated, 9 per page) |
| GET | `/movies/search` | Search movies |
| GET | `/movies/new` | Show create form |
| POST | `/movies` | Create new movie |
| GET | `/movies/{id}` | View movie details |
| GET | `/movies/{id}/edit` | Show edit form |
| POST | `/movies/{id}/edit` | Update movie |
| POST | `/movies/{id}/delete` | Delete movie |

### Query Parameters for Search

| Parameter | Type | Description |
|-----------|------|------------|
| title | String | Filter by title |
| director | String | Filter by director |
| year | Integer | Filter by release year |

---

## Project Structure

```
src/main/java/org/noob/springbootcrudwebapp/
├── SpringbootCrudWebappApplication.java    # Main entry point
├── controller/
│   └── MovieController.java              # Web controllers
├── service/
│   └── MovieService.java                 # Business logic
├── repository/
│   └── MovieRepository.java               # Data access
├── entity/
│   └── Movie.java                        # JPA entity
├── dto/
│   ├── MovieDTO.java                    # Data transfer objects
│   ├── CreateMovieDTO.java
│   ├── UpdateMovieDTO.java
│   ├── MoviePageDTO.java
│   └── MovieFilterDTO.java
├── mapper/
│   └── MovieMapper.java                  # Entity <-> DTO mapping
├── exception/
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
└── DataSeeder.java                     # Sample data

src/main/jte/                           # jte templates
src/main/resources/
├── application.properties               # Configuration
└── import.sql                         # Initial data
```

---

## Sample Data

The app seeds 25 classic movies on first run:

| Title | Director | Year |
|-------|----------|------|
| Inception | Christopher Nolan | 2010 |
| The Dark Knight | Christopher Nolan | 2008 |
| Interstellar | Christopher Nolan | 2014 |
| The Shawshank Redemption | Frank Darabont | 1994 |
| The Godfather | Francis Ford Coppola | 1972 |
| Pulp Fiction | Quentin Tarantino | 1994 |
| Schindler's List | Steven Spielberg | 1993 |
| The Lord of the Rings | Peter Jackson | 2001 |
| Forrest Gump | Robert Zemeckis | 1994 |
| Fight Club | David Fincher | 1999 |
| Goodfellas | Martin Scorsese | 1990 |
| The Matrix | Lana Wachowski | 1999 |
| Se7en | David Fincher | 1995 |
| The Silence of the Lambs | Jonathan Demme | 1991 |
| Saving Private Ryan | Steven Spielberg | 1998 |
| Gladiator | Ridley Scott | 2000 |
| The Departed | Martin Scorsese | 2006 |
| Whiplash | Damien Chazelle | 2014 |
| Parasite | Bong Joon-ho | 2019 |
| The Grand Budapest Hotel | Wes Anderson | 2014 |
| No Country for Old Men | Joel Coen | 2007 |
| There Will Be Blood | Paul Thomas Anderson | 2007 |
| Mad Max: Fury Road | George Miller | 2015 |
| La La Land | Damien Chazelle | 2016 |
| The Revenant | Alejandro G. Inarritu | 2015 |

---

## Running Tests

```bash
mvn test
```

---

## License

This project is licensed under the MIT License.