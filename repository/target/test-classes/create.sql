-- -----------------------------------------------------
-- Table app_user
-- -----------------------------------------------------
CREATE  TABLE  app_user (
  id_app_user BIGINT NOT NULL AUTO_INCREMENT ,
  user_login VARCHAR(20) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  name VARCHAR(45) NOT NULL ,
  surname VARCHAR(45) NOT NULL ,
  email VARCHAR(150) NOT NULL ,
  birth_date DATE NULL ,
  gender VARCHAR(20) NULL ,
  telephone MEDIUMTEXT NULL ,
  country VARCHAR(45) NULL ,
  city VARCHAR(45) NULL ,
  address VARCHAR(45) NULL ,
  about LONGTEXT NULL ,
  registration_date DATE NOT NULL ,
  photo_path VARCHAR(45) NULL ,
  positive_marks INT NULL ,
  negative_marks INT NULL ,
  UNIQUE INDEX login_UNIQUE (user_login ASC) ,
  PRIMARY KEY (id_app_user) )
;


-- -----------------------------------------------------
-- Table role
-- -----------------------------------------------------
CREATE  TABLE  role (
  id_role BIGINT NOT NULL AUTO_INCREMENT ,
  role_name VARCHAR(30) NULL ,
  description VARCHAR(250) NULL ,
  PRIMARY KEY (id_role) )
;


-- -----------------------------------------------------
-- Table section
-- -----------------------------------------------------
CREATE  TABLE  section (
  id_section BIGINT NOT NULL AUTO_INCREMENT ,
  name_section VARCHAR(40) NULL ,
  description VARCHAR(250) NULL ,
  PRIMARY KEY (id_section) )
;


-- -----------------------------------------------------
-- Table recipe
-- -----------------------------------------------------
CREATE  TABLE  recipe (
  id_recipe BIGINT NOT NULL AUTO_INCREMENT ,
  recipe_name VARCHAR(40) NULL ,
  photo_path VARCHAR(50) NULL ,
  description LONGTEXT NOT NULL ,
  accepted TINYINT(1) NULL ,
  positive_marks INT NULL ,
  negative_marks INT NULL ,
  id_app_user_fk BIGINT NOT NULL ,
  id_section_fk BIGINT NOT NULL ,
  PRIMARY KEY (id_recipe) ,

  CONSTRAINT fk_recipe_app_user1
    FOREIGN KEY (id_app_user_fk )
    REFERENCES app_user (id_app_user )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_recipe_section1
    FOREIGN KEY (id_section_fk )
    REFERENCES section (id_section )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table ingredient
-- -----------------------------------------------------
CREATE  TABLE  ingredient (
  id_ingredient BIGINT NOT NULL AUTO_INCREMENT ,
  name_ingredient VARCHAR(250) NOT NULL ,
  comment VARCHAR(250) NULL ,
  quantity VARCHAR(100) NOT NULL ,
  id_recipe_fk BIGINT NOT NULL ,
  PRIMARY KEY (id_ingredient) ,
  CONSTRAINT fk_ingredient_recipe1
    FOREIGN KEY (id_recipe_fk )
    REFERENCES recipe (id_recipe )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table provider
-- -----------------------------------------------------
CREATE  TABLE  provider (
  id_provider BIGINT NOT NULL AUTO_INCREMENT,
  provider_name VARCHAR(100) NULL ,
  terms_of_delivery TEXT NOT NULL ,
  about_company TEXT NULL ,
  accepted TINYINT(1) NULL ,
  registration_date DATE NULL ,
  positive_marks INT NULL ,
  negative_marks INT NULL ,
  id_app_user_fk BIGINT NOT NULL ,
  PRIMARY KEY (id_provider) ,
  CONSTRAINT fk_provider_app_user1
    FOREIGN KEY (id_app_user_fk )
    REFERENCES app_user (id_app_user )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table delivery
-- -----------------------------------------------------
CREATE  TABLE  delivery (
  id_delivery BIGINT NOT NULL AUTO_INCREMENT ,
  price INT NOT NULL ,
  is_prepared TINYINT(1) NOT NULL ,
  delivery_price INT NOT NULL ,
  id_provider_fk BIGINT NOT NULL ,
  PRIMARY KEY (id_delivery) ,
  CONSTRAINT fk_delivery_provider1
    FOREIGN KEY (id_provider_fk )
    REFERENCES provider (id_provider )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table app_comment
-- -----------------------------------------------------
CREATE  TABLE  app_comment (
  id_app_comment BIGINT NOT NULL AUTO_INCREMENT ,
  content TEXT NOT NULL ,
  date DATETIME NOT NULL ,
  positive_marks INT NULL ,
  negative_marks INT NULL ,
  id_recipe_fk BIGINT NOT NULL ,
  id_app_user_fk BIGINT NOT NULL ,
  PRIMARY KEY (id_app_comment) ,
  CONSTRAINT fk_app_comment_recipe1
    FOREIGN KEY (id_recipe_fk )
    REFERENCES recipe (id_recipe )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_app_comment_app_user1
    FOREIGN KEY (id_app_user_fk )
    REFERENCES app_user (id_app_user )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table user_order
-- -----------------------------------------------------
CREATE  TABLE  user_order (
  id_user_order BIGINT NOT NULL AUTO_INCREMENT ,
  date DATETIME NOT NULL ,
  id_delivery_fk BIGINT NOT NULL ,
  id_app_user_fk BIGINT NOT NULL ,
  PRIMARY KEY (id_user_order) ,
  CONSTRAINT fk_order_delivery1
    FOREIGN KEY (id_delivery_fk )
    REFERENCES delivery (id_delivery )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_order_app_user1
    FOREIGN KEY (id_app_user_fk )
    REFERENCES app_user (id_app_user )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table app_user_has_role
-- -----------------------------------------------------
CREATE  TABLE  app_user_has_role (
  id_role_fk BIGINT NOT NULL ,
  id_app_user_fk BIGINT NOT NULL ,
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


-- -----------------------------------------------------
-- Table delivery_has_recipe
-- -----------------------------------------------------
CREATE  TABLE  delivery_has_recipe (
  id_delivery_fk BIGINT NOT NULL ,
  id_recipe_fk BIGINT NOT NULL ,
  PRIMARY KEY (id_delivery_fk, id_recipe_fk) ,
  CONSTRAINT fk_delivery_has_recipe_delivery1
    FOREIGN KEY (id_delivery_fk )
    REFERENCES delivery (id_delivery )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_delivery_has_recipe_recipe1
    FOREIGN KEY (id_recipe_fk )
    REFERENCES recipe (id_recipe )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


