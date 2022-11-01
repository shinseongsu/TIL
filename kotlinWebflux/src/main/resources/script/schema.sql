DROP TABLE IF EXISTS book;
CREATE TABLE book
(
    id  bigint NOT NULL AUTO_INCREMENT,
    name varchar(50),
    price int,
    primary key (id)
);