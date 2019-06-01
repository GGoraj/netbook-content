DROP TABLE IF EXISTS Book, Tag, tags_books, Author, authors_books, MarkedToRead;

CREATE TABLE Book
(
  id serial NOT NULL,
  goodreadsbook_id INTEGER UNIQUE,
  isbn TEXT,
  originalpublicationyear VARCHAR(7),
  originaltitle TEXT,
  internationaltitle TEXT,
  languagecode VARCHAR(5),
  averagerating DECIMAL,
  ratingscount INTEGER,
  imageurl TEXT,
  smallimageurl TEXT,
  bookurl TEXT,
  PRIMARY KEY (id)
);

CREATE TABLE MarkedToRead(
  id serial NOT Null,
  user_id INTEGER,
  book_id INTEGER REFERENCES book(id) ON DELETE CASCADE,
  PRIMARY KEY (id)
);


CREATE TABLE tag(
  id INTEGER,
  tagname TEXT,
  PRIMARY KEY (id)
);


CREATE TABLE bookstagstemp(
 goodreadsbook_id Integer,
 tag_id Integer,
 counter Integer
);

CREATE TABLE tags_books(
  goodreadsbook_id Integer REFERENCES book(goodreadsbook_id) ON DELETE CASCADE,
  tag_id Integer REFERENCES tag(id) ON DELETE CASCADE,
  counter INTEGER,
  PRIMARY KEY (goodreadsbook_id, tag_id)
);

\COPY book(goodreadsbook_id, isbn, originalpublicationyear, originaltitle, internationaltitle, languagecode, averagerating, ratingscount, imageurl, smallimageurl) FROM '/Users/petyabuchkova/Desktop/KEA/dls/netbook-content/database/books_proc.csv' DELIMITER ',' CSV HEADER;


\COPY markedtoread(user_id, book_id) FROM '/Users/petyabuchkova/Desktop/KEA/dls/netbook-content/database/to_read.csv' DELIMITER ',' CSV HEADER;

\COPY tag(id, tagname) From '/Users/petyabuchkova/Desktop/KEA/dls/netbook-content/database/tags.csv' DELIMITER ',' CSV HEADER;

\COPY bookstagstemp(goodreadsbook_id, tag_id, counter) From '/Users/petyabuchkova/Desktop/KEA/dls/netbook-content/database/bookstags.csv' DELIMITER ',' CSV HEADER;

INSERT INTO tags_books SELECT DISTINCT ON (bookstagstemp.goodreadsbook_id, bookstagstemp.tag_id) * FROM BooksTagsTemp;
DROP TABLE BooksTagsTemp;

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