-- customer 더미값 --
INSERT INTO customer (id, password, name, address, phone, birth) 
VALUES ('user01', 'pass1234', '장관협', '대전시 동구', '010-1234-5678', '2006-12-12'),
	   ('user02', 'pass5678', '정근화', '대전시 유성구', '010-4321-5678', '2007-03-01'),
	   ('user03', 'test4321', '최현', '대전시 중구', '010-3456-7890', '2006-03-02'),
	   ('1234', '1234', '관리자', '대전', '010-1234-5678', '2005-03-02');

-- store 더미 값 --
INSERT INTO store (ceonum, custid, name, address)
VALUES ('123-45-567-8', 'user01', 'ABC매장', '대전광역시 서구 둔산남로 175번길 19');

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
