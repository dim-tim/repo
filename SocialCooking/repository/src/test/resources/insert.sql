INSERT INTO section VALUES('Салаты', 'Легкая закуска');
INSERT INTO section VALUES('Супы', '');
INSERT INTO section VALUES('Напитки', '');

INSERT INTO app_comment VALUES(null, 'Это первое сообщение', '2013-07-19 05:25:00', 3, 1);
INSERT INTO app_comment VALUES(null, 'Второе сообщение', '2013-07-19 05:25:00', 5, 1);
INSERT INTO app_comment VALUES(null, 'Третье сообщение', '2013-07-19 05:25:00', 5, 3);

INSERT INTO delivery VALUES(null, 20000000, true, 200000000);
INSERT INTO delivery VALUES(null, 2000, false, 200);
INSERT INTO delivery VALUES(null, 3000, false, 300);

INSERT INTO ingredient VALUES(null, 'Картофель', '', '100 грамм');
INSERT INTO ingredient VALUES(null, 'Морковь', '', '3 шт');
INSERT INTO ingredient VALUES(null, 'Масло', '', '1 уп');

INSERT INTO provider VALUES ('Ресторан у дома', 'Доставка по Бресту', 'Работают проф повара', true, '2013-07-19', 14, 5);
INSERT INTO provider VALUES ('Националь', 'Доставка по Бресту', 'Работают проф повара', true, '2013-07-20', 21, 2);
INSERT INTO provider VALUES ('Ресторан Дружба', 'Доставка по Минску', 'Работают проф повара', true, '2013-07-21', 21, 5);