INSERT INTO app_user(user_login, password, name, surname, email, registration_date) VALUES ('vgerton', '123', 'Mikalai', 'Kisel', 'kisel.nikolay@gmail.com', '2013-07-19');

INSERT INTO role VALUES (null, 'менеджер', 'имеет максимальные права');

INSERT INTO app_user_has_role VALUES (1, 1);