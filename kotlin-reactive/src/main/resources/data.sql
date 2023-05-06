DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL
);

INSERT INTO users (first_name, last_name, email)
VALUES
       ('Jogn01', 'Smith01', 'test01@test.com'),
       ('Jogn02', 'Smith02', 'test02@test.com'),
       ('Jogn03', 'Smith03', 'test03@test.com'),
       ('Jogn04', 'Smith04', 'test04@test.com'),
       ('Jogn05', 'Smith05', 'test05@test.com'),
       ('Jogn06', 'Smith06', 'test06@test.com'),
       ('Jogn07', 'Smith07', 'test07@test.com'),
       ('Jogn08', 'Smith08', 'test08@test.com'),
       ('Jogn09', 'Smith09', 'test09@test.com');