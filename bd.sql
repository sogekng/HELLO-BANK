
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hellobank` DEFAULT CHARACTER SET utf8mb4 ;
USE `hellobank` ;

-- -----------------------------------------------------
-- Table `hellobank`.`administradores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hellobank`.`administradores` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(20) NOT NULL,
  `nome` VARCHAR(70) NOT NULL,
  `senha` VARCHAR(70) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `hellobank`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hellobank`.`cliente` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(20) NOT NULL,
  `email` VARCHAR(70) NOT NULL,
  `nome` VARCHAR(70) NOT NULL,
  `senha` VARCHAR(70) NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `hellobank`.`conta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hellobank`.`conta` (
  `id_conta` INT(11) NOT NULL AUTO_INCREMENT,
  `agencia` VARCHAR(8) NOT NULL,
  `numero` VARCHAR(20) NOT NULL,
  `saldo` DOUBLE NOT NULL,
  `tipo` VARCHAR(20) NOT NULL,
  `id_cliente` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_conta`),
  INDEX `FK4o5w6tmaqt0ojd6anrub0qny8` (`id_cliente` ASC) VISIBLE,
  CONSTRAINT `FK4o5w6tmaqt0ojd6anrub0qny8`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `hellobank`.`cliente` (`id_cliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `hellobank`.`transacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hellobank`.`transacao` (
  `id_transacao` INT(11) NOT NULL AUTO_INCREMENT,
  `data_transacao` DATE NOT NULL,
  `tipo` VARCHAR(255) NULL DEFAULT NULL,
  `valor` DOUBLE NOT NULL,
  `id_conta` INT(11) NULL DEFAULT NULL,
  `status` VARCHAR(70) NOT NULL,
  PRIMARY KEY (`id_transacao`),
  INDEX `FKj57iekb2ucoyifb1flof7kjml` (`id_conta` ASC),
  CONSTRAINT `FKj57iekb2ucoyifb1flof7kjml`
    FOREIGN KEY (`id_conta`)
    REFERENCES `hellobank`.`conta` (`id_conta`))
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = utf8mb4;
