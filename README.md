# 📚 Goodreads Advanced

A Java Spring Boot application that manages books, authors, and publishers. This project showcases a layered architecture using Controller-Service-Repository patterns and JPA for database interaction.

---

## 🏗️ Project Structure

```
com.example.goodreads.demo
├── controller
│   ├── AuthorController.java
│   ├── BookController.java
│   └── PublisherController.java
├── model
│   ├── Author.java
│   ├── Book.java
│   └── Publisher.java
├── repository
│   ├── AuthorRepository.java
│   ├── AuthorJpaRepository.java
│   ├── BookRepository.java
│   ├── BookJpaRepository.java
│   ├── PublisherRepository.java
│   └── PublisherJpaRepository.java
├── service
│   ├── AuthorJpaService.java
│   ├── BookJpaService.java
│   └── PublisherJpaService.java
└── GoodreadsApplication.java
```

---

## 🚀 Features

- CRUD operations for:
    - 📖 Books
    - 👤 Authors
    - 🏢 Publishers
- RESTful APIs built using Spring Web
- Data persistence using Spring Data JPA
- Clean code structure following MVC pattern

---

## ⚙️ Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- H2 / MySQL (Configurable)
- IntelliJ IDEA

---

## 🔧 Getting Started

### Prerequisites

- JDK 17+
- Maven 3.8+
- IDE like IntelliJ IDEA

### Clone the Repository

```bash
git clone https://github.com/Skywalker690/Good-Reads-Advanced-.git
cd Good-Reads-Advanced-
```

### Run the Application

```bash
./mvnw spring-boot:run
```

Or use your IDE's run option to start `GoodreadsApplication`.

---

## 🌐 API Endpoints

```
GET    /authors
POST   /authors
PUT    /authors/{id}
DELETE /authors/{id}

GET    /books
POST   /books
PUT    /books/{id}
DELETE /books/{id}

GET    /publishers
POST   /publishers
PUT    /publishers/{id}
DELETE /publishers/{id}
```

---

## 🧪 Running Tests

```bash
./mvnw test
```

---

## 🤝 Contributing

Contributions are welcome! Feel free to fork the repository and submit a pull request.

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

## ✍️ Author

Developed by [Skywalker690](https://github.com/Skywalker690)
