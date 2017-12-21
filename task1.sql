CREATE SCHEMA `real_estate` ;

CREATE TABLE `real_estate`.`house` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL,
  `price` INT NOT NULL,
  `date_complete_building` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `address_UNIQUE` (`address` ASC));

  
CREATE TABLE `real_estate`.`status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `status_UNIQUE` (`status` ASC));

  
CREATE TABLE `real_estate`.`renter` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `house_id` INT NOT NULL,
  `pay_date` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
  
CREATE TABLE `real_estate`.`payment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `renter_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `payment` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

  
INSERT INTO `real_estate`.`status` (`status`) VALUES ('under_construction');
INSERT INTO `real_estate`.`status` (`status`) VALUES ('ready');
INSERT INTO `real_estate`.`status` (`status`) VALUES ('rented');
INSERT INTO `real_estate`.`status` (`status`) VALUES ('for_rent');
INSERT INTO `real_estate`.`status` (`status`) VALUES ('for_sale');
INSERT INTO `real_estate`.`status` (`status`) VALUES ('solded');

INSERT INTO `real_estate`.`house` (`address`, `status`, `price`, `date_complete_building`) VALUES ('some_address_1', '1', '15', '18.12.2017');
INSERT INTO `real_estate`.`house` (`address`, `status`, `price`, `date_complete_building`) VALUES ('some_address_2', '2', '20', '30.10.2015');
INSERT INTO `real_estate`.`house` (`address`, `status`, `price`, `date_complete_building`) VALUES ('some_address_3', '3', '25', '25.01.2014');
INSERT INTO `real_estate`.`house` (`address`, `status`, `price`, `date_complete_building`) VALUES ('some_address_4', '4', '50', '14.10.2000');
INSERT INTO `real_estate`.`house` (`address`, `status`, `price`, `date_complete_building`) VALUES ('some_address_5', '5', '45', '15.09.2017');
INSERT INTO `real_estate`.`house` (`address`, `status`, `price`, `date_complete_building`) VALUES ('some_address_6', '6', '30', '10.06.2011');
INSERT INTO `real_estate`.`house` (`address`, `status`, `price`, `date_complete_building`) VALUES ('some_address_7', '3', '80', '23.10.2013');
INSERT INTO `real_estate`.`house` (`address`, `status`, `price`, `date_complete_building`) VALUES ('baker str', '3', '30', '23.05.2013');
INSERT INTO `real_estate`.`house` (`address`, `status`, `price`, `date_complete_building`) VALUES ('mallholand drive', '5', '85', '23.05.2013');

INSERT INTO `real_estate`.`renter` (`name`, `house_id`, `pay_date`) VALUES ('john', '3', '15.10.2013');
INSERT INTO `real_estate`.`renter` (`name`, `house_id`, `pay_date`) VALUES ('alex', '7', '25.10.2015');

INSERT INTO `real_estate`.`payment` (`renter_id`, `date`, `payment`) VALUES ('1', '2017.10.20', '20');
INSERT INTO `real_estate`.`payment` (`renter_id`, `date`, `payment`) VALUES ('1', '2017.09.20', '20');
INSERT INTO `real_estate`.`payment` (`renter_id`, `date`, `payment`) VALUES ('1', '2017.11.20', '20');
INSERT INTO `real_estate`.`payment` (`renter_id`, `date`, `payment`) VALUES ('2', '2017.07.17', '40');

  
  
  
select 'Сдано в аренду ', count(*) as 'Количество' from real_estate.house where status = 3 group by house.status
union 
select 'На продажу ', count(*) as 'Количество' from real_estate.house where status = 5 group by house.status
union 
select 'Продано  ', count(*) as 'Количество' from real_estate.house where status = 6 group by house.status;

select renter.name as 'Арендатор', renter.pay_date as 'Дата платежа', payment.payment as 'Сумма платежа' from real_estate.renter, real_estate.payment where renter.id=payment.renter_id group by renter.name
union
select 'Всего ', 'арендаторов ', count(renter.id) from real_estate.renter;
  
select 'Общая стоимость всех домов ', sum(house.price) from real_estate.house;

select address as 'Адрес дома', date_complete_building as 'Дата постройки' from real_estate.house where address = 'baker str' or address = 'mallholand drive';