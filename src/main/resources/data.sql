DROP TABLE IF EXISTS room;

CREATE TABLE room (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  type VARCHAR(250) NOT NULL,
  state VARCHAR(250) NOT NULL
);

INSERT INTO room (type, state) VALUES
  ('standard', 'libre'),
  ('normal', 'ocupada'),
  ('suite', 'limpieza');