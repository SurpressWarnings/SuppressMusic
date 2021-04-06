CREATE DATABASE IF NOT EXISTS surpress_music;

CREATE TABLE IF NOT EXISTS albums (
  album_id int NOT NULL AUTO_INCREMENT,
  album varchar(255) DEFAULT NOT NULL,
  genre varchar(255) DEFAULT NOT NULL,
  PRIMARY KEY (album_id)
);

 CREATE TABLE IF NOT EXISTS songs (
  song_id int NOT NULL AUTO_INCREMENT,
  artist varchar(255) DEFAULT NOT NULL,
  format varchar(255) DEFAULT NULL,
  genre varchar(255) DEFAULT NULL,
  price float DEFAULT NOT NULL,
  song varchar(255) DEFAULT NOT NULL,
  album_id int DEFAULT NULL,
  PRIMARY KEY (song_id),
  FOREIGN KEY(album_id) REFERENCES albums(album_id)
);

CREATE TABLE IF NOT EXISTS genres (
  genre_id int NOT NULL AUTO_INCREMENT,
  genre int DEFAULT NOT NULL,
  PRIMARY KEY (genre_id)
);

CREATE TABLE IF NOT EXISTS users (
  user_id int NOT NULL AUTO_INCREMENT,
  cc_number varchar(255) DEFAULT NULL,
  first_name varchar(255) DEFAULT NOT NULL,
  last_name varchar(255) DEFAULT NOT NULL,
  password varchar(255) DEFAULT NOT NULL,
  user_name varchar(255) DEFAULT NOT NULL,
  PRIMARY KEY (user_id)
);

CREATE TABLE  IF NOT EXISTS roles (
  role_id int NOT NULL AUTO_INCREMENT,
  role varchar(255) DEFAULT NOT NULL,
  PRIMARY KEY (role_id)
)

CREATE TABLE IF NOT EXISTS user_role (
  user_id int NOT NULL,
  role_id int NOT NULL,
  PRIMARY KEY (user_id),
  FOREIGN KEY (role_id)
);