# zemoga-back-test
Prueba backend zemoga

Para ejecutar el backEnd necesitaras lo siguiente:

- Java 11 (JDK 11)
- IDE Eclipse (Eclipse IDE for Enterprise Java Developers - 2020-06)
- Spring boot (Para instalar spring boot en eclipse puede seguir el siguiente enlace: https://www.youtube.com/watch?v=6Tuomy5INcY)
- Tomcat 9.0 o mayor, no sirven versiones inferiores como la 8.5 debido a la version JDK 11 usada en el proyecto
- Postman para probar el servicio post, estara adjunto al correo donde este el link de la prueba
y en este estaran las URLs con ejemplos de los json con que se puede probar
- A nivel de back, la API de twitter puede cargar los comentarios de cualquier usuario registrado en la red, a nivel de frontEnd se valida que solo muestre los registrados en la base de datos suministrada en la prueba
- Las librerias necesarias para el proyecto estan en un archivo POM, hay que realizar un "Maven update", en caso de ser necesario
- En eclipse, montar el servidor tomcat y agregarlo en el IDE
- La informacion de las versiones de las librerias se encuentra en la carpeta libreries del proyecto
- Las librerias principales del proyectos estan descritas en el archivo POM
- Es posible que 

Horas de trabajo en backend(15 horas aprox)

- En la construccion de paquetes e integracion de las librerias que necesitaba 4 horas
- 1 hora mas añadiendo las librerias de twitter4j y Twitter4j-v2
- En la logica principal de la aplicacion DTOs,DAOs,Services, etc (4 horas)
- Arreglando detalles y errores (4 horas) (Cambie mas de una vez el tipo de consulta que iba a hacer y los campos que iba a consultar para realizar servicios con los campos mas necesarios ya que algunas columnas en la base de datos, se repetian)
- Gaste un tiempo extra buscando informacion sobre las librerias de twitter y entendiendo como usarlas en java, no tenia experiencia con esta libreria(4 horas)
(Afortunadamente pude encontrar informacion y algo de codigo para realizar la tarea)


NOTA: use Java 11, Spring boot, JPA, en las consultas se podia realizar uso de consultas HQL, pero por preferencia use consulta nativa para poder traer solo los campos que necesitaba

NOTA 2: use la base de datos: 'zemoga_test_db' y la tabla 'portfolio'.

