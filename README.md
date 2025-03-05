
Instrucciones para ejecutar el proyecto

Requisitos previos:
•	Java 17
•	Maven 
•	Git 


Clonar el repositorio:
git clone https://github.com/danielagudelo11/pedidos.git


Construcción y ejecución del proyecto

1.	Abre una terminal y navega hasta la carpeta del proyecto:
cd 
Comando CMD: C:/ruta/del/proyecto


2.	Compila y construye el proyecto:
Comando CMD:  mvnw clean package


3.	Ejecuta la aplicación con Spring Boot:
Comando CMD:  mvnw spring-boot:run


Uso de la API

La API se ejecutará en http://localhost:8080. Los principales endpoints son:

Crear un pedido (POST)
•	URL:  http://localhost:8080/api/pedidos
•	Authorization: Basic Auth (admin/admin123)
•	Cuerpo JSON:
{
  "nombre": "Samsung S24",
  "total": 150. 0
}

Listar pedidos (GET)
•	URL:  http://localhost:8080/api/pedidos
•	Authorization: Basic Auth (admin/admin123)


Para cambiar el idioma de los mensajes en las respuestas de la API, usa el encabezado Accept-Language:
•	Español (por defecto): Accept-Language: es
•	Inglés: Accept-Language: en


Pruebas automatizadas
Para ejecutar las pruebas unitarias, usar el siguiente en la carpeta del proyecto:
Comando CMD: mvnw test
