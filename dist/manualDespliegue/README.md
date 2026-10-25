# Sistema de Gestión de Biblioteca

Aplicación de consola hecha en Java para gestionar los libros de una biblioteca. Los datos se pueden guardar en una base de datos MySQL o en un archivo de texto, y se elige al arrancar

Es un proyecto Ant de NetBeans

## Requisitos

| Software | Versión |
|---|---|
| Windows | 10 / 11 |
| JDK | 21 |
| NetBeans | 23 |
| MySQL | 8.4 |
| Git | la última |

## Instalación rápida

1. Clonar el repositorio: git clone https://github.com/HugoMoura88/Proyecto01_InigoHugo.git
2. Abrir la carpeta en NetBeans (File > Open Project). Las librerías están en lib/
3. Crear la base de datos desde cmd
4. Copiar .env.example como .env y poner el usuario y la contraseña de MySQL
5. Clean and Build y luego Run

## Configuración (.env)

| Variable | Qué es | Ejemplo |
|---|---|---|
| DB_URL | URL de la base de datos | jdbc:mysql://localhost:3306/biblioteca |
| DB_USER | Usuario de MySQL | root |
| DB_PASSWORD | Contraseña de MySQL | tu contraseña |

El .env tiene que estar en la carpeta del proyecto y no se sube a GitHub.

## Documentación

- [Manual de despliegue completo (PDF)](docs/manual_despliegue.pdf)

## Autores

- Iñigo
- Hugo
