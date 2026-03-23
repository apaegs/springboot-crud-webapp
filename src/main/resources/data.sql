INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'Inception', 'A thief who steals corporate secrets through dream-sharing technology is given the inverse task of planting an idea.', 'Christopher Nolan', '2010-07-16', 148
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'Inception' AND director = 'Christopher Nolan');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'The Dark Knight', 'When the menace known as the Joker wreaks havoc on Gotham, Batman must accept one of the greatest psychological tests of his ability to fight injustice.', 'Christopher Nolan', '2008-07-18', 152
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'The Dark Knight' AND director = 'Christopher Nolan');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'Interstellar', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity survival.', 'Christopher Nolan', '2014-11-07', 169
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'Interstellar' AND director = 'Christopher Nolan');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'The Shawshank Redemption', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', 'Frank Darabont', '1994-09-23', 142
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'The Shawshank Redemption' AND director = 'Frank Darabont');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'The Godfather', 'The aging patriarch of an organized crime dynasty transfers control of his empire to his reluctant son.', 'Francis Ford Coppola', '1972-03-24', 175
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'The Godfather' AND director = 'Francis Ford Coppola');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'Pulp Fiction', 'The lives of two mob hitmen, a boxer, a gangster and his wife intertwine in four tales of violence and redemption.', 'Quentin Tarantino', '1994-10-14', 154
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'Pulp Fiction' AND director = 'Quentin Tarantino');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'Schindlers List', 'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce.', 'Steven Spielberg', '1993-12-15', 195
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'Schindlers List' AND director = 'Steven Spielberg');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'The Lord of the Rings: The Fellowship of the Ring', 'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring.', 'Peter Jackson', '2001-12-19', 178
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'The Lord of the Rings: The Fellowship of the Ring' AND director = 'Peter Jackson');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'Forrest Gump', 'The presidencies of Kennedy and Johnson, the Vietnam War, and other historical events unfold from the perspective of an Alabama man.', 'Robert Zemeckis', '1994-07-06', 142
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'Forrest Gump' AND director = 'Robert Zemeckis');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'Fight Club', 'An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.', 'David Fincher', '1999-10-15', 139
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'Fight Club' AND director = 'David Fincher');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'Goodfellas', 'The story of Henry Hill and his life in the mob, covering his marriage and his life of crime.', 'Martin Scorsese', '1990-09-19', 146
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'Goodfellas' AND director = 'Martin Scorsese');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'The Matrix', 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.', 'Lana Wachowski', '1999-03-31', 136
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'The Matrix' AND director = 'Lana Wachowski');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'Se7en', 'Two detectives hunt a serial killer who uses the seven deadly sins as his modus operandi.', 'David Fincher', '1995-09-22', 127
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'Se7en' AND director = 'David Fincher');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'The Silence of the Lambs', 'A young FBI cadet must receive the help of an incarcerated and manipulative cannibal killer to catch another serial killer.', 'Jonathan Demme', '1991-02-14', 118
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'The Silence of the Lambs' AND director = 'Jonathan Demme');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'Saving Private Ryan', 'Following the Normandy Landings, a group of U.S. soldiers go behind enemy lines to retrieve a paratrooper whose brothers have been killed in action.', 'Steven Spielberg', '1998-07-24', 169
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'Saving Private Ryan' AND director = 'Steven Spielberg');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'Gladiator', 'A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.', 'Ridley Scott', '2000-05-05', 155
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'Gladiator' AND director = 'Ridley Scott');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'The Departed', 'An undercover cop and a mole in the police attempt to identify each other while infiltrating an Irish gang in South Boston.', 'Martin Scorsese', '2006-10-06', 151
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'The Departed' AND director = 'Martin Scorsese');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'Whiplash', 'A promising young drummer enrolls at a cut-throat music conservatory where his dreams of greatness are mentored by an instructor who will stop at nothing.', 'Damien Chazelle', '2014-10-10', 107
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'Whiplash' AND director = 'Damien Chazelle');

INSERT INTO movie (title, description, director, release_date, duration)
SELECT 'Parasite', 'Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.', 'Bong Joon-ho', '2019-05-30', 132
    WHERE NOT EXISTS (SELECT 1 FROM movie WHERE title = 'Parasite' AND director = 'Bong Joon-ho');
