-- customer 더미값 --
INSERT INTO customer (id, password, name, address, phone, birth)
VALUES ('kopo', 'pass', '홍길동', '서울시', '010-1234-5678', '1990-01-01');

-- store 더미 값 --
INSERT INTO store (ceonum, custid, name, address)
VALUES ('123-45-567-8', 'kopo', 'ABC매장', '대전광역시 서구 둔산남로 175번길 19');

-- storeimg 더미값 --
INSERT INTO storeimg (ceonum, file, uuid)
VALUES ('123-45-567-8', 'first.jpeg', '2ac33236-1993-4f78-9fc9-121aff094206');

-- shoe 더미값 --
INSERT INTO shoe (ceonum, name, price, detail, category)
VALUES ('123-45-567-8', '홍길동', 1324, '안녕하세요', '옥스포드');

-- shoeimg 더미값 --
INSERT INTO shoeimg (shoeid, file, uuid)
VALUES (1, 'first.jpeg', '2ac33236-1993-4f78-9fc9-121aff094206');

-- maker 더미값 --
INSERT INTO maker (ceonum, name, info, file, uuid)
VALUES ('123-45-567-8', '홍길동', '안녕하세요', 'first.jpeg', '2ac33236-1993-4f78-9fc9-121aff094206');
