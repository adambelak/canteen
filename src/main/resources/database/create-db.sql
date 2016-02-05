CREATE  TABLE users (
  username VARCHAR(45) NOT NULL,
  password VARCHAR(100) NOT NULL,
  enabled BOOLEAN DEFAULT TRUE NOT NULL,
  PRIMARY KEY (username)
);

CREATE TABLE user_roles (
  user_role_id INTEGER NOT NULL GENERATED BY DEFAULT AS IDENTITY,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  CONSTRAINT uniq_username_role UNIQUE (role,username),
  FOREIGN KEY (username) REFERENCES users(username)
);

CREATE TABLE flavours (
	id INTEGER NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	name VARCHAR(100) NOT NULL,
	PRIMARY KEY (id),
  CONSTRAINT uniq_flavours_name UNIQUE (name)
);

CREATE TABLE side_dishes (
	id INTEGER NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	name VARCHAR(100) NOT NULL,
	PRIMARY KEY (id),
  CONSTRAINT uniq_side_dishes_name UNIQUE (name)
);

CREATE TABLE foods (
	id INTEGER NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	name VARCHAR(200) NOT NULL,
	description VARCHAR(500),
	PRIMARY KEY (id)
);

CREATE TABLE food_pictures (
	food_id INTEGER NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	picture BLOB NOT NULL,
	PRIMARY KEY (food_id)
);
