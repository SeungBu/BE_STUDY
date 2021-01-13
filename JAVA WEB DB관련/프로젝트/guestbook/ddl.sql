CREATE TABLE `guestbook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'guestbook id',
   `name` VARCHAR(255) NOT NULL COMMENT 'user name',
  `content` TEXT NOT NULL COMMENT 'guestbook content',
  `regdate` DATETIME NULL DEFAULT NULL COMMENT 'µÓ∑œ¿œ',
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;