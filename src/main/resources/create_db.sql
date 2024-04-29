-- create_db.sql
CREATE DATABASE profile_service;

-- Switch to the new database
\c profile_service;

-- Create the profile_creation table
CREATE TABLE profile_creation (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create the address table
CREATE TABLE address (
    id SERIAL PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    zip_code VARCHAR(10) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create the student_registration table
CREATE TABLE student_registration (
    id SERIAL PRIMARY KEY,
    student_name VARCHAR(50) NOT NULL,
    course VARCHAR(100) NOT NULL,
    registration_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    date_of_birth DATE NOT NULL,
    gender CHAR(1) NOT NULL,
    grade VARCHAR(10) NOT NULL,
    father_name VARCHAR(100) NOT NULL,
    mother_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    mobile_number VARCHAR(15) NOT NULL,
    first_language VARCHAR(50) NOT NULL,
    address_id INTEGER,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (address_id) REFERENCES address(id)
);

-- Create the teacher_registration table
CREATE TABLE teacher_registration (
    id SERIAL PRIMARY KEY,
    teacher_name VARCHAR(50) NOT NULL,
    course VARCHAR(100) NOT NULL,
    registration_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    date_of_birth DATE NOT NULL,
    email VARCHAR(255) NOT NULL,
    mobile_number VARCHAR(15) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_update TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create indexes
CREATE INDEX idx_student_registration_address_id ON student_registration(address_id);
CREATE INDEX idx_profile_creation_id ON profile_creation(id);
CREATE INDEX idx_student_registration_student_name ON student_registration(student_name);
CREATE INDEX idx_address_zip_code ON address(zip_code);
CREATE INDEX idx_profile_creation_email ON profile_creation(email);
CREATE INDEX idx_student_registration_email ON student_registration(email);
CREATE INDEX idx_profile_creation_username ON profile_creation(username);
CREATE INDEX idx_student_registration_mobile_number ON student_registration(mobile_number);