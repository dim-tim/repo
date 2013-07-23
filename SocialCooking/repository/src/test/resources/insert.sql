INSERT INTO section VALUES(null, 'Салаты', 'Легкая закуска');
INSERT INTO section VALUES(null, 'Супы', '');
INSERT INTO section VALUES(null, 'Напитки', '');

INSERT INTO app_comment VALUES(null, 'Это первое сообщение', '2013-07-19 05:25:00', 3, 1);
INSERT INTO app_comment VALUES(null, 'Второе сообщение', '2013-07-19 05:25:00', 5, 1);
INSERT INTO app_comment VALUES(null, 'Третье сообщение', '2013-07-19 05:25:00', 5, 3);
INSERT INTO app_comment VALUES(null, 'Четвертое сообщение', '2013-07-23 05:25:00', 5, 9);

INSERT INTO delivery VALUES(null, 20000000, true, 200000000);
INSERT INTO delivery VALUES(null, 2000, false, 200);
INSERT INTO delivery VALUES(null, 3000, false, 300);

INSERT INTO ingredient VALUES(null, 'Картофель', '', '100 грамм');
INSERT INTO ingredient VALUES(null, 'Морковь', '', '3 шт');
INSERT INTO ingredient VALUES(null, 'Масло', '', '1 уп');

INSERT INTO provider VALUES (null, 'Ресторан у дома', 'Доставка по Бресту', 'Работают проф повара', true, '2013-07-19', 14, 5);
INSERT INTO provider VALUES (null, 'Националь', 'Доставка по Бресту', 'Работают проф повара', true, '2013-07-20', 21, 2);
INSERT INTO provider VALUES (null, 'Ресторан Дружба', 'Доставка по Минску', 'Работают проф повара', true, '2013-07-21', 21, 5);

INSERT INTO recipe VALUES (null, 'фото1', 'D:/1.jpeg', 'Блюдо1', true, 4, 1);
INSERT INTO recipe VALUES (null, 'фото2', 'D:/2.jpeg', 'Блюдо2', true, 9, 1);
INSERT INTO recipe VALUES (null, 'фото3', 'D:/3.jpeg', 'Блюдо3', true, 4, 7);

INSERT INTO role VALUES (null, 'менеджер', 'имеет максимальные права');

INSERT INTO app_order VALUES (null, '2013-07-19 05:25:00');