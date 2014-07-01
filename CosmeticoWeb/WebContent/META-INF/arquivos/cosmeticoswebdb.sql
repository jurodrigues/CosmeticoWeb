# SQL Manager Lite for MySQL 5.4.0.42211
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : cosmeticoswebdb


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES latin1 */;

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `cosmeticoswebdb`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

USE `cosmeticoswebdb`;

#
# Structure for the `fornecedor` table : 
#

CREATE TABLE `fornecedor` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cnpj` VARCHAR(255) COLLATE latin1_swedish_ci DEFAULT NULL,
  `nome` VARCHAR(255) COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`) COMMENT ''
)ENGINE=InnoDB
AUTO_INCREMENT=3 AVG_ROW_LENGTH=8192 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
COMMENT=''
;

#
# Structure for the `cosmeticos` table : 
#

CREATE TABLE `cosmeticos` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) COLLATE latin1_swedish_ci DEFAULT NULL,
  `nome` VARCHAR(255) COLLATE latin1_swedish_ci DEFAULT NULL,
  `valor` FLOAT NOT NULL,
  `fornecedor_id` BIGINT(20) DEFAULT NULL,
  `foto` VARCHAR(255) COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`) COMMENT '',
   INDEX `FK_9wxpdamhaptv5dytiti5wnevu` USING BTREE (`fornecedor_id`) COMMENT '',
  CONSTRAINT `FK_9wxpdamhaptv5dytiti5wnevu` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedor` (`id`)
)ENGINE=InnoDB
AUTO_INCREMENT=7 AVG_ROW_LENGTH=16384 CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
COMMENT=''
;

#
# Structure for the `usuario` table : 
#

CREATE TABLE `usuario` (
  `nome` VARCHAR(255) COLLATE latin1_swedish_ci NOT NULL,
  `senha` VARCHAR(255) COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY USING BTREE (`nome`) COMMENT ''
)ENGINE=InnoDB
CHARACTER SET 'latin1' COLLATE 'latin1_swedish_ci'
COMMENT=''
;

#
# Data for the `fornecedor` table  (LIMIT -497,500)
#

INSERT INTO `fornecedor` (`id`, `cnpj`, `nome`) VALUES

  (1,'12345649616','Aroma'),
  (2,'98765432100','Nivea');
COMMIT;

#
# Data for the `cosmeticos` table  (LIMIT -498,500)
#

INSERT INTO `cosmeticos` (`id`, `descricao`, `nome`, `valor`, `fornecedor_id`, `foto`) VALUES

  (6,'Sombra para os olhos','Sombra Color',12.5,1,'dfb86535-75ae-41af-830c-c2feb4082350.jpg');
COMMIT;

#
# Data for the `usuario` table  (LIMIT -498,500)
#

INSERT INTO `usuario` (`nome`, `senha`) VALUES

  ('juliana','1234');
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;