create table admin(
	username varchar(100) primary key,
	password varchar(20) not null
);

create table User(
	username varchar(100) primary key,
	password varchar(20) not null,
	title varchar(20),
	firstname varchar(100) not null,
	lastname varchar(100) not null,
	dob varchar(50),
	gender varchar(100),
	address varchar(100) not null,
	mobileNo varchar(100) not null
);

CREATE TABLE flight(
	flight_id integer ,
	flight_name varchar(25),
	src varchar(25),
	dest varchar(25),
	datei varchar(15),
	time varchar(20),
	type varchar(20),
	Primary Key(flight_id,flight_name,type));

create table typeSeats(
	flight_id integer,
	type varchar(20),
	noOfSeats integer,
	AvailableSeats integer,
	Price float,
	flight_name varchar(25),
	Primary Key(flight_id,flight_name,type),
	FOREIGN KEY(flight_id,flight_name,type) References FLIGHT(flight_id,flight_name,type));


create table History(
	username varchar(100),
	flightId int,
	flightname varchar(100),
	source varchar(100),
	dest varchar(100),
	date varchar(100),
	time varchar(100),
	type varchar(20),
	price float,
	primary key(username,flightId,type);

);
create table History(

	username varchar(100),
	flightId int,
	flightname varchar(100),
	source varchar(100),
	dest varchar(100),
	date varchar(100),
	time varchar(100),
	type varchar(20),
	price float,
	primary key(username,flightId,type),
	Foreign key(username) references user(username)

);


insert into admin values('Sonalj@gmail.com','payal');
insert into History values('Him@gmail.com',1,'IndiaAirline','Jaipur','Mumbai','1998-02-13','12','Economic',1000);
insert into History values('priyanka@gmail.com',2,'CheapAirline','kota','Jaipur','2013-02-13','1','Business',2000);
