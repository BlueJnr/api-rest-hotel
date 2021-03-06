DROP TABLE IF EXISTS room;
CREATE TABLE room (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  type VARCHAR(250) NOT NULL,
  state VARCHAR(250) NOT NULL,
  occupants INT NOT NULL
);

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  rol VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS reservation;
CREATE TABLE reservation (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_id INT NOT NULL,
  room_id INT NOT NULL
);

INSERT INTO room (type, state, occupants) VALUES
  ('STANDARD', 'FREE', 3),
  ('NORMAL', 'MAINTENANCE', 2),
  ('NORMAL', 'OCCUPIED', 1),
  ('SUITE', 'CLEANING', 5);

INSERT INTO user (rol) VALUES
  ('MANAGER'),
  ('RECEPTIONIST'),
  ('CLIENT');

INSERT INTO reservation (user_id, room_id) VALUES
  (1, 2),
  (2, 3);