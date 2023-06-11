-- test veritabanınızda employee isimli sütun bilgileri id(INTEGER), name VARCHAR(50), birthday DATE, email VARCHAR(100) olan bir tablo oluşturalım.
CREATE TABLE employee (
	id SERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	birthday DATE,
	email VARCHAR(100) NOT NULL
);

-- Oluşturduğumuz employee tablosuna 'Mockaroo' servisini kullanarak 50 adet veri ekleyelim.

insert into employee (id, name, birthday, email) values (1, 'Norma', '1990-07-13', 'nnaish0@wired.com');
insert into employee (id, name, birthday, email) values (2, 'Eadmund', '2001-01-17', 'ekolodziejski1@latimes.com');
insert into employee (id, name, birthday, email) values (3, 'Darnell', '1992-01-07', 'droskell2@google.cn');
insert into employee (id, name, birthday, email) values (4, 'Maison', '1994-08-10', 'mpervoe3@theglobeandmail.com');
insert into employee (id, name, birthday, email) values (5, 'Ted', null, 'tcavie4@yale.edu');
insert into employee (id, name, birthday, email) values (6, 'Herby', '2000-10-12', 'hgrigorio5@jigsy.com');
insert into employee (id, name, birthday, email) values (7, 'Fifi', null, 'feddleston6@noaa.gov');
insert into employee (id, name, birthday, email) values (8, 'Kennie', '1992-06-30', 'ktibbits7@walmart.com');
insert into employee (id, name, birthday, email) values (9, 'Donal', '2005-12-12', 'djeste8@foxnews.com');
insert into employee (id, name, birthday, email) values (10, 'Brier', '1995-05-05', 'bchildren9@hatena.ne.jp');
insert into employee (id, name, birthday, email) values (11, 'Zechariah', '1996-05-29', 'zspurdensa@1688.com');
insert into employee (id, name, birthday, email) values (12, 'Shermie', '2004-06-02', 'sjecksb@cdbaby.com');
insert into employee (id, name, birthday, email) values (13, 'Sissy', '1992-02-20', 'spetranekc@wikispaces.com');
insert into employee (id, name, birthday, email) values (14, 'Baillie', '1993-12-12', 'bbogied@apple.com');
insert into employee (id, name, birthday, email) values (15, 'Mordy', '1992-12-21', 'mrosterne@reuters.com');
insert into employee (id, name, birthday, email) values (16, 'Randa', null, 'rwalklotf@topsy.com');
insert into employee (id, name, birthday, email) values (17, 'Leeland', '2009-11-05', 'lbilliong@themeforest.net');
insert into employee (id, name, birthday, email) values (18, 'Flossie', '1996-06-03', 'friccellih@china.com.cn');
insert into employee (id, name, birthday, email) values (19, 'Erv', null, 'ewardlowi@ning.com');
insert into employee (id, name, birthday, email) values (20, 'Chiquita', '1997-10-22', 'cvenablesj@cbsnews.com');
insert into employee (id, name, birthday, email) values (21, 'Chrissie', '2003-07-30', 'cleflemingk@chron.com');
insert into employee (id, name, birthday, email) values (22, 'Eduard', '1996-09-12', 'epresseyl@facebook.com');
insert into employee (id, name, birthday, email) values (23, 'Kathye', '1992-01-16', 'kwinstonm@gizmodo.com');
insert into employee (id, name, birthday, email) values (24, 'Damian', '1990-12-29', 'dyieldingn@example.com');
insert into employee (id, name, birthday, email) values (25, 'Isadora', '2009-05-04', 'iauchinlecko@cornell.edu');
insert into employee (id, name, birthday, email) values (26, 'Kerrill', null, 'kcouvep@answers.com');
insert into employee (id, name, birthday, email) values (27, 'Bellanca', '2001-08-08', 'bmacterlaghq@edublogs.org');
insert into employee (id, name, birthday, email) values (28, 'Dahlia', '1998-01-11', 'dmapesr@deviantart.com');
insert into employee (id, name, birthday, email) values (29, 'Burk', '2003-07-01', 'bsneads@google.de');
insert into employee (id, name, birthday, email) values (30, 'Benedetta', '1992-02-27', 'bboomt@alexa.com');
insert into employee (id, name, birthday, email) values (31, 'Lee', null, 'lhamertonu@cpanel.net');
insert into employee (id, name, birthday, email) values (32, 'Lorilyn', '2002-11-02', 'lhumburtonv@google.com');
insert into employee (id, name, birthday, email) values (33, 'Mike', '1997-04-14', 'mmauvinw@slideshare.net');
insert into employee (id, name, birthday, email) values (34, 'Wildon', '2001-07-16', 'wlorrowayx@instagram.com');
insert into employee (id, name, birthday, email) values (35, 'Agnella', '2007-04-27', 'akunnekey@mit.edu');
insert into employee (id, name, birthday, email) values (36, 'Vilhelmina', null, 'vscoularz@google.de');
insert into employee (id, name, birthday, email) values (37, 'Beatrisa', '1999-11-21', 'bglyn10@smh.com.au');
insert into employee (id, name, birthday, email) values (38, 'Cesar', '2004-04-21', 'cfaherty11@google.com.au');
insert into employee (id, name, birthday, email) values (39, 'Tiffani', null, 'tfido12@indiatimes.com');
insert into employee (id, name, birthday, email) values (40, 'Marthe', '1999-01-28', 'mhover13@hexun.com');
insert into employee (id, name, birthday, email) values (41, 'Brinna', '2009-04-17', 'bcunliffe14@oakley.com');
insert into employee (id, name, birthday, email) values (42, 'Sal', '2002-12-21', 'sburgill15@gov.uk');
insert into employee (id, name, birthday, email) values (43, 'Rakel', '1995-11-17', 'rcoultass16@seesaa.net');
insert into employee (id, name, birthday, email) values (44, 'Addie', '1994-12-07', 'akwietak17@godaddy.com');
insert into employee (id, name, birthday, email) values (45, 'Ashley', null, 'aelis18@jugem.jp');
insert into employee (id, name, birthday, email) values (46, 'Neda', '2008-11-15', 'nstanworth19@marketwatch.com');
insert into employee (id, name, birthday, email) values (47, 'Golda', '1991-06-29', 'gkremer1a@github.com');
insert into employee (id, name, birthday, email) values (48, 'Clair', '1991-03-31', 'cvowles1b@jugem.jp');
insert into employee (id, name, birthday, email) values (49, 'Farr', '1999-07-12', 'fandino1c@npr.org');
insert into employee (id, name, birthday, email) values (50, 'Bastian', '1998-09-29', 'bmcvitie1d@jugem.jp');

-- Sütunların her birine göre diğer sütunları güncelleyecek 5 adet UPDATE işlemi yapalım.
UPDATE employee
SET name = 'XX',
	birthday = '1991-02-12',
	email = 'johnx@gmail.com'
WHERE id > 40;

-- Sütunların her birine göre ilgili satırı silecek 5 adet DELETE işlemi yapalım.
DELETE FROM employee
WHERE id > 40;