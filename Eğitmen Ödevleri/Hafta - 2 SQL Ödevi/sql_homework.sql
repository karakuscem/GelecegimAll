/*
User Tablosu Yaratımı
----
ID Primary key olmalı
Username ve email unique ve not null olmalı
creation date insert sorgusunda verilmediyse default olarak şimdiki tarihi almalı
*/
CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	username VARCHAR(50) UNIQUE NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL,
	creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	is_active BOOLEAN
);

/*
Category tablosu yaratımı
---
ID primary key olmalı
name unique ve not null olmalı
creation date default olarak şimdiki tarihi almalı
*/
CREATE TABLE categories (
	category_id SERIAL PRIMARY KEY,
	name VARCHAR(50) UNIQUE NOT NULL,
	creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/*
Posts tablosu yaratımı
---
Post_id primary key olmalı
Foreign keyler ilişkilendirilmeli (bunun için önce ilgili tabloların yartılması lazım), ikisi de not null olmalı
title ve content bilgisi olmalı title 50 karakteri geçmemeli
view_count default olarak 0 olmalı,

*/

CREATE TABLE posts (
    post_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    category_id INTEGER NOT NULL,
    title VARCHAR(50) NOT NULL,
    content TEXT NOT NULL,
    view_count INTEGER DEFAULT 0,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_published BOOLEAN,
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (category_id) REFERENCES categories (category_id)
);

/*
Comments tablosu yaratımı
---
Hiç bir yorum post bilgisi olmadan kaydedilmemeli, post_id not null olacak
Comment bilgisi olmak zorunda, comment not null olmalı
*/

CREATE TABLE comments (
	comment_id SERIAL PRIMARY KEY,
	post_id INTEGER NOT NULL,
	user_id INTEGER,
	comment VARCHAR(50) NOT NULL,
	creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	is_confirmed BOOLEAN
);

--Users tablosu için veri ekleme
insert into users (user_id, username, email, is_active) values (1, 'hsholem0', 'eelston0@salon.com', true);
insert into users (user_id, username, email, creation_date, is_active) values (2, 'bjoannet1', 'gglyde1@163.com', '2022-03-10', true);
insert into users (user_id, username, email, creation_date, is_active) values (3, 'zkeig2', 'rdrain2@blog.com', '2019-11-23', false);
insert into users (user_id, username, email, creation_date, is_active) values (4, 'mrushmere3', 'tattwater3@hp.com', '2021-06-06', true);
insert into users (user_id, username, email, is_active) values (5, 'panespie4', 'kkennard4@purevolume.com', true);
insert into users (user_id, username, email, creation_date, is_active) values (6, 'woswald5', 'bouldcott5@amazon.co.uk', '2018-12-21', true);
insert into users (user_id, username, email, creation_date, is_active) values (7, 'aamner6', 'nmccullouch6@youku.com', '2022-10-18', false);
insert into users (user_id, username, email, is_active) values (8, 'bsimonou7', 'dingledew7@cbsnews.com', true);
insert into users (user_id, username, email, creation_date, is_active) values (9, 'lwhittingham8', 'mbattrum8@google.com.br', '2019-11-26', true);
insert into users (user_id, username, email, is_active) values (10, 'bcharrette9', 'dkilgallen9@hc360.com', true);
insert into users (user_id, username, email, is_active) values (11, 'xxx', 'yyy@hc360.com', true);

--Category için veri eklemesi
insert into categories (category_id, name) values (1, 'Action');
insert into categories (category_id, name) values (2, 'Comedy');
insert into categories (category_id, name, creation_date) values (3, 'Romantic', '2023-05-10');
insert into categories (category_id, name, creation_date) values (4, 'Sci-Fi', '2013-08-25');
insert into categories (category_id, name, creation_date) values (5, 'Legends', '2019-05-10');

--Posts tablosu için veri ekleme
insert into posts (post_id, user_id, category_id, title, content, view_count, is_published) values (1, 1, 1, 'When Marnie Was There', 'sunt in culpa qui officia deserunt mollit anim id est laborum.', 3717, false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (2, 8, 1, 'Man Who Laughs', 'sunt in culpa qui officia deserunt mollit anim id est laborum.', 6625, '2022-06-09 16:57:54', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, is_published) values (3, 2, 5, 'Randy a', 'Ut enim ad minim veniam', 6485, false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (4, 6, 5, 'Agnes ', 'Lorem ipsum dolor sit amet', 2661, '2016-07-18 10:38:12', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (5, 2, 5, 'Gregory : ', 'sunt in culpa qui officia deserunt mollit anim id est laborum.', 2520, '2017-08-13 19:57:43', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, is_published) values (6, 7, 5, 'Confessions', 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 4231, false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (7, 9, 1, 'Joshua', 'consectetur adipiscing elit.', 1894, '2016-02-27 07:11:46', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (8, 8, 1, 'Conversation', 'consectetur adipiscing elit.', 6559, '2014-04-27 10:04:37', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (9, 10, 4, 'The Road to', 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 3943, '2015-06-20 07:33:06', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (10, 3, 2, '8 Diagram , ', 'Ut enim ad minim veniam', 4029, '2021-05-17 08:04:53', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (11, 9, 5, 'Red Violin', 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 7157, '2016-02-24 19:00:50', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, is_published) values (12, 2, 4, '6954', 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 4932, false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (13, 3, 4, 'Zaza', 'Excepteur sint occaecat cupidatat non proident', 980, '2021-10-16 15:43:14', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, is_published) values (14, 8, 1, 'Murder Most', 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 507, false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (15, 7, 4, 'Princess 2: ', 'Ut enim ad minim veniam', 5020, '2023-05-01 18:02:14', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (16, 10, 5, 'Grapes of', 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 6891, '2020-12-09 12:56:44', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (17, 7, 1, 'AtomicThe', 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 9891, '2012-10-28 15:17:12', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (18, 8, 1, 'Valley of', 'Lorem ipsum dolor sit amet', 9356, '2015-11-23 11:56:12', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (19, 10, 2, 'In the Name', 'consectetur adipiscing elit.', 55, '2022-06-18 15:35:44', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, is_published) values (20, 5, 5, 'Rockete', 'Sed do  tempor incididunt ut labore et dolore magna aliqua.', 4815, true);
insert into posts (post_id, user_id, category_id, title, content, view_count, is_published) values (21, 8, 4, 'Year of', 'Ut enim ad minim veniam', 1703, true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (22, 9, 1, 'Madame ', 'Lorem ipsum dolor sit amet', 9240, '2021-03-12 18:59:32', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, is_published) values (23, 1, 2, 'Message from', 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 3664, false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (24, 4, 5, 'My Mothers Smile', 'sunt in culpa qui officia deserunt mollit anim id est laborum.', 3244, '2019-12-05 07:15:56', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (25, 9, 4, 'Carnosaur 2', 'consectetur adipiscing elit.', 6173, '2015-01-31 12:06:35', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, is_published) values (26, 2, 2, 'Close', 'Ut enim ad minim veniam', 6058, true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (27, 1, 2, 'Urusei Yat', 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 3205, '2013-11-25 05:18:01', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (28, 7, 4, 'Freaky Friday', 'Excepteur sint occaecat cupidatat non proident', 7126, '2013-02-21 03:47:57', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (29, 4, 5, 'Accident', 'Excepteur sint occaecat cupidatat non proident', 8218, '2021-08-16 13:57:57', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (30, 8, 3, 'Hot Rods to ', 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 4686, '2019-12-17 15:40:47', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, is_published) values (31, 3, 4, 'Jasminum', 'Ut enim ad minim veniam', 7573, false);
insert into posts (post_id, user_id, category_id, title, content, view_count, is_published) values (32, 7, 4, 'Jack the Giant', 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 5539, true);
insert into posts (post_id, user_id, category_id, title, content, view_count, is_published) values (33, 6, 2, 'On Top of the', 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 3009, false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (34, 1, 1, 'The ''s Candlesticks', 'Ut enim ad minim veniam', 8160, '2015-01-27 08:25:43', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (35, 3, 3, 'Pocketful of ', 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 681, '2015-11-23 09:44:49', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (36, 8, 3, 'Journey  Fear', 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 9692, '2010-10-30 07:59:17', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, is_published) values (37, 2, 3, 'Sorority  in', 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 2874, true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (38, 8, 4, 'Dug''s  Mission', 'consectetur adipiscing elit.', 6045, '2019-12-04 07:53:55', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (39, 10, 4, 'Outpost:  Sun', 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 2386, '2011-10-15 12:06:38', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (40, 4, 1, 'Autumn Tale, An', 'Lorem ipsum dolor sit amet', 5249, '2021-12-05 09:43:39', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (41, 8, 4, 'Amateur', 'sunt in culpa qui officia deserunt mollit anim id est laborum.', 5136, '2020-11-19 04:28:18', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (42, 2, 4, 'Bonhoeffer: A', 'sunt in culpa qui officia deserunt mollit anim id est laborum.', 9814, '2010-08-15 22:19:16', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (43, 4, 3, 'Robber, Th)', 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 6378, '2016-06-18 15:33:47', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, is_published) values (44, 8, 4, 'Quiller, The', 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 1653, false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (45, 2, 4, 'V/H/S/2', 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 7627, '2012-06-11 21:56:36', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (46, 7, 1, 'Comancheros, ', 'Ut enim ad minim veniam', 2945, '2015-12-26 17:54:01', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (47, 2, 3, 'Hellraiser:', 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 7064, '2016-11-12 23:23:23', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (48, 1, 3, 'Mantle', 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 3002, '2020-09-29 18:10:58', false);
insert into posts (post_id, user_id, category_id, title, content, view_count, is_published) values (49, 5, 1, 'American Sniper', 'Lorem ipsum dolor sit amet', 6401, false);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (50, 1, 5, 'Krakatoa ', 'Ut enim ad minim veniam', 6812, '2021-04-15 03:11:08', true);
insert into posts (post_id, user_id, category_id, title, content, view_count, creation_date, is_published) values (50, 1, 5, 'Krakatoa ', 'Ut enim ad minim veniam', 6812, '2021-04-15 03:11:08', true);


--Comments için veri eklemesi
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (1, 42, 4, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2022-06-26 15:51:53', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (2, 3, 6, 'Excepteur sint occaecat cupidatat non proident', '2019-08-20 11:03:33', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (3, 28, 2, 'Excepteur sint occaecat cupidatat non proident', '2018-01-10 02:50:09', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (4, 11, 5, 'Excepteur sint occaecat cupidatat non proident', '2022-10-03 20:03:52', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (5, 41, null, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2016-04-15 07:30:05', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (6, 34, 10, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2013-07-06 21:53:53', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (7, 5, 3, 'Excepteur sint occaecat cupidatat non proident', '2017-10-09 06:13:18', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (8, 49, 7, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2011-01-31 18:55:28', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (9, 20, 7, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2022-01-18 02:13:24', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (10, 49, 5, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2015-08-11 10:02:01', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (11, 13, null, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2019-09-02 06:56:32', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (12, 10, null, 'consectetur adipiscing elit.', '2020-10-17 14:22:30', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (13, 45, 8, 'Ut enim ad minim veniam', '2020-11-18 21:32:09', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (14, 25, 10, 'Lorem ipsum dolor sit amet', '2010-10-22 23:15:07', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (15, 7, null, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2010-11-23 00:35:17', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (16, 32, 7, 'consectetur adipiscing elit.', '2019-10-19 05:54:27', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (17, 25, null, 'Lorem ipsum dolor sit amet', '2022-12-28 04:56:56', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (18, 44, 1, 'consectetur adipiscing elit.', '2015-05-19 15:07:20', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (19, 16, 2, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2014-12-13 05:01:14', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (20, 41, 9, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2013-09-05 02:44:32', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (21, 39, 7, 'Lorem ipsum dolor sit amet', '2014-02-10 10:39:29', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (22, 13, null, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2019-08-05 06:17:58', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (23, 5, 10, 'consectetur adipiscing elit.', '2013-01-22 02:15:45', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (24, 24, null, 'Lorem ipsum dolor sit amet', '2020-06-04 03:48:34', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (25, 6, 10, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2022-08-25 04:18:14', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (26, 33, 5, 'Ut enim ad minim veniam', '2011-10-14 20:39:56', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (27, 16, null, 'Ut enim ad minim veniam', '2015-04-10 15:18:46', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (28, 23, 9, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2013-01-13 19:39:04', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (29, 3, 1, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2015-04-14 06:29:08', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (30, 8, 7, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2019-11-25 06:00:11', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (31, 47, 9, 'consectetur adipiscing elit.', '2021-04-28 23:11:26', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (32, 32, null, 'consectetur adipiscing elit.', '2019-10-01 09:33:37', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (33, 32, 3, 'Lorem ipsum dolor sit amet', '2013-11-09 03:48:33', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (34, 33, 9, 'Lorem ipsum dolor sit amet', '2019-12-18 07:45:30', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (35, 4, 9, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2011-03-27 04:03:33', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (36, 7, 9, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2015-08-04 10:03:28', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (37, 20, 7, 'Ut enim ad minim veniam', '2021-07-24 06:58:10', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (38, 30, 8, 'Excepteur sint occaecat cupidatat non proident', '2014-12-01 14:30:11', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (39, 44, 9, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2010-08-25 21:04:06', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (40, 44, 4, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2015-11-28 02:25:20', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (41, 10, null, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2015-02-03 14:43:55', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (42, 40, 9, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2018-10-15 01:30:15', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (43, 12, 9, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2014-11-03 16:28:39', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (44, 6, 7, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2011-02-22 17:18:56', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (45, 6, 8, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2015-02-11 11:57:59', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (46, 34, 10, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2013-09-17 22:35:28', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (47, 46, null, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2021-05-10 15:31:14', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (48, 31, null, 'Lorem ipsum dolor sit amet', '2020-06-16 08:34:37', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (49, 31, null, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2017-01-09 18:26:35', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (50, 13, 9, 'consectetur adipiscing elit.', '2011-08-20 14:47:44', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (51, 6, 3, 'consectetur adipiscing elit.', '2014-07-17 07:15:19', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (52, 2, 8, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2017-01-25 06:30:19', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (53, 35, null, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2016-10-06 20:11:22', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (54, 10, 5, 'Ut enim ad minim veniam', '2016-05-12 13:36:59', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (55, 42, 5, 'Lorem ipsum dolor sit amet', '2016-03-18 23:28:47', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (56, 42, null, 'Excepteur sint occaecat cupidatat non proident', '2016-11-03 21:22:26', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (57, 3, 6, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2019-09-12 10:23:35', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (58, 32, null, 'Excepteur sint occaecat cupidatat non proident', '2022-09-30 15:25:07', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (59, 24, 2, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2011-06-01 01:17:53', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (60, 13, null, 'Lorem ipsum dolor sit amet', '2014-08-22 06:54:36', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (61, 22, 10, 'Ut enim ad minim veniam', '2022-11-03 21:40:38', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (62, 16, 8, 'Excepteur sint occaecat cupidatat non proident', '2022-11-05 04:24:56', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (63, 14, 4, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2011-07-27 10:57:04', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (64, 5, 3, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2015-12-25 09:41:28', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (65, 5, 8, 'Excepteur sint occaecat cupidatat non proident', '2021-02-17 06:11:18', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (66, 7, 5, 'Excepteur sint occaecat cupidatat non proident', '2021-03-16 23:10:47', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (67, 32, 9, 'Ut enim ad minim veniam', '2015-12-28 19:45:59', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (68, 33, 3, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2015-07-17 13:52:40', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (69, 1, 2, 'Lorem ipsum dolor sit amet', '2010-06-18 18:15:20', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (70, 37, 9, 'Excepteur sint occaecat cupidatat non proident', '2022-07-02 01:46:24', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (71, 27, 3, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2012-08-22 21:55:19', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (72, 36, 2, 'Lorem ipsum dolor sit amet', '2019-08-04 09:00:32', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (73, 2, null, 'Excepteur sint occaecat cupidatat non proident', '2021-05-04 14:46:07', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (74, 3, 4, 'Ut enim ad minim veniam', '2012-10-02 20:02:06', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (75, 16, null, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2011-03-07 15:25:32', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (76, 28, 8, 'Ut enim ad minim veniam', '2021-02-21 11:02:11', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (77, 14, null, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2016-11-10 13:51:08', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (78, 40, 9, 'Ut enim ad minim veniam', '2015-07-23 16:46:25', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (79, 46, 4, 'Lorem ipsum dolor sit amet', '2017-12-12 20:00:39', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (80, 45, 7, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2015-06-24 18:30:50', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (81, 20, 2, 'Excepteur sint occaecat cupidatat non proident', '2016-07-11 10:13:41', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (82, 25, null, 'Excepteur sint occaecat cupidatat non proident', '2011-05-27 19:25:39', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (83, 6, null, 'Ut enim ad minim veniam', '2018-12-23 15:05:01', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (84, 42, 9, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2018-11-05 08:56:12', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (85, 16, 7, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2011-12-08 17:41:39', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (86, 29, 9, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2015-05-08 19:53:39', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (87, 25, null, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2015-05-03 07:56:45', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (88, 13, 2, 'consectetur adipiscing elit.', '2022-12-25 18:43:02', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (89, 47, 8, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2012-10-29 00:03:00', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (90, 19, null, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2019-02-22 14:54:46', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (91, 41, null, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2021-02-14 03:52:06', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (92, 43, 2, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2017-10-06 22:24:43', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (93, 41, 3, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2023-02-19 08:42:02', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (94, 6, 3, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2016-08-11 19:39:43', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (95, 27, null, 'Lorem ipsum dolor sit amet', '2021-03-16 16:37:58', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (96, 2, 4, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2011-02-11 11:45:42', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (97, 6, 6, 'Ut enim ad minim veniam', '2021-07-07 13:38:58', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (98, 45, 10, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2019-11-08 02:06:14', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (99, 48, 5, 'Excepteur sint occaecat cupidatat non proident', '2013-06-29 01:09:50', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (100, 26, 7, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2019-04-22 14:27:32', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (101, 11, 1, 'Excepteur sint occaecat cupidatat non proident', '2011-02-27 04:29:40', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (102, 41, 1, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2013-12-30 21:31:38', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (103, 33, 8, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2020-03-22 23:01:09', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (104, 41, 3, 'Lorem ipsum dolor sit amet', '2021-08-22 01:14:49', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (105, 28, 10, 'Excepteur sint occaecat cupidatat non proident', '2010-11-27 20:39:47', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (106, 45, 9, 'Excepteur sint occaecat cupidatat non proident', '2022-01-03 00:15:17', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (107, 41, 1, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2011-04-29 16:09:00', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (108, 35, 3, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2014-01-25 15:38:18', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (109, 8, 6, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2022-10-30 10:15:18', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (110, 37, null, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2021-06-28 08:27:34', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (111, 10, 9, 'consectetur adipiscing elit.', '2016-12-10 04:59:51', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (112, 19, null, 'consectetur adipiscing elit.', '2015-07-22 11:59:33', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (113, 18, 3, 'Lorem ipsum dolor sit amet', '2020-05-15 03:55:38', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (114, 21, null, 'Excepteur sint occaecat cupidatat non proident', '2015-01-22 02:21:50', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (115, 45, 5, 'Ut enim ad minim veniam', '2023-04-20 17:58:57', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (116, 17, 1, 'Excepteur sint occaecat cupidatat non proident', '2018-07-11 21:25:26', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (117, 50, 10, 'Ut enim ad minim veniam', '2015-12-15 06:13:23', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (118, 43, 6, 'Excepteur sint occaecat cupidatat non proident', '2011-05-25 14:32:37', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (119, 49, 6, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2010-06-24 08:43:50', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (120, 17, 2, 'Lorem ipsum dolor sit amet', '2014-08-24 18:43:49', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (121, 15, 6, 'Lorem ipsum dolor sit amet', '2017-08-18 12:24:12', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (122, 38, null, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2020-05-30 06:21:04', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (123, 45, 8, 'Ut enim ad minim veniam', '2014-02-06 03:22:58', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (124, 4, null, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2022-04-11 15:08:19', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (125, 38, 7, 'consectetur adipiscing elit.', '2019-03-22 04:30:23', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (126, 22, 4, 'consectetur adipiscing elit.', '2021-01-09 08:50:46', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (127, 44, 2, 'Lorem ipsum dolor sit amet', '2013-02-09 04:22:12', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (128, 50, 5, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2022-07-03 19:40:32', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (129, 5, 1, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2014-02-16 02:29:18', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (130, 29, 8, 'Lorem ipsum dolor sit amet', '2021-09-14 03:42:18', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (131, 5, 1, 'Ut enim ad minim veniam', '2013-01-09 00:22:08', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (132, 2, 2, 'Ut enim ad minim veniam', '2010-11-22 18:19:03', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (133, 31, 2, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2022-08-18 05:07:46', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (134, 13, 5, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2014-11-16 18:17:13', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (135, 14, 2, 'Ut enim ad minim veniam', '2022-11-11 02:23:28', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (136, 3, 2, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2014-07-15 15:22:00', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (137, 17, 1, 'Ut enim ad minim veniam', '2023-03-01 07:21:53', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (138, 25, null, 'consectetur adipiscing elit.', '2010-08-27 04:13:52', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (139, 1, 1, 'Ut enim ad minim veniam', '2020-07-21 18:52:55', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (140, 19, 2, 'consectetur adipiscing elit.', '2018-06-04 00:37:09', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (141, 27, 2, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2015-01-30 13:22:42', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (142, 40, 5, 'Ut enim ad minim veniam', '2020-12-12 21:07:10', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (143, 10, 2, 'Ut enim ad minim veniam', '2020-07-20 16:30:23', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (144, 47, 7, 'Lorem ipsum dolor sit amet', '2016-01-02 23:22:49', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (145, 4, 5, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2021-12-17 05:09:19', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (146, 32, 1, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2022-07-21 00:32:21', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (147, 4, 4, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2018-04-30 19:30:36', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (148, 14, 1, 'Ut enim ad minim veniam', '2015-06-11 18:43:54', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (149, 5, 4, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2014-11-01 22:06:08', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (150, 34, 1, 'Ut enim ad minim veniam', '2015-03-23 10:50:52', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (151, 5, 3, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2011-04-14 13:28:26', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (152, 8, 7, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2013-11-29 11:55:43', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (153, 49, 4, 'Ut enim ad minim veniam', '2015-09-09 16:39:24', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (154, 34, null, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2020-04-21 04:14:47', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (155, 20, null, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2019-09-23 06:19:41', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (156, 29, null, 'Lorem ipsum dolor sit amet', '2017-10-05 06:29:42', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (157, 43, 6, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2022-04-11 06:38:28', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (158, 2, 8, 'Ut enim ad minim veniam', '2014-09-18 02:16:03', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (159, 11, 1, 'Ut enim ad minim veniam', '2022-12-13 05:42:05', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (160, 16, 3, 'Lorem ipsum dolor sit amet', '2014-06-03 01:31:49', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (161, 5, 4, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2016-10-21 23:00:59', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (162, 47, 9, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2011-10-05 08:34:41', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (163, 46, 10, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2014-10-28 23:32:12', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (164, 49, 6, 'Lorem ipsum dolor sit amet', '2021-08-07 12:54:24', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (165, 34, 9, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2014-05-19 19:30:00', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (166, 47, 4, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2012-02-22 18:27:56', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (167, 7, 3, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2019-11-22 11:18:59', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (168, 29, 6, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2012-10-11 09:16:40', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (169, 31, 6, 'Ut enim ad minim veniam', '2021-09-16 04:52:16', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (170, 29, 1, 'Ut enim ad minim veniam', '2019-08-24 15:41:11', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (171, 23, 3, 'Ut enim ad minim veniam', '2019-07-11 16:59:09', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (172, 32, 8, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2013-01-08 13:52:53', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (173, 3, 10, 'Lorem ipsum dolor sit amet', '2021-04-11 00:56:01', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (174, 5, 6, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2012-02-28 07:59:42', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (175, 1, 4, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2018-10-16 05:01:48', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (176, 42, 9, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2019-01-19 02:42:00', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (177, 21, 9, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2014-03-22 07:57:12', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (178, 1, null, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2013-04-18 01:44:57', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (179, 36, null, 'Excepteur sint occaecat cupidatat non proident', '2012-12-08 08:39:17', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (180, 21, null, 'consectetur adipiscing elit.', '2011-06-23 23:07:20', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (181, 4, 3, 'Lorem ipsum dolor sit amet', '2017-12-15 00:29:27', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (182, 49, 1, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2015-03-03 18:37:43', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (183, 19, 5, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2020-12-25 02:26:31', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (184, 48, 1, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2017-05-13 03:14:35', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (185, 25, 3, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2017-05-19 06:19:17', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (186, 13, 10, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2018-03-03 18:39:41', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (187, 9, 7, 'consectetur adipiscing elit.', '2010-11-06 03:48:34', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (188, 12, 8, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2015-06-27 12:14:26', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (189, 2, 3, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2013-04-28 15:22:22', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (190, 8, null, 'consectetur adipiscing elit.', '2018-05-11 02:33:24', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (191, 43, null, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2010-10-09 19:18:24', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (192, 41, 4, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2014-11-25 12:10:20', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (193, 33, 4, 'Lorem ipsum dolor sit amet', '2014-02-25 01:50:39', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (194, 20, null, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2020-12-15 10:14:28', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (195, 21, 9, 'Excepteur sint occaecat cupidatat non proident', '2010-06-20 14:36:06', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (196, 32, 5, 'Lorem ipsum dolor sit amet', '2019-10-15 19:27:24', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (197, 4, 7, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2022-10-12 17:56:14', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (198, 12, 4, 'consectetur adipiscing elit.', '2011-06-06 11:42:11', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (199, 29, null, 'consectetur adipiscing elit.', '2013-05-06 15:01:14', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (200, 9, null, 'Lorem ipsum dolor sit amet', '2013-05-05 00:58:58', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (201, 36, 4, 'Excepteur sint occaecat cupidatat non proident', '2017-03-16 01:14:41', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (202, 19, 8, 'consectetur adipiscing elit.', '2017-03-02 12:54:49', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (203, 43, 2, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2011-07-09 17:21:58', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (204, 6, 7, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2013-10-09 03:09:53', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (205, 38, 5, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2010-11-03 09:26:29', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (206, 2, null, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2014-12-18 03:57:32', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (207, 22, null, 'Excepteur sint occaecat cupidatat non proident', '2022-12-25 17:48:02', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (208, 3, null, 'Ut enim ad minim veniam', '2013-02-06 20:11:30', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (209, 37, 3, 'Lorem ipsum dolor sit amet', '2012-10-02 22:24:41', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (210, 35, 7, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2020-07-24 05:02:46', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (211, 21, 2, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2015-01-21 08:43:00', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (212, 37, 7, 'consectetur adipiscing elit.', '2013-06-08 23:11:06', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (213, 8, 4, 'consectetur adipiscing elit.', '2018-12-19 14:31:33', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (214, 12, 4, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2017-10-16 21:24:28', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (215, 10, 4, 'Lorem ipsum dolor sit amet', '2011-08-03 10:28:43', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (216, 19, 6, 'Excepteur sint occaecat cupidatat non proident', '2019-01-09 11:43:09', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (217, 41, 8, 'consectetur adipiscing elit.', '2019-03-09 09:20:32', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (218, 41, 5, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2018-08-20 05:51:47', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (219, 10, 8, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2012-06-29 06:33:19', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (220, 16, 7, 'Excepteur sint occaecat cupidatat non proident', '2021-08-17 11:50:55', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (221, 37, 7, 'consectetur adipiscing elit.', '2017-09-16 06:06:13', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (222, 24, 10, 'Lorem ipsum dolor sit amet', '2015-10-31 07:53:47', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (223, 9, 3, 'Excepteur sint occaecat cupidatat non proident', '2018-09-30 17:58:58', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (224, 44, 5, 'Excepteur sint occaecat cupidatat non proident', '2018-09-19 16:29:09', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (225, 29, 4, 'consectetur adipiscing elit.', '2018-05-05 22:00:01', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (226, 32, 10, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2021-11-11 09:26:45', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (227, 40, 4, 'Ut enim ad minim veniam', '2010-12-24 03:36:44', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (228, 11, null, 'Lorem ipsum dolor sit amet', '2023-02-18 05:00:31', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (229, 7, 8, 'Ut enim ad minim veniam', '2015-10-22 11:04:54', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (230, 37, 8, 'Excepteur sint occaecat cupidatat non proident', '2013-03-08 14:03:56', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (231, 35, 3, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2020-03-17 09:54:59', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (232, 14, 2, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2016-02-20 01:30:07', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (233, 35, 5, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2014-10-07 06:41:02', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (234, 16, 9, 'Ut enim ad minim veniam', '2020-04-04 18:27:50', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (235, 24, 7, 'Ut enim ad minim veniam', '2018-09-09 08:47:44', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (236, 15, 8, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2017-12-11 17:18:57', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (237, 37, null, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2020-03-14 04:02:28', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (238, 9, 4, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2014-08-22 21:02:26', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (239, 27, 7, 'Excepteur sint occaecat cupidatat non proident', '2011-03-15 20:24:08', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (240, 46, 2, 'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', '2014-05-10 21:59:35', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (241, 44, 4, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2014-03-24 06:24:53', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (242, 48, null, 'Lorem ipsum dolor sit amet', '2020-10-23 08:37:38', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (243, 35, 1, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2020-04-25 19:35:13', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (244, 19, null, 'Excepteur sint occaecat cupidatat non proident', '2013-10-16 04:06:46', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (245, 15, null, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2020-08-15 08:48:01', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (246, 5, null, 'Excepteur sint occaecat cupidatat non proident', '2020-09-14 14:31:10', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (247, 30, 7, 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '2016-06-16 22:45:57', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (248, 27, 5, 'Lorem ipsum dolor sit amet', '2013-06-27 15:25:09', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (249, 34, 1, 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '2014-12-03 23:51:12', false);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (250, 14, 7, 'Ut enim ad minim veniam', '2022-11-15 08:26:50', true);
insert into comments (comment_id, post_id, user_id, comment, creation_date, is_confirmed) values (251, 42, 11, 'sunt in culpa qui officia deserunt mollit anim id est laborum.', '2022-06-26 15:51:53', true);

/* Yapılacak Sorgular */

--Tüm blog yazılarını başlıkları, yazarları ve kategorileriyle birlikte getirin
SELECT posts.title, users.username, categories.name FROM posts
INNER JOIN categories ON posts.category_id = categories.category_id
INNER JOIN users ON posts.user_id = users.user_id;
--En son yayınlanan 5 blog yazısını başlıkları, yazarları ve yayın tarihleriyle birlikte alın
SELECT posts.title, users.username, posts.creation_date FROM posts
INNER JOIN users ON posts.user_id = users.user_id
ORDER BY posts.creation_date DESC
LIMIT 5;
-- Her blog yazısı için yorum sayısını gösterin.
SELECT title,
(
	SELECT COUNT (*) FROM comments WHERE posts.post_id = comments.post_id
) AS count
FROM posts
INNER JOIN comments
ON posts.post_id = comments.post_id;
-- Tüm kayıtlı kullanıcıların kullanıcı adlarını ve e-posta adreslerini gösterin.
SELECT username, email FROM users;
-- En son 10 yorumu, ilgili gönderi başlıklarıyla birlikte alın.
SELECT comments.comment, posts.title
FROM comments
INNER JOIN posts ON comments.post_id = posts.post_id
ORDER BY posts.creation_date DESC
LIMIT 10;
-- Belirli bir kullanıcı tarafından yazılan tüm blog yazılarını bulun.
SELECT users.username, posts.content
FROM users
INNER JOIN posts ON users.user_id = posts.user_id
WHERE users.user_id = 5;
--  Her kullanıcının yazdığı toplam gönderi sayısını alın
SELECT users.username,
(
	SELECT COUNT(*) FROM posts WHERE users.user_id = posts.user_id
) AS post_count
FROM users;
--  Her kategoriyi, kategorideki gönderi sayısıyla birlikte gösterin.
SELECT categories.name,
(
	SELECT COUNT(*) FROM posts
	WHERE categories.category_id = posts.category_id
)
FROM categories;
-- Gönderi sayısına göre en popüler kategoriyi bulun.
SELECT categories.name,
(
	SELECT COUNT(*) FROM posts
	WHERE categories.category_id = posts.category_id
) AS post_count
FROM categories
ORDER BY post_count DESC
LIMIT 1;
--  Gönderilerindeki toplam görüntülenme sayısına göre en popüler kategoriyi bulun.
SELECT categories.name,
(
	SELECT SUM(view_count) FROM posts WHERE posts.category_id = categories.category_id
) AS view_count
FROM categories
ORDER BY view_count DESC
LIMIT 1;
--  En fazla yoruma sahip gönderiyi alın.
SELECT posts.title,
(
	SELECT COUNT(*) FROM comments WHERE comments.post_id = posts.post_id
) AS count_comment
FROM posts
ORDER BY count_comment DESC
LIMIT 1;
--  Belirli bir gönderinin yazarının kullanıcı adını ve e-posta adresini gösterin
SELECT posts.content, users.username, users.email
FROM posts
INNER JOIN users ON posts.user_id = users.user_id
WHERE posts.post_id = 3;
-- Başlık veya içeriklerinde belirli bir anahtar kelime bulunan tüm gönderileri bulun.
SELECT *
FROM posts
WHERE title ILIKE '%lorem%' OR content ILIKE '%lorem%';
--  Belirli bir kullanıcının en son yorumunu gösterin.
SELECT users.username,
(
	SELECT comment
	FROM comments WHERE comments.user_id = users.user_id
	ORDER BY creation_date DESC
	LIMIT 1
)
FROM users
WHERE users.user_id = 6;
--  Gönderi başına ortalama yorum sayısını bulun.
SELECT ROUND(AVG(comment_count), 2) AS count
FROM
(
	SELECT posts.post_id, COUNT(comments.comment_id) AS comment_count
	FROM posts
	INNER JOIN comments ON posts.post_id = comments.post_id
	GROUP BY posts.post_id
) AS post_comments
-- Son 30 günde yayınlanan gönderileri gösterin
SELECT *
FROM posts
WHERE creation_date > NOW() - INTERVAL '30 day';
-- Belirli bir kullanıcının yaptığı yorumları alın
SELECT comments.comment,
(
	SELECT users.username FROM users WHERE comments.user_id = users.user_id
)
FROM comments
WHERE comments.user_id = 6;
-- Belirli bir kategoriye ait tüm gönderileri bulun
SELECT posts.content,
(
	SELECT categories.name FROM categories WHERE categories.category_id = posts.category_id
) AS category
FROM posts
WHERE posts.category_id = 5;
--  5'ten az yazıya sahip kategorileri bulun
SELECT categories.name, post_counts.count_posts
FROM categories
INNER JOIN
(
    SELECT category_id, COUNT(title) AS count_posts
    FROM posts
    GROUP BY category_id
) AS post_counts
ON categories.category_id = post_counts.category_id
WHERE post_counts.count_posts < 5;
--  Hem bir yazı hem de bir yoruma sahip olan kullanıcıları gösterin.
SELECT users.username FROM users
WHERE
(
	SELECT COUNT(*) FROM posts
	WHERE users.user_id = posts.user_id
) > 0
AND
(
	SELECT COUNT(*) FROM comments
	WHERE comments.user_id = comments.user_id
) > 0;
-- En az 2 farklı yazıya yorum yapmış kullanıcıları alın.
SELECT users.username FROM users
WHERE
(
	SELECT DISTINCT COUNT(post_id) FROM comments
	WHERE users.user_id = comments.user_id
) >= 2;
-- En az 3 yazıya sahip kategorileri görüntüleyin.
SELECT categories.name, post_counts.count_posts
FROM categories
INNER JOIN
(
    SELECT category_id, COUNT(title) AS count_posts
    FROM posts
    GROUP BY category_id
) AS post_counts
ON categories.category_id = post_counts.category_id
WHERE post_counts.count_posts >= 3;
-- 5'ten fazla blog yazısı yazan yazarları bulun.
SELECT users.username FROM users
WHERE
(
	SELECT COUNT(*) FROM posts
	WHERE users.user_id = posts.user_id
) > 5;
-- Bir blog yazısı yazmış veya bir yorum yapmış kullanıcıların e-posta adreslerini görüntüleyin. (UNION kullanarak)
(
	SELECT users.email
	FROM users
	WHERE (SELECT COUNT(*) FROM posts WHERE posts.user_id = users.user_id) = 1
)
UNION
(
	SELECT users.email
	FROM users
	WHERE (SELECT COUNT(*) FROM comments WHERE comments.user_id = users.user_id) = 1
);
-- Bir blog yazısı yazmış ancak hiç yorum yapmamış yazarları bulun.
SELECT users.username FROM users
WHERE
(
	SELECT COUNT(*) FROM posts WHERE posts.user_id = users.user_id
) > 0
AND
(
	SELECT COUNT(*) FROM comments WHERE comments.user_id = users.user_id
) = 0;
