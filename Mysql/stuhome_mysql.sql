create database stuhome;

create table usuario (
id_usuario int primary key,
nombre varchar(30),
apellido varchar(30),
edad int,
email varchar(30),
username varchar(30),
usertype bool,
resenyas int,
telefono int,
direccion varchar(30),
descripcion text,
estudios varchar(30));

create table vivienda (
id_vivienda int primary key,
direccion varchar(100),
ciudad varchar(30),
comarcas varchar(50),
municipios varchar(50),
barrios varchar(50),
superficies float,
tipo_vivienda varchar(30),
precio int,
descripcion text,
num_habitacion int,
num_banyos int,
orientacion varchar(30),
antiguedad int,
imagenes blob,
cert_energetico blob,
extras_interior text,
extras_exterior text,
extras_comunitarios text,
resenyas text);

create table alquilar (
id_usuario int,
id_vivienda int,
tiempo_start date,
tiempo_termino date,
foreign key (id_usuario) references usuario(id_usuario),
foreign key (id_vivienda) references vivienda(id_vivienda));

create table habitacion (
id_habitacion int primary key,
direccion varchar(100),
ciudad varchar(30),
comarcas varchar(50),
municipios varchar(50),
comentarios text,
imagenes blob,
descripcion text,
antiguedad int,
num_banyos int,
precio int,
id_usuario int,
id_vivienda int,
foreign key (id_usuario) references usuario(id_usuario),
foreign key (id_vivienda) references vivienda(id_vivienda))

create table chat (
id_chat int primary key,
mensajes text,
mensaje_tiempo date,
nombre_usuario varchar(30),
img_perfil blob,
id_usuario int,
foreign key (id_usuario) references usuario(id_usuario))
