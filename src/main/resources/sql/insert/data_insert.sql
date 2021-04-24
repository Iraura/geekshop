insert into section(ID,name, description) values
(1, 'Anime and Manga', 'Here you will find paraphernalia from popular anime!'),
(2, 'Films', 'Here you will find paraphernalia of popular cinematographic works!'),
(3, 'Series', 'Here you will find paraphernalia for popular and favorite TV series!'),
(4, 'Cartoons and animated series', 'Here you will find paraphernalia based on your favorite cartoons and animated series of childhood and not only!'),
(5, 'MARVEL Universe', 'Here you will find paraphernalia of your favorite characters from the famous MARVEL universe!'),
(6, 'DC Universe', 'Here you will find paraphernalia of your favorite characters from the famous DC Universe!'),
(7, 'Games', 'Here you will find paraphernalia for the games you spent so much time in!'),
(8, 'Miscellaneous', 'Here you can find many other cool products that you might like!');
insert into category (ID, name, description) values
(1, 'T-shirts', 'Choose what you like!'),
(2, 'Mugs', 'Choose what you like!'),
(3, 'Posters', 'Choose what you like!'),
(4, 'Socks', 'Choose what you like!'),
(5, 'Keychains', 'Choose what you like!'),
(6, 'Books and comics', 'Choose what you like!'),
(7, 'Soft toys', 'Choose what you like!'),
(8, 'Stickers', 'Choose what you like!');
insert into promocode (name, discount, fromDate, toDate, count) values
('WEB', 10, '2021.04.10', '2022.04.10', 5),
('GEEKS', 50, '2021.04.01', '2021.05.31', 20);
insert into client (ID, firstName, lastName, middleName, birthDay, email, login, password, phone, address) values
(1, 'Nikolay', 'Nikolaev', 'Nikolaevich', '1980.01.02', 'nikolaevich@gmail.com', 'nikolya', 'koko1980', '89213467238', 'Samara, Novo- station, 200-21 '),
(2, 'Tina', 'Kandelaki', 'Ilyinichna', '1992.03.09', 'tinakandek@mail.ru', 'tinki', 'kantin92', '89287572361', 'Sochi, Krasivaya st., 76 '),
(3, 'Naruto', 'Uzumaki', 'Minatovich', '2001.11.23', 'evergiveup@gmail.com', 'rassengun', 'hokage1', '89357295518', 'Kazan, st.Chak- chuck, 88-2 ');
insert into admins (ID, firstName, lastName, middleName, login, password, position, workExperience, salary, phone) values
(1, 'Petya', 'Funny', 'Alexandrovich', 'administrator00', 'geekadmin228', 'Seller', '3 years', 20000, '89227649912');
insert into orders (ID, client_ID, status, cost, orderDate, deliveryDate) values
(1, 1, 'Accepted', 5000, '2021.04.16', '2021.04.22'),
(2, 2, 'Issued', 3500, '2021.04.08', '2021.04.14'),
(3, 3, 'Accepted', 2100, '2021.04.15', '2021.04.21');
insert into product (ID, name, description, price, count, section_ID, category_ID) values
(1, 'Naruto Manga Volume 1', 'Featured', 500, 20, 1, 1),
(2, 'Harry Potter T-shirt', 'Harry Potter persistent print cotton T-shirt', 700, 15, 2, 2),
(3, '"Friends" mug', 'Ceramic mug with a print from the cult series Friends!', 400, 30, 3, 2),
(4, 'Spiderman Poster', 'Vintage poster to create an atmosphere in your room or other room. Size 30x40. Great gift for a fan of the MARVEL universe!', 100, 25, 5, 3),
(5, '"Attack of the Titans" Stickers', 'A set of stickers, A5 format. Perfect as a gift for a fan of the cult anime "Attack of the Titans!"', 100, 50, 1, 8);
insert into element (code, product_ID, order_ID, count) values
(1, 1, 1, 10),
(2, 2, 2, 5),
(3, 3, 3, 5),
(4, 4, 3, 1);