INSERT INTO app_user(user_login, password, name, surname, email, registration_date) VALUES ('vgerton', '123', 'Mikalai', 'Kisel', 'kisel.nikolay@gmail.com', '2013-07-19');
INSERT INTO app_user(user_login, password, name, surname, email, registration_date) VALUES ('dim-tim', '111', 'Dzmitry', 'Kislo', 'dim-tim@gmail@gmail.com', '2013-07-29');
INSERT INTO app_user(user_login, password, name, surname, email, registration_date) VALUES ('ivanov', 'qwerty', 'Ivan', 'Ivanov', 'ivan.ivanov@yandex.ru', '2013-07-25');

INSERT INTO role VALUES (null, 'менеджер', 'имеет максимальные права');
INSERT INTO role VALUES (null, 'пользователь', 'может оставлять рецепты');
INSERT INTO role VALUES (null, 'поставщик', 'может осуществлять доставки продуктов');

INSERT INTO section VALUES(null, 'Салаты', 'Легкая закуска');
INSERT INTO section VALUES(null, 'Супы', '');
INSERT INTO section VALUES(null, 'Напитки', '');

INSERT INTO recipe VALUES (null, 'фото1', 'D:/1.jpeg', 'Блюдо1', true, 4, 1, 1, 1);
INSERT INTO recipe VALUES (null, 'фото2', 'D:/2.jpeg', 'Блюдо1', true, 7, 3, 2, 1);
INSERT INTO recipe VALUES (null, 'фото3', 'D:/3.jpeg', 'Блюдо1', true, 1, 9, 3, 2);

INSERT INTO ingredient VALUES(null, 'Картофель', '', '100 грамм', 1);
INSERT INTO ingredient VALUES(null, 'Морковь', '', '3 шт', 1);
INSERT INTO ingredient VALUES(null, 'Масло', '', '1 уп', 2);
INSERT INTO ingredient VALUES(null, 'Масло', '', '2 уп', 3);

INSERT INTO provider VALUES (null, 'Ресторан у дома', 'Доставка по Бресту', 'Работают проф повара', true, '2013-07-19', 14, 5, 1);
INSERT INTO provider VALUES (null, 'Националь', 'Доставка по Бресту', 'Работают проф повара', true, '2013-07-20', 21, 2, 1);
INSERT INTO provider VALUES (null, 'Ресторан Дружба', 'Доставка по Минску', 'Работают проф повара', true, '2013-07-21', 21, 5, 1);

INSERT INTO delivery VALUES(null, 20000000, true, 200000000, 1);
INSERT INTO delivery VALUES(null, 2000, false, 200, 2);
INSERT INTO delivery VALUES(null, 3000, false, 300, 3);
INSERT INTO delivery VALUES(null, 3000, false, 30, 3);

INSERT INTO app_comment VALUES (null, 'Это первое сообщение', '2013-07-19 05:25:00', 3, 1, 1, 1);
INSERT INTO app_comment VALUES (null, 'Второе сообщение', '2013-07-19 05:25:00', 5, 1, 1, 2);
INSERT INTO app_comment VALUES (null, 'Третье сообщение', '2013-07-19 05:25:00', 5, 3, 1, 3);
INSERT INTO app_comment VALUES (null, 'Четвертое сообщение', '2013-07-23 05:25:00', 5, 9, 1, 1);

INSERT INTO user_order VALUES (null, '2013-07-19 05:25:00', 1, 1);
INSERT INTO user_order VALUES (null, '2013-07-29 05:25:00', 4, 2);
INSERT INTO user_order VALUES (null, '2013-07-29 05:25:00', 3, 3);
INSERT INTO user_order VALUES (null, '2013-07-29 05:25:00', 2, 2);
INSERT INTO user_order VALUES (null, '2013-07-30 05:25:00', 1, 1);

INSERT INTO app_user_has_role VALUES (1, 1);
INSERT INTO app_user_has_role VALUES (1, 2);
INSERT INTO app_user_has_role VALUES (2, 2);
INSERT INTO app_user_has_role VALUES (3, 3);

INSERT INTO delivery_has_recipe values (1, 1);
INSERT INTO delivery_has_recipe values (2, 3);
INSERT INTO delivery_has_recipe values (3, 2);

