//Usuario
INSERT INTO users(id, enable, password, username) VALUES (1, 1,'$2y$12$V5SGLIS3D6/kNQ4GLOWDDOkCUsdYax73FJIzTdVXeSmwRS5P.JXM2', 'admin');
INSERT INTO users(id, enable, password, username) VALUES (2, 1,'$2y$12$o4sr0CZZk9ROo/w3JLPxmOh5EPq9fvKUVOFiuMvtP8Q.ENaODKLwW', 'camiloa');
INSERT INTO users(id, enable, password, username) VALUES (3, 1,'$2y$12$o4sr0CZZk9ROo/w3JLPxmOh5EPq9fvKUVOFiuMvtP8Q.ENaODKLwW', 'javierM');
INSERT INTO users(id, enable, password, username) VALUES (4, 1,'$2y$12$o4sr0CZZk9ROo/w3JLPxmOh5EPq9fvKUVOFiuMvtP8Q.ENaODKLwW', 'Cesar05');
INSERT INTO users(id, enable, password, username) VALUES (5, 1,'$2y$12$o4sr0CZZk9ROo/w3JLPxmOh5EPq9fvKUVOFiuMvtP8Q.ENaODKLwW', 'camilob');
INSERT INTO users(id, enable, password, username) VALUES (6, 1,'$2y$12$o4sr0CZZk9ROo/w3JLPxmOh5EPq9fvKUVOFiuMvtP8Q.ENaODKLwW', 'carlosj');
INSERT INTO users(id, enable, password, username) VALUES (7, 1,'$2y$12$o4sr0CZZk9ROo/w3JLPxmOh5EPq9fvKUVOFiuMvtP8Q.ENaODKLwW', 'sebastianh');

//Roles
INSERT INTO authorities(id, authority, usuario) VALUES (1, 'ROLE_ADMIN',1);
INSERT INTO authorities(id, authority, usuario) VALUES (2, 'ROLE_SUPERVISOR',2);
INSERT INTO authorities(id, authority, usuario) VALUES (3, 'ROLE_SUPERVISOR',3);
INSERT INTO authorities(id, authority, usuario) VALUES (4, 'ROLE_SUPERVISOR',4);
INSERT INTO authorities(id, authority, usuario) VALUES (5, 'ROLE_VIGILANTE',5);
INSERT INTO authorities(id, authority, usuario) VALUES (6, 'ROLE_VIGILANTE',6);
INSERT INTO authorities(id, authority, usuario) VALUES (7, 'ROLE_VIGILANTE',7);

//Supervisores
INSERT INTO supervisor(cedula, edad, nombre, usuario) VALUES ('1090504585',35,'Camilo Andres Rivera',2);
INSERT INTO supervisor(cedula, edad, nombre, usuario) VALUES ('1090504586',40,'Javier Moncada',3);
INSERT INTO supervisor(cedula, edad, nombre, usuario) VALUES ('1090504587',45,'Cesar David Carvajal',4);

//Vigilantes
INSERT INTO vigilante(cedula, edad, nombre, supervisor, usuario) VALUES ('109012345',23,'Camilo Boada Mejia','1090504585',5);
INSERT INTO vigilante(cedula, edad, nombre, supervisor, usuario) VALUES ('109012346',23,'Carlos Jose Pablos',null,6);
INSERT INTO vigilante(cedula, edad, nombre, supervisor, usuario) VALUES ('109012347',23,'Sebastian Hernandez Mejia',null,7);


//Zonas
INSERT INTO zonas(id, contacto, direccion, nombre_empresa, responsable, telefono, supervisor) VALUES (1, 'ufps@gmail.com','Calle 3 av 4', 'UFPS', 'Hector Parra', '3124313245', '1090504585');


 