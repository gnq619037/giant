DROP TABLE IF EXISTS t_system_user;
create table t_system_user(
  id          int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username    VARCHAR(20),
  password    VARCHAR(100),
  address     VARCHAR(100),
  email       VARCHAR(100),
  nick_name   VARCHAR(20)
);