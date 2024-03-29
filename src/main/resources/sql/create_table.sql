USE mailsystem;

CREATE TABLE mst_user (
 id int(11) PRIMARY KEY AUTO_INCREMENT,
 user_name VARCHAR(32) NOT NULL UNIQUE,
 client_id VARCHAR(255) NOT NULL,
 password VARCHAR(16) NOT NULL,
 signature VARCHAR(255),
 created_at TIMESTAMP NOT NULL DEFAULT current_timestamp(),
 updated_at TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
);

CREATE TABLE mst_address (
 id int(11) PRIMARY KEY AUTO_INCREMENT,
 user_id int(11) NOT NUll,
 company_name VARCHAR(128) NOT NULL,
 company_address VARCHAR(255),
 corporation TINYINT DEFAULT 0,
 company_number VARCHAR(16),
 staff_name1 VARCHAR(16) NOT NULL,
 staff_mail1 VARCHAR(255) NOT NULL,
 staff_number1 VARCHAR(16),
 staff_name2 VARCHAR(16),
 staff_mail2 VARCHAR(32),
 staff_number2 VARCHAR(16),
 staff_name3 VARCHAR(16),
 staff_mail3 VARCHAR(32),
 staff_number3 VARCHAR(16),
 staff_name4 VARCHAR(16),
 staff_mail4 VARCHAR(32),
 staff_number4 VARCHAR(16),
 staff_name5 VARCHAR(16),
 staff_mail5 VARCHAR(32),
 staff_number5 VARCHAR(16),
 staff_name6 VARCHAR(16),
 staff_mail6 VARCHAR(32),
 staff_number6 VARCHAR(16),
 staff_name7 VARCHAR(16),
 staff_mail7 VARCHAR(32),
 staff_number7 VARCHAR(16),
 staff_name8 VARCHAR(16),
 staff_mail8 VARCHAR(32),
 staff_number8 VARCHAR(16),
 staff_name9 VARCHAR(16),
 staff_mail9 VARCHAR(32),
 staff_number9 VARCHAR(16),
 staff_name10 VARCHAR(16),
 staff_mail10 VARCHAR(32),
 staff_number10 VARCHAR(16),
 created_at TIMESTAMP NOT NULL DEFAULT current_timestamp(),
 updated_at TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
);

CREATE TABLE select_address (
 id int(11) PRIMARY KEY AUTO_INCREMENT,
 company_name VARCHAR(32) NOT NULL,
 corporation TINYINT NOT NULL,
 user_id int(11) NOT NULL,
 staff_name VARCHAR(16) ,
 staff_mail VARCHAR(32) NOT NULL
);

CREATE TABLE mail_history (
 id int(11) PRIMARY KEY AUTO_INCREMENT,
 user_id int(11) NOT NUll,
 subject VARCHAR(255), 
 to_staff VARCHAR(16),
 to_company VARCHAR(32), 
 created_at TIMESTAMP NOT NULL DEFAULT current_timestamp(),
 updated_at TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
);
 
CREATE TABLE create_mail (
 user_id int(11) NOT NUll,
 subject VARCHAR(255) NOT NUll,
 text VARCHAR(255) NOT NUll
);