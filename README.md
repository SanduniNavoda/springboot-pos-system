# Point of Sale System (POS)

This is the backend implementation of a Point of Sale (POS) system developed using Spring Boot and MySQL. The system includes functionalities for managing items, item categories, stock, and point of sale transactions. Additionally, it incorporates authentication using Spring Security with JWT.

## Features

- **User Management**: Create, edit, and delete items.
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
  <p align="center">
     <img src="https://github.com/user-attachments/assets/b77af294-1a3e-4cdf-85d8-66691d97ebd7" alt="Screenshot of user login interface and database" width="60%"/>
     <img src="https://github.com/user-attachments/assets/cb639e24-4df2-47c2-9cec-34e485f1cf43" alt="Screenshot of Home Page" width="30%"/>
  </p>
  <br>

### User Management
- GET /api/products: Retrieve all users
- POST /api/products: Add a new user
- PUT /api/products/{id}: Update user
- DELETE /api/products/{id}: Delete user

  <p align="center">
     <img src="https://github.com/user-attachments/assets/7d7db547-2be6-4f69-909b-cfafb50f4a64" alt="Screenshot of Create User Interface" width="45%"/>
     <img src="https://github.com/user-attachments/assets/27d2bd02-863b-494f-9845-4d87638fc655" alt="Screenshot of Update User Interface" width="45%"/>
  </p>
  <br>

### Product Management
- GET /api/products: Retrieve all items
- POST /api/products: Add a new item
- PUT /api/products/{id}: Update an item
- DELETE /api/products/{id}: Delete an item

  <p align="center">
     <img src="https://github.com/user-attachments/assets/2f4d8216-0cd1-4fe7-b495-ecd62e6630e5" alt="Screenshot of Add New Product Interface" width="45%"/> 
     <img src="https://github.com/user-attachments/assets/0f6225bc-d124-427e-b517-eb16546059d9" alt="Screenshot of Update Product Interface" width="45%"/> 
  </p>
  <br>

### Item Category Management
- GET /api/categories: Retrieve all item categories
- POST /api/categories: Add a new item category
- PUT /api/categories/{id}: Update an item category
- DELETE /api/categories/{id}: Delete an item category

  <p align="center">
     <img src="https://github.com/user-attachments/assets/4cf2c4bf-4183-49da-b4c4-a99d0feb5ae3" alt="Screenshot of Category Management Interface" width="45%"/> 
  </p>
  <br>

### Point of Sale
- POST /api/orders: Create an order
  <p align="center">
   <img src="https://github.com/user-attachments/assets/6a9c0953-43a1-453b-9060-ae6934cc2f78" alt="Screenshot of Orders Management Interface" width="45%"/>
  </p>
  <br>
  
- POST /api/orders/{id}/addProduct: Add a product to cart, and remove from the stock
  <p align="center">
   <img src="https://github.com/user-attachments/assets/6f090b56-2abc-4ddd-9408-d8c15aae5091" alt="Screenshot of Add Items to Cart Intrface and Database" width="60%"/>
  </p>
  <br>

   
- POST /api/{orderId}/removeProduct: Remove a product from order and add back into the stock
  <p align="center">
   <img src="https://github.com/user-attachments/assets/4dd1c805-630a-47ec-ab84-fb1a8d9e9d18" alt="Screenshot of Remove a product from order and add back into the stock" width="60%"/>
  </p>
  <br>
  
- GET /api/orders/{id}: Get a specific order by it's id
- GET /api/orders: Get all Orders
  <p align="center">
   <img src="https://github.com/user-attachments/assets/2ba2f234-518d-4690-92a2-8ae153e0ffd6" alt="Screenshot of Create Order Interface and Database" width="60%"/>
  </p>
  <br>
  
- DELETE /api/orders/{id}: Delete an order

  <p align="center">
   <img src="https://github.com/user-attachments/assets/fec63fbf-b623-40ba-a9a5-b981783324d2" alt="Screenshot of Delete an order and restore items in stock" width="60%"/>
  </p>
  <br>

## Security
- The application uses Spring Security with JWT for authentication. After logging in, you will receive a JWT token that must be included in the Authorization header of your API requests as a Bearer token.

## License
- This project is licensed under the MIT License. See the LICENSE file for details.
