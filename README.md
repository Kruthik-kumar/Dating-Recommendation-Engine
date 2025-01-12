# Dating Recommendation Engine

## Description

A dating recommendation engine built using Spring Boot that matches users based on gender, age, and interests.
Screenshot (https://drive.google.com/drive/folders/1P673qYJeul-J34Mgu8RCPJjsuJ5ocypT?usp=sharing)

## How to Run

1. Clone the repository
2. Navigate to the project directory
3. Run the application using Maven or your IDE
   ```bash
   mvn spring-boot:run

API Endpoints
  POST /api/users/recommend
    Request Body:
    json
          {
            "name": "User  2",
            "gender": "Male",
            "age": 27,
            "interests": ["Cricket", "Football", "Movies"]
          }
