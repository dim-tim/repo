-- -----------------------------------------------------
-- Table app_user
-- -----------------------------------------------------
CREATE  TABLE  app_user (
  id_app_user INT NOT NULL AUTO_INCREMENT,
  user_login VARCHAR(20) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  name VARCHAR(45) NOT NULL ,
  surname VARCHAR(45) NOT NULL ,
  email VARCHAR(150) NOT NULL ,
  birth_date DATE NULL ,
  gender VARCHAR(20) NULL ,
  telephone INT NULL ,
  country VARCHAR(45) NULL ,
  city VARCHAR(45) NULL ,
  address VARCHAR(45) NULL ,
  about LONGTEXT NULL ,
  registration_date DATE NOT NULL ,
  photo_path VARCHAR(45) NULL ,
  positive_marks INT NULL ,
  negative_marks INT NULL ,
  UNIQUE INDEX login_UNIQUE (user_login ASC) ,
  PRIMARY KEY (id_app_user) );



-- -----------------------------------------------------
-- Table role
-- -----------------------------------------------------
CREATE  TABLE role (
  id_role INT NOT NULL AUTO_INCREMENT,
  role_name VARCHAR(30) NULL ,
  description VARCHAR(250) NULL ,
  PRIMARY KEY (id_role) );


-- -----------------------------------------------------
-- Table app_user_has_role
-- -----------------------------------------------------
CREATE  TABLE app_user_has_role (
  id_role_fk INT NOT NULL ,
  id_app_user_fk INT NOT NULL ,
  PRIMARY KEY (id_role_fk, id_app_user_fk) ,
  CONSTRAINT fk_role_has_app_user_role1
    FOREIGN KEY (id_role_fk )
    REFERENCES role (id_role )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_role_has_app_user_app_user1
    FOREIGN KEY (id_app_user_fk )
    REFERENCES app_user (id_app_user )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

