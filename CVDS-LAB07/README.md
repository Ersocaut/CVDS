# __CVDS-LAB07__

## __Laboratorio 7__
## __Escuela Colombiana de Ingeniería__
## __Ciclos de vida del Desarrollo de Software__
## __Sección I. - Introducción a JDBC__
1. Clonar el proyecto [MyBatis_Introduction_VideoRental de GitHub](https://github.com/PDSW-ECI/MyBatis_Introduction_VideoRental) donde se realizará la implementación completa del laboratorio.
2. Descargue el archivo [JDBCExample.java](http://campusvirtual.escuelaing.edu.co/moodle/pluginfile.php/191340/mod_assign/intro/JDBCExample.java) y agreguelo en el paquete "edu.eci.cvds.sampleprj.jdbc.example".
3. Desde esta clase se realizará una conexión a una base de datos MySQL por medio de JDBC y sus "Prepared Statements".
4. En un motor de base de datos SQL se tiene un esquema con el siguiente modelo de base de datos (para registrar pedidos sobre productos):


   ![Imag1](https://raw.githubusercontent.com/PDSW-ECI/JDBC_Intro/master/img/RMODEL.png)

5. Revise la documentación de [‘PreparedStatement’](https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html), del API JDBC.

6. En la clase __JDBCExample__ juste los parámetros de conexión a la base de datos con los datos reales:
   * ```
       Url: jdbc:mysql://desarrollo.is.escuelaing.edu.co:3306/bdprueba
       Driver: com.mysql.jdbc.Driver
       Usuario: bdprueba
       Contraseña: prueba2019
     ```
7. Implemente las operaciones faltantes:
   1. nombresProductosPedido
   2. valorTotalPedido - El resultado final lo debe retornar la base de datos, no se deben hacer operaciones en memoria.
   3. registrarNuevoProducto - Use su código de estudiante para evitar colisiones.
8. Verifique por medio de un cliente SQL, que la información retornada por el programa coincide con la que se encuentra almacenada en base de datos.

## __Sección II. - Introducción a MyBatis__
1. Revise la [documentación básica de MyBatis](https://mybatis.org/mybatis-3/es/) de forma que entienda para qué sirve y el uso básico que se le puede dar al framework.
2. Seguir las instrucciones que se encuentran en el repositorio de forma que en la clase __MyBatisExample.java__ se creen los mappers necesarios y sea posible realizar la ejecución de diferentes sentencias SQL en la base de datos de pruebas.

## Bibliografia 
* [Repositorio Original](https://github.com/PDSW-ECI/MyBatis_Introduction_VideoRental)

### __Autores__

* Camilo Rincón [Rincon10](https://github.com/Rincon10)
* Leonardo Galeano [Ersocaut](https://github.com/Ersocaut)
