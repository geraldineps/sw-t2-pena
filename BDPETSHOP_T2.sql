Create DataBase BDPetshop;
Use BDPetshop;

create table cliente
( idcliente int PRIMARY key auto_increment,
nombrecli varchar(30),
apellidoscli varchar(30),
correo varchar(50),
direccion varchar(30),
telefono varchar(15),
dni varchar(8));

create table empleado
( idempleado int PRIMARY key auto_increment,
nombreemp varchar(30),
apellidosemp varchar(30),
correoemp varchar(50),
direccionemp varchar(30),
telefonoemp varchar(15),
dniemp varchar(8));

create table categoria(
idcategoria int primary key auto_increment,
nombrecategoria varchar (50)
);

create table producto(
idproducto int primary key auto_increment,
nombreproducto varchar (200),
idcategoria int,
marca varchar(100),
precio decimal(10,4),
stock int,
FOREIGN KEY(idcategoria) REFERENCES categoria(idcategoria));

create table boletap(
idboletap int PRIMARY KEY auto_increment,
fechaPago date,
idcliente int,
idempleado int,
FOREIGN KEY(idcliente) REFERENCES cliente(idcliente),
FOREIGN KEY(idempleado) REFERENCES empleado(idempleado));


create table detalleboletap( 
idboletap int,
idproducto int,
cantidad int,
precio decimal(10,4),
FOREIGN KEY(idboletap) REFERENCES boletap(idboletap),
FOREIGN KEY(idproducto) REFERENCES producto(idproducto));



INSERT INTO categoria (nombrecategoria)
VALUES
('Alimento para perros'),
('Alimento para gatos'),
('Juguetes para mascotas'),
('Accesorios para mascotas'),
('Higiene y cuidado');


INSERT INTO producto (nombreproducto, idcategoria, marca, precio, stock)
VALUES
('Croquetas para perros 10kg', 1, 'DogChow', 45.99, 50),
('Arena para gatos 5kg', 2, 'CatLitter', 10.50, 30),
('Pelota de goma para perros', 3, 'PetFun', 5.99, 100),
('Collar ajustable para perros', 4, 'PetSafe', 12.99, 25),
('Shampoo para gatos 500ml', 5, 'CatClean', 8.50, 40),
('Croquetas para gatos 5kg', 2, 'Whiskas', 25.99, 40),
('Rascador para gatos mediano', 3, 'CatFun', 35.00, 15),
('Comedero automático para perros', 4, 'PetFeeder', 45.99, 10),
('Cama para perros tamaño grande', 4, 'ComfortPet', 55.99, 20),
('Juguete interactivo para gatos', 3, 'CatPlay', 18.75, 60),
('Arena biodegradable para gatos 10kg', 2, 'EcoCat', 20.99, 25),
('Cepillo para el pelaje de perros', 5, 'PetGroom', 15.50, 50),
('Comida húmeda para perros 1kg', 1, 'Pedigree', 12.99, 35),
('Transportadora para gatos', 4, 'TravelPet', 49.99, 12),
('Snacks dentales para perros', 1, 'DentaChew', 9.99, 100);


INSERT INTO cliente (nombrecli, apellidoscli, correo, direccion, telefono, dni)
VALUES 
('Marcos', 'Sánchez', 'MarcoSanchez123@gmail.com','av. tulipanes 258','985 258 147','25897463'),
('María', 'Chavez', 'MaríaChavez124@hotmail.com','av. las flores 123','935 741 421','74896321'),
('José', 'Fernandez', 'Joséernandez247@gmail.com' ,'av. rosales 478','985 999 658','25896347'),
('Julio', 'Tello', 'JulioTello742@hotmail.com','av. bertello 45','924 478 639','74859612'),
('Maria', 'Gomez', 'MariaGomez85@gmail.com', 'calle San Martin 123', '921 365 214', '84571236'),
('Carlos', 'Ruiz', 'CarlosR1980@yahoo.com', 'jr. Los Álamos 204', '952 487 165', '36754892'),
('Ana', 'Pérez', 'AnaPerez73@outlook.com', 'av. Las Flores 567', '987 654 321', '15963247'),
('Jose', 'Moreno', 'JoseM_92@hotmail.com', 'calle Los Laureles 890', '914 258 796', '27485916'),
('Patricia', 'Ortiz', 'PattyOrtiz24@gmail.com', 'av. Bolívar 111', '968 574 231', '48579612'),
('Luis', 'Fernandez', 'LuisFdez76@hotmail.com', 'calle Los Pinos 444', '924 678 354', '56879431'),
('Laura', 'Martinez', 'LauraMtz_89@yahoo.com', 'av. Principal 780', '911 345 678', '64857912'),
('Diego', 'Vega', 'DiegoV123@gmail.com', 'jr. La Unión 55', '953 286 417', '76948521'),
('Sofia', 'Lopez', 'SofiaLopez_94@hotmail.com', 'av. Libertad 300', '968 534 219', '75896412'),
('Miguel', 'Torres', 'MiguelT85@gmail.com', 'calle Nueva 645', '920 438 765', '87459632'),
('Carmen', 'Jimenez', 'CarmenJ_87@yahoo.com', 'av. Los Alamos 458', '937 512 846', '96587413'),
('Francisco', 'Diaz', 'PacoDiaz71@hotmail.com', 'jr. Las Dalias 212', '975 467 189', '15489672'),
('Sandra', 'Romero', 'SandraRo88@gmail.com', 'calle Margaritas 678', '981 467 543', '31659785'),
('Ricardo', 'Soto', 'RickySoto45@hotmail.com', 'av. San Miguel 142', '976 359 821', '49856172'),
('Andrea', 'Garcia', 'AndyGarcia_93@yahoo.com', 'calle Los Cedros 900', '947 286 543', '63594871'),
('Oscar', 'Morales', 'OscarM76@gmail.com', 'jr. Las Begonias 321', '952 467 821', '48571269'),
('Veronica', 'Castro', 'VeroCastro82@hotmail.com', 'av. El Sol 112', '924 678 396', '64859713'),
('Jorge', 'Rodriguez', 'JorgeRdz_77@yahoo.com', 'calle Los Lirios 433', '910 345 672', '75984312'),
('Natalia', 'Vargas', 'NatyVargas_85@gmail.com', 'av. Del Pueblo 223', '938 467 124', '84759236'),
('Hector', 'Salazar', 'HectorSal90@hotmail.com', 'jr. Las Camelias 987', '976 352 467', '39715482');

INSERT INTO empleado (nombreemp, apellidosemp, correoemp, direccionemp, telefonoemp, dniemp)
VALUES
('Carlos', 'Sánchez', 'carlos.sanchez@tiendamascotas.com', 'Calle Sol 123', '987654321', '12345678'),
('María', 'Pérez', 'maria.perez@tiendamascotas.com', 'Avenida Luna 456', '987654322', '23456789'),
('Ana', 'Gómez', 'ana.gomez@tiendamascotas.com', 'Calle Estrella 789', '987654323', '34567890'),
('Luis', 'Fernández', 'luis.fernandez@tiendamascotas.com', 'Calle Río 101', '987654324', '45678901'),
('Paola', 'Díaz', 'paola.diaz@tiendamascotas.com', 'Avenida Mar 202', '987654325', '56789012');


DELIMITER  $$
CREATE PROCEDURE InsertarProducto(
    IN nombreProducto VARCHAR(200),
    IN idCategoria INT,
    IN marca VARCHAR(100),
    IN precio DECIMAL(10,4),
    IN stock INT
)
BEGIN
    INSERT INTO producto(nombreproducto, idcategoria, marca, precio, stock)
    VALUES (nombreProducto, idCategoria, marca, precio, stock);
END $$

DELIMITER ;

DELIMITER  $$

CREATE PROCEDURE ActualizarStockProducto(
    IN idProducto INT,
    IN nuevoStock INT
)
BEGIN
    UPDATE producto
    SET stock = nuevoStock
    WHERE idproducto = idProducto;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE InsertarCliente(
    IN nombreCli VARCHAR(30),
    IN apellidosCli VARCHAR(30),
    IN correoCli VARCHAR(50),
    IN direccionCli VARCHAR(30),
    IN telefonoCli VARCHAR(15),
    IN dniCli VARCHAR(8)
)
BEGIN
    INSERT INTO cliente(nombrecli, apellidoscli, correo, direccion, telefono, dni)
    VALUES (nombreCli, apellidosCli, correoCli, direccionCli, telefonoCli, dniCli);
END $$

DELIMITER ;








