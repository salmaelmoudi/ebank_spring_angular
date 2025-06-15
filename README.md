# 💳 eBank – Digital Banking Platform (Spring Boot + Angular)

Welcome to **eBank**, a full-stack digital banking system developed using **Spring Boot** for the backend and **Angular** for the frontend. This project simulates a simplified internet banking application that includes core functionalities like account management, transaction history, and real-time operations such as credit, debit, and transfers.

---

## 🗂️ Project Structure

```
ebank_spring_angular-main/
├── ebankingback     # Backend (Java + Spring Boot)
└── ebankingweb      # Frontend (Angular)
```

---

## 🔧 Technologies Used

### Backend (Spring Boot)

* Java 17+
* Spring Boot
* Spring Data JPA
* H2 / MySQL (configurable)
* Maven

### Frontend (Angular)

* Angular 14+
* TypeScript
* RxJS
* Angular Material (optional)
* REST API integration

---

## ⚙️ Features

### ✅ Core Functionalities

* View customer list and details
* View and manage bank accounts (current and saving)
* Perform credit, debit, and transfer operations
* View transaction history with pagination

### 📊 Frontend Features

* Modern Angular UI
* Forms for transaction operations
* Dynamic routing for account views
* Real-time error feedback and form validation

### 🛠 Backend Capabilities

* RESTful APIs for account operations
* Exception handling
* DTO-based data transfer
* Embedded H2 database for quick testing (can switch to MySQL)

---

## 🚀 Getting Started

### Backend Setup (Spring Boot)

```bash
cd ebankingback
./mvnw spring-boot:run
```

> By default, it runs on `http://localhost:8085`

* You can access the H2 console at `http://localhost:8085/h2-console`
* Default DB URL: `jdbc:h2:mem:testdb`

### Frontend Setup (Angular)

```bash
cd ebankingweb
npm install
ng serve
```

> Runs on `http://localhost:4200`

---

## 🔐 Sample APIs (Backend)

* `GET /customers`: List customers
* `GET /accounts/{id}`: Get account details
* `POST /accounts/debit`: Debit an account
* `POST /accounts/credit`: Credit an account
* `POST /accounts/transfer`: Transfer between accounts

---

## 🧪 Testing & Development Tips

* Use the H2 database during development for ease of testing.
* Switch to MySQL/PostgreSQL in `application.properties` for production.
* Use Angular's built-in development server for hot reloads.

---

## 📁 Project Insights

This project is a practical exercise in:

* Building REST APIs with Spring Boot
* Consuming APIs with Angular services
* Structuring clean, layered backend code with DTOs
* Creating responsive forms and dynamic views in Angular

It can serve as a base template for more complex fintech applications or academic projects.

---

## 🤝 Contribution & License

This is an educational and open-source project. Contributions are welcome via pull requests.

---

## 📸 Screenshots 

![Capture d'écran 2025-06-10 000853](https://github.com/user-attachments/assets/bba283f9-9e61-46e1-b608-8caf3513c7a5)
![Capture d'écran 2025-06-10 000912](https://github.com/user-attachments/assets/0e6a06fd-1cfa-43fe-8679-2f5396ab1662)
![Capture d'écran 2025-06-09 181445](https://github.com/user-attachments/assets/e464fa94-5ff5-47da-b709-e093ec055bad)
![image](https://github.com/user-attachments/assets/b60b5380-6853-4470-8e3e-abcb02dc9748)
![image](https://github.com/user-attachments/assets/9e63eb31-cfd4-477d-84d3-7003a67fc633)
![image](https://github.com/user-attachments/assets/77f02550-aebb-4414-b517-f112ed015d68)




