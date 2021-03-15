USE mailsystem;

CREATE TABLE mst_user (
 id int(11) PRIMARY KEY AUTO_INCREMENT,
 user_name VARCHAR(32) NOT NULL UNIQUE,
 password VARCHAR(16) NOT NULL,
 created_at TIMESTAMP NOT NULL DEFAULT current_timestamp(),
 updated_at TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
);

CREATE TABLE mst_address (
 id int(11) PRIMARY KEY AUTO_INCREMENT,
 company_name VARCHAR(32) NOT NULL UNIQUE,
 company_address VARCHAR(255),
 corporation TINYINT DEFAULT 0,
 company_number VARCHAR(16),
 staff_name1 VARCHAR(16) NOT NULL,
 staff_name2 VARCHAR(16) NOT NULL,
 staff_mail1 VARCHAR(32) NOT NULL,
 staff_mail2 VARCHAR(32) NOT NULL,
 staff_number1 VARCHAR(16),
 staff_number2 VARCHAR(16),
 created_at TIMESTAMP NOT NULL DEFAULT current_timestamp(),
 updated_at TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
);