CREATE TABLE PRICES (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
brand_id INT,
start_date VARCHAR(255),
end_date VARCHAR(255),
price_list INT,
product_id INT,
priority INT,
price FLOAT,
curr VARCHAR(3)
);
