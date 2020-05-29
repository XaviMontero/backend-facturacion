# Facturación kpyvara
`Kpyvara` Software donde se redireccionara las peticiones 200 y acojer todos los registros generados por veronica 

## Software requerido
- JDK 1.8.0_121
- Apache Maven 3.5.3
- PostgreSQL 11.1-1

## Pasos previos
- [Instalar y configurar Maven](https://www.mkyong.com/maven/how-to-install-maven-in-windows/)
## Instalación
`generados` puede ser ejecutado como una aplicación Spring-Boot la cual requiere la instalación previa de PostgreSQL.

### Despliegue estándar

1. Abrir una consola o shell y crear la base de datos.
```bash
$ psql -U postgres
# CREATE DATABASE "kpyvara-db1";
# \q
```
2. Ejecuta spring boot ya que cuenta con la capa ddl-auto
