drop table if exists notes;
create table notes (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    content VARCHAR(500) NOT NULL,
    create_time Timestamp
);