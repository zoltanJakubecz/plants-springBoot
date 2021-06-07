DROP TABLE IF EXISTS listing;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS status;
DROP TABLE IF EXISTS marketplace;


CREATE TABLE location (
  id uuid PRIMARY KEY,
  manager_name VARCHAR(100),
  phone VARCHAR(20),
  address_primary VARCHAR(255),
  address_secondary VARCHAR(255),
  country VARCHAR(100),
  town VARCHAR(100),
  postal_code VARCHAR(20)
);


CREATE TABLE status (
  id INTEGER PRIMARY KEY,
  status_name VARCHAR(200)
);


CREATE TABLE marketplace (
  id INTEGER PRIMARY KEY,
  marketplace_name VARCHAR(200)
);


CREATE TABLE listing (
  id uuid PRIMARY KEY,
  title VARCHAR(100),
  description VARCHAR(255),
  inventory_item_location_id uuid REFERENCES location(id),
  listing_price FLOAT,
  currency VARCHAR(3),
  quantity INTEGER,
  listing_status INTEGER REFERENCES status(id),
  marketplace INTEGER REFERENCES marketplace(id),
  upload_time VARCHAR(20),
  owner_email_address VARCHAR(255)
);



