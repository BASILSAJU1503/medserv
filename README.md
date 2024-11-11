To manage different types of users (doctors, admins, and patients) for a clinic, here’s a suggested table structure that includes necessary fields. This structure uses user_id as the primary key, and it has a user_type field to distinguish between different user roles.
Suggested Table: users
Column Name
Data Type
Constraints
Description
user_id
INT
PRIMARY KEY, AUTO_INCREMENT
Unique identifier for each user.
username
VARCHAR(50)
NOT NULL, UNIQUE
Username chosen by the user.
password
VARCHAR(255)
NOT NULL
Encrypted password for security.
user_type
ENUM('doctor', 'admin', 'patient')
NOT NULL
Identifies the role of the user.
first_name
VARCHAR(50)
NOT NULL
User's first name.
last_name
VARCHAR(50)
NULL
User's last name.
email
VARCHAR(100)
NOT NULL, UNIQUE
User's email address.
mobile_number
VARCHAR(15)
NOT NULL
User's contact number.
age
INT
NULL
Age of the user.
gender
ENUM('male', 'female', 'other')
NULL
Gender of the user.
address
TEXT
NULL
User's address details.
date_of_birth
DATE
NULL
User's date of birth.
created_at
TIMESTAMP
DEFAULT CURRENT_TIMESTAMP
Date and time the user was created.
updated_at
TIMESTAMP
DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
Last update timestamp for the user.
status
ENUM('active', 'inactive')
NOT NULL
Indicates if the user is active.


Explanation of Fields:
user_id: Primary key, unique identifier for each user.
username & password: Credentials for user login; password should ideally be encrypted.
user_type: Enum field to specify if the user is a doctor, admin, or patient.
first_name & last_name: Basic identification details for the user.
email & mobile_number: Contact details, with email set as unique for each user.
age, gender, date_of_birth: Personal details that might be needed for patient records.
address: Store the user’s residential information.
created_at & updated_at: Timestamps to track when the user was created and last updated.
status: Useful to handle users who are no longer active but might be retained in the system for records.
Additional Suggestions:
Specialization: For doctors, an optional field to store their area of specialization.
Emergency Contact: Could be useful, especially for patients.
Medical History: Link a separate table to store a patient's medical history if needed.
Permissions/Roles: To expand flexibility for admin roles, add a roles or permissions table.
This table structure should give a well-rounded approach to managing different user types within a clinic database system.


CREATE TABLE t_userdetail (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    user_type ENUM('doctor', 'admin', 'patient') NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    email VARCHAR(100) NOT NULL UNIQUE,
    mobile_number VARCHAR(15) NOT NULL,
    age INT,
    gender ENUM('male', 'female', 'other'),
    address TEXT,
    date_of_birth DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    status ENUM('active', 'inactive') NOT NULL
);
POST API : user/signup


{
    "first_name": "John",
    "last_name": "Doe",
    "username": "johndoe123",
    "password": "securePassword123",
    "user_type": "doctor",
    "email": "johndoe@example.com",
    "mobile_number": "1234567890",
    "age": "35",
    "gender": "male",
    "address": "123 Main St, Cityville",
    "date_of_birth": "1988-05-20T00:00:00",
    "status": "1"
}


