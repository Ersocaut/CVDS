# __CVDS-LAB5__

## __Requisitos__
A continución los requisitos, para poder realizar el Laboratorio
* Tener habilitado **Telnet de Windows 10** ya que viene deshabilitado por defecto.
* Tener instalado **Cygwin Terminal**, si es de sistema operativo windows y presenta problemas. **(Opcional)**
  
## __Instalación de requisitos__
*  En caso de no tener habilitado **Telnet de Windows 10** activo seguir los siguientes pasos:
   * Buscar el cmd de windows y ejecutarlo como administrador \
   ![Imag1](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/InstallTelnetStep1.jpg)
   * Ejecutar el siguiente comando \
   ![Imag2](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/InstallTelnetStep2.png)
*   En caso de no tener Cygwin Terminal, [instalacion del terminal](https://cygwin.com/install.html)
## __Introducción a proyectos Web__ 




# __Parte I. - Jugando a ser un cliente HTTP__

1. Abra una terminal Linux o consola de comandos Windows.
2. Realice una conexión síncrona TCP/IP a través de Telnet al siguiente servidor:
   * Host: www.escuelaing.edu.co
   * Puerto: 80 
    
3. Antes de que el servidor cierre la conexión por falta de comunicación
   * realizar una petición GET. Con esto, solicite al servidor el recurso ```‘sssss/abc.html’```, usando la ```versión 1.0 de HTTP```. 

    **Solicitando el recurso html**:  
    Ejecute el comando ```telnet HOST PORT```
    ```
    $ telnet www.escuelaing.edu.co 80
    ```
    
    Se debera realizar la solicitud GET, introduciendo el comando:
    ```
    $ GET /sssss/abc.html HTTP/1.0
    ```
    Con esta solicitud  saldran los siguientes errores/mensajes: 

  * __Error 400: Bad request__: Indica que el sitio web o Host, no reconoce el comando o la solicitud del cliente porque esta no respeta el protocolo HTTP, por ende no la puede procesar.

    ![Imag3](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/Error400.png)

   * __Error 301: Moved permanently__: Indica que el host ha sido capaz de comunicarse con 
el servidor pero que el recurso solicitado ha sido movido a otra dirección permanentemente.  
    ![Imag4](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/Error301.png)  

   * __¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?__ \
   ![Imagn](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/StatusCode.png)  

4. Realice una nueva conexión con telnet, esta vez a: 
   * Host: www.httpbin.org
   * Puerto: 80

 * **Solicitando el recurso html**:  \
    Ahora, solicite el recurso /html. (GET), Ejecute el comando ```telnet HOST PORT```
    ```
    $ telnet www.httpbin.org 80
    ```
    
    Se debera realizar la solicitud GET, introduciendo el comando:
    ```
    $ GET /html HTTP/1.0
    ```
    Como resultado se tendra el siguiente html \
    ![Imag5](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/GEThttpbin.png)

5. Seleccione el contenido ```HTML``` de la respuesta y copielo al cortapapeles ```CTRL-SHIFT-C```. Ejecute el comando ```wc``` (word count) para contar palabras con la opción ```-c``` para contar el número de caracteres:
   ```
   $ wc -c 
   ```
   Nosotros guardamos el contenido del ```HTML``` en el archivo ```htmlTexto.txt``` que se encuentra en el repositorio. \
   ![Imag6](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/count.png)

* __¿Cuál es la diferencia entre los verbos GET y POST?__
   * **GET** \
    El método GET  lleva una representación de un recurso específico que se encuentran almacenados en un servidor al usuarip. Las peticiones que usan el método GET sólo deben recuperar datos.
   * **POST:** \
    El método POST se utiliza para enviar una entidad a un recurso en específico, causando a menudo un cambio en el estado o efectos secundarios en el servidor.
   * **Diferencias:**  \
    El método GET lleva los datos usando la URL de forma visible, el método POST los envía de forma que no podemos verlos (en un segundo plano u "ocultos" al usuario)
    
* __¿Qué otros tipos de peticiones existen?__  \
    ![Imag7](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/operations.png)

6. En la practica no se utiliza ```telnet``` para hacer peticiones a sitios web sino el comando ```curl``` con ayuda de la linea de comandos:
```
curl www.httpbin.org
```
El objetivo de curl es transferir datos, sin interacción del usuario, hacia o desde un servidor.

Utilice ahora el parámetro -v:
```
curl www.httpbin.org -v
```
![Imag9](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/curl-v.png) 

Utilice ahora el parámetro -i:
```
curl www.httpbin.org -i
```
![Imag10](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/curl-i.png)
* __¿Cuáles son las diferencias con los diferentes parámetros?__ \
   * El ```-v``` hace que la operación sea más detallada 
   * El ```-i``` hace que incluya en las cabeceras de respuesta el protocolo responsable de la salida
 

# __Parte II. - Haciendo una aplicación Web dinámica a bajo nivel.__
En este ejercicio, va a implementar una aplicación Web muy básica, haciendo uso de los elementos de más bajo nivel de Java-EE (Enterprise Edition), con el fin de revisar los conceptos del protocolo HTTP. En este caso, se trata de un módulo de consulta de clientes Web que hace uso de una librería de acceso a datos disponible en un repositorio Maven local.
1. Revise la clase SampleServlet incluida a continuacion, e identifique qué hace: \
    **Servlet:** Los servlets son modulos java que nos sirven para extender las capacidades de los servidores web. 
2. Revise en el pom.xml para qué puerto TCP/IP está configurado el servidor embebido de Tomcat (ver sección de plugins): \
    El servidor se encuentra configurado para el puerto ***8080***
3. Compile y ejecute la aplicación en el servidor embebido Tomcat, a través de Maven con:
   ```
   mvn package
   mvn tomcat7:run
   ```
   como resultado se tiene \
   ![Imag11](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/CompilingTomCat.png)
4. Abra un navegador, y en la barra de direcciones ponga la URL con la cual se le enviarán peticiones al ‘SampleServlet’. Tenga en cuenta que la URL tendrá como host ‘localhost’, como puerto, el configurado en el pom.xml y el path debe ser el del Servlet. Debería obtener un mensaje de saludo. \
   ![Imag12](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/SampleServlet.png)
5. Observe que el Servlet ‘SampleServlet’ acepta peticiones GET, y opcionalmente, lee el parámetro ‘name’. Ingrese la misma URL, pero ahora agregando un parámetro GET (si no sabe como hacerlo, revise la documentación en <http://www.w3schools.com/tags/ref_httpmethods.asp> 

   ![Imag13](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/SampleServletParamterName.png)

6. Busque el artefacto ```gson``` en el repositorio de ```maven``` y agregue la dependencia.
   ```
   <!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
   <dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.3.1</version>
   </dependency>
   ```
7. En el navegador revise la dirección <https://jsonplaceholder.typicode.com/todos/1.> Intente cambiando diferentes números al final del path de la url.
   * numero = 1

       ![Imag14](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/jsonplaceholderId1.png)
   * numero = 2

       ![Imag15](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/jsonplaceholderId2.png)
   * numero = 55 
       
       ![Imag16](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/jsonplaceholderId55.png)

8. Basado en la respuesta que le da el servicio del punto anterior, cree la clase ```edu.eci.cvds.servlet.model.Todo``` con un constructor vacío y los métodos ```getter``` y ```setter``` para las propiedades de los "To Dos" que se encuentran en la url indicada.
   
   __Revisar ```edu.eci.cvds.servlet.model.Todo``` en el proyecto que se encuentra en el repo.__
9. Cree una clase que herede de la clase HttpServlet (similar a SampleServlet), y para la misma sobrescriba el método heredado ```doGet```. Incluya la anotación ```@Override``` para verificar –en tiempo de compilación- que efectivamente se esté sobreescribiendo un método de las superclases.

   __Revisar ```edu.eci.cvds.servlet.NewServlet``` en el proyecto que se encuentra en el repo.__
10. Teniendo en cuenta las siguientes los métodos disponibles en los objetos ServletRequest y ServletResponse recibidos por el método doGet:
   * __Implemente dicho método de manera que:__
      * Asuma que la petición ```HTTP``` recibe como parámetro el número de ```id``` de una lista de cosas por hacer (todo), y que dicha identificación es un número entero.

      * Con el identificador recibido, consulte el item por hacer de la lista de cosas por hacer, usando la clase "Service" creada en el punto 10.

      * __Si el item existe:__
          * Responder con el código HTTP que equivale a ‘OK’ [ver referencia anterior](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes), y como contenido de dicha respuesta, el código html correspondiente a una página con una tabla que tenga los detalles del item, usando la clase "Service" creada en el punto 10 par crear la tabla.

      * __Si el item no existe:__
          * Responder con el código correspondiente a ‘no encontrado’, y con el código de una página html que indique que no existe un item con el identificador dado.
          * Si no se paso parámetro opcional, o si el parámetro no contiene un número entero, devolver el código equivalente a ```requerimiento inválido```.
          * Si se genera la excepcion ```MalformedURLException``` devolver el código de ```error interno en el servidor```
          * Para cualquier otra excepcion, devolver el código equivalente a ```requerimiento inválido```.


     __Revisar ```edu.eci.cvds.servlet.model.Todo``` en el proyecto que se encuentra en el repo.__
11. Intente hacer diferentes consultas desde un navegador Web para probar las diferentes funcionalidades.
   * Salida Valida

     ![Imag17](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/validOutput.png)
   * Excepcion numberFormatException

     ![Imag18](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/nuException.png)
   * Excepcion fileNotFoundException

     ![Imag19](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/fileException.png)



# __Parte III__
1. En su servlet, sobreescriba el método doPost, y haga la misma implementación del doGet.

2. En la página anterior, cree un formulario que tenga un campo para ingresar un número y un botón. El formulario debe usar como método ‘POST’, y como acción, la ruta relativa del último servlet creado

   ![Imag20](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/impForm.png)

   ![Imag21](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/postForm.png)
3. Revise este [ejemplo de validación de formularios con javascript](https://www.w3schools.com/js/js_validation.asp) y agruéguelo a su formulario, de manera que -al momento de hacer ‘submit’- desde el browser se valide que el valor ingresado es un valor numérico.
4. Recompile y ejecute la aplicación. Abra en su navegador en la página del formulario, y rectifique que la página hecha anteriormente sea mostrada. Ingrese los datos y verifique los resultados. Cambie el formulario para que ahora en lugar de POST, use el método GET . 

   ![Imag22](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/getForm.png)
   * ¿Qué diferencia observa?

     Con el post se oculta el path del recurso que se quiere consultar, get si lo muestra

# __Parte IV- Frameworks Web MVC – Java Server Faces / Prime Faces__

En este ejercicio, usted va a desarrollar una aplicación Web basada en el marco JSF, y en una de sus implementaciones más usadas: PrimeFaces. 

Escriba una aplicación web que utilice PrimeFaces para calcular la media, la moda, la desviación estándar y varianza de un conjunto de N números reales. Este conjunto de N números reales deben ser ingresados por el usuario de manera que puedan ser utilizados para los cálculos.

1. Revisar los casos de uso de la aplicacion **Revisar astah**
2. Al proyecto Maven, debe agregarle las dependencias mas recientes de ```javax.javaee-api```, ```com.sun.faces.jsf-api```, ```com.sun.faces.jsf-impl```, ```javax.servlet.jstl``` y Primefaces (en el archivo pom.xml).
   ```
   <servlet>
     <servlet-name>Faces Servlet</servlet-name>
     <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
   <load-on-startup>1</load-on-startup>
   </servlet>
   <servlet-mapping>
     <servlet-name>Faces Servlet</servlet-name>
     <url-pattern>/faces/*</url-pattern>
   </servlet-mapping>
   <welcome-file-list>
      <welcome-file>faces/index.jsp</welcome-file>
   </welcome-file-list>
   ```
3. Ahora, va a crear un Backing-Bean de sesión, el cual, para cada usuario, mantendrá de lado del servidor las siguientes propiedades:

   Para hacer esto, cree una clase que tenga:
      * el constructor por defecto (sin parámetros)
      * los métodos ```get/set``` necesarios dependiendo si las propiedades son de escritura o lectura
      * coloque las anotaciones:
           * ```@ManagedBean```incluyendo el nombre:
           * ```@ApplicationScoped```

    A la implementación de esta clase, agregue los siguientes métodos:
      * calculateMean: Debe recibir como parámetro el listado de valores y retornar el promedio de los números en ella.
      * calculateStandardDeviation: Debe recibir como parámetro el listado de valores y retornar el la desviación estandar de los números en ella.
      * calculateVariance: Debe recibir como parámetro el listado de valores y retornar la varianza de los números en ella.
      * calculateMode: Debe recibir como parámetro el listado de valores y retornar la moda de los números en ella.
      * restart: Debe volver a iniciar la aplicación (Borrar el campo de texto para que el usuario agregue los datos).
4. Cree una página XHTML, de nombre calculadora.xhtml (debe quedar en la ruta src/main/webapp). [Revise en la página 13 del manual de PrimeFaces](https://www.primefaces.org/docs/guide/primefaces_user_guide_5_2.pdf), qué espacios de nombres XML requiere una página de PrimeFaces y cuál es la estructura básica de la misma
5. Verificando el funcionamiento de la aplicación:
* Ingresando datos

    ![Imag23](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/calcBean1.png)
    
    ![Imag24](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/calcBeanD.png)
 
    ![Imag25](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/calcBean2.png)
* Reiniciando

    ![Imag26](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/calcBeanR.png)
* Abriendo en diferentes navegadores 
   * Microsoft edge y Firefox

      ![Imag27](https://github.com/Rincon10/CVDS-LAB5/blob/master/resources/microsoftAndfirefox.png)

### __Bibliografia__
* <https://developer.mozilla.org/es/docs/Web/HTTP/Methods>
* <https://es.stackoverflow.com/questions/34904/cuando-debo-usar-los-m%C3%A9todos-post-y-get>
* <http://www.manualweb.net/javaee/introduccion-servlets/>
* <http://www.w3schools.com/tags/ref_httpmethods.asp>
* <https://en.wikipedia.org/wiki/List_of_HTTP_status_codes>
* <http://www.w3schools.com/html/>
* <https://www.primefaces.org/docs/guide/primefaces_user_guide_5_2.pdf>
### __Autores__

* Camilo Rincón [Rincon10](https://github.com/Rincon10)
* Leonardo Galeano [Ersocaut](https://github.com/Ersocaut)
