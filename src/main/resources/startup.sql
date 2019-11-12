CREATE DATABASE IF NOT EXISTS `web_bookmark_tracker`;
USE `web_bookmark_tracker`;

# -----------------------------book--------------------------
CREATE TABLE IF NOT EXISTS `Author` (
  `Author_ID`   INT(11) NOT NULL AUTO_INCREMENT,
  `Author_name` VARCHAR(255)     DEFAULT NULL,
  PRIMARY KEY (`Author_ID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE IF NOT EXISTS `Book` (
  `Book_ID`            INT(11) NOT NULL AUTO_INCREMENT,
  `Book_title`         VARCHAR(255)     DEFAULT NULL,
  `Book_description`   TEXT             DEFAULT NULL,
  `Book_publish_year`  VARCHAR(255)     DEFAULT NULL,
  `Book_amazon_rating` FLOAT(2, 1)      DEFAULT NULL,
  `Book_CT`            TIMESTAMP        DEFAULT CURRENT_TIMESTAMP,
  `Book_genre`         VARCHAR(255)     DEFAULT NULL,
  `Book_typeId`        INT(1)           DEFAULT 0,
  `Book_image_url`     VARCHAR(255)     DEFAULT NULL,
  PRIMARY KEY (`Book_ID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE IF NOT EXISTS `Publisher` (
  `Publisher_ID`   INT(11)      NOT NULL AUTO_INCREMENT,
  `Publisher_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Publisher_ID`, `Publisher_name`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE `Book_publisher` (
  Book_publisher_book_id      INT(11) NOT NULL,
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
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE Book_author (
  Book_author_book_id   INT(11) NOT NULL,
  Book_author_author_id INT(11) NOT NULL,
  PRIMARY KEY (`Book_author_book_id`, `Book_author_author_id`),
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
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

# -----------------------------movie--------------------------
CREATE TABLE IF NOT EXISTS `Movie` (
  `Movie_ID`           INT(11) NOT NULL AUTO_INCREMENT,
  `Movie_title`        VARCHAR(255)     DEFAULT NULL,
  `Movie_description`  TEXT             DEFAULT NULL,
  `Movie_release_year` VARCHAR(255)     DEFAULT NULL,
  `Movie_imdb_rating`  FLOAT(2, 1)      DEFAULT NULL,
  `Movie_CT`           TIMESTAMP        DEFAULT CURRENT_TIMESTAMP,
  `Movie_genre`        VARCHAR(255)     DEFAULT NULL,
  `Movie_typeId`       INT(1)           DEFAULT 1,

  PRIMARY KEY (`Movie_ID`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

CREATE TABLE IF NOT EXISTS `Actor` (
  `Actor_ID`   INT(11)      NOT NULL AUTO_INCREMENT,
  `Actor_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Actor_ID`, `Actor_name`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE `Movie_actor` (
  Movie_actor_movie_id INT(11) NOT NULL,
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
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;

CREATE TABLE IF NOT EXISTS `Director` (
  `Director_ID`   INT(11)      NOT NULL AUTO_INCREMENT,
  `Director_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Director_ID`, `Director_name`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;


CREATE TABLE `Movie_director` (
  Movie_director_movie_id    INT(11) NOT NULL,
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
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = latin1;





























