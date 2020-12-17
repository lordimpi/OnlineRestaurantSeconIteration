## Table of contents
[1. Introduction](#1-Introduction)

[2. Document information](#2-Document-information)

[3. Connection data base](#3-Connection-data-base)

[4. Configuring Payara Server](#3-Configuring-Payara-Server)


## 1. Introduction
El sistema de Restaurantes Online - SRO ha sido tomado como el caso de estudio del
curso de laboratorio de ingeniería de software II del Departamento de sistemas de la
Universidad del Cauca.


## 2. Document information
(https://github.com/lordimpi/OnlineRestaurantSecondIteration/files/5707173/Document.information.pdf)

## 3. Connection data base

### In Commons project 

modify Utilities.java
```ssh
    private final String username = "Insert here your user from MySql";
    private final String pwd = "Insert here you password from MySql";
```

### Script MySQL

Database creation
```ssh
	CREATE DATABASE `restaurante`
```
Tables creations
```ssh
	CREATE TABLE `restaurante`.`user` ( 
		`id_user` INT AUTO_INCREMENT, 
		`first_name` VARCHAR(100) NOT NULL , `last_name` VARCHAR(100) NOT NULL , 
		`address` VARCHAR(100) NOT NULL , `mobile` VARCHAR(10) NOT NULL , 
		`email` VARCHAR(100) NOT NULL , `rol` VARCHAR(10) NOT NULL,
		`pws` VARCHAR(20) NOT NULL , PRIMARY KEY (`id_user`), 
		 UNIQUE (`email`)) ENGINE = InnoDB;

	CREATE TABLE `restaurante`.`maindish` ( 
		`id_dish` VARCHAR(10) NOT NULL , 
		`dish_name` VARCHAR(100) NOT NULL , 
		`dish_price` INT(40) NOT NULL , 
		PRIMARY KEY (`id_dish`)) ENGINE = InnoDB;

	CREATE TABLE `restaurante`.`drink` ( 
		`id_drink` VARCHAR(10) NOT NULL , 
		`drink_name` VARCHAR(100) NOT NULL , 
		`drink_price` INT(40) NOT NULL , 
		PRIMARY KEY (`id_drink`)) ENGINE = InnoDB;


    CREATE TABLE `restaurante`.`restaurant` (  
		`idres` VARCHAR(10) NOT NULL , 
		`name_restaurant` VARCHAR(100) NOT NULL , 
		`address_restaurant` VARCHAR(100) NOT NULL , 
		`phone` VARCHAR(40) NOT NULL , 
		`id_lu_menu` VARCHAR(10) NULL ,
  		`id_ma_menu` VARCHAR(10) NULL ,
    	`id_mi_menu` VARCHAR(10) NULL ,
    	`id_ju_menu` VARCHAR(10) NULL ,
    	`id_vi_menu` VARCHAR(10) NULL ,
    	`id_sa_menu` VARCHAR(10) NULL ,
		PRIMARY KEY (`idres`)) ENGINE = InnoDB;

	CREATE TABLE `restaurante`.`dessert` ( 
		`id_dessert` VARCHAR(10) NOT NULL , 
		`dessert_name` VARCHAR(100) NOT NULL , 
		`dessert_price` INT(40) NOT NULL , 
		PRIMARY KEY (`id_dessert`)) ENGINE = InnoDB;

	CREATE TABLE `restaurante`.`dishentry` ( 
		`idDishEntry` VARCHAR(10) NOT NULL , 
		`nameDishEntry` VARCHAR(100) NOT NULL , 
		`costDishEntry` INT(40) NOT NULL , 
		PRIMARY KEY (`idDishEntry`)) ENGINE = InnoDB;

	CREATE TABLE `restaurante`.`salad` ( 
		`idsalad` VARCHAR(10) NOT NULL , 
		`namesalad` VARCHAR(100) NOT NULL , 
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

	CREATE TABLE `restaurante`.`delivery` ( 
		`id_delivery` INT AUTO_INCREMENT, 
		`descripcion` VARCHAR(300) NULL, 
		`cantidad` INTEGER NOT NULL, 
		`direccion_envio` VARCHAR(100) NOT NULL,
		`fecha` DATE NOT NULL, 
		`id_menu` VARCHAR(10) NOT NULL, 
		PRIMARY KEY (`id_delivery`)) ENGINE = InnoDB;

	ALTER TABLE menu ADD CONSTRAINT FK_IDentry FOREIGN KEY (id_entry) REFERENCES dishentry(idDishEntry);
	ALTER TABLE menu ADD CONSTRAINT FK_IDsalad FOREIGN KEY (id_salad) REFERENCES salad(idsalad);
	ALTER TABLE menu ADD CONSTRAINT FK_IDmaindish FOREIGN KEY (id_maindish) REFERENCES maindish(id_dish);
	ALTER TABLE menu ADD CONSTRAINT FK_IDdessert FOREIGN KEY (id_dessert) REFERENCES dessert(id_dessert);
	ALTER TABLE menu ADD CONSTRAINT FK_IDdrink FOREIGN KEY (id_drink) REFERENCES drink(id_drink);
	ALTER TABLE restaurant ADD CONSTRAINT FK_ID_lu_menu FOREIGN KEY (id_lu_menu) REFERENCES menu(id_menu);
	ALTER TABLE restaurant ADD CONSTRAINT FK_ID_ma_menu FOREIGN KEY (id_ma_menu) REFERENCES menu(id_menu);
	ALTER TABLE restaurant ADD CONSTRAINT FK_ID_mi_menu FOREIGN KEY (id_mi_menu) REFERENCES menu(id_menu);
	ALTER TABLE restaurant ADD CONSTRAINT FK_ID_ju_menu FOREIGN KEY (id_ju_menu) REFERENCES menu(id_menu);
	ALTER TABLE restaurant ADD CONSTRAINT FK_ID_vi_menu FOREIGN KEY (id_vi_menu) REFERENCES menu(id_menu);
	ALTER TABLE restaurant ADD CONSTRAINT FK_ID_sa_menu FOREIGN KEY (id_sa_menu) REFERENCES menu(id_menu);
	ALTER TABLE delivery ADD CONSTRAINT FK_ID_menu FOREIGN KEY (id_menu) REFERENCES menu(id_menu);
```
Inserts
```ssh
	INSERT INTO `maindish`(`id_dish`, `dish_name`, `dish_price`) VALUES ('1','Arroz chino',2000);
	INSERT INTO `maindish`(`id_dish`, `dish_name`, `dish_price`) VALUES ('2','Ajiaco',2500);
	INSERT INTO `maindish`(`id_dish`, `dish_name`, `dish_price`) VALUES ('3','Higado encebollado',3000);
	INSERT INTO `maindish`(`id_dish`, `dish_name`, `dish_price`) VALUES ('4','Carne sudada con Arroz',4500);
	INSERT INTO `maindish`(`id_dish`, `dish_name`, `dish_price`) VALUES ('1','Arroz paisa',2000);
	INSERT INTO `maindish`(`id_dish`, `dish_name`, `dish_price`) VALUES ('2','Sancocho de gallina',2500);
	INSERT INTO `maindish`(`id_dish`, `dish_name`, `dish_price`) VALUES ('3','Pizza de pollo',3000);
	INSERT INTO `maindish`(`id_dish`, `dish_name`, `dish_price`) VALUES ('4','Carne asada',4500);

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

	INSERT INTO `user`(`id_user`, `first_name`, `last_name`, `address`, `mobile`, `email`, `rol`,`pws`) VALUES (null,"alejo","rodriguez","calle 10","3166161700","alejo1@rc.com","admin","123");
	INSERT INTO `user`(`id_user`, `first_name`, `last_name`, `address`, `mobile`, `email`, `rol`,`pws`) VALUES (null,"Santiago","Acuña","calle 10","3166161700","snt-26@hotmail.com","admin","123456");
	INSERT INTO `user`(`id_user`, `first_name`, `last_name`, `address`, `mobile`, `email`, `rol`,`pws`) VALUES (null,"Admin","rodriguez","calle 10","3166161700","alejo2@rc.com","admin","123");
	INSERT INTO `user`(`id_user`, `first_name`, `last_name`, `address`, `mobile`, `email`, `rol`,`pws`) VALUES (null,"User","rodriguez","calle 10","3166161700","alejo3@rc.com","user","123");
	INSERT INTO `user`(`id_user`, `first_name`, `last_name`, `address`, `mobile`, `email`, `rol`,`pws`) VALUES (null,"user2","rodriguez","calle 10","3166161700","alejo4@rc.com","user","123");
	INSERT INTO `user`(`id_user`, `first_name`, `last_name`, `address`, `mobile`, `email`, `rol`,`pws`) VALUES (null,"user4","rodriguez","calle 10","3166161700","user@user.com","user","123456");

	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("1","1","1","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("2","1","2","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("3","4","1","3","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("4","1","2","1","1","4");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("5","1","1","3","3","3");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("6","2","2","3","4","2");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("7","2","4","3","4","1");
    INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("8","1","1","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("9","1","2","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("10","4","1","3","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("11","1","2","1","1","4");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("12","1","1","3","3","3");
    INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("13","1","1","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("14","1","2","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("15","4","1","3","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("16","1","2","1","1","4");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("17","1","1","3","3","3");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("18","2","2","3","4","2");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("19","2","4","3","4","1");
    INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("20","1","1","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("21","1","2","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("22","4","1","3","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("23","1","2","1","1","4");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("24","1","1","3","3","3");
    INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("25","1","1","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("26","1","2","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("27","4","1","3","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("28","1","2","1","1","4");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("29","1","1","3","3","3");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("30","2","2","3","4","2");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("31","2","4","3","4","1");
   	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("32","1","1","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("33","1","2","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("34","4","1","3","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("35","1","2","1","1","4");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("36","1","1","3","3","3");
    INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("37","1","1","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("38","1","2","1","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("39","4","1","3","1","1");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("40","1","2","1","1","4");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("41","1","1","3","3","3");
	INSERT INTO `menu`(`id_menu`, `id_maindish`, `id_drink`, `id_salad`, `id_entry`, `id_dessert`) VALUES ("42","2","2","3","4","2");

	INSERT INTO `restaurant`(`idres`, `name_restaurant`, `address_restaurant`, `phone`, `id_lu_menu`, `id_ma_menu`, `id_mi_menu`, `id_ju_menu`, `id_vi_menu`, `id_sa_menu`) VALUES ("1","mister pollo","calle 50","312333222","1","2","3","4","5","6");
	INSERT INTO `restaurant`(`idres`, `name_restaurant`, `address_restaurant`, `phone`, `id_lu_menu`, `id_ma_menu`, `id_mi_menu`, `id_ju_menu`, `id_vi_menu`, `id_sa_menu`) VALUES ("2","cafeto","carrera 15","312333222","7","8","9","10","11","12");
	INSERT INTO `restaurant`(`idres`, `name_restaurant`, `address_restaurant`, `phone`, `id_lu_menu`, `id_ma_menu`, `id_mi_menu`, `id_ju_menu`, `id_vi_menu`, `id_sa_menu`) VALUES ("3","Hunngry","calle 19","312333222","13","14","15","16","17","2");
	INSERT INTO `restaurant`(`idres`, `name_restaurant`, `address_restaurant`, `phone`, `id_lu_menu`, `id_ma_menu`, `id_mi_menu`, `id_ju_menu`, `id_vi_menu`, `id_sa_menu`) VALUES ("4","la merced","carrera 12","312333222","2","12","11","6","4","15");
	INSERT INTO `restaurant`(`idres`, `name_restaurant`, `address_restaurant`, `phone`, `id_lu_menu`, `id_ma_menu`, `id_mi_menu`, `id_ju_menu`, `id_vi_menu`, `id_sa_menu`) VALUES ("5","la canasta","calle 1","312333222","5","7","9","2","3","14");
	INSERT INTO `restaurant`(`idres`, `name_restaurant`, `address_restaurant`, `phone`, `id_lu_menu`, `id_ma_menu`, `id_mi_menu`, `id_ju_menu`, `id_vi_menu`, `id_sa_menu`) VALUES ("6","pollo sorpresa","carrera 10","312333222","3","2","6","4","5","8");
	INSERT INTO `restaurant`(`idres`, `name_restaurant`, `address_restaurant`, `phone`, `id_lu_menu`, `id_ma_menu`, `id_mi_menu`, `id_ju_menu`, `id_vi_menu`, `id_sa_menu`) VALUES ("7","Andres carne de res","carrera 12 con calle 10","312333222","7","8","3","4","6","12");
	
	INSERT INTO `delivery`(`id_delivery`, `descripcion`, `cantidad`, `direccion_envio`, `fecha`, `id_menu`) VALUES(NULL,"Pendiente por agregar", 4, "calle iguana", '2020/12/12',"1");
	INSERT INTO `delivery`(`id_delivery`, `descripcion`, `cantidad`, `direccion_envio`, `fecha`, `id_menu`) VALUES(NULL,"Pendiente por agregar", 2, "calle perico", '2020/12/11',"2");
	INSERT INTO `delivery`(`id_delivery`, `descripcion`, `cantidad`, `direccion_envio`, `fecha`, `id_menu`) VALUES(NULL,"Pendiente por agregar", 1, "calle elefante", '2020/12/13',"3");		
```
## 4. Configuring Payara Server 

Copy the driver sql-conector from the repository where installing your Payara Server.

![0](https://user-images.githubusercontent.com/53197926/99511021-bc1e6680-2955-11eb-9f93-cd6a56b6f2d1.png)

Go to Payara Server Console - Common Task in http://localhost:4848/ and click in JBDC , JBDC Connection Pools.

![1](https://user-images.githubusercontent.com/53197926/99511954-ecb2d000-2956-11eb-82ae-3651eb49d32f.png)

Create a new connection pool.

![2](https://user-images.githubusercontent.com/53197926/99512416-6d71cc00-2957-11eb-928e-f1db6ec3faa7.png)

Put your favorite name, select resource type and Database driver vender. Finally click in next

![3](https://user-images.githubusercontent.com/53197926/99512785-deb17f00-2957-11eb-8e54-b8a018add4be.png)

Select all properties and procede to delet, create seven new properties and insert the datas.

![4](https://user-images.githubusercontent.com/53197926/99513541-c2621200-2958-11eb-9021-e2d611e85dd7.png)

Go to back to JBDC and select JBDC Resources.

![5](https://user-images.githubusercontent.com/53197926/99513618-d574e200-2958-11eb-9d16-78b2434b4218.png)

Procede to create a new resource.

![6](https://user-images.githubusercontent.com/53197926/99513644-dad22c80-2958-11eb-94ef-b9a8868149ba.png)

Proce to fill the fields and click in ok.

![7](https://user-images.githubusercontent.com/53197926/99513660-dd348680-2958-11eb-900d-515d6802be49.png)

Go back to JBDC and select JBDC Connection Pools and select your created connection pool.

![8](https://user-images.githubusercontent.com/53197926/99513673-e0c80d80-2958-11eb-8aab-0716285cef68.png)

Don't forget runing xamp services. Procede to click in ping

![9](https://user-images.githubusercontent.com/53197926/99513689-e3c2fe00-2958-11eb-959c-6527a2cf0d62.png)

if everything goes fine, you will see the connection message with the database

![10](https://user-images.githubusercontent.com/53197926/99513702-e6bdee80-2958-11eb-9342-a8abd8b901d2.png)
