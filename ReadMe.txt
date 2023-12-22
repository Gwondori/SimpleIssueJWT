MySQL 사용
  Database 생성문:
    CREATE DATABASE `IssueJWT` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci;
  Table 생성문:
  	DROP TABLE IF EXISTS `IssueJWT`.`user`;
    CREATE TABLE `IssueJWT`.`user` (idx INT NOT NULL PRIMARY KEY AUTO_INCREMENT, login_type INT NOT NULL, username VARCHAR(32) NOT NULL, password VARCHAR(64) NOT NULL, agreement1 TINYINT(1) DEFAULT NULL, agreement2 TINYINT(1) DEFAULT NULL, agreement3 TINYINT(1) DEFAULT NULL, agreement4 TINYINT(1) DEFAULT NULL, token TEXT CHARACTER SET ascii COLLATE ascii_bin, issuance_time DATE, expiration_time DATE, status INT NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

Spring Boot 3.2 사용
GCP 로그인 JWT
일반 로그인 JWT
단, JWT의 Database 저장과 관련된 기능은 구현 X