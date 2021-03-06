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

3. Si deseas cambiar ala version de docker 

```
spring.datasource.url=jdbc:postgresql://dbpostgresql-db/facturacion-api
spring.datasource.username=postgres
spring.datasource.password=XaviNoob2016
spring.datasource.initialization-mode=always
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true 
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jackson.default-property-inclusion=non-null
server.port = 80
security.oauth2.resource.filter-order=3

security.signing-key=MaYzkSjmkzPC57L
security.encoding-strength=256
security.security-realm=Spring Boot JWT

security.jwt.client-id=mitomediapp
security.jwt.client-secret=mito89codex
security.jwt.grant-type=password
security.jwt.scope-read=read
security.jwt.scope-write=write
security.jwt.resource-ids=mitoresourceid
```
 

4. Si desea ejecutar local 

```
spring.datasource.url=jdbc:postgresql://localhost:5432/kpyvara-db1
spring.datasource.username=postgres
spring.datasource.password=admin
spring.datasource.initialization-mode=always
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true 
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jackson.default-property-inclusion=non-null
security.oauth2.resource.filter-order=3

security.signing-key=MaYzkSjmkzPC57L
security.encoding-strength=256
security.security-realm=Spring Boot JWT

security.jwt.client-id=mitomediapp
security.jwt.client-secret=mito89codex
security.jwt.grant-type=password
security.jwt.scope-read=read
security.jwt.scope-write=write
security.jwt.resource-ids=mitoresourceid
```
5. Modelo de retencion 

```
{
	"empresa":{
	 "ruc":"0300937034001"	
	},
	"rucProvedor":"0106079783",
	"valor":15.00,
	"baseImponible":16.23,
	"fecha":"2020-06-02",
	"codigo":"0545646484678786768767687687645161368841646",
	"documento":"Documento"
}
```
6. Modelo de factura

```
	{
	"empresa":{
	 "ruc":"0300937034001"	
	},
	"identificacion":"0106079783",
	"subTotal":15.00,
	"total":16.23,
	"iva":0.12,
	"subTotaliva":0.95,
	"fecha":"2020-06-02",
	"codigo":"0545646484678786768767687687645161368841646",
	"documento":"Aqui va el pdf en byte "
	}
```

7. Modelo de para crear un contador
```
{
    "idUsuario": 25,
    "username": "xavi@kpyvara.com",
    "password": "123",
    "enabled": true,
    "empresas": [
        { "ruc": "0300937034001"}
    ]
}
```
Ahora podras eliminar retenciones y facturas con  la clave de acceso que poseea el usuario final

https://tu-api/facturas/{Clave de acceso}

https://tu-api/facturas/{Clave de acceso
