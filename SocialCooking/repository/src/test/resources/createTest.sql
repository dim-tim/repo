-- -----------------------------------------------------
-- Table section
-- -----------------------------------------------------
CREATE  TABLE  section (
  id_section INT NOT NULL AUTO_INCREMENT ,
  name_section VARCHAR(40) NOT NULL ,
  description VARCHAR(250) NULL ,
  PRIMARY KEY (id_section) )
;


-- -----------------------------------------------------
-- Table app_comment
-- -----------------------------------------------------
CREATE  TABLE  app_comment (
  id_comment INT NOT NULL AUTO_INCREMENT ,
  content TEXT NOT NULL ,
  date TIMESTAMP NOT NULL,
  positive_marks INT,
  negative_marks INT,
  PRIMARY KEY (id_comment))
;

-- -----------------------------------------------------
-- Table delivery
-- -----------------------------------------------------
CREATE  TABLE  delivery (
  id_delivery INT NOT NULL AUTO_INCREMENT ,
  price INT NOT NULL ,
  is_prepared TINYINT(1) NOT NULL ,
  delivery_price INT NOT NULL ,
  PRIMARY KEY (id_delivery))
;

-- -----------------------------------------------------
-- Table ingredient
-- -----------------------------------------------------
CREATE  TABLE  ingredient (
  id_ingredient INT NOT NULL AUTO_INCREMENT ,
  name_ingredient VARCHAR(250) NOT NULL ,
  comment VARCHAR(250) NULL ,
  quantity VARCHAR(100) NOT NULL ,
  PRIMARY KEY (id_ingredient))
;

-- -----------------------------------------------------
-- Table provider
-- -----------------------------------------------------
CREATE  TABLE  provider (
  id_provider INT NOT NULL AUTO_INCREMENT ,
  provider_name VARCHAR(100) NOT NULL ,
  terms_of_delivery TEXT NOT NULL ,
  about_company TEXT NULL ,
  accepted TINYINT(1) NOT NULL ,
  registration_date TIMESTAMP NOT NULL,
  positive_marks INT,
  negative_marks INT,
  PRIMARY KEY (id_provider))
;

-- -----------------------------------------------------
-- Table recipe
-- -----------------------------------------------------
CREATE  TABLE  recipe (
  id_recipe INT NOT NULL AUTO_INCREMENT ,
  recipe_name VARCHAR(40) NOT NULL ,
  photo_path VARCHAR(50)  ,
  description LONGTEXT NOT NULL ,
  accepted TINYINT(1) NULL ,
  positive_marks INT,
  negative_marks INT,
  PRIMARY KEY (id_recipe))
;

-- -----------------------------------------------------
-- Table role
-- -----------------------------------------------------
CREATE  TABLE  role (
  id_role INT NOT NULL AUTO_INCREMENT ,
  role_name VARCHAR(30) NOT NULL ,
  description VARCHAR(250) NULL ,
  PRIMARY KEY (id_role) )
;

-- -----------------------------------------------------
-- Table order
-- -----------------------------------------------------

CREATE TABLE app_order (
   id_order INT NOT NULL AUTO_INCREMENT ,
   date TIMESTAMP NOT NULL ,
   PRIMARY KEY (id_order)
);

-- -----------------------------------------------------
-- Table app_user
-- -----------------------------------------------------
CREATE  TABLE  app_user (
  id_app_user INT NOT NULL AUTO_INCREMENT ,
  user_login VARCHAR(20) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  name VARCHAR(45) NOT NULL ,
  surname VARCHAR(45) NOT NULL ,
  email VARCHAR(150) NOT NULL ,
  photo_path VARCHAR(50) NULL ,
  birth_date DATE NULL ,
  gender VARCHAR(40) NULL ,
  telephone INT ,
  country VARCHAR(45) NULL ,
  city VARCHAR(45) NULL ,
  address VARCHAR(45) NULL ,
  about LONGTEXT NULL ,
  positive_marks INT ,
  negative_marks INT ,
  registration_date DATE NOT NULL ,
  PRIMARY KEY (id_app_user) )

;

