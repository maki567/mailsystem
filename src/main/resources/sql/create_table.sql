USE mailsystem1;

CREATE TABLE mst_user (
 id int(11) PRIMARY KEY AUTO_INCREMENT,
 user_name VARCHAR(32) NOT NULL UNIQUE,
 password VARCHAR(16) NOT NULL,
 family_name VARCHAR(255) NOT NULL,
 first_name VARCHAR(255) NOT NULL,
 family_name_kana VARCHAR(255) NOT NULL,
 first_name_kana VARCHAR(255) NOT NULL,
 gender TINYINT DEFAULT 0,
 created_at TIMESTAMP NOT NULL DEFAULT current_timestamp(),
 updated_at TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
);

create table mail_history (
 subject VARCHAR(255),
 created_at TIMESTAMP NOT NULL DEFAULT current_timestamp()
);