/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 * Created: 19 de nov. de 2023
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Claudio Alcantara &lt;claudio.alcantara at ifnmg.edi.br&gt;
 * Created: 12 de nov. de 2023
 */

CREATE TABLE credential(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(15) NOT NULL UNIQUE,
    password VARCHAR(32) NOT NULL,
    lastAccess DATE,
    enabled BOOLEAN,
    user BIGINT
);

CREATE TABLE user(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(255) NOT NULL,
    birthdate DATE,
    role BIGINT    
);

CREATE TABLE role(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE reader(
    id BIGINT PRIMARY KEY
);

CREATE TABLE librarian(
    id BIGINT PRIMARY KEY
);

CREATE TABLE admin(
    id BIGINT PRIMARY KEY
);

CREATE TABLE book(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(150) NOT NULL,
    authors VARCHAR(250) NOT NULL,
    pages SMALLINT,
    year SMALLINT NOT NULL,
    edition TINYINT
);

CREATE TABLE copy(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    available  BOOLEAN,
    conditionn VARCHAR(150),
    acquisition DATE,
    idbook BIGINT
);

CREATE TABLE comment(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    comment VARCHAR(500),
    idreader BIGINT    
);

CREATE TABLE loan(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    dataDoEmprestimo DATE,
    dataDaDevolução DATE,
    idlibrarian BIGINT,
    idreader BIGINT
);

CREATE TABLE copies(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    idloan BIGINT,
    idcopy BIGINT
);

ALTER TABLE credential ADD FOREIGN KEY (user) REFERENCES user(id);
ALTER TABLE user ADD FOREIGN KEY (role) REFERENCES role(id);
ALTER TABLE reader ADD FOREIGN KEY (id) REFERENCES user(id);
ALTER TABLE librarian ADD FOREIGN KEY (id) REFERENCES user(id);
ALTER TABLE admin ADD FOREIGN KEY (id) REFERENCES user(id);
ALTER TABLE copy ADD FOREIGN KEY (idbook) REFERENCES book(id);
ALTER TABLE comment ADD FOREIGN KEY (idreader) REFERENCES reader(id);
ALTER TABLE loan ADD FOREIGN KEY (idreader) REFERENCES reader(id);
ALTER TABLE loan ADD FOREIGN KEY (idlibrarian) REFERENCES librarian(id);
ALTER TABLE copies ADD FOREIGN KEY (idloan) REFERENCES loan(id);
ALTER TABLE copies ADD FOREIGN KEY (idcopy) REFERENCES copy(id);