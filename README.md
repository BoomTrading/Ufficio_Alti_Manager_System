# Ufficio Management System

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-brightgreen.svg)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)
![Maven](https://img.shields.io/badge/Maven-4.0.0-red.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

A comprehensive office management system built with Spring Boot that allows organizations to manage offices, employees, and administrative users efficiently. The system provides a web-based interface for CRUD operations and features a modern, responsive design.

## 🌟 Features

### 📍 Office Management
- Create, read, update, and delete office locations
- Manage office details including addresses, territories, and contact information
- Search and filter offices by city, country, or territory
- View employees assigned to each office

### 👥 Employee Management
- Complete employee information management
- Hierarchical reporting structure (employees can report to other employees)
- Office assignment for each employee
- Employee search and filtering capabilities
- Job title and contact information tracking

### 🔐 Administrative User Management
- Secure user authentication and authorization
- Role-based access control (USER, MANAGER, ADMIN)
- Password hashing for security
- User creation, modification, and deletion
- Last login tracking

### 🎨 Modern Web Interface
- Responsive Bootstrap-based UI
- Intuitive navigation with card-based dashboard
- Modern FontAwesome icons
- Mobile-friendly design
- Interactive forms with autocomplete functionality

## 🏗️ Architecture

### Technology Stack
- **Backend**: Spring Boot 3.4.4
- **Frontend**: Thymeleaf templates with Bootstrap 5
- **Database**: MySQL 8.0
- **Security**: Spring Security 6
- **Build Tool**: Maven
- **Java Version**: 21

### Project Structure
```
src/
├── main/
│   ├── java/com/example/Ufficio_Mngmnt/
│   │   ├── config/           # Security and configuration
│   │   ├── controller/       # Web controllers
│   │   ├── model/           # JPA entities
│   │   ├── repository/      # Data repositories
│   │   └── service/         # Business logic
│   └── resources/
│       ├── static/          # CSS, JS, images
│       ├── templates/       # Thymeleaf templates
│       └── application.properties
└── test/                    # Unit and integration tests
```

### Database Schema
The system uses three main entities:
- **Offices**: Office locations with address and territory information
- **Employees**: Employee records with hierarchical reporting structure
- **Admin Users**: System users with role-based permissions

## 🚀 Getting Started

### Prerequisites
- Java 21 or higher
- Maven 3.6+
- MySQL 8.0+
- Git

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/Ufficio_Mngmnt.git
   cd Ufficio_Mngmnt
   ```

2. **Set up MySQL Database**
   ```bash
   # Create MySQL container with Docker (recommended)
   docker run --name mysql-Ufficio_Mngmnt \
     -v ~/Documents/docker-data/mysql-Ufficio_Mngmnt:/var/lib/mysql \
     -e MYSQL_ROOT_PASSWORD=blackfriday \
     -p 3306:3306 -d mysql:8.0.41
   
   # Import the database schema
   mysql -h localhost -u root -p < database.sql
   ```

3. **Configure Application Properties**
   Update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/Ufficio_Mngmnt
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

4. **Build and Run**
   ```bash
   # Build the project
   mvn clean install
   
   # Run the application
   mvn spring-boot:run
   ```

5. **Access the Application**
   Open your browser and navigate to: `http://localhost:8080`

## 📖 Usage

### Dashboard
The main dashboard provides quick access to all system modules:
- **Offices**: Manage office locations and territories
- **Employees**: Handle employee records and reporting structures  
- **Admin Users**: Manage system users and permissions

### Key Operations

#### Office Management
- **View All Offices**: Browse all office locations with search and filter options
- **Add New Office**: Create new office locations with complete address information
- **Edit Office**: Update existing office details
- **Delete Office**: Remove office locations (with cascade considerations)

#### Employee Management
- **View All Employees**: List all employees with their office and reporting information
- **Add New Employee**: Create employee records with office assignment and reporting structure
- **Edit Employee**: Update employee information including job title and reporting relationships
- **Delete Employee**: Remove employee records from the system

#### Admin User Management
- **View All Users**: List all administrative users with their roles
- **Create User**: Add new system users with appropriate permissions
- **Edit User**: Modify user information and roles
- **Delete User**: Remove users from the system

## 🔒 Security Features

- **Authentication**: Secure login system with Spring Security
- **Password Hashing**: Encrypted password storage
- **Role-Based Access Control**: Three-tier permission system (USER, MANAGER, ADMIN)
- **Session Management**: Secure session handling
- **CSRF Protection**: Built-in protection against cross-site request forgery

## 🗄️ Database Configuration

The application uses MySQL with JPA/Hibernate for data persistence. The database schema includes:

- **offices table**: Office location information
- **employees table**: Employee records with foreign key relationships
- **admusers table**: Administrative user accounts

All table names follow snake_case convention for Hibernate compatibility.

## 🛠️ Development

### Running in Development Mode
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### Running Tests
```bash
mvn test
```

### Building for Production
```bash
mvn clean package -Pprod
```

## 📝 API Endpoints

### Web Interface Endpoints
- `GET /` - Dashboard/Home page
- `GET /login` - Login page
- `GET /offices` - Office listing
- `GET /employees` - Employee listing  
- `GET /adminusers` - Admin user listing

### CRUD Operations
Each entity supports full CRUD operations through the web interface:
- Create: `GET /{entity}/new`, `POST /{entity}`
- Read: `GET /{entity}`, `GET /{entity}/{id}`
- Update: `GET /{entity}/edit/{id}`, `POST /{entity}/{id}`
- Delete: `POST /{entity}/delete/{id}`

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🐛 Bug Reports

If you encounter any bugs or issues, please report them on the [Issues](https://github.com/your-username/Ufficio_Mngmnt/issues) page.

## 📞 Support

For support and questions, please contact:
- **Email**: your-email@example.com
- **GitHub Issues**: [Project Issues](https://github.com/your-username/Ufficio_Mngmnt/issues)

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Bootstrap team for the responsive UI components
- FontAwesome for the beautiful icons
- MySQL team for the robust database system

---

**Made with ❤️ using Spring Boot**
