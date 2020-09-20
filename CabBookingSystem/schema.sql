create table Orders (
        orderId serial,
        customerLatitude float8 not null,
        customerLongitude float8 not null,
        customerName varchar(255) not null,
        primary key (orderId)
    );
create table Drivers (
        driverId serial,
        currentLatitude float8 not null,
        currentLogitude float8 not null,
        driverName varchar(255) not null,
        status varchar(255) not null,
		orderId int,
        primary key (driverId),
		CONSTRAINT fk_orders
       FOREIGN KEY(orderId) 
	  REFERENCES Orders(orderId)
    );
