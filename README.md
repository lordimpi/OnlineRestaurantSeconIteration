## In OnlineRestaurant-Service project 

modify Utilities.java
```ssh
    private final String username = "Insert here your user from MySql";
    private final String pwd = "Insert here you password from MySql";
```

## Run this script in mysql

Database creation
```ssh
	CREATE DATABASE `restaurante`
```
Tables creations
```ssh
	CREATE TABLE `restaurante`.`user` ( 
		`id_user` VARCHAR(10) NOT NULL , 
		`first_name` VARCHAR(40) NOT NULL , `last_name` VARCHAR(40) NOT NULL , 
		`address` VARCHAR(40) NOT NULL , `mobile` VARCHAR(10) NOT NULL , 
		`email` VARCHAR(20) NOT NULL , `rol` VARCHAR(10) NOT NULL,
		`pws` VARCHAR(40) NOT NULL , PRIMARY KEY (`id_user`), 
	UNIQUE (`first_name`)) ENGINE = InnoDB;

	CREATE TABLE `restaurante`.`maindish` ( 
		`id_dish` VARCHAR(10) NOT NULL , 
		`dish_name` VARCHAR(40) NOT NULL , 
		`dish_price` INT(40) NOT NULL , 
		PRIMARY KEY (`id_dish`)) ENGINE = InnoDB;

	CREATE TABLE `restaurante`.`drink` ( 
		`id_drink` VARCHAR(10) NOT NULL , 
		`drink_name` VARCHAR(40) NOT NULL , 
		`drink_price` INT(40) NOT NULL , 
		PRIMARY KEY (`id_drink`)) ENGINE = InnoDB;

	CREATE TABLE `restaurante`.`restaurant` ( 
		`idres` VARCHAR(10) NOT NULL , 
		`name_restaurant` VARCHAR(40) NOT NULL , 
		`address_restaurant` VARCHAR(40) NOT NULL , 
		`phone` VARCHAR(40) NOT NULL , 
		`id_wmenu` VARCHAR(10) NULL , 
		PRIMARY KEY (`idres`)) ENGINE = InnoDB;

	CREATE TABLE `restaurante`.`dessert` ( 
		`id_dessert` VARCHAR(10) NOT NULL , 
		`dessert_name` VARCHAR(40) NOT NULL , 
		`dessert_price` INT(40) NOT NULL , 
		PRIMARY KEY (`id_dessert`)) ENGINE = InnoDB;

	CREATE TABLE `restaurante`.`dishentry` ( 
		`idDishEntry` VARCHAR(10) NOT NULL , 
		`nameDishEntry` VARCHAR(40) NOT NULL , 
		`costDishEntry` INT(40) NOT NULL , 
		PRIMARY KEY (`idDishEntry`)) ENGINE = InnoDB;

	CREATE TABLE `restaurante`.`salad` ( 
		`idsalad` VARCHAR(10) NOT NULL , 
		`namesalad` VARCHAR(40) NOT NULL , 
		`pricesalada` INT(40) NOT NULL , 
		PRIMARY KEY (`idsalad`)) ENGINE = InnoDB;

	CREATE TABLE `restaurante`.`menu` ( 
		`id_menu` VARCHAR(10) NOT NULL , 
		`id_maindish` VARCHAR(10) NULL, 
		`id_drink` VARCHAR(10) NULL, 
		`id_salad` VARCHAR(10) NULL,
		`id_entry` VARCHAR(10) NULL, 
		`id_dessert` VARCHAR(10) NULL, 
		PRIMARY KEY (`id_menu`)) ENGINE = InnoDB;

	ALTER TABLE menu ADD CONSTRAINT FK_IDentry FOREIGN KEY (id_entry) REFERENCES dishentry(idDishEntry);
	ALTER TABLE menu ADD CONSTRAINT FK_IDsalad FOREIGN KEY (id_salad) REFERENCES salad(idsalad);
	ALTER TABLE menu ADD CONSTRAINT FK_IDmaindish FOREIGN KEY (id_maindish) REFERENCES maindish(id_dish);
	ALTER TABLE menu ADD CONSTRAINT FK_IDdessert FOREIGN KEY (id_dessert) REFERENCES dessert(id_dessert);
	ALTER TABLE menu ADD CONSTRAINT FK_IDdrink FOREIGN KEY (id_drink) REFERENCES drink(id_drink);
	ALTER TABLE restaurant ADD CONSTRAINT FK_IDmenu FOREIGN KEY (id_wmenu) REFERENCES menu(id_menu);
```
Inserts
```ssh
	INSERT INTO `maindish`(`id_dish`, `dish_name`, `dish_price`) VALUES ('1','papitas',2000);
	INSERT INTO `maindish`(`id_dish`, `dish_name`, `dish_price`) VALUES ('2','mas papitas',2500);
	INSERT INTO `maindish`(`id_dish`, `dish_name`, `dish_price`) VALUES ('3','aun mas papitas',3000);
	INSERT INTO `maindish`(`id_dish`, `dish_name`, `dish_price`) VALUES ('4','mega papitas',4500);

	INSERT INTO `drink`(`id_drink`, `drink_name`, `drink_price`) VALUES ('1','cerveza poker',2500);
	INSERT INTO `drink`(`id_drink`, `drink_name`, `drink_price`) VALUES ('2','cerveza rubia',3500);
	INSERT INTO `drink`(`id_drink`, `drink_name`, `drink_price`) VALUES ('3','cerveza roja',3500);
	INSERT INTO `drink`(`id_drink`, `drink_name`, `drink_price`) VALUES ('4','cerveza negra',4500);
	INSERT INTO `drink`(`id_drink`, `drink_name`, `drink_price`) VALUES ('5','cerveza clara',3500);
	INSERT INTO `drink`(`id_drink`, `drink_name`, `drink_price`) VALUES ('6','jugo natural',1500);
	INSERT INTO `drink`(`id_drink`, `drink_name`, `drink_price`) VALUES ('7','agua',1000);

	INSERT INTO `dessert`(`id_dessert`, `dessert_name`, `dessert_price`) VALUES ("1","fresas",2000);
	INSERT INTO `dessert`(`id_dessert`, `dessert_name`, `dessert_price`) VALUES ("2","miel con quajada",2100);
	INSERT INTO `dessert`(`id_dessert`, `dessert_name`, `dessert_price`) VALUES ("3","pastelitos",2200);
	INSERT INTO `dessert`(`id_dessert`, `dessert_name`, `dessert_price`) VALUES ("4","flan",3000);
	INSERT INTO `dessert`(`id_dessert`, `dessert_name`, `dessert_price`) VALUES ("5","gelatina",2500);

	INSERT INTO `dishentry`(`idDishEntry`, `nameDishEntry`, `costDishEntry`) VALUES ("1","salchichitas",2000);
	INSERT INTO `dishentry`(`idDishEntry`, `nameDishEntry`, `costDishEntry`) VALUES ("2","mani",2000);
	INSERT INTO `dishentry`(`idDishEntry`, `nameDishEntry`, `costDishEntry`) VALUES ("3","pan",2000);
	INSERT INTO `dishentry`(`idDishEntry`, `nameDishEntry`, `costDishEntry`) VALUES ("4","crispetas",2000);

	INSERT INTO `salad`(`idsalad`, `namesalad`, `pricesalada`) VALUES ("1","ensalada cesar",1000);
	INSERT INTO `salad`(`idsalad`, `namesalad`, `pricesalada`) VALUES ("2","ensalada dulce",1000);
	INSERT INTO `salad`(`idsalad`, `namesalad`, `pricesalada`) VALUES ("3","ensalada frutas",1000);
	INSERT INTO `salad`(`idsalad`, `namesalad`, `pricesalada`) VALUES ("4","ensalada",1000);

	INSERT INTO `user`(`id_user`, `first_name`, `last_name`, `address`, `mobile`, `email`, `rol`,`pws`) VALUES ("1","alejo","rodriguez","calle 10","3166161700","alejo@rc.com","admin","123");
	INSERT INTO `user`(`id_user`, `first_name`, `last_name`, `address`, `mobile`, `email`, `rol`,`pws`) VALUES ("2","Admin","rodriguez","calle 10","3166161700","alejo@rc.com","admin","123");
	INSERT INTO `user`(`id_user`, `first_name`, `last_name`, `address`, `mobile`, `email`, `rol`,`pws`) VALUES ("3","User","rodriguez","calle 10","3166161700","alejo@rc.com","user","123");
	INSERT INTO `user`(`id_user`, `first_name`, `last_name`, `address`, `mobile`, `email`, `rol`,`pws`) VALUES ("4","user2","rodriguez","calle 10","3166161700","alejo@rc.com","user","123");

	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("1","1","1","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("2","1","2","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("3","4","1","3","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("4","1","2","1","1","4");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("5","1","1","3","3","3");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("6","2","2","3","4","2");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("7","2","4","3","4","1");

	INSERT INTO `restaurant`(`idres`, `name_restaurant`, `address_restaurant`, `phone`, `id_wmenu`) VALUES ("1","mister pollo","calle 50","312333222","1");
	INSERT INTO `restaurant`(`idres`, `name_restaurant`, `address_restaurant`, `phone`, `id_wmenu`) VALUES ("2","cafeto","carrera 15","312333222","2");
	INSERT INTO `restaurant`(`idres`, `name_restaurant`, `address_restaurant`, `phone`, `id_wmenu`) VALUES ("3","Hunngry","calle 19","312333222","3");
	INSERT INTO `restaurant`(`idres`, `name_restaurant`, `address_restaurant`, `phone`, `id_wmenu`) VALUES ("4","la merced","carrera 12","312333222","4");
	INSERT INTO `restaurant`(`idres`, `name_restaurant`, `address_restaurant`, `phone`, `id_wmenu`) VALUES ("5","la canasta","calle 1","312333222","5");
	INSERT INTO `restaurant`(`idres`, `name_restaurant`, `address_restaurant`, `phone`, `id_wmenu`) VALUES ("6","pollo sorpresa","carrera 10","312333222","6");
	INSERT INTO `restaurant`(`idres`, `name_restaurant`, `address_restaurant`, `phone`, `id_wmenu`) VALUES ("7","Andres carne de res","carrera 12 con calle 10","312333222","7");
	
```
