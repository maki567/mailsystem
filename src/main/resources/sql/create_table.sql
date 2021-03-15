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
 staff_mail1 VARCHAR(32) NOT NULL,
 staff_number1 VARCHAR(16),
 staff_name2 VARCHAR(16) NOT NULL,
 staff_mail2 VARCHAR(32) NOT NULL,
 staff_number2 VARCHAR(16),
 staff_name3 VARCHAR(16) NOT NULL,
 staff_mail3 VARCHAR(32) NOT NULL,
 staff_number3 VARCHAR(16),
 staff_name4 VARCHAR(16) NOT NULL,
 staff_mail4 VARCHAR(32) NOT NULL,
 staff_number4 VARCHAR(16),
 staff_name5 VARCHAR(16) NOT NULL,
 staff_mail5 VARCHAR(32) NOT NULL,
 staff_number5 VARCHAR(16),
 staff_name6 VARCHAR(16) NOT NULL,
 staff_mail6 VARCHAR(32) NOT NULL,
 staff_number6 VARCHAR(16),
 staff_name7 VARCHAR(16) NOT NULL,
 staff_mail7 VARCHAR(32) NOT NULL,
 staff_number7 VARCHAR(16),
 staff_name8 VARCHAR(16) NOT NULL,
 staff_mail8 VARCHAR(32) NOT NULL,
 staff_number8 VARCHAR(16),
 staff_name9 VARCHAR(16) NOT NULL,
 staff_mail9 VARCHAR(32) NOT NULL,
 staff_number9 VARCHAR(16),
 staff_name10 VARCHAR(16) NOT NULL,
 staff_mail10 VARCHAR(32) NOT NULL,
 staff_number10 VARCHAR(16),
 created_at TIMESTAMP NOT NULL DEFAULT current_timestamp(),
 updated_at TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
);