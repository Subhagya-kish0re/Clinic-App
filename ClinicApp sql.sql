create database clinic;
use clinic;

-- CREATE TABLE visitors (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     name VARCHAR(255) NOT NULL,
--     phoneNumber VARCHAR(20),
--     appointmentDate DATE,
--     age INT
-- );
-- INSERT INTO visitors (name, phoneNumber, appointmentDate, age)
-- VALUES ('Rahul', '8976342361', '2023-09-10', 25);
CREATE TABLE patient (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    age INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(20)
);
INSERT INTO patient (age, name, phoneNumber)
VALUES (25, 'Rahul', '9089371287');
select * from patient;
delete from patient where id=3;


-- select * from visitors;

CREATE TABLE doctor (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);
INSERT INTO doctor (name) VALUES
    ('Dr. Ajay Kumar'),
    ('Dr. Sudhansu Sharma');
    select * from doctor;
    
  CREATE TABLE appointment (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    doctor_id BIGINT NOT NULL,
    patient_id BIGINT NOT NULL,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    FOREIGN KEY (doctor_id) REFERENCES doctor(id),
    FOREIGN KEY (patient_id) REFERENCES patient(id)
);

drop table appointment;
select * from appointment;
INSERT INTO appointment (doctor_id, patient_id, appointment_date_time)
VALUES (1, 2, '2023-09-15 14:30:00');

CREATE TABLE user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);
select * from user;

INSERT INTO user (username, password, role) VALUES
('Subhagya', 'password@123', 'ROLE_ADMIN'),
('Rahul', 'user123', 'ROLE_USER');

INSERT INTO user (username, password, role) VALUES
('Subh', '1234', 'ADMIN');
SELECT a FROM Appointment a JOIN Doctor d ON a.doctor.id = d.id WHERE d.name = "Dr. Ajay Kumar";
SELECT a.*
FROM appointment a
JOIN doctor d ON a.doctor_id = d.id
WHERE d.name = 'Dr. Sudhansu Sharma';
ALTER TABLE appointment ADD COLUMN status VARCHAR(10) DEFAULT 'PENDING' NOT NULL;
update appointment set status ='PENDING' where id =2;






