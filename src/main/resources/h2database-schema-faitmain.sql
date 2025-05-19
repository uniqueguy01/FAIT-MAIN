-- 고객 테이블
DROP TABLE IF EXISTS customer;

CREATE TABLE IF NOT EXISTS customer (
    id VARCHAR(32) NOT NULL PRIMARY KEY,
    password VARCHAR(32) NOT NULL,
    name VARCHAR(32) NOT NULL,
    address VARCHAR(64) NOT NULL,
    phone VARCHAR(32) NOT NULL,
    birth DATE NULL
);

-- 권한 테이블
DROP TABLE IF EXISTS authority;

CREATE TABLE IF NOT EXISTS authority (
    code INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    authority VARCHAR(32) NOT NULL,
    subject VARCHAR(64) NOT NULL
);

-- 권한 부여 테이블
DROP TABLE IF EXISTS role;

CREATE TABLE IF NOT EXISTS role (
    code INT NOT NULL AUTO_INCREMENT,
    custid VARCHAR(32) NOT NULL,
    authority_code INT NOT NULL,
    PRIMARY KEY(custid, authority_code),
    FOREIGN KEY (custid) REFERENCES customer (id),
    FOREIGN KEY (authority_code) REFERENCES authority (code)
);

-- 가게 테이블
DROP TABLE IF EXISTS store;

CREATE TABLE IF NOT EXISTS store (
    ceonum VARCHAR(32) NOT NULL PRIMARY KEY,
    custid VARCHAR(32) NOT NULL,
    name VARCHAR(32) NOT NULL,
    address VARCHAR(64) NOT NULL,
    FOREIGN KEY (custid) REFERENCES customer (id)
);


-- 가게 이미지 테이블
DROP TABLE IF EXISTS storeimg;

CREATE TABLE IF NOT EXISTS storeimg (
    id NUMBER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ceonum VARCHAR(32) NOT NULL,
    file VARCHAR(32) NOT NULL,
    uuid VARCHAR(36) NOT NULL,
    FOREIGN KEY (ceonum) REFERENCES store (ceonum)
);

-- 작가 테이블(이미지 정보 포함)
DROP TABLE IF EXISTS maker;

CREATE TABLE IF NOT EXISTS maker(
	id NUMBER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	ceonum VARCHAR(32) NOT NULL,
	name VARCHAR(32) NOT NULL,
	info TEXT,
	file VARCHAR(32) NOT NULL,
    uuid VARCHAR(36) NOT NULL,
	FOREIGN KEY (ceonum) REFERENCES store (ceonum)
);

-- 발 테이블
DROP TABLE IF EXISTS foot;

CREATE TABLE IF NOT EXISTS foot (
	custid VARCHAR(32) NOT NULL PRIMARY KEY,
	size NUMBER NOT NULL,
	shape VARCHAR(32) NOT NULL,
	insole VARCHAR(32) NOT NULL,
	FOREIGN KEY (custid) REFERENCES customer (id)
);

-- 발 이미지 테이블
DROP TABLE IF EXISTS footimg;

CREATE TABLE IF NOT EXISTS footimg (
    id NUMBER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    custid VARCHAR(32) NULL,
    file VARCHAR(36) NULL,
	uuid VARCHAR(36) NULL,
    FOREIGN KEY (custid) REFERENCES foot (custid)
);

-- 신발(상품) 테이블
DROP TABLE IF EXISTS shoe;

CREATE TABLE IF NOT EXISTS shoe (
    id NUMBER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ceonum VARCHAR(32) NULL,
    name VARCHAR(32) NULL,
    price NUMBER NULL,
    detail VARCHAR(255) NULL,
    category VARCHAR(32) NOT NULL,
    FOREIGN KEY (ceonum) REFERENCES store (ceonum)
);

-- 신발(상품) 이미지 테이블
DROP TABLE IF EXISTS shoeimg;

CREATE TABLE IF NOT EXISTS shoeimg (
    id NUMBER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    shoeid NUMBER NULL,
    file VARCHAR(32) NULL,
    uuid VARCHAR(36) NULL,
    FOREIGN KEY (shoeid) REFERENCES shoe (id)
);

-- 리뷰 테이블
DROP TABLE IF EXISTS review;

CREATE TABLE IF NOT EXISTS review (
    id NUMBER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ceonum VARCHAR(32),
    custid VARCHAR(32),
    rating INT,
    content TEXT,
    regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ceonum) REFERENCES store(ceonum),
    FOREIGN KEY (custid) REFERENCES customer(id)
);

-- 리뷰 이미지 테이블
DROP TABLE IF EXISTS reviewimg;

CREATE TABLE IF NOT EXISTS reviewimg (
    id NUMBER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    reviewid NUMBER NULL,
    file VARCHAR(32) NULL,
    uuid VARCHAR(36) NULL,
    FOREIGN KEY (reviewid) REFERENCES review (id)
);

-- 주문 테이블
DROP TABLE IF EXISTS orders;

CREATE TABLE IF NOT EXISTS orders (
	id NUMBER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    custid VARCHAR(32) NOT NULL,
    ceonum VARCHAR(32) NOT NULL,
    shoeid NUMBER NOT NULL,
    FOREIGN KEY (custid) REFERENCES customer (id),
    FOREIGN KEY (ceonum) REFERENCES store (ceonum),
    FOREIGN KEY (shoeid) REFERENCES shoe (id)
);

-- 현장 테이블
DROP TABLE IF EXISTS real;

CREATE TABLE IF NOT EXISTS real (
	id NUMBER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    custid VARCHAR(32) NOT NULL,
    ceonum VARCHAR(32) NULL,
    shoeid NUMBER NULL,
    saleprice NUMBER NOT NULL,
    amount NUMBER NOT NULL,
    orderdate DATE NULL,
    reservation DATE NOT NULL,
    FOREIGN KEY (ceonum) REFERENCES store (ceonum),
    FOREIGN KEY (shoeid) REFERENCES shoe (id)
);

-- 온라인 테이블
DROP TABLE IF EXISTS online;

CREATE TABLE IF NOT EXISTS online (
    custid VARCHAR(32) NOT NULL PRIMARY KEY,
    ceonum VARCHAR(32) NULL,
    shoeid NUMBER NULL,
    saleprice NUMBER NOT NULL,
    amount NUMBER NOT NULL,
    orderdate DATE NULL,
    FOREIGN KEY (custid) REFERENCES customer (id),
	FOREIGN KEY (ceonum) REFERENCES store (ceonum),
	FOREIGN KEY (shoeid) REFERENCES shoe (id)
);