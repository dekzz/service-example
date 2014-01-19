CREATE TABLE members (
  id int NOT NULL,
  firstname varchar(30) NOT NULL DEFAULT '',
  lastname varchar(30) NOT NULL DEFAULT '',
  email varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (id)
);

INSERT INTO MEMBERS VALUES(1,'Luka', 'Kos', 'luka.kos@foi.hr');
INSERT INTO MEMBERS VALUES(2,'Pero', 'Peric', 'pero.peric@foi.hr');
INSERT INTO MEMBERS VALUES(3,'Ivan', 'Horvat', 'ivan.horvat@foi.hr');
INSERT INTO MEMBERS VALUES(4,'Tomislav', 'Bozic', 'tomislav.bozic@foi.hr');

CREATE TABLE books (
  isbn BIGINT NOT NULL,
  title varchar(30) NOT NULL DEFAULT '',
  author varchar(30) NOT NULL DEFAULT '',
  available boolean NOT NULL DEFAULT TRUE,
  PRIMARY KEY (isbn)
);

INSERT INTO BOOKS VALUES(9789533247281,'The Game', 'Anres De La Motte', false);
INSERT INTO BOOKS VALUES(9789533245874,'Smijesna povijest svijeta', 'Erik Sass and Steve Wiegand', true);
INSERT INTO BOOKS VALUES(9789533246642,'Portret Špijunke', 'Daniel Silva', true);
INSERT INTO BOOKS VALUES(9780062119698,'Nemeza', 'Jo Nesbo', false);

CREATE TABLE loan (
  isbn BIGINT NOT NULL,
  id int NOT NULL,
  loandate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (isbn,id),
  CONSTRAINT isbnFK FOREIGN KEY (isbn) REFERENCES books (isbn),
  CONSTRAINT idFK FOREIGN KEY (id) REFERENCES members (id)
);

INSERT INTO LOAN VALUES(9789533247281, 1, DEFAULT);
INSERT INTO LOAN VALUES(9780062119698, 3, DEFAULT);
