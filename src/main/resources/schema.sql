DROP TABLE IF EXIST listing;
DROP TABLE IF EXIST location;
DROP TABLE IF EXIST status;
DROP TABLE IF EXIST marketplace;



CREATE TABLE location (
  id uuid PRIMARY KEY,
  manager_name VARCHAR(100),
  phone VARCHAR(20)
  address_primary VARCHAR(255),
  address_secondary VARCHAR(255),
  country VARCHAR(100),
  town VARCHAR(100),
  postal_code VARCHAR(20)
)


CREATE TABLE status (
  id INTEGER PRIMARY KEY,
  status_name VARCHAR(200)
)


CREATE TABLE marketplace (
  id INTEGER PRIMARY KEY,
  marketplace_name VARCHAR(200)
)




CREATE TABLE listing (
  id uuid PRIMARY KEY,
  title VARCHAR(100),
  description VARCHAR(100),
  invertory_item_location uuid REFERENCES location(id),
  listing_price FLOAT,
  currency VARCHAR(3),
  quantity INTEGER,
  listing_status INTEGER REFERENCES status(id),
  marketplace INTEGER REFERENCES marketplace(id),
  upload_time TIMESTAMP,
  owner_email_address VARCHAR(255)
)



