CREATE DATABASE  IF NOT EXISTS `web_bookmark_tracker` ;
USE `web_bookmark_tracker`;

create table if not exists `Author`(
  `Author_ID` int(11) not null auto_increment,
  `Author_name` varchar(255) default null,
  primary key(`Author_ID`)
) Engine = InnoDB
  auto_increment=1
  Default charset = latin1;


create table IF NOT EXISTS `Book`(
  `Book_ID` int(11) not null auto_increment,
  `Book_title` VARCHAR(255) DEFAULT NULL,
  `Book_description` VARCHAR(255) DEFAULT NULL,
  `Book_publish_year` DATE DEFAULT NULL,
  `Book_amazon_rating` float(2,1),
  `Book_CT` DATETIME default current_timestamp(),
  `Book_genre` VARCHAR(255) DEFAULT null,
  PRIMARY KEY (`Book_ID`)
)Engine = InnoDB
  auto_increment=1
  Default charset = latin1;


create table if not exists `Publisher`(
  `Publisher_ID` int(11) not null auto_increment,
  `Publisher_name` varchar(255) not null,
  primary key(`Publisher_ID`,`Publisher_name`)
) Engine = InnoDB
  auto_increment=1
  Default charset = latin1;


create table `Book_publisher`(
  Book_publisher_book_id INT(11) NOT NULL ,
  Book_publisher_publisher_id INT(11) NOT NULL,
  PRIMARY KEY (`Book_publisher_book_id`, `Book_publisher_publisher_id`),
  KEY `FK_PUBLISHER_IDX`(`Book_publisher_publisher_id`),
  CONSTRAINT `FK_PUBLISHER` FOREIGN KEY (`Book_publisher_publisher_id`)
  REFERENCES `publisher` (`Publisher_ID`)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
  KEY `FK_BOOK_IDX`(`Book_publisher_book_id`),
  CONSTRAINT `FK_BOOK_2` FOREIGN KEY (`Book_publisher_book_id`)
  REFERENCES `Book` (`Book_ID`)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
)Engine = InnoDB
  auto_increment=1
  Default charset = latin1;


CREATE TABLE Book_author (
  Book_author_book_id INT(11) NOT NULL ,
  Book_author_author_id INT(11) NOT NULL ,
  PRIMARY KEY (`Book_author_book_id`,`Book_author_author_id`),
  KEY `FK_AUTHOR_IDX`(`Book_author_author_id`),
  CONSTRAINT `FK_AUTHOR` FOREIGN KEY (`Book_author_author_id`)
  REFERENCES `Author` (`Author_ID`)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
  KEY `FK_BOOK_IDX`(`Book_author_book_id`),
  CONSTRAINT `FK_BOOK` FOREIGN KEY (`Book_author_book_id`)
  REFERENCES `Book` (`Book_ID`)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
)Engine = InnoDB
  auto_increment=1
  Default charset = latin1;