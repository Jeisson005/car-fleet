# Car fleet
## Descripción
Prueba práctica en Java.<br/>
Sistema en Maven + SpringBoot + SpringSecurity + SpringData que gestiona el uso de automóviles en la flota de una empresa por parte de los empleados. La persistencia estará en
PostgreSQL.
## Alcances y limitaciones
El proyecto cuenta con todos y cada uno de los requerimientos descritos en el documento recibido, sin embargo es importante mencionar algunos ajustes y delimitaciones que se establecieron durante el desarrollo:
- Algunos nombres de atributos se cambiaron (por ejemplo dataFabricacao a fechaFabricacion)
- Sí se contemplaron las validaciones y manejo de exepciones en todos los servicios
- No se desarrollaron parámetros de búsqueda o paginación sobre los servicios
- No se desarrolló un sistema de gestión de múltiples usuarios
- La API funciona con un único usuario configurado por parámetros (aunque se podría ampliar para usar un repositorio Spring Data de usuarios)
- Se crearon los archivos necesarios para ejecutar el proyecto con docker compose

## Ejecución
Las siguientes son las posibles formas de ejecución, las variables requeridas estan ya con sus valores por defecto en cada archivo, por lo que es probable que no se requiera ninguna configuración adicional.
### Maven
El proyecto puede ser ejecutado directamente con maven si se cuenta con todas las versiones compatibles:
```
mvn spring-boot:run
```
En este caso el archivo [application.properties](src/main/resources/application.properties) cuenta con todas las variables de entorno y sus valores por defecto, puede ser configurado según se requiera (pero ).
### Docker compose 
Puede ser ejecutado usando `docker-compose up` o en la última versión de docker:
```
docker compose up
```
En este caso archivo [.env](.env) cuenta con todas las variables de entorno y sus valores por defecto, este archivo puede cambiarse teniendo múltiples ".env" para el ambiente requerido con los valores que se requieran.
## Desarrollo y tecnologías
Estas son las tecnologías utilizadas:

- Java, Maven, SpringBoot, SpringSecurity, SpringData: Tecnologías base
- jjwt: Manejo de tokens jwt
- SpringBoot Devtools: Despliegue rápido en ambiente de desarrollo
- Lombok: Simplifica el lenguaje repetitivo de Java

# Soporte
Creador y autor:
| Campo | Valor |
| ------ | ------ |
| Nombre | Jeisson Piñeros|
| Correos | jeisson005@hotmail.com <br> jeissonp005@gmail.com <br> jrpinerosr@udistrital.edu.co|
| Teléfono | <a href="tel:573115339687">+57 3115339687</a> |
