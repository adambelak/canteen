INSERT INTO users(username,password,enabled)
VALUES ('admin','admin', true), ('user','user', true);

INSERT INTO user_roles (username, role)
VALUES ('admin', 'ADMIN'), ('user', 'USER');