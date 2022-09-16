DROP TABLE IF EXISTS prices;

CREATE TABLE prices (
price_Id INT AUTO_INCREMENT  PRIMARY KEY,
brand_Id long NOT NULL,
start_Date timestamp NOT NULL,
end_Date timestamp NOT NULL,
price_list long NOT NULL,
product_Id long NOT NULL,
priority long NOT NULL,
price double,
curr varchar(3)
);
