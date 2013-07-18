-- -----------------------------------------------------
-- Table app_user
-- -----------------------------------------------------
CREATE  TABLE  app_user (
  user_login VARCHAR(20) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  name VARCHAR(45) NOT NULL ,
  surname VARCHAR(45) NOT NULL ,
  email VARCHAR(150) NOT NULL ,
  photo BLOB NULL ,
  birth_date DATE NULL ,
  gender TINYINT(1) NULL ,
  telephone MEDIUMTEXT NULL ,
  country VARCHAR(45) NULL ,
  city VARCHAR(45) NULL ,
  address VARCHAR(45) NULL ,
  about LONGTEXT NULL ,
  rating FLOAT NULL ,
  registration_date DATE NOT NULL ,
  PRIMARY KEY (user_login) )

;


-- -----------------------------------------------------
-- Table role
-- -----------------------------------------------------
CREATE  TABLE  role (
  role_name VARCHAR(30) NOT NULL ,
  description VARCHAR(250) NULL ,
  PRIMARY KEY (role_name) )
;


-- -----------------------------------------------------
-- Table section
-- -----------------------------------------------------
CREATE  TABLE  section (
  name_section VARCHAR(40) NOT NULL ,
  description VARCHAR(250) NULL ,
  PRIMARY KEY (name_section) )
;


-- -----------------------------------------------------
-- Table recipe
-- -----------------------------------------------------
CREATE  TABLE  recipe (
  recipe_name VARCHAR(40) NOT NULL ,
  photo BLOB NULL ,
  description LONGTEXT NOT NULL ,
  accepted TINYINT(1) NULL ,
  mark FLOAT NULL ,
  user_login VARCHAR(20) NOT NULL ,
  name_section VARCHAR(40) NOT NULL ,
  PRIMARY KEY (recipe_name) ,

  CONSTRAINT fk_recipe_app_user1
    FOREIGN KEY (user_login )
    REFERENCES app_user (user_login )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_recipe_section1
    FOREIGN KEY (name_section )
    REFERENCES section (name_section )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table ingredient
-- -----------------------------------------------------
CREATE  TABLE  ingredient (
  id_ingredient INT NOT NULL AUTO_INCREMENT ,
  name_ingredient VARCHAR(250) NOT NULL ,
  comment VARCHAR(250) NULL ,
  quantity VARCHAR(100) NOT NULL ,
  recipe_name VARCHAR(40) NOT NULL ,
  PRIMARY KEY (id_ingredient) ,

  CONSTRAINT fk_ingredient_recipe1
    FOREIGN KEY (recipe_name )
    REFERENCES recipe (recipe_name )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table app_user_has_role
-- -----------------------------------------------------
CREATE  TABLE  app_user_has_role (
  user_login VARCHAR(20) NOT NULL ,
  role_name VARCHAR(30) NOT NULL ,
  PRIMARY KEY (user_login, role_name) ,

  CONSTRAINT fk_app_user_has_role_app_user
    FOREIGN KEY (user_login )
    REFERENCES app_user (user_login )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_app_user_has_role_role1
    FOREIGN KEY (role_name )
    REFERENCES role (role_name )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table provider
-- -----------------------------------------------------
CREATE  TABLE  provider (
  provider_name VARCHAR(100) NOT NULL ,
  terms_of_delivery TEXT NOT NULL ,
  about_company TEXT NULL ,
  user_login VARCHAR(20) NOT NULL ,
  PRIMARY KEY (provider_name) ,

  CONSTRAINT fk_provider_app_user1
    FOREIGN KEY (user_login )
    REFERENCES app_user (user_login )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table delivery
-- -----------------------------------------------------
CREATE  TABLE  delivery (
  id_delivery INT NOT NULL AUTO_INCREMENT ,
  price MEDIUMTEXT NOT NULL ,
  isWhole TINYINT(1) NOT NULL ,
  provider_name VARCHAR(100) NOT NULL ,
  recipe_name VARCHAR(40) NOT NULL ,
  delivery_price MEDIUMTEXT NOT NULL ,
  PRIMARY KEY (id_delivery) ,

  CONSTRAINT fk_delivery_provider1
    FOREIGN KEY (provider_name )
    REFERENCES provider (provider_name )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_delivery_recipe1
    FOREIGN KEY (recipe_name )
    REFERENCES recipe (recipe_name )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table app_comment
-- -----------------------------------------------------
CREATE  TABLE  app_comment (
  id_comment INT NOT NULL AUTO_INCREMENT ,
  content TEXT NOT NULL ,
  recipe_name VARCHAR(40) NOT NULL ,
  user_login VARCHAR(20) NOT NULL ,
  PRIMARY KEY (id_comment) ,

  CONSTRAINT fk_comment_recipe1
    FOREIGN KEY (recipe_name )
    REFERENCES recipe (recipe_name )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_comment_app_user1
    FOREIGN KEY (user_login )
    REFERENCES app_user (user_login )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


