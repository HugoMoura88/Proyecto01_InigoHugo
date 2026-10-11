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
| Tienda | nombre, direccion, telefono, ciudad | «Cada una tiene su nombre, su dirección, su teléfono y su ciudad» |
| Editorial | nombre, país, teléfono de contacto | «de cada editorial anotan su nombre, el país y un teléfono de contacto para hacer pedidos» |
| Libro | SBN, título, año de publicación, número de páginas, precio de catálogo | «Cada libro se identifica por su ISBN (13 cifras), y de cada uno guardan el título, el año de publicación, el número de páginas y el precio de catálogo» |
| Autor | 	nombre, nacionalidad, año de nacimiento| «De cada autor guardamos el nombre, la nacionalidad y el año de nacimiento» |
| Empleado | DNI, nombre, apellidos, cargo, fecha de contratación, correo | «el DNI, el nombre y los apellidos, el cargo (…), la fecha de contratación y el correo de trabajo» |
| Cliente | nombre completo, correo (único), teléfono (opcional), si es socio, fecha de alta | «Los clientes pueden darse de alta como socios» |
| Pedido | número, fecha, forma de pago, estado| «Tiene una fecha, una forma de pago y un estado» |
| Inventario | copias, fecha del último recuento | «para cada libro y cada tienda sepa cuántas copias hay, y cuándo se contó por última vez» |
| Linea | cantidad, precio cobrado | «de cada uno me interesa la cantidad» y «guarde lo que realmente se cobró por cada libro» |
| Autoria | copias, fecha del último recuento | «distinguir si el autor es principal o colaborador en cada libro» |

## 2.2 Relaciones

| Relacion | Cardinalidad | Razonamiento |
|---|---|---|
| Editorial – Libro | 1:N | Una editorial publica muchos libros, cada libro lo publica una sola editorial |
| Libro – Autor | N:M | Un libro puede tener dos o tres autores y un autor tiene muchos libros |
| Tienda – Libro | N:M | Una tienda tiene muchos libros y un mismo libro está en varias tiendas (§1, §3). Se resuelve con Inventario, que guarda copias y fecha del recuento |
| Tienda – Empleado | 1:N | Una tienda tiene varios empleados; cada empleado trabaja en una sola |
| Tienda – Pedido | 1:N | Un pedido se hace siempre en una tienda; una tienda tiene muchos pedidos |
| Empleado – Pedido | 1:N | Un pedido lo atiende un empleado; un empleado atiende muchos pedidos |
| Cliente – Pedido | 1:N | Un pedido lo compra un cliente; un cliente hace muchos pedidos |
| Pedido – Libro | N:M | Un pedido lleva varios libros y un libro está en muchos pedidos |
| Sala – Sesión | 1:N | En una sala hay muchas sesiones; una sesión es en una sola sala. |

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

