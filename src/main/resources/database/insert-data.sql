INSERT INTO users(username,password,enabled) VALUES 
	('admin','$2a$10$TU7VfPs2iHvX290Y5FDw8egjm9frzrOugyUg/Y7nVFDuCocL3Zsk.', true), 
	('user','$2a$10$KpzG9DyQxnJiQXbpduPR8OSOaJOBkT2vuIAmlH3h5dPLN9IAF8Lg.', true),
	('user2','$2a$10$i3oTSiHnUoun0pZzGAm9RORvFjqSTd1IExURZtc9VVzE0OWb5kfl6', true);

INSERT INTO user_roles (username, role) VALUES 
	('admin', 'ADMIN'), 
	('user', 'USER'),
	('user2', 'USER');

INSERT INTO flavours (name) VALUES
	('nutella'),
	('jam'),
	('cottage cheese');