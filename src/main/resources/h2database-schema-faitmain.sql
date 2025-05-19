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

-- 가게 테이블
DROP TABLE IF EXISTS store;

CREATE TABLE IF NOT EXISTS store (
	ceonum VARCHAR(32) NOT NULL PRIMARY KEY,
	custid VARCHAR(32) NOT NULL,
	name VARCHAR(32) NOT NULL,
	FOREIGN KEY (custid) REFERENCES customer (id)
);

-- 가게 이미지 테이블
DROP TABLE IF EXISTS storeimg;

CREATE TABLE IF NOT EXISTS storeimg (
	id NUMBER NOT NULL PRIMARY KEY AUTO_INCREMENT,
	ceonum VARCHAR(32) NULL,
	file VARCHAR(36) NULL,
	uuid VARCHAR(36) NULL,
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
	id NUMBER NOT NULL PRIMARY KEY,
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
	FOREIGN KEY (ceonum) REFERENCES store (ceonum)
);

-- 신발(상품) 이미지 테이블
DROP TABLE IF EXISTS shoeimg;

CREATE TABLE IF NOT EXISTS shoeimg (
	id NUMBER NOT NULL PRIMARY KEY,
	shoeid NUMBER NULL,
	file VARCHAR(36) NULL,
	uuid VARCHAR(36) NULL,
	FOREIGN KEY (shoeid) REFERENCES shoe (id)
);


-- 주문 테이블
DROP TABLE IF EXISTS orders;

CREATE TABLE IF NOT EXISTS orders (
	custid VARCHAR(32) NOT NULL PRIMARY KEY,
	ceonum VARCHAR(32) NOT NULL,
	shoeid NUMBER NOT NULL,
	FOREIGN KEY (custid) REFERENCES customer (id),
	FOREIGN KEY (ceonum) REFERENCES store (ceonum),
	FOREIGN KEY (shoeid) REFERENCES shoe (id)
);


-- 현장 테이블
DROP TABLE IF EXISTS reals;

CREATE TABLE IF NOT EXISTS reals (
	custid VARCHAR(32) NOT NULL PRIMARY KEY,
	ceonum VARCHAR(32) NULL,
	shoeid NUMBER  NULL,
	saleprice NUMBER NOT NULL,
	amount NUMBER NOT NULL,
	orderdate DATE NULL,
	reservation DATE NOT NULL,
	FOREIGN KEY (ceonum) REFERENCES store (ceonum),
	FOREIGN KEY (shoeid) REFERENCES shoe (id)
);


-- 온라인 테이블
DROP TABLE IF EXISTS onlines;

CREATE TABLE IF NOT EXISTS onlines (
	custid VARCHAR(32) NOT NULL PRIMARY KEY,
	ceonum VARCHAR(32) NULL,
	shoeid NUMBER NULL,
	saleprice NUMBER NOT NULL,
	amount NUMBER NOT NULL,
	orderdate DATE NULL,
	FOREIGN KEY (ceonum) REFERENCES store (ceonum),
	FOREIGN KEY (shoeid) REFERENCES shoe (id)
);
























