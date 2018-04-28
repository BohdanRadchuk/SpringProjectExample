INSERT INTO springdata.manufacturers (id, name) VALUES
  ('1', 'LuksSoft'),
  ('2', 'Cogmizamt Techmology'),
  ('3', 'Capgenimi'),
  ('4', 'Hemllet Paskard Emteprpise');
INSERT INTO springdata.products (id, name, price, id_manufacturer) VALUES
  ('1', 'SuperBrowser', 550000, 1),
  ('2', 'mediaPlayer', 30000, 1),
  ('3', 'Printer no toner', 1000000, 4),
  ('4', 'phone', 70000, 3);

INSERT INTO springdata.roles (id, role) VALUES (1, 'ADMIN'), (2, 'USER');

INSERT INTO springdata.users (id, email, password, first_name, last_name) VALUES
  (1, 'adminemail@mail.com', '1234', 'Super', 'Admin'),
  (2, 'useremail@mail.com', '4321', 'Simple', 'User');

INSERT INTO springdata.users_roles VALUES (1, 1), (2, 2);
/*
  INSERT INTO springdata.products (id, NAME, price, id_manufacturer) VALUES
  ('5', 'asd', 6, 6);
*/
SELECT *
FROM springdata.products
WHERE id_manufacturer LIKE (
  SELECT id
  FROM springdata.manufacturers
  WHERE manufacturers.name LIKE
        'LuksSoft');