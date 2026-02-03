-- 테이블 만들기
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100).
    price INT
);

-- 데이터 넣기
INSERT INTO products (name, price) VALUES ('아이스 아메리카노', 4500);
INSERT INTO products (name, price) VALUES ('카페라뗴', 5000);
INSERT INTO products (name, price) VALUES ('치즈 케이크', 6500);

-- 데이터 수정 및 삭제
UPDATE products SET price = 5000 WHERE id = 1;
DELETE FROM products WHERE id = 3;

-- 조회
SELECT * FROM products