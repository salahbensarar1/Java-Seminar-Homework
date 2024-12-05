# **Java Seminar Homework**

This project is a web application developed as part of a Java seminar homework. It demonstrates the implementation of a fully functional Spring Boot application with features like authentication, RESTful APIs, form validation, database integration, and deployment preparation. The project uses GitHub as a version control system and follows collaborative development practices.

## **Features**

1. **Authentication and Authorization**
   - Users can log in with different roles (Admin, User, Visitor).
   - Menu items and access permissions vary based on the user's role.

2. **Contact Form**
   - Allows users to send messages via a form.
   - Validates form inputs on the server side.
   - Stores the submitted messages in the database.

3. **Message Viewing**
   - Displays all submitted messages in reverse chronological order.
   - Messages include the sender's name (or "Guest" for unauthenticated users) and submission time.

4. **RESTful API**
   - Provides endpoints to manage contact messages (GET, POST, PUT, DELETE).
   - API endpoints are publicly accessible for demonstration purposes.

5. **Database Integration**
   - MySQL database is used to store messages and application data.
   - Includes a `data.sql` file for easy setup.

6. **Deployment Ready**
   - Packaged as a `run.jar` file for standalone execution.
   - Configuration is included in the `application.properties` file for quick setup.

---

## **Repository Structure**
```/Java-Seminar-Homework

├── src/                      # Source code of the application

├── run.jar                   # Packaged JAR file for running the application\n

├── data.sql                  # SQL dump file for initializing the database\n

├── application.properties    # Configuration file for the application\n

├── README.md                 # Project documentation (this file)\n

└── pom.xml                   # Maven configuration file---
```

## **Getting Started**

### **Prerequisites**
- Java 17 or later
- Maven
- MySQL (e.g., XAMPP)
- Git

### **Setup Instructions**

1. **Clone the Repository**
   `````bash
   git clone https://github.com/salahbensarar1/Java-Seminar-Homework.git
   cd Java-Seminar-Homework
   
### **2. Import Database**
- Use the provided `data.sql` file to set up the MySQL database:
  1. Open **phpMyAdmin** or **MySQL Workbench**.
  2. Create a database named `exercise`.
  3. Import `data.sql`.
 
	### **3.	Run the Application**
    `java -jar run.jar`
### **4. Access the Application**
- Open a browser and navigate to:
  - [http://localhost:8080](http://localhost:8080) for the main application.
  - [http://localhost:8080/api/messages](http://localhost:8080/api/messages) for the RESTful API.

## **Collaborative Development**

### **GitHub Version Control**

1. **Project Work Method**
   - The repository reflects the project’s development stages in at least 5 steps.
   - Each commit is properly documented to show incremental progress.

2. **Contributors**
   - **Salah Bensarar**: [GitHub Profile](https://github.com/salahbensarar1)
   - **Edgar Hamilton**: [GitHub Profile](https://github.com/edgeSilver12)
   - Each commit contains the contributor’s name for identification.

## **Project Development Process**

1. **Initial Setup**
   - Configured the Spring Boot project with dependencies.
   - Set up the MySQL database connection.

2. **Authentication System**
   - Implemented login and role-based authorization.
   - Added role-specific menu items and access permissions.

3. **Contact Form**
   - Created a contact form with server-side validation.
   - Stored submitted messages in the database.

4. **RESTful API**
   - Developed RESTful endpoints to manage contact messages.
   - Tested API using cURL and Postman.

5. **Final Packaging**
   - Packaged the application as `run.jar`.
   - Included `data.sql` and `application.properties` for easy deployment.

## **API Endpoints**

- **GET /api/messages**: Retrieve all messages.
  <img width="1445" alt="curl5" src="https://github.com/user-attachments/assets/fa4df259-4fb0-48c5-9eae-f58f284728c7">
  <img width="1037" alt="Postman1" src="https://github.com/user-attachments/assets/9ede5e57-99ee-433c-832e-42c20aa395e3">

- **GET /api/messages/{id}**: Retrieve a specific message by ID.
  <img width="984" alt="curl1" src="https://github.com/user-attachments/assets/d80a1cd2-2bd5-47d1-a800-fe7f78e2f9d8">
  <img width="715" alt="postman4" src="https://github.com/user-attachments/assets/4964ede5-cc71-43e7-ae57-07b8131944c5">


- **POST /api/messages**: Create a new message.
  <img width="1049" alt="curl3" src="https://github.com/user-attachments/assets/4a262440-2ae4-4b6b-8951-a27a6926278d">
  <img width="723" alt="postam3" src="https://github.com/user-attachments/assets/6f01f6c3-056d-4633-8b0a-34da2ff8db7b">


- **PUT /api/messages/{id}**: Update an existing message.
  <img width="1441" alt="curl4" src="https://github.com/user-attachments/assets/7a0d67c6-7d73-43e9-a00a-574d41fe28ad">
  <img width="722" alt="postman2" src="https://github.com/user-attachments/assets/80b9350c-679c-493c-97b7-6c9f4c12c148">

- **DELETE /api/messages/{id}**: Delete a message.
  <img width="506" alt="Screenshot 2024-12-05 at 1 16 14" src="https://github.com/user-attachments/assets/a91ef553-d0e2-4ac2-9935-af97e0a598de">
  <img width="840" alt="postman5" src="https://github.com/user-attachments/assets/c4d52aee-1777-48db-9722-b14b60cf1526">


## **How to Contribute**

1. **Fork the Repository**
   - Click on the "Fork" button in the top-right corner of the GitHub repository page to create a copy of the repository under your GitHub account.

2. **Clone the Forked Repository**
   - Clone the repository to your local machine:
     ```bash
     git clone https://github.com/your-username/Java-Seminar-Homework.git
     cd Java-Seminar-Homework
     ```

3. **Create a New Branch**
   - Always create a new branch for your changes:
     ```bash
     git checkout -b feature-name
     ```

4. **Make Your Changes**
   - Implement the desired feature or fix.
   - Test the application to ensure your changes work as expected.

5. **Commit Your Changes**
   - Write a clear and descriptive commit message:
     ```bash
     git commit -m "Add feature-name functionality"
     ```

6. **Push Your Changes**
   - Push your branch to your forked repository:
     ```bash
     git push origin feature-name
     ```

7. **Create a Pull Request**
   - Go to the original repository on GitHub.
   - Click the "Pull Request" button and select your branch to merge into the main branch.
   - Provide a description of your changes and submit the pull request.

8. **Collaborate**
   - Discuss and address any feedback from the project maintainers during the review process.
