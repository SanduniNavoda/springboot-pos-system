# Point of Sale System (POS)

This is the backend implementation of a Point of Sale (POS) system developed using Spring Boot and MySQL. The system includes functionalities for managing items, item categories, stock, and point of sale transactions. Additionally, it incorporates authentication using Spring Security with JWT.

## Features

- **Item Management**: Create, edit, and delete items.
- **Item Category Management**: Manage categories of items.
- **Point of Sale**: Handle sales transactions, including adding items to a cart, and updating stock.
- **Authentication**: Secure user authentication using JWT (JSON Web Token).

## Technologies Used

- **Java**: Programming language
- **Spring Boot**: Framework for building the backend
- **Spring Security**: For implementing authentication and authorization
- **JWT (JSON Web Token)**: For securing API endpoints
- **MySQL**: Database for storing application data
- **Hibernate JPA**: ORM for database operations

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher
- MySQL Server
- An IDE like IntelliJ IDEA or Eclipse

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/SanduniNavoda/springboot-pos-system.git
   cd pos-system

2. **Configure the database**:
   - Create a new MySQL database:
     ```bash
     CREATE DATABASE pos_system_db;
   - Update the application.properties file in the src/main/resources directory with your MySQL credentials:
     ```bash
     spring.datasource.url=jdbc:mysql://localhost:3306/pos_system_db
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true

3. **Build the project**:
    ```bash
    mvn clean install
4. **Run the application**:
   ```bash
   mvn spring-boot:run
5. **Access the application**:
   - The application will be running at http://localhost:8080.


## API Endpoints

### Authentication
- POST /api/users: Register a new user
- POST /api/auth/login: Authenticate and retrieve a JWT token

### Product Management
- GET /api/products: Retrieve all items
- POST /api/products: Add a new item
- PUT /api/products/{id}: Update an item
- DELETE /api/products/{id}: Delete an item

### Item Category Management
- GET /api/categories: Retrieve all item categories
- POST /api/categories: Add a new item category
- PUT /api/categories/{id}: Update an item category
- DELETE /api/categories/{id}: Delete an item category

### Point of Sale
- POST /api/orders: Create an order
- POST /api/orders/{id}/addProduct: Add a product to cart, and remove from the stock
- POST /api/{orderId}/removeProduct: Remove a product from order and add back into the stock
- GET /api/orders/{id}: Get a specific order by it's id
- GET /api/orders: Get all Orders
- DELETE /api/orders/{id}: Delete an order

## Security
- The application uses Spring Security with JWT for authentication. After logging in, you will receive a JWT token that must be included in the Authorization header of your API requests as a Bearer token.

## License
- This project is licensed under the MIT License. See the LICENSE file for details.
