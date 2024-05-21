CREATE TABLE Teachers (
    teacher_id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100)
);

CREATE TABLE Students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE Courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100),
    teacher_id INT,
    FOREIGN KEY (teacher_id) REFERENCES Teachers(teacher_id)
);

CREATE TABLE CourseRegistrations (
    registration_id INT PRIMARY KEY,
    student_id INT,
    course_id INT,
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);

CREATE TABLE grades (
    grade_id INT PRIMARY KEY,
    registration_id INT,
    grade DECIMAL,
    FOREIGN KEY (registration_id) REFERENCES CourseRegistrations(registration_id)
);