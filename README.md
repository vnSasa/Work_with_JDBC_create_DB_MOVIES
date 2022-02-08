# Work_with_JDBC_create_DB_MOVIES

## The project is an example of working with a database.

We are creating a database of movies.

Implement menus to add movies, edit database, view and delete movies.

## create DB in MySQL: 

CREATE SCHEMA `movies` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `movies`.`new_table` (

`id` INT NOT NULL AUTO_INCREMENT,

`movie_name` VARCHAR(45) NOT NULL,

`movie_genre` VARCHAR(45) NOT NULL,

`movie_genre_alternative` VARCHAR(45) NOT NULL,

`year_release` INT NOT NULL,

PRIMARY KEY (`id`));
