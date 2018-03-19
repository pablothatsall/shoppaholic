# API REST
-------------------------------------------------------------------------------

Siempre que se desee consultar la API las consultas deben estar precedidas de /api
-------------------------------------------------------------------------------

###RestCustomerController

## Usuario

* URL:

	api/customer

* Función

Compueba de identidad del usuario.

* Success Response:

	* HttpStatus.OK

* Error Response:

	* HttpStatus.FORBIDDEN


* Método:

	`GET`

* URL Params

	* Required:

		`id=[long]`



## Carrito Usuario

* URL:

	api/customer/cart

* Función

Devuelve el carrito al usuario.

* Success Response:

	* HttpStatus.OK

* Error Response:

	* HttpStatus.FORBIDDEN


* Método:

	`GET`

* URL Params

	* Required:

		`id=[long]`



## Compras Usuario

* URL:

	/api/customer/myorders

* Función

Devuelve las compras realizadas por el usuario identificado.

* Success Response:

	* HttpStatus.OK

* Error Response:

	* HttpStatus.FORBIDDEN


* Método:

	`GET`

* URL Params

	* Required:

		`id=[long]`



## Editar Usuario

* URL:

	/api/editCustomer

* Función

Edita los datos del usuario.

* Success Response:

	* HttpStatus.OK


* Método:

	`PUT`



## Eliminar Usuario

* URL:

	/api/admin/deleteCustomer

* Función

Elimina al usuario identificado.

* Success Response:

	* HttpStatus.OK

* Error Response:

	* HttpStatus.UNAUTHORIZED


* Método:

	`DELETE`

* URL Params

	* Required:

		`id=[long]`
		

-------------------------------------------------------------------------------

###RestLoginController


## Registro

* URL:

	/api/register

* Función

Da de alta a un usuario en el sistema.

* Success Response:

	* HttpStatus.OK

* Error Response:

	* HttpStatus.PARTIAL_CONTENT


* Método:

	`POST`

* Body

	* Required:

		Customer
		


## Cerrar Sesión

* URL:

	/api/logOut

* Función

Cierra la sesión activa.

* Success Response:

	* HttpStatus.OK

* Error Response:

	* HttpStatus.UNAUTHORIZED



## Iniciar Sesión de Usuario

* URL:

	/api/login

* Función

Abre la sesión identificada previamente.

* Success Response:

	* HttpStatus.OK

* Error Response:

	* HttpStatus.UNAUTHORIZED
		



-------------------------------------------------------------------------------

###RestCommentController


## Comentarios

* URL:

	/api/comments

* Función

Devuelve todos los comentarios .

* Success Response:

	* HttpStatus.CREATED

* Método:

	`GET`


## Añadir Comentario

* URL:

	/api/addComment

* Función

Añade un comentario.

* Success Response:

	* HttpStatus.CREATED

* Método:

	`POST`

	* URL Params

	* Required:

		`id=[long]`

-------------------------------------------------------------------------------

###RestProductController


## Producto

* URL:

	/api/product

* Función

Devuelve el producto introducido.

* Success Response:

	* HttpStatus.OK

* Método:

	`GET`

* URL Params

	* Required:

		`id=[long]`
		



## Lista de Productos

* URL:

	/api/products

* Función

Devuelve todos los productos disponibles.


* Método:

	`GET`
		



## Comentarios Objeto

* URL:

	/api/productGetComments

* Función

Devuelve los comentarios del objeto introducido.


* Método:

	`GET`

* URL Params

	* Required:

		`id=[long]`


## Añadir Objeto

* URL:

	/api/admin/addProduct

* Función

Añade un objeto.

* Success Response:

	* HttpStatus.CREATED


* Método:

	`POST`



## Eliminar Objeto

* URL:

	/api/deleteProduct

* Función

Elimina al objeto identificado.

* Success Response:

	* HttpStatus.OK


* Método:

	`DELETE`

* URL Params

	* Required:

		`id=[long]`



## Añadir al Carrito

* URL:

	/api/addToCart

* Función

Añade el objeto seleccionado al carrito.

* Success Response:

	* HttpStatus.OK


* Método:

	`POST`

* URL Params

	* Required:

		`id=[long]`




## Eliminar del Carrito

* URL:

	/api/editProduct

* Función

Elimina al usuario identificado.

* Success Response:

	* HttpStatus.OK

* Error Response:

	* HttpStatus.UNAUTHORIZED


* Método:

	`PUT`

* URL Params

	* Required:

		`id=[long]`



-------------------------------------------------------------------------------

###RestSearchController


## Buscar por etiqueta

* URL:

	/api/searchByLabel

* Función

Busca por etiqueta de los objetos.

* Success Response:

	* HttpStatus.OK

* URL Params

	* Required:

		`labelname=[long]`



## Buscar por Nombre

* URL:

	/api/searchByName

* Función

Busca mediante el nombre del objeto.

* Success Response:

	* HttpStatus.OK

* URL Params

	* Required:

		`name=[long]`



-------------------------------------------------------------------------------

###RestSecurityConfig


## Eliminar Usuario

* URL:

	/api/**

* Función

Configura la los metodos las funciones.



-------------------------------------------------------------------------------


###RestPedidoController


## Pedido

* URL:

	/api/order

* Función

Define un pedido.

* Success Response:

	* HttpStatus.OK

* Error Response:

	* HttpStatus.UNAUTHORIZED

* Método:

	`GET`

* URL Params

	* Required:

		`idC=[long]`
		`idP=[long]`





## Añadir Pedido

* URL:

	/api/createorder

* Función

Crea un nuevo pedido.

* Success Response:

	* HttpStatus.CREATED


* Método:

	`POST`




## Eliminar Usuario

* URL:

	/api/deleteCustomer

* Función

Elimina al usuario identificado.

* Success Response:

	* HttpStatus.OK

* Error Response:

	* HttpStatus.UNAUTHORIZED


* Método:

	`DELETE`

* URL Params

	* Required:

		`id=[long]`



		## Eliminar Usuario

* URL:

	/api/deleteCustomer

* Función

Elimina al usuario identificado.

* Success Response:

	* HttpStatus.OK

* Error Response:

	* HttpStatus.UNAUTHORIZED


* Método:

	`DELETE`

* URL Params

	* Required:

		`id=[long]`
