DROP TABLE IF EXISTS Books, MarkedToRead;
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

CREATE TABLE MarkedToRead(
  UserId INTEGER,
  BookId INTEGER REFERENCES Books(BookId) ON DELETE CASCADE,
  PRIMARY KEY (UserId, BookId)
);


COPY books(GoodReadsBookId, Isbn, OriginalPublicationYear, OriginalTitle,
InternationalTitle, LanguageCode, AverageRating,
RatingsCount, ImageUrl, SmallImageUrl)
FROM '/home/quenar/Desktop/DLS/Project/postgres_db/netbook_monolith_database/books_proc.csv' DELIMITER ',' CSV HEADER;


COPY MarkedToRead(userid, bookid) 
FROM '/home/quenar/Desktop/DLS/Project/postgres_db/netbook_monolith_database/to_read.csv' DELIMITER ',' CSV HEADER;




