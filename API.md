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

* JSON

	`{
        "id": 1,
        "customer": {
            "id": 1,
            "firstName": "Ruben",
            "lastName": "Iglesias",
            "mail": "chubi",
            "address": "c/Aprobado",
            "telephone": 1313,
            "imageUrl": "../../../../imgProfile/chubi.jpg",
            "roles": [
                "ROLE_USER",
                "ROLE_ADMIN"
            ],
            "idLogged": false,
            "idCustomer": 1
        },
    },`



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

* JSON

	* Entry
		{
		  "id": 2,
		  "totalPrice": 30,
	      "status": "Pending",
	      "user": "Ruben",
		  }

	*   "id": 1,
	    "totalPrice": 30,
	    "status": "Pending",
	    "user": "Ruben",
	    "date": "2 Apr 2018 13:19:28 GMT",
	    "productsofPedido": [
        {
            "id": 2,
            "name": "FARCRY Primal",
            "price": 30,
            "description": "Survive ",
            "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/61oqT8IYn4L.jpg",
            "label": "Videogames",
            "pDate": "2 Apr 2018 13:19:28 GMT",
            "score": 22,
            "comments": [],
            "idLogged": false,
            "pdate": "2 Apr 2018 13:19:28 GMT"
        }
    ],
    "list": [
        {
            "id": 2,
            "name": "FARCRY Primal",
            "price": 30,
            "description": "Survive ",
            "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/61oqT8IYn4L.jpg",
            "label": "Videogames",
            "pDate": "2 Apr 2018 13:19:28 GMT",
            "score": 22,
            "comments": [],
            "idLogged": false,
            "pdate": "2 Apr 2018 13:19:28 GMT"
        }
    ]
}


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

* JSON

	* [
	    {
	        "id": 1,
	        "totalPrice": 30,
	        "status": "Pending",
	        "user": "Ruben",
	        "date": "2 Apr 2018 13:19:28 GMT",
	        "productsofPedido": [
	            {
	                "id": 2,
	                "name": "FARCRY Primal",
	                "price": 30,
	                "description": "Survive ",
	                "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/61oqT8IYn4L.jpg",
	                "label": "Videogames",
	                "pDate": "2 Apr 2018 13:19:28 GMT",
	                "score": 22,
	                "comments": [],
	                "idLogged": false,
	                "pdate": "2 Apr 2018 13:19:28 GMT"
	            }
	        ],
	        "list": [
	            {
	                "id": 2,
	                "name": "FARCRY Primal",
	                "price": 30,
	                "description": "Survive ",
	                "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/61oqT8IYn4L.jpg",
	                "label": "Videogames",
	                "pDate": "2 Apr 2018 13:19:28 GMT",
	                "score": 22,
	                "comments": [],
	                "idLogged": false,
	                "pdate": "2 Apr 2018 13:19:28 GMT"
	            }
	    ]



## Editar Usuario

* URL:

	/api/editCustomer

* Función

Edita los datos del usuario.

* Success Response:

	* HttpStatus.OK


* Método:

	`PUT`

* JSON
	
	* {
    "id": 1,
    "firstName": "Antonio",
    "lastName": "Iglesias",
    "mail": "chubi",
    "password": "$2a$10$oUBi2zi/2YJjcOTK1w5Qbu.MLL38bwRgY4cJJwiGULGm/A7H2Z/yW",
    "address": "c/Aprobado",
    "telephone": 1313,
    "imageUrl": "../../../../imgProfile/chubi.jpg",
    "myOrders": [
        {
            "id": 1,
            "totalPrice": 30,
            "status": "Pending",
            "user": "Ruben",
            "date": "2 Apr 2018 13:19:28 GMT",
            "productsofPedido": [
                {
                    "id": 2,
                    "name": "FARCRY Primal",
                    "price": 30,
                    "description": "Survive ",
                    "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/61oqT8IYn4L.jpg",
                    "label": "Videogames",
                    "pDate": "2 Apr 2018 13:19:28 GMT",
                    "score": 22,
                    "comments": [],
                    "idLogged": false,
                    "pdate": "2 Apr 2018 13:19:28 GMT"
                }
            ],
            "list": [
                {
                    "id": 2,
                    "name": "FARCRY Primal",
                    "price": 30,
                    "description": "Survive ",
                    "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/61oqT8IYn4L.jpg",
                    "label": "Videogames",
                    "pDate": "2 Apr 2018 13:19:28 GMT",
                    "score": 22,
                    "comments": [],
                    "idLogged": false,
                    "pdate": "2 Apr 2018 13:19:28 GMT"
                }
            ]
        }
    ],
    "myCart": {
		        "id": 1,
		        "totalPrice": 30,
		        "status": "Pending",
		        "user": "Ruben",
		        "date": "2 Apr 2018 13:19:28 GMT",
		        "productsofPedido": [
		            {
		                "id": 2,
		                "name": "FARCRY Primal",
		                "price": 30,
		                "description": "Survive ",
		                "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/61oqT8IYn4L.jpg",
		                "label": "Videogames",
		                "pDate": "2 Apr 2018 13:19:28 GMT",
		                "score": 22,
		                "comments": [],
		                "idLogged": false,
		                "pdate": "2 Apr 2018 13:19:28 GMT"
		            }
		        ],
		        "list": [
		            {
		                "id": 2,
		                "name": "FARCRY Primal",
		                "price": 30,
		                "description": "Survive ",
		                "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/61oqT8IYn4L.jpg",
		                "label": "Videogames",
		                "pDate": "2 Apr 2018 13:19:28 GMT",
		                "score": 22,
		                "comments": [],
		                "idLogged": false,
		                "pdate": "2 Apr 2018 13:19:28 GMT"
		            }
		        ]
		    },
		    "roles": [
		        "ROLE_USER",
		        "ROLE_ADMIN"
		    ],
		    "idLogged": false,
		    "idCustomer": 1
		}



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

* JSON

	* User Pablo deleted
		

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

* JSON

	* Entry
		{
		  "id": 3,
		  "firstName": "Pablo",
	    	"lastName": "Moreno",
		    "mail": "pablo",
		  "address": "c/Sprint",
		    "telephone": 666,
		    "imageUrl": "../../../../imgProfile/pablo.jpg",
		  }

	* {
	  	"id": 3,
	  	"firstName": "Pablo",
    	"lastName": "Moreno",
	    "mail": "pablo",
	    "password": "$2a$10$QoR19MlfmI7F8VQMXfRK7utggXQp6oaLYFRSsVEl534G.ygckrnAG",
	    "address": "c/Sprint",
	    "telephone": 666,
	    "imageUrl": "../../../../imgProfile/pablo.jpg",
	  	"roles": [
	      "ROLE_USER"
	    ]
	 }
		


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

* JSON

	* {
	    "firstName": "Antonio",
	    "lastName": "Iglesias",
	    "mail": "chubi",
	    "password": "$2a$10$oUBi2zi/2YJjcOTK1w5Qbu.MLL38bwRgY4cJJwiGULGm/A7H2Z/yW",
	    "address": "c/Aprobado",
	    "telephone": 1313,
	    "imageUrl": "../../../../imgProfile/chubi.jpg"
	}
		



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

* JSON

	* Entry
		{
		  "id": 29,
		  "comment": "Nice camera",
          "date": "1 Apr 2018 15:50:19 GMT",
		  "description": "World's first1 201 MP 1 Exmor RS stacked back illuminated CMOS",
		  "label": "Electronic",
		  "score": 32,
		  }

	*	"comment": "Nice camera",
        "date": "1 Apr 2018 15:50:19 GMT",
        "product": {
            "id": 29,
            "name": "Sony Cyber-shot DSC-RX100M4 Pack",
            "price": 898.72,
            "description": "World's first1 201 MP 1 Exmor RS stacked back illuminated CMOS",
            "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/51HppQk1mfL._AC_US436_QL65_.jpg",
            "label": "Electronic",
            "pDate": "1 Apr 2018 15:50:19 GMT",
            "score": 32,
            "comments": [],
            "idLogged": false,
            "pdate": "1 Apr 2018 15:50:19 GMT"
        }


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

* JSON:
	
	* Entry
		{
		 "id": 4,
		 "name": "Dani",
		 "address": "c/Henry",
		 "mail": "dani",
		 "message": "Very confortable
		  }
	* {
		 "id": 4,
		 "name": "Dani",
		 "address": "c/Henry",
		 "mail": "dani",
		 "message": "Very confortable"
	}

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

* JSON:
	* {
	    "id": 4,
	    "name": "Pioneer cdj-2000nxs2",
	    "price": 2290.99,
	    "description": "For DJing ",
	    "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/9198ikbY1aL._SL1500_.jpg",
	    "label": "Music",
	    "pDate": "2 Apr 2018 13:19:28 GMT",
	    "score": 31,
	    "comments": [],
	    "idLogged": false,
	    "pdate": "2 Apr 2018 13:19:28 GMT"
	}
		



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

* JSON:
	* {
	 "comment": "Great book",
        "date": "2 Apr 2018 11:58:24 GMT",
        "product": {
            "id": 26,
            "name": "Origin: A Novel",
            "price": 17.96,
            "description": "Robert Langdon, Harvard professor of symbology and religious iconology, arrives at the ultramodern Guggenheim Museum Bilbao to attend a major announcement...",
            "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/51OOD3HzgzL._AC_US436_QL65_.jpg",
            "label": "Books",
            "pDate": "2 Apr 2018 11:58:23 GMT",
            "score": 22,
			"idLogged": false,
            "pdate": "2 Apr 2018 11:58:23 GMT"
	}


## Añadir Objeto

* URL:

	/api/admin/addProduct

* Función

Añade un objeto.

* Success Response:

	* HttpStatus.CREATED


* Método:

	`POST`

* JSON:

	* Entry

		{
			"name": "FARCRY Primal",
			"price": 30,
	        "description": "Survive ",
			"imageUrl": "https://images-na.ssl-images-amazon.com/images/I/61oqT8IYn4L.jpg",
	        "label": "Videogames",
			"score": 22,
		}

	* {
	        "id": 2,
	        "name": "FARCRY Primal",
	        "price": 30,
	        "description": "Survive ",
	        "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/61oqT8IYn4L.jpg",
	        "label": "Videogames",
	        "pDate": "2 Apr 2018 11:58:23 GMT",
	        "score": 22,
	        "comments": [],
	        "idLogged": false,
	        "pdate": "2 Apr 2018 11:58:23 GMT"
	                        }

      CREATED.OK



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

* JSON
	* {
	    "id": 1,
	    "totalPrice": 30,
	    "status": "Pending",
	    "user": "Ruben",
	    "date": "2 Apr 2018 13:19:28 GMT",
	    "productsofPedido": [
	        {
	            "id": 4,
	            "name": "Pioneer cdj-2000nxs2",
	            "price": 2290.99,
	            "description": "For DJing ",
	            "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/9198ikbY1aL._SL1500_.jpg",
	            "label": "Music",
	            "pDate": "2 Apr 2018 13:19:28 GMT",
	            "score": 31,
	            "comments": [],
	            "idLogged": false,
	            "pdate": "2 Apr 2018 13:19:28 GMT"
	        }
	    ],
	    "list": [
	        {
	            "id": 4,
	            "name": "Pioneer cdj-2000nxs2",
	            "price": 2290.99,
	            "description": "For DJing ",
	            "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/9198ikbY1aL._SL1500_.jpg",
	            "label": "Music",
	            "pDate": "2 Apr 2018 13:19:28 GMT",
	            "score": 31,
	            "comments": [],
	            "idLogged": false,
	            "pdate": "2 Apr 2018 13:19:28 GMT"
	        }
	    ]
	}




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


* URL:

	/api/**

* Función

Configura la los metodos las funciones.



-------------------------------------------------------------------------------


###RestPedidoController


## Pedido

* URL:

	/api/order/{id}

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

		`id=[long]`

* JSON
	* "myOrders": 
                {
                    "id": 2,
                    "totalPrice": 0,
                    "status": "Pending",
                    "user": "Pablo",
                    "date": "2 Apr 2018 11:58:23 GMT",
                    "productsofPedido": [],
                    "list": []
                }
		





## Añadir Pedido

* URL:

	/api/paycart

* Función

	Crea un nuevo pedido.

* Success Response:

	* HttpStatus.CREATED


* Método:

	`POST`

* JSON

	* [
	    {
	        "id": 1,
	        "totalPrice": 30,
	        "status": "Paid",
	        "user": "Ruben",
	        "date": "2 Apr 2018 13:19:28 GMT",
	        "productsofPedido": [
	            {
	                "id": 4,
	                "name": "Pioneer cdj-2000nxs2",
	                "price": 2290.99,
	                "description": "For DJing ",
	                "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/9198ikbY1aL._SL1500_.jpg",
	                "label": "Music",
	                "pDate": "2 Apr 2018 13:19:28 GMT",
	                "score": 31,
	                "comments": [],
	                "idLogged": false,
	                "pdate": "2 Apr 2018 13:19:28 GMT"
	            }
	        ],
	        "list": [
	            {
	                "id": 4,
	                "name": "Pioneer cdj-2000nxs2",
	                "price": 2290.99,
	                "description": "For DJing ",
	                "imageUrl": "https://images-na.ssl-images-amazon.com/images/I/9198ikbY1aL._SL1500_.jpg",
	                "label": "Music",
	                "pDate": "2 Apr 2018 13:19:28 GMT",
	                "score": 31,
	                "comments": [],
	                "idLogged": false,
	                "pdate": "2 Apr 2018 13:19:28 GMT"
	            }
	        ]
	    },
	    {
	        "id": 5,
	        "totalPrice": 0,
	        "status": "Pending",
	        "user": "Antonio",
	        "date": "2 Apr 2018 13:35:07 GMT",
	        "productsofPedido": [],
	        "list": []
	    }
	]



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

* JSON
		
		* User Pablo deleted



## POSTMAN COLLECTION EXAMPLE https://www.getpostman.com/collections/9f9d032b47e54574a23e
