DROP TABLE USERS;
CREATE TABLE IF NOT EXISTS USERS(
seq bigint NOT NULL AUTO_INCREMENT,
name varchar(10) NOT NULL,
email varchar(50) NOT NULL,
password varchar(80) NOT NULL,
profile_image_url varchar(255) DEFAULT NULL,
login_count int NOT NULL DEFAULT 0,
last_login_at datetime DEFAULT NULL,
create_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP(),
PRIMARY KEY (seq),
CONSTRAINT unq_user_email UNIQUE (email)
);