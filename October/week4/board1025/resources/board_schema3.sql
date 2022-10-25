-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ssafyweb3
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ssafyweb3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssafyweb3` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ssafyweb3` ;

-- -----------------------------------------------------
-- Table `ssafyweb3`.`members`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ssafyweb3`.`members` ;

CREATE TABLE IF NOT EXISTS `ssafyweb3`.`members` (
  `user_id` VARCHAR(16) NOT NULL,
  `user_name` VARCHAR(20) NOT NULL,
  `user_password` VARCHAR(16) NOT NULL,
  `email_id` VARCHAR(20) NULL DEFAULT NULL,
  `email_domain` VARCHAR(45) NULL DEFAULT NULL,
  `join_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

insert into `ssafyweb3`.`members` (user_id, user_name, user_password, email_id, email_domain, join_date)
values 	('ssafy', '김싸피', '1234', 'ssafy', 'ssafy.com', now()), 
	('admin', '관리자', '1234', 'admin', 'google.com', now());
	
commit;

-- -----------------------------------------------------
-- Table `ssafyweb3`.`board`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ssafyweb3`.`board` ;

CREATE TABLE IF NOT EXISTS `ssafyweb3`.`board` (
  `article_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(16) NULL DEFAULT NULL,
  `subject` VARCHAR(100) NULL DEFAULT NULL,
  `content` VARCHAR(2000) NULL DEFAULT NULL,
  `hit` INT NULL DEFAULT 0,
  `register_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_no`),
  INDEX `board_to_members_user_id_fk` (`user_id` ASC) VISIBLE,
  CONSTRAINT `board_to_members_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `ssafyweb3`.`members` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafyweb3`.`memo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ssafyweb3`.`memo` ;

CREATE TABLE IF NOT EXISTS `ssafyweb3`.`memo` (
  `memo_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(16) NULL DEFAULT NULL,
  `comment` VARCHAR(500) NULL DEFAULT NULL,
  `memo_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `article_no` INT NULL DEFAULT NULL,
  PRIMARY KEY (`memo_no`),
  INDEX `memo_to_board_article_no_fk` (`article_no` ASC) VISIBLE,
  INDEX `memo_to_member_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `memo_to_board_article_no_fk`
    FOREIGN KEY (`article_no`)
    REFERENCES `ssafyweb3`.`board` (`article_no`),
  CONSTRAINT `memo_to_member_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `ssafyweb3`.`members` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafyweb3`.`file_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ssafyweb3`.`file_info` ;

CREATE TABLE IF NOT EXISTS `ssafyweb3`.`file_info` (
  `idx` INT NOT NULL AUTO_INCREMENT,
  `article_no` INT NULL,
  `save_folder` VARCHAR(45) NULL,
  `original_file` VARCHAR(50) NULL,
  `save_file` VARCHAR(50) NULL,
  PRIMARY KEY (`idx`),
  CONSTRAINT `file_info_to_board_article_no_fk`
    FOREIGN KEY (`article_no`)
    REFERENCES `ssafyweb3`.`board` (`article_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;




-- -----------------------------------------------------
-- Table `mydb`.`payment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafyweb3`.`payment` (
  `pid` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(16) NOT NULL,
  `pday` DATETIME NOT NULL,
  `pamount` INT NOT NULL,
  `pwhy` VARCHAR(200) NULL,
  `fin` INT NOT NULL,
  PRIMARY KEY (`pid`),
   CONSTRAINT `payment_to_member_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `ssafyweb3`.`members` (`user_id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;








