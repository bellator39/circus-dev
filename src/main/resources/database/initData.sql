INSERT INTO roleuser
    (id, namerole)
SELECT 1,
       'CUSTOMER' WHERE
    NOT EXISTS (
            SELECT id FROM roleuser WHERE id = 1
        );

INSERT INTO roleuser
    (id, namerole)
SELECT 2,
       'ADMIN' WHERE
    NOT EXISTS (
            SELECT id FROM roleuser WHERE id = 2
        );

INSERT INTO roleuser
    (id, namerole)
SELECT 3,
       'MODERATOR' WHERE
    NOT EXISTS (
            SELECT id FROM roleuser WHERE id = 3
        );

INSERT INTO typeshow
    (id, typeshowname)
SELECT 1,
       'ANIMAL' WHERE
    NOT EXISTS (
            SELECT id FROM typeshow WHERE id = 1
        );


INSERT INTO typeshow
    (id, typeshowname)
SELECT 2,
       'MUSICIAN' WHERE
    NOT EXISTS (
            SELECT id FROM typeshow WHERE id = 2
        );


INSERT INTO typeshow
    (id, typeshowname)
SELECT 3,
       'FIRE' WHERE
    NOT EXISTS (
            SELECT id FROM typeshow WHERE id = 3
        );


INSERT INTO circusshow
(id, name, describe, urlpathlogophoto, countavailableticket, dateshow, priceshow, typeshow)
SELECT 878,
       'МАГИЯ БАБОЧКИ ИЛИ НОВОГОДНИЕ ЧУДЕСА В ЦИРКЕ',
       '«Предновогодняя суета» - «Акробаты на батуте»
       п/р Сергея Орешкина (Владимир Холодков, Егор Лукьянов, Александр Грибков, Михаил Козин, Никита Соколов, Кирилл Рябинин)' ||
       '«Лохматые новаторы» - «Дрессированные собачки»
п/р Андрея Ильина (Лилия Максименко)',
       'https://circus.by/wp-content/uploads/2021/12/-e1640255758109.jpg',
       450,
       '2023-01-09',
       12.3,
       1 WHERE
    NOT EXISTS (
            SELECT id FROM circusshow WHERE id = 878
        );


INSERT INTO circusshow
(id, name, describe, urlpathlogophoto, countavailableticket, dateshow, priceshow, typeshow)
SELECT 879
     , 'ОТПУСК БЕЗ НОСКОВ?!'
     , 'Воздушный полёт «Белые птицы»
п/р Алишера Алиева (Екатерина Алиева, Фарход Садыков, Юлия Типаева, Евгений Лукьянцев, Владислав Горелый, Заур Алиев, Алена Дубинина, Михаил Куранков)' ||
       ' (обладатели наград на престижных цирковых фестивалях -серебряная награда в Монте-Карло, Золотые награды во Франции и России)'
     , 'https://circus.by/wp-content/uploads/2022/05/IMG-e34ee290edc0aa47977a22a8fb2ff4fe-V-e1652700903363.jpg'
     , 450
     , '2023-02-09'
     , 17.3
     , 2 WHERE
    NOT EXISTS (
            SELECT id FROM circusshow WHERE id = 879
        );

INSERT INTO circusshow
(id, name, describe, urlpathlogophoto, countavailableticket, dateshow, priceshow, typeshow)
SELECT 880,
       'ПОЧТИ СЕРЬЕЗНО',
       '
       «Бразильское колесо смелости»
       п/р Фабрисио Тейшейра Да Лапа (Тиаго Силва Бразил, Джефферсон Альвес Ди Соуса ) «Высшая школа верховой езды»
       п/р Елены Павлович',
       'https://circus.by/wp-content/uploads/2017/08/2021-04-14_14-06-55-e1618905997974.png',
       450,
       '2023-02-09',
       22.3,
       3 WHERE
    NOT EXISTS (
            SELECT id FROM circusshow WHERE id = 880
        );

INSERT INTO circusshow
(id, name, describe, urlpathlogophoto, countavailableticket, dateshow, priceshow, typeshow)
SELECT 881,
       'ЧУДЕСНЫЙ ДОМ',
       '
       «Канатоходцы Ташкенбаевы»
       п/р Бехзода Ташкенбаева (Джамшид Тошкенбоев, Святослав Гайдамакин, Оксана Ташкенбаева, Александр Хорольский)',
       'https://circus.by/wp-content/uploads/2017/08/A1-e1555591007950.jpg',
       450,
       '2023-02-09',
       25.3,
       1 WHERE
    NOT EXISTS (
            SELECT id FROM circusshow WHERE id = 881
        );


INSERT INTO tagnews
    (id, tagname)
SELECT 1,
       'GENERAL' WHERE
    NOT EXISTS (
            SELECT id FROM tagnews WHERE id = 1
        );

INSERT INTO tagnews
    (id, tagname)
SELECT 2,
       'CELEBRATION' WHERE
    NOT EXISTS (
            SELECT id FROM tagnews WHERE id = 2
        );

INSERT INTO tagnews
    (id, tagname)
SELECT 3,
       'URGENTLY' WHERE
    NOT EXISTS (
            SELECT id FROM tagnews WHERE id = 3
        );

INSERT INTO tagnews
    (id, tagname)
SELECT 4,
       'STOCK' WHERE
    NOT EXISTS (
            SELECT id FROM tagnews WHERE id = 4
        );



INSERT INTO circusnews
(id, newsname, newstext, urllogonews, date_publication, idauthor, tagnews)
SELECT 784,
       'УКРАСЬ НОВОГОДНЮЮ ЁЛОЧКУ',
       'Дорогие друзья, символом приближающегося года станет пушистый и ' ||
       'ласковый кролик. Вместе с вами мы хотим поприветствовать его, ' ||
       'поэтому объявляем о запуске увлекательного проекта, который позволит' ||
       ' вам проявить свои творческие способности. Предлагаем вам своими руками ' ||
       'смастерить игрушку для нашей ёлочки в виде милого кролика. Форма, материал' ||
       ' и вид игрушки зависят от вашей фантазии! Приходите на наше представление, приносите игрушку, и вместе с Дедом Морозом и Снегурочкой украшайте нашу ёлочку! Все участники получат приятные сувениры! Также любой желающий сможет потанцевать на нашей зажигательной новогодней дискотеке и сделать фото с Дедом Морозом! Мы будем ждать вас у ёлочки в фойе второго этажа!'
        ,
       'https://circus.by/wp-content/uploads/2022/12/IMG-0a234132d32ef7acfe76d64f8bd270f0-V.jpg',
       '2022-12-25',
       777,
       1 WHERE
    NOT EXISTS (
            SELECT id FROM circusnews WHERE id = 784
        );

INSERT INTO circusnews
(id, newsname, newstext, urllogonews, date_publication, idauthor, tagnews)
SELECT 785,
       'НОВОГОДНЕЕ ПУТЕШЕСТВИЕ',
       'В канун новогодних праздников Белгосцирк приглашает в незабываемое «Новогоднее путешествие»! Вместе с главными героями завораживающей сказки зрители отправятся в увлекательное странствие по загадочному Северу, где повстречают мудрых шаманов, таинственных строителей воздушного корабля, сразятся с хитрыми и коварными разбойниками, познакомятся северным Дедом Морозом и даже увидят настоящих обитателей вечной мерзлоты — гигантских мамонтов! На манеже цирка развернется чудесная зимняя сказка, наполненная неповторимым колоритом Севера, яркими новогодними приключениями и захватывающими трюками!
       В ПРОГРАММЕ:
       -«Стражи полярной ночи» — белоснежные тигры
       -Гимнасты на летающих мачтах
       -Жонглеры с брёвнами
       -Свободная проволока
       -Гимнасты на воздушной трапеции
       -Дрессированные пони
       -Воздушный полёт
       И многое другое!
       Спешите! Программа пройдет с 17 декабря по 15 января!
       Билеты можно приобрести в кассе Белгосцирка и на сайте www.kvitki.by'
        ,
       'https://circus.by/wp-content/uploads/2022/11/111-e1668624115282.jpg',
       '2022-12-25',
       777,
       1 WHERE
    NOT EXISTS (
            SELECT id FROM circusnews WHERE id = 785
        );

INSERT INTO circusnews
(id, newsname, newstext, urllogonews, date_publication, idauthor, tagnews)
SELECT 786,
       'ВСЕ БУДЕТ ХОРОШО!',
        'Дорогие друзья! Открыта продажа билетов на новую программу «Все будет хорошо!»
Хочется праздника? А он совсем рядом! Белгосцирк и Московский цирк Никулина на Цветном бульваре представляют программу «Всё будет хорошо!», которая пройдёт с 24 сентября по 4 декабря. Герои новой программы — Импресарио и Шоумен откроют для вас дверь в удивительный мир, где живут летающие люди и звери на велосипедах, где акробаты спорят с притяжением земли, а попугаи летают над вашими головами, как в тропическом лесу, где акула – это не страшный морской хищник, а веселый и добрый клоун. Приходите в цирк и помните — Всё будет хорошо!Билеты — в кассе Белгосцирка и на сайте kvitki.by'
        ,
       'https://circus.by/wp-content/uploads/2022/08/IMG-2499ec813fc481475406d1297243da77-V-1.jpg',
       '2022-12-25',
       777,
       1 WHERE
    NOT EXISTS (
            SELECT id FROM circusnews WHERE id = 786
        );

