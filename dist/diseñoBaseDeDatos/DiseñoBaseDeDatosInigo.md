# Base de datos de Páginas de Villa Serena

## 1. Resumen del caso

Este caso trata de hacer una base de datos para Paginas de Villa Serena, una libreria con 20 años de historia que empezo como una pequeña tienda de barrio,
su dueña es Elena Ruiz, tiene 3 tiendas: Centro, Ribera y Universidad 

Cada tienda cuenta con su propio personal y su propia hoja de calculo, esto provoca que la informacion acabe siendo un lio, Elena cuenta que una vez un cliente
pidio un libro en la tienda Centro, la informacion decia que habia 3 copias y en verdad estaban todas en otra tienda, ademas Elena quiere que en case de que 
algun empleado cambie de tienda figure rapidamente en la nueva aunque no le importaria que se mantenga su historial en la anterior. Cada libro cuenta con un ISBN, 
título, año de publicación, número de páginas, precio y su editorial, Elena quiere poder agilizar la busqueda de libros por autor ya que algunos libros tienen 
mas de un autor y necesita poder saber si el autor es priincipal o colaborador. En cuanto a los clientes Elena quiere que todos se registren, ya sean socios
o no ya que quiere poder avisarles de las novedades, pero los que no son socios solo deberan registrarse con su nombre y correo mientras que los socios ademas
la fecha de alta y opcionalmente el telefono. Elena tambien tiene problemas con las facturas de las compras, los precios se suelen reflejar erroneamente

En resumen Elena quiere una base de datos centralizada que permita reflejar correctamente el inventario de cada tienda, que tenga un catalogo de libros
versatil que permita encontrar facilmente cada libro como ver los libros que ha escrito cada autor tanto si es el principal como colaborador  

## 6. Script SQL ejecutable

CREATE DATABASE libreria; 
USE libreria;

CREATE TABLE `libreria`.`editorial` (
  `ideditorial` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(45) NULL,
  `pais` VARCHAR(45) NULL,
  PRIMARY KEY (`ideditorial`));

CREATE TABLE `libreria`.`autor` (
  `idautor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `nacionalidad` VARCHAR(45) NULL,
  `anio_nacimienot` INT NULL,
  PRIMARY KEY (`idautor`));

CREATE TABLE `libreria`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombre_completo` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`idcliente`));

CREATE TABLE `libreria`.`tienda` (
  `idtienda` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `direccion` VARCHAR(150) NULL,
  `ciudad` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`idtienda`));

CREATE TABLE `libreria`.`libro` (
  `isbn` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(200) NOT NULL,
  `anio_publicacion` INT NULL,
  `paginas` INT NULL,
  `precio_catalogo` DECIMAL(10,2) NOT NULL,
  `id_editorial` INT NOT NULL,
  PRIMARY KEY (`isbn`),
  INDEX `fk_id_editorial_idx` (`id_editorial` ASC) VISIBLE,
  CONSTRAINT `fk_id_editorial`
    FOREIGN KEY (`id_editorial`)
    REFERENCES `libreria`.`editorial` (`ideditorial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `libreria`.`empleado` (
  `dni` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `apellidos` VARCHAR(150) NOT NULL,
  `email` VARCHAR(100) NULL,
  `cargo` VARCHAR(45) NULL,
  `fecha_contratacion` DATETIME NULL,
  `id_tienda` INT NOT NULL,
  PRIMARY KEY (`dni`),
  INDEX `fk_id_tienda_idx` (`id_tienda` ASC) VISIBLE,
  CONSTRAINT `fk_id_tienda`
    FOREIGN KEY (`id_tienda`)
    REFERENCES `libreria`.`tienda` (`idtienda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `libreria`.`libro_autor` (
  `isbn` INT NOT NULL,
  `id_autor` INT NOT NULL,
  `rol` VARCHAR(50) NULL,

  PRIMARY KEY (`isbn`, `id_autor`),

  INDEX `fk_isbn_libro_idx` (`isbn` ASC) VISIBLE,
  INDEX `fk_id_autor_idx` (`id_autor` ASC) VISIBLE,

  CONSTRAINT `fk_isbn_libro`
    FOREIGN KEY (`isbn`)
    REFERENCES `libreria`.`libro` (`isbn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

  CONSTRAINT `fk_id_autor`
    FOREIGN KEY (`id_autor`)
    REFERENCES `libreria`.`autor` (`idautor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE `libreria`.`inventario` (
  `isbn` INT NOT NULL,
  `id_tienda` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `fecha_ultimo_conteo` DATE NULL,

  PRIMARY KEY (`isbn`, `id_tienda`),

  INDEX `fk_inventario_libro_idx` (`isbn` ASC) VISIBLE,
  INDEX `fk_inventario_tienda_idx` (`id_tienda` ASC) VISIBLE,

  CONSTRAINT `fk_inventario_libro`
    FOREIGN KEY (`isbn`)
    REFERENCES `libreria`.`libro` (`isbn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

  CONSTRAINT `fk_inventario_tienda`
    FOREIGN KEY (`id_tienda`)
    REFERENCES `libreria`.`tienda` (`idtienda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION


);
CREATE TABLE `libreria`.`socio` (
  `id_socio` INT NOT NULL AUTO_INCREMENT,
  `id_cliente` INT NOT NULL,
  `fecha_alta` DATE NOT NULL,

  PRIMARY KEY (`id_socio`),

  UNIQUE INDEX `id_cliente_UNIQUE` (`id_cliente` ASC) VISIBLE,
  INDEX `fk_socio_cliente_idx` (`id_cliente` ASC) VISIBLE,

  CONSTRAINT `fk_socio_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `libreria`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);



CREATE TABLE `libreria`.`pedido` (
  `id_pedido` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `forma_pago` VARCHAR(50) NULL,
  `estado` VARCHAR(50) NULL,
  `id_cliente` INT NOT NULL,
  `dni_empleado` VARCHAR(20) NOT NULL,
  `id_tienda` INT NOT NULL,

  PRIMARY KEY (`id_pedido`),

  INDEX `fk_pedido_cliente_idx` (`id_cliente` ASC) VISIBLE,
  INDEX `fk_pedido_empleado_idx` (`dni_empleado` ASC) VISIBLE,
  INDEX `fk_pedido_tienda_idx` (`id_tienda` ASC) VISIBLE,

  CONSTRAINT `fk_pedido_cliente`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `libreria`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

  CONSTRAINT `fk_pedido_empleado`
    FOREIGN KEY (`dni_empleado`)
    REFERENCES `libreria`.`empleado` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

  CONSTRAINT `fk_pedido_tienda`
    FOREIGN KEY (`id_tienda`)
    REFERENCES `libreria`.`tienda` (`idtienda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE `libreria`.`detalle_pedido` (
  `id_pedido` INT NOT NULL,
  `isbn` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `precio_unitario` DECIMAL(10,2) NOT NULL,

  PRIMARY KEY (`id_pedido`, `isbn`),

  INDEX `fk_detalle_pedido_pedido_idx` (`id_pedido` ASC) VISIBLE,
  INDEX `fk_detalle_pedido_libro_idx` (`isbn` ASC) VISIBLE,

  CONSTRAINT `fk_detalle_pedido_pedido`
    FOREIGN KEY (`id_pedido`)
    REFERENCES `libreria`.`pedido` (`id_pedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

  CONSTRAINT `fk_detalle_pedido_libro`
    FOREIGN KEY (`isbn`)
    REFERENCES `libreria`.`libro` (`isbn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION

 
);



