CREATE DATABASE  IF NOT EXISTS `web_bookmark_tracker` ;
USE `web_bookmark_tracker`;

# -----------------------------book--------------------------
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
  `Book_description` TEXT DEFAULT NULL,
  `Book_publish_year` varchar(255) DEFAULT NULL,
  `Book_amazon_rating`  FLOAT(2,1) DEFAULT NULL,
  `Book_CT` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
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

# -----------------------------movie--------------------------
create table IF NOT EXISTS `Movie`(
  `Movie_ID` int(11) not null auto_increment,
  `Movie_title` VARCHAR(255) DEFAULT NULL,
  `Movie_description` VARCHAR(255) DEFAULT NULL,
  `Movie_release_year` varchar(255) DEFAULT NULL,
  `Movie_imdb_rating` VARCHAR(4) DEFAULT null,
  `Movie_CT` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `Movie_genre` VARCHAR(255) DEFAULT null,
  PRIMARY KEY (`Movie_ID`)
)Engine = InnoDB
  auto_increment=1
  Default charset = latin1;

create table if not exists `Actor`(
  `Actor_ID` int(11) not null auto_increment,
  `Actor_name` varchar(255) not null,
  primary key(`Actor_ID`,`Actor_name`)
) Engine = InnoDB
  auto_increment=1
  Default charset = latin1;


create table `Movie_actor`(
  Movie_actor_movie_id INT(11) NOT NULL ,
  Movie_actor_actor_id INT(11) NOT NULL,
  PRIMARY KEY (`Movie_actor_movie_id`, `Movie_actor_actor_id`),
  KEY `FK_Actor_IDX`(`Movie_actor_actor_id`),
  CONSTRAINT `FK_Actor` FOREIGN KEY (`Movie_actor_actor_id`)
  REFERENCES `Actor` (`Actor_ID`)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
  KEY `FK_Movie_IDX`(`Movie_actor_movie_id`),
  CONSTRAINT `FK_Movie` FOREIGN KEY (`Movie_actor_movie_id`)
  REFERENCES `Movie` (`Movie_ID`)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
)Engine = InnoDB
  auto_increment=1
  Default charset = latin1;

create table if not exists `Director`(
  `Director_ID` int(11) not null auto_increment,
  `Director_name` varchar(255) not null,
  primary key(`Director_ID`,`Director_name`)
) Engine = InnoDB
  auto_increment=1
  Default charset = latin1;


create table `Movie_director`(
  Movie_director_movie_id INT(11) NOT NULL ,
  Movie_director_director_id INT(11) NOT NULL,
  PRIMARY KEY (`Movie_director_movie_id`, `Movie_director_director_id`),
  KEY `FK_director_IDX`(`Movie_director_director_id`),
  CONSTRAINT `FK_director` FOREIGN KEY (`Movie_director_director_id`)
  REFERENCES `director` (`Director_ID`)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
  KEY `FK_Movie_IDX`(`Movie_director_movie_id`),
  CONSTRAINT `FK_Movie_2` FOREIGN KEY (`Movie_director_movie_id`)
  REFERENCES `Movie` (`Movie_ID`)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
)Engine = InnoDB
  auto_increment=1
  Default charset = latin1;





























