-- -----------------------------------------------------
-- Table section
-- -----------------------------------------------------
CREATE  TABLE  section (
  name_section VARCHAR(40) NOT NULL ,
  description VARCHAR(250) NULL ,
  PRIMARY KEY (name_section) )
;


-- -----------------------------------------------------
-- Table app_comment
-- -----------------------------------------------------
CREATE  TABLE  app_comment (
  id_comment INT NOT NULL AUTO_INCREMENT ,
  content TEXT NOT NULL ,
  date TIMESTAMP NOT NULL,
  PRIMARY KEY (id_comment))
;


