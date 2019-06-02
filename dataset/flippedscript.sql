DROP TABLE IF EXISTS User, Book, Tag, Author, authors_books, MarkedToRead, tags_books, books_tags_temp, users_temp, users_ratings_temp, books_temp, tags_temp;


CREATE TABLE User
(
  id serial NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE users_temp
(
  id INTEGER,
  skip1 INTEGER,
  skip2 INTEGER
);

\COPY users_temp(id,skip1,skip2) FROM 'C:\\Users\\Jeffrey\\greggg\\netbook-content\\database\\ratings.csv' DELIMITER ',' CSV HEADER;

INSERT INTO User (id) SELECT DISTINCT ON (users_temp.id) id FROM users_temp ORDER BY id;
DROP TABLE users_temp;

CREATE TABLE Book
(
  id serial NOT NULL,
  goodreadsbookid INTEGER UNIQUE,
  isbn TEXT,
  originalpublicationyear VARCHAR(7),
  originaltitle TEXT,
  internationaltitle TEXT,
  languagecode VARCHAR(5),
  averagerating DECIMAL,
  ratingscount INTEGER,
  imageurl TEXT,
  smallimageurl TEXT,
  PRIMARY KEY (id)
);

CREATE TABLE books_temp
(
  id INTEGER,
  goodreadsbookid INTEGER,
  bestbookid INTEGER,
  workid INTEGER,
  bookscount INTEGER,
  isbn TEXT,
  isbn13 TEXT,
  authors TEXT,
  originalpublicationyear VARCHAR(7),
  originaltitle TEXT,
  internationaltitle TEXT,
  languagecode VARCHAR(5),
  averagerating DECIMAL,
  ratingscount INTEGER,
  workratingscount INTEGER,
  worktextreviewscount INTEGER,
  ratings1 INTEGER,
  ratings2 INTEGER,
  ratings3 INTEGER,
  ratings4 INTEGER,
  ratings5 INTEGER,
  imageurl TEXT,
  smallimageurl TEXT
);


\COPY bookstemp(id,goodreadsbookid,bestbookid,workid,bookscount,isbn,isbn13,authors,originalpublicationyear,originaltitle,internationaltitle,languagecode,averagerating,ratingscount,workratingscount,worktextreviewscount,ratings1,ratings2,ratings3,ratings4,ratings5,imageurl,smallimageurl) FROM 'C:\\Users\\Jeffrey\\greggg\\netbook-content\\database\\books.csv' DELIMITER ',' CSV HEADER;

INSERT INTO Book (id, goodreadsbookid, isbn, originalpublicationyear, originaltitle, internationaltitle, languagecode, averagerating, ratingscount, imageurl, smallimageurl)
SELECT DISTINCT ON (books_temp.id) id, goodreadsbookid, isbn, originalpublicationyear, originaltitle, internationaltitle, languagecode, averagerating, ratingscount, imageurl, smallimageurl FROM books_temp ORDER BY id;
DROP TABLE books_temp;


CREATE TABLE tag(
  id serial NOT NULL,
  tagname TEXT,
  PRIMARY KEY (id)
);

\COPY tag(id, tagname) From '/Users/petyabuchkova/Desktop/KEA/dls/netbook-content/database/tags.csv' DELIMITER ',' CSV HEADER;


CREATE TABLE tags_books(
  book_id INTEGER REFERENCES Book(id) ON DELETE CASCADE,
  tag_id INTEGER REFERENCES Tag(id) ON DELETE CASCADE,
  counter INTEGER,
  PRIMARY KEY (book_id, tag_id));

CREATE TABLE books_tags_temp(
 book_id INTEGER,
 tag_id INTEGER,
 counter INTEGER
);

\COPY books_tags_temp(book_id, tag_id, counter) FROM 'C:\\Users\\Jeffrey\\greggg\\netbook-content\\database\\book_tags.csv' DELIMITER ',' CSV HEADER;

INSERT INTO tags_books SELECT DISTINCT ON (books_tags_temp.book_id, books_tags_temp.tag_id, books_tags_temp.counter) * FROM books_tags_temp ON CONFLICT DO UPSERT;
DROP TABLE books_tags_temp;

CREATE TABLE MarkedToRead(
 id serial NOT Null,
 user_id INTEGER,
 book_id INTEGER REFERENCES book(id) ON DELETE CASCADE,
 PRIMARY KEY (id)
);

\COPY markedtoread(user_id, book_id) FROM '/Users/petyabuchkova/Desktop/KEA/dls/netbook-content/database/to_read.csv' DELIMITER ',' CSV HEADER;


CREATE TABLE ratings(
  user_id INTEGER REFERENCES User(id) ON DELETE CASCADE,
  book_id INTEGER REFERENCES Book(id) ON DELETE CASCADE,
  rating INTEGER,
  PRIMARY KEY (book_id, user_id)
);

CREATE TABLE usersratingstemp(
 user_id INTEGER,
 book_id INTEGER,
 rating INTEGER
);

\COPY usersratingstemp(user_id, book_id, rating) FROM 'C:\\Users\\Jeffrey\\greggg\\netbook-content\\database\\ratings.csv' DELIMITER ',' CSV HEADER;

INSERT INTO ratings SELECT DISTINCT ON (usersratingstemp.user_id, usersratingstemp.book_id) * FROM usersratingstemp;
DROP TABLE usersratingstemp;


CREATE TABLE author(
                       id serial NOT NULL,
                       fullname TEXT,
                       PRIMARY KEY (id)
);

CREATE TABLE authors_books(
  author_id INTEGER NOT NULL REFERENCES author(id) ON DELETE NO ACTION,
  book_id serial NOT NULL REFERENCES book(id) ON DELETE RESTRICT,
  PRIMARY KEY (author_id, book_id)
);

\COPY author(fullname) FROM '/Users/petyabuchkova/Desktop/KEA/dls/netbook-content/database/author.csv' DELIMITER ',' CSV HEADER;

\COPY authors_books(book_id, author_id) FROM '/Users/petyabuchkova/Desktop/KEA/dls/netbook-content/database/booksauthors.csv' DELIMITER ',' CSV HEADER;
