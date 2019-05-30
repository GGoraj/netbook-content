\connect contentDB

DROP TABLE IF EXISTS Books, Tags, Authors, BooksAuthors, MarkedToRead, BooksTags, BooksTagsTemp;

CREATE TABLE Books
(
  BookId serial NOT NULL,
  GoodReadsBookId INTEGER UNIQUE,
  Isbn TEXT,
  OriginalPublicationYear VARCHAR(7),
  OriginalTitle TEXT,
  InternationalTitle TEXT,
  LanguageCode VARCHAR(5),
  AverageRating DECIMAL,
  RatingsCount INTEGER,
  ImageUrl TEXT,
  SmallImageUrl TEXT,
  PRIMARY KEY (BookId)
);

CREATE TABLE MarkedToRead
(
  UserId INTEGER,
  BookId INTEGER REFERENCES Books(BookId) ON DELETE CASCADE,
  PRIMARY KEY (UserId, BookId)
);


CREATE TABLE Tags
(
  TagId INTEGER,
  TagName TEXT,
  PRIMARY KEY (TagId)
);


CREATE TABLE BooksTagsTemp
(
  GoodReadsBookId Integer,
  TagId Integer,
  Counter Integer
);

CREATE TABLE BooksTags
(
  GoodReadsBookId Integer REFERENCES Books(GoodReadsBookId) ON DELETE CASCADE,
  TagId Integer REFERENCES Tags(TagId) ON DELETE CASCADE,
  Counter INTEGER,
  PRIMARY KEY (TagId, GoodReadsBookId)
);

\COPY books(GoodReadsBookId, Isbn, OriginalPublicationYear, OriginalTitle, InternationalTitle, LanguageCode, AverageRating, RatingsCount, ImageUrl, SmallImageUrl) FROM '/Users/petyabuchkova/Desktop/KEA/dls/netbook-content/database/books_proc.csv' DELIMITER ',' CSV HEADER;


\COPY MarkedToRead(userid, bookid) FROM '/Users/petyabuchkova/Desktop/KEA/dls/netbook-content/database/to_read.csv' DELIMITER ',' CSV HEADER;

\COPY Tags(TagId, TagName) FROM '/Users/petyabuchkova/Desktop/KEA/dls/netbook-content/database/tags.csv' DELIMITER ',' CSV HEADER;

\COPY BooksTagsTemp(GoodReadsBookId, TagId, Counter) FROM '/Users/petyabuchkova/Desktop/KEA/dls/netbook-content/database/bookstags.csv' DELIMITER ',' CSV HEADER;

INSERT INTO BooksTags
SELECT DISTINCT ON
(GoodReadsBookId, TagId) * FROM BooksTagsTemp;
DROP TABLE BooksTagsTemp;

CREATE TABLE Authors
(
  AuthorId serial NOT NULL,
  FullName TEXT,
  PRIMARY KEY (AuthorId)
);

CREATE TABLE BooksAuthors(
  BookId serial NOT NULL REFERENCES books(BookId) ON DELETE RESTRICT,
  AuthorId INTEGER NOT NULL REFERENCES authors
(AuthorId) ON
DELETE NO ACTION,
  PRIMARY KEY
(BookId, AuthorId)
);

\COPY authors(fullname) FROM '/Users/petyabuchkova/Desktop/KEA/dls/netbook-content/database/authors.csv' DELIMITER ',' CSV HEADER;

\COPY booksauthors(bookid, authorid) FROM '/Users/petyabuchkova/Desktop/KEA/dls/netbook-content/database/booksauthors.csv' DELIMITER ',' CSV HEADER;


create extension unaccent;
