SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS  DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE  ;

-- -----------------------------------------------------
-- Table app_user
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS app_user (
  id_app_user BIGINT NOT NULL ,
  login VARCHAR(20) NOT NULL ,
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
  UNIQUE INDEX login_UNIQUE (login ASC) ,
  PRIMARY KEY (id_app_user) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table role
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS role (
  id_role BIGINT NOT NULL ,
  role_name VARCHAR(30) NULL ,
  description VARCHAR(250) NULL ,
  PRIMARY KEY (id_role) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table section
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS section (
  id_section BIGINT NOT NULL ,
  name_section VARCHAR(40) NULL ,
  description VARCHAR(250) NULL ,
  PRIMARY KEY (id_section) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table recipe
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS recipe (
  id_recipe BIGINT NOT NULL ,
  recipe_name VARCHAR(40) NULL ,
  photo_path VARCHAR(50) NULL ,
  description LONGTEXT NOT NULL ,
  accepted TINYINT(1) NULL ,
  positive_marks INT NULL ,
  negative_marks INT NULL ,
  id_app_user_fk BIGINT NOT NULL ,
  id_section_fk BIGINT NOT NULL ,
  PRIMARY KEY (id_recipe) ,
  INDEX fk_recipe_app_user1 (id_app_user_fk ASC) ,
  INDEX fk_recipe_section1 (id_section_fk ASC) ,
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
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table ingredient
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS ingredient (
  id_ingredient BIGINT NOT NULL AUTO_INCREMENT ,
  name_ingredient VARCHAR(250) NOT NULL ,
  comment VARCHAR(250) NULL ,
  quantity VARCHAR(100) NOT NULL ,
  id_recipe_fk BIGINT NOT NULL ,
  PRIMARY KEY (id_ingredient) ,
  INDEX fk_ingredient_recipe1 (id_recipe_fk ASC) ,
  CONSTRAINT fk_ingredient_recipe1
    FOREIGN KEY (id_recipe_fk )
    REFERENCES recipe (id_recipe )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table provider
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS provider (
  id_provider BIGINT NOT NULL ,
  provider_name VARCHAR(100) NULL ,
  terms_of_delivery TEXT NOT NULL ,
  about_company TEXT NULL ,
  accepted TINYINT(1) NULL ,
  registration_date DATE NULL ,
  positive_marks INT NULL ,
  negative_marks INT NULL ,
  id_app_user_fk BIGINT NOT NULL ,
  PRIMARY KEY (id_provider) ,
  INDEX fk_provider_app_user1 (id_app_user_fk ASC) ,
  CONSTRAINT fk_provider_app_user1
    FOREIGN KEY (id_app_user_fk )
    REFERENCES app_user (id_app_user )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table delivery
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS delivery (
  id_delivery BIGINT NOT NULL AUTO_INCREMENT ,
  price INT NOT NULL ,
  is_prepared TINYINT(1) NOT NULL ,
  delivery_price INT NOT NULL ,
  id_recipe_fk BIGINT NOT NULL ,
  id_provider_fk BIGINT NOT NULL ,
  PRIMARY KEY (id_delivery) ,
  INDEX fk_delivery_recipe1 (id_recipe_fk ASC) ,
  INDEX fk_delivery_provider1 (id_provider_fk ASC) ,
  CONSTRAINT fk_delivery_recipe1
    FOREIGN KEY (id_recipe_fk )
    REFERENCES recipe (id_recipe )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_delivery_provider1
    FOREIGN KEY (id_provider_fk )
    REFERENCES provider (id_provider )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table app_comment
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS app_comment (
  id_app_comment BIGINT NOT NULL AUTO_INCREMENT ,
  content TEXT NOT NULL ,
  date DATETIME NOT NULL ,
  positive_marks INT NULL ,
  negative_marks INT NULL ,
  id_recipe_fk BIGINT NOT NULL ,
  id_app_user_fk BIGINT NOT NULL ,
  PRIMARY KEY (id_app_comment) ,
  INDEX fk_app_comment_recipe1 (id_recipe_fk ASC) ,
  INDEX fk_app_comment_app_user1 (id_app_user_fk ASC) ,
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
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table user_order
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS user_order (
  id BIGINT NOT NULL ,
  date DATETIME NOT NULL ,
  id_delivery_fk BIGINT NOT NULL ,
  id_app_user_fk BIGINT NOT NULL ,
  PRIMARY KEY (id) ,
  INDEX fk_order_delivery1_idx (id_delivery_fk ASC) ,
  INDEX fk_order_app_user1 (id_app_user_fk ASC) ,
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
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table app_user_has_role
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS app_user_has_role (
  id_role_fk BIGINT NOT NULL ,
  id_app_user_fk BIGINT NOT NULL ,
  PRIMARY KEY (id_role_fk, id_app_user_fk) ,
  INDEX fk_role_has_app_user_app_user1 (id_app_user_fk ASC) ,
  INDEX fk_role_has_app_user_role1 (id_role_fk ASC) ,
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
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;