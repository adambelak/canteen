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
	('lekvár'),
	('túró');
	
INSERT INTO side_dishes (name) VALUES
	('rizibizi'),
	('saláta'),
	('krumplipüré'),
	('pennetészta'),
	('zöldborsófőzelék');
	
INSERT INTO foods (name, description) VALUES
	('Bábolnai fokhagymás csirkemell', 'A csirkemellet felszeleteljük, sózzuk és lisztbe forgatjuk. Olajjal kikent tepsibe tesszük és alufóliával letakarva 180 fokon sütjük. 2 ek olajon megfuttatjuk a zúzott fokhagymát, adunk hozzá 3 ek lisztet, majd a rántást felengedjük fél l levessel, utána hozzáadjuk a tejfölt, sót és borsot. Ha a csirkemell megpuhult, leöntjük a felengedett rántással és még 10-20 percig sütjük fólia nélkül.'),
	('Almás-sajtos rakott csirkemell', 'A csirkemellfiléből vágj több vékony, lapos szeletet, majd legalább egy óráig áztasd meg a fokhagymával ízesített tejben. Egy kisebb tepsit bélelj ki szalonnaszeletekkel (néhány szeletet tegyél félre belőle a tetejére), majd tedd rá a tejből kivett, lecsöpögtetett, majd lisztben megforgatott csirkemelleket. Reszelj rá almát, fedd be füstölt sajttal. Kend meg 1-2 evőkanál tejföllel, és takard le a maradék szalonnával. Előmelegített sütőben kb. 30 perc alatt süsd készre.'),
	('Bakonyi csirkeragu', 'A húst mosd meg, és vágd kisujjnyi vastag csíkokra. Az apróra vágott vöröshagymát pirítsd üvegesre az olajon, majd add hozzá a csirkecsíkokat. Ha a hús már kissé megfehéredett, tedd bele a megtisztított és vékony szeletekre vágott gombát is. Sózd, borsozd, adj hozzá finomra vágott petrezselymet és őrölt paprikát, és pirítsd addig, amíg a gomba leve el nem elpárolog.');