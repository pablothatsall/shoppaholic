# shoppaholic
-------------------------------------------------------------------------------

## DATOS DEL GRUPO
### Miembros del Grupo 14:
- Pablo Moreno Yanguas (p.morenoy@alumnos.urjc.es)
- Rubén Iglesias García (r.iglesiasg@alumnos.urjc.es)
- Daniel Ribeiro Chacón (d.ribeiro@alumnos.urjc.es)
- Sergio Sarriá Porro (s.sarria@alumnos.urjc.es)
- Lei Han (l.han@alumnos.urjc.es)

### Enlace al tablero de Trello: 
https://trello.com/b/TWf57Qly/shoppaholic-daw-2018

-------------------------------------------------------------------------------

## DATOS DE LA APLICACIÓN WEB
### Entidades de bases de datos:
- Usuario: Nombre, Apellido, ID, Correo, Contraseña, Dirección, Teléfono, Imagen
- Producto: Precio, Nombre, Descripción, Imagen, Etiqueta, Fecha de Publicación, Stock
- Pedido: Identificador, Lista de Productos, Precio Total, Estado, Usuario, Fecha
- Comentario: Producto, Usuario, Contenido, Fecha

### Funcionalidad avanzada
- Sistema de productos recomendados y relacionados

### Tecnología avanzada extra
- Exportar pedidos (factura o similar) a formato PDF y envío por correo

### Información a visualizar en Gráficos
- Productos vendidos por categoría en tarta
- Proporcion de productos vendidos en tarta
- Top vendidos en barras

-------------------------------------------------------------------------------

### Capturas de pantalla

##### Index

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/index.png)
![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/index%202.png)

- Pagina principal de la web, compuesta por un contenedor dinamico con varias imagenes principales, apartado de productos destacados, recomendaciones, productos mas vendidos del mes y categorias.


##### Carrito

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/carrito.png)

- Pagina donde se almacenan los productos seleccionados. Se compone de una imagen, descripción y precio del producto. Ademas de un resumen general de este.

##### Lista

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/lista.png)

- Pagina que muestra listas de productos por categorias. Se compone de imagen, descripción,  precio del producto y dos botones. 

##### Información del Usuario

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/usuario.png)

- Pagina donde se muestra la información del usuario. Se compone de la imagen de perfil, resumen de su información y dos botones.

##### Editar Perfil

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/edPerfil.png)

- Pagina donde se editan los datos del perfil. Esta compuesta por una serie de campos donde introducir la nueva información y dos botones.

##### Login

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/login.png)

- Pagina donde iniciar sesión. Compuesta por dos campos de introducción de datos, casilla de recordar datos y botones.

##### Sign In

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/registro.png)

- Pagina donde registrar un nuevo usuario, compuesta por los campos de introducción de datos, una aceptación de terminos de uso y un botón.

##### Productos Pedidos

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/productosPedidos.png)

- Pagina donde se resumen los productos comprados. Se compone de una imagen, descripción y un enlace al producto.

##### Pedidos

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/pedidos.png)

- Pagina donde se resumen los pedidos realizados. Se compone de imagen y resumen de los datos de envio.
- *Nota: Esta clase esta nombrada en castellano de manera intencionada debido a motivos de compilación ya que el nombre de Order generaba un problema a la hora de acceder a la base de datos ya qe se interpretaba como un Order de ordenar en SQL

##### Pago

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/pago.png)

- Pagina donde se realiza la introducción de los datos de pago. Compuesta por varios campos de introducción de datos y botón de envio.

##### Producto

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/producto.png)

- Pagina donde se muestra la información del producto. Compuesta por una imagen, descripción y precio de este.

##### Search

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/search.png)

- Pagina que muestra los resultados de una busqueda. Se compone de pequeñas imagenes con sus descripciones.

##### Administración

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/administration.png)

- Pagina que permite administrar tanto productos como usuarios.

##### Añadir Producto

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/add.png)

- Pagina que permite añadir un nuevo producto.

##### Editar o Eliminar

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/editOrDelete.png)

- Pagina que permite editar o eliminar un producto.

##### Editar

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/edit.png)

- Pagina que permite editar un producto.

##### Administración Usuarios

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/manage.png)

- Pagina que permite la eliminación de un usuario.


-------------------------------------------------------------------------------

### Diagrama de Navegación

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/diagrama.png)

-------------------------------------------------------------------------------

### Entorno de Desarrollo

- Para generar el entorno de desarrollo debemos crear un proyecto Maven desde Spring suit el cual es una versión de Eclipse. Desde este proyecto Maven que gestiona las dependencias del proyecto Spring se monta con la gerarquia de directorios de un proyecto Spring y conectarla a una base de datos mysql. Esta parte debe ser descargada de internet, para conectarlaa este servidor abres un puerto especificandolo desde el application.properties el cual es un archivo alojado en el proyecto. Una vez hecho esto configuras el usuario y la contraseña para poder trabajar en el workbench de mysql.
-Como herramientas hemos utilizado el brackets, sublime text y el google chrome.

-------------------------------------------------------------------------------


### Diagrama de entidades de Bases de Datos

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/entidades.png)
- Diagrama templates:
![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/diagramaTemplates.png)

-------------------------------------------------------------------------------


### Diagrama de Clases y Templates

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/capturas/diagramaClases.png)


-------------------------------------------------------------------------------


### API

![alt text](https://github.com/pablothatsall/shoppaholic/blob/master/API.md)

