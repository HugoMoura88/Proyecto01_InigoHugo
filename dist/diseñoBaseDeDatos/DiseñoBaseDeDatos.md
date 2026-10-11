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

## 2. Analisis del caso


## 2.1 Entidades y atributos

| Entidad | Atributos encontrados | Fragmento del texto |
|---|---|---|
| Tienda | id, nombre, direccion, telefono, ciudad | «Cada una tiene su nombre, su dirección, su teléfono y su ciudad» |
| Editorial | id, nombre, pais, telefono | «de cada editorial anotan su nombre, el pais y un telefono de contacto para hacer pedidos» |
| Libro | isbn, titulo, anio_publicacion, num_paginas, precio, editorial_id | «Cada libro se identifica por su ISBN (13 cifras), y de cada uno guardan el titulo, el anio de publicacion, el numero de paginas y el precio de catalogo» |
| Autor | id, nombre, nacionalidad, anio_nacimiento | «De cada autor guardamos el nombre, la nacionalidad y el anio de nacimiento» |
| Empleado | dni, nombre, apellidos, cargo, fecha_contratacion, correo, tienda_id | «el DNI, el nombre y los apellidos, el cargo, la fecha de contratacion y el correo de trabajo» |
| Cliente | id, nombre, correo, telefono, es_socio, fecha_alta | «Los clientes pueden darse de alta como socios» y «nombre y correo» |
| Pedido | id, fecha, forma_pago, estado, tienda_id, empleado_dni, cliente_id | «Pedido n», «Fecha», «forma de pago y un estado» |
| inventario (intermedia) | tienda_id, isbn, copias, fecha_recuento | «para cada libro y cada tienda sepa cuantas copias hay, y cuando se conto por ultima vez» |
| linea_pedido (intermedia) | pedido_id, isbn, cantidad, precio_cobrado | «cada pedido puede llevar varios libros distintos, y de cada uno me interesa la cantidad» y «guarde lo que realmente se cobro» |
| libro_autor (intermedia) | isbn, autor_id, rol | «distinguir si el autor es principal o colaborador en cada libro» |

## 2.2 Relaciones

| Relacion | Cardinalidad | Razonamiento |
|---|---|---|
| Editorial – Libro | 1:N | Una editorial publica muchos libros; un libro lo publica una sola editorial |
| Libro – Autor | N:M | Un libro puede estar escrito por varios autores y un autor tiene muchos libros. Se resuelve con la tabla intermedia libro_autor (que incluye el rol) |
| Tienda – Libro | N:M | Una tienda tiene muchos libros en su inventario y un libro esta en varias tiendas. Se resuelve con la tabla intermedia inventario (con copias y fecha_recuento) |
| Tienda – Empleado | 1:N | Una tienda tiene varios empleados; cada empleado trabaja en una sola tienda |
| Tienda – Pedido | 1:N | Un pedido se hace siempre en una tienda; una tienda tiene muchos pedidos |
| Empleado – Pedido | 1:N | Un pedido lo atiende un empleado; un empleado atiende muchos pedidos |
| Cliente – Pedido | 1:N | Un pedido lo compra un cliente; un cliente puede hacer varios pedidos |
| Pedido – Libro | N:M | Un pedido lleva varios libros y un libro aparece en muchos pedidos. Se resuelve con la tabla intermedia linea_pedido (con cantidad y precio_cobrado) |

## 3. Reglas del negocio

1. Cada libro tiene un ISBN de 13 cifras y no puede haber dos libros con el mismo
2. Un libro lo publica una sola editorial, pero una editorial puede publicar muchos libros
3. Un libro puede tener varios autores y un autor puede tener varios libros. Ademas hay que saber si el autor es principal o colaborador
4. De cada libro en cada tienda se guarda cuantas copias hay y la fecha del ultimo recuento
5. Si un libro no esta en una tienda no se pone nada, y las copias no pueden ser negativas
6. Cada empleado trabaja en una sola tienda y en una tienda trabajan varios empleados
7. El cargo del empleado solo puede ser librero, cajero o encargado
8. Si un empleado cambia de tienda no se guarda el historial, solo la tienda nueva
9. Los clientes tienen nombre y correo (el correo no se repite). El telefono es opcional
10. Los socios tienen fecha de alta
11. Un pedido se hace en una tienda, lo atiende un empleado y lo compra un cliente
12. El pedido tiene fecha, forma de pago (efectivo, tarjeta o bizum) y estado (preparado, entregado o cancelado)
13. Un pedido puede tener varios libros y de cada uno se guarda la cantidad
14. En cada pedido se guarda el precio que se cobro por cada libro, porque el precio del catalogo puede cambiar
15. El total del pedido no se guarda porque se puede calcular

## 4.Diagrama Entidad-Relacion

![Diagrama entidad relacion](image.png)

## 5. Modelo logico

### tienda
| Columna | Clave | Referencia |
|---|---|---|
| idtienda | PK | |
| nombre | | |
| direccion | | |
| ciudad | | |
| telefono | | |

### editorial
| Columna | Clave | Referencia |
|---|---|---|
| ideditorial | PK | |
| nombre | | |
| telefono | | |
| pais | | |

### autor
| Columna | Clave | Referencia |
|---|---|---|
| idautor | PK | |
| nombre | | |
| nacionalidad | | |
| anio_nacimienot | | |

### libro
| Columna | Clave | Referencia |
|---|---|---|
| isbn | PK | |
| titulo | | |
| anio_publicacion | | |
| paginas | | |
| precio_ratalogo | | |
| id_editorial | FK | editorial.ideditorial |

### cliente
| Columna | Clave | Referencia |
|---|---|---|
| idcliente | PK | |
| nombre_completo | | |
| email | | |
| telefono | | |

### empleado
| Columna | Clave | Referencia |
|---|---|---|
| dni | PK | |
| nombre | | |
| apellidos | | |
| email | | |
| cargo | | |
| fecha_contratacion | | |
| id_tienda | FK | tienda.idtienda |

### pedido
| Columna | Clave | Referencia |
|---|---|---|
| id_pedido | PK | |
| fecha | | |
| forma_pago | | |
| estado | | |
| id_cliente | FK | cliente.idcliente |
| dni_empleado | FK | empleado.dni |
| id_tienda | FK | tienda.idtienda |

### detalle_pedido (intermedia)
| Columna | Clave | Referencia |
|---|---|---|
| id_pedido | PK, FK | pedido.id_pedido |
| isbn | PK, FK | libro.isbn |
| cantidad | | |
| precio_unitario | | |

### socio
| Columna | Clave | Referencia |
|---|---|---|
| id_socio | PK | |
| id_cliente | FK | cliente.idcliente |
| fecha_alta | | |

### inventario
| Columna | Clave | Referencia |
|---|---|---|
| isbn | PK, FK | libro.isbn |
| id_tienda | PK, FK | tienda.idtienda |
| cantidad | | |
| fecha_ultimo_conteo | | |

### libro_autor (intermedia)
| Columna | Clave | Referencia |
|---|---|---|
| isbn | PK, FK | libro.isbn |
| id_autor | PK, FK | autor.idautor |
| rol | | |