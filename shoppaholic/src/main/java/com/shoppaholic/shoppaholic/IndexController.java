package com.shoppaholic.shoppaholic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class IndexController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerComponent customerComponent;
	@Autowired 
	private CommentRepository commentRepository;
	
	//final static Logger log = LoggerFactory.getLogger(IndexController.class); for login

	@SuppressWarnings("deprecation")
	@PostConstruct
	public void init() {
		java.util.Date fecha = new Date(); 
		Product fifa = new Product("FIFA", 45, "Best football simulator", "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/81JEhgEtqGL._SX385_.jpg",null);

		Product farcry = new Product("FARCRY Primal", 30, "Survive ", "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/61oqT8IYn4L.jpg",null);
		Product nba = new Product("NBA", 34.99, "Play basketball ", "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/71r6RDosSDL._SL1000_.jpg",null);
		Product cdj = new Product("Pioneer cdj-2000nxs2", 2290.99, "For DJing ", "Music", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/9198ikbY1aL._SL1500_.jpg",null);
		Product pc = new Product("Medion S91 - Ordenador de sobremesa", 1071.18,"Intel Core i7-6700 | 8 GB RAM | 1 TB HDD", "Electronic", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/91jemD9L-OL._SL1500_.jpg",null);
		Product quidditch = new Product("Quidditch Through the Ages", 8.99,"If you have ever asked yourself where the Golden Snitch came from, how the Bludgers came into existence, or why the Wigtown Wanderers have pictures of meat cleavers on their robes, you need Quidditch Through the Ages.", "Books", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51ebk9M32HL._SX321_BO1,204,203,200_.jpg",null);
		Product iphone  = new Product("Apple iPhone X 256 GB",1450.0,"If you wanted an apple drawing on your phone...", "Smartphones", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/81qcvkPSa9L._SL1500_.jpg",null);
		Product harrypotter  = new Product("Harry Potter and the Chamber of Secrets",8.0,"Harry returns to Hogwarts, still famous and a hero, when strange thingsstart to happen", "Movies", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51JxWRcdnRL.jpg",null);
		Product rocketleague = new Product("Rocket League", 20, "Football + cars", "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51Rne6waRLL._SX215_.jpg",null);
		Product callofduty = new Product("Call of Duty WWII", 45 , "Fight in world war II",  "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/61TavA4DOhL.jpg",null);
		Product farcry5 = new Product("Farcry 5", 60 , "The new FarCry",  "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/91ASDwyZjrL._AC_SX215_.jpg",null);
		Product top = new Product("Romwe Women's Top Blouse", 14.99 , "95% Polyester, 5% Spandex",  "Clothing", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/41M0ZQ42IJL._AC_US0_.jpg",null);
		Product dress = new Product("KISSMODA Dresses", 18.99, "This pencil dress is made of polyester+spendex.It is lightweight soft and comfortable against your skin. ", "Clothing", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/31tW-sXP46L._AC_UL500_SR385,500_QL65_.jpg",null);
		Product galaxy8 = new Product("Samsung Galaxy S8 64GB", 626.28, "Infinity Display: a bezel-less, full-frontal, edge-to-edge screen.", "Smartphones", fecha.toGMTString(),"https://thumb.pccomponentes.com/w-530-530/articles/12/123417/s8n3.jpg",null);
		Product rasp = new Product("Raspberry Pi 3", 38.00, "1.2GHz 64-bit quad-core ARMv8 CPU, 1 GB RAM ", "Electronic", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51Vt9f26ryL._AC_US436_QL65_.jpg",null);
		Product grill = new Product("Char-Broil Performance 475", 193.03,"4-Burner, 36,000-BTU Cart-Style Gas Grill with 10,000-BTU Lidded Side Burner", "Garden", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/41ISNBS-kML._AC_US436_QL65_.jpg",null);
		Product forniture = new Product("Devoko Patio Porch Furniture Set", 129.99,"High quality strong steel frame with waterproof PE rattan wicker Patio furniture set.", "Garden", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/411fPmSFixL._AC_US400_QL65_.jpg",null);
		Product play4  = new Product("PlayStation 4 Slim 1TB",299.00,"Includes a new slim 1TB PlayStation®4 system, a matching DualShock 4 Wireless Controller.","Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/71xSJoog7OL._AC_.jpg",null);
		Product boots  = new Product("adidas Performance Men's",157.24,"Responsive touch and optimum ball control out of the box with soft AGILITY MESH", "Sports", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/518XBaSv+lL._AC_US0_.jpg",null);
		Product tshirt = new Product("Under Armour Men's Tech Short", 78.00, "UA Tech fabric is quick-drying, ultra-soft & has a more natural feel","Sports", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/61AWmuVtLkL._AC_US0_.jpg",null);
		Product bars = new Product("HEALTH WARRIOR Chia Bars", 11.99 , "100 calorie superfood snack made from real ingredients like chia that help keep you full",  "Health", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51TaOrSD3UL._AC_US400_QL65_.jpg",null);
		Product makeup = new Product("Maybelline 24 Hour Eyeshadow", 5.94, "24 hour wear without creasing or fading","Makeup", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/511GldPzSiL._AC_US400_QL65_.jpg",null);
		Product hammer = new Product("Titan Tools 63125 5-Piece Hammer", 44.47, "(1) 16 oz. Ball Pein Hammer (63316),(1) 32 oz. Ball Pein Hammer (63024)","Tools", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/516Gwp3ZREL._AC_US400_QL65_.jpg",null);
		Product multitool = new Product("IRWIN VISE-GRIP Multi-Tool", 13.90, "Wire cutter with induction hardened cutting edge stays sharp longer", "Tools", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/31uY1TVTmaL._AC_US400_QL65_.jpg",null);
		Product sneakers = new Product("Bruno Marc Sneakers", 29.99,"Lightweige, soft and comfortable design", "Sneakers", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/41Wg70BSzjL._AC_US0_.jpg",null);
		Product origin = new Product("Origin: A Novel", 17.96,"Robert Langdon, Harvard professor of symbology and religious iconology, arrives at the ultramodern Guggenheim Museum Bilbao to attend a major announcement...", "Books", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51OOD3HzgzL._AC_US436_QL65_.jpg",null);
		Product gigants  = new Product("Fall of Giants",7.99,"A thirteen-year-old Welsh boy enters a man’s world in the mining pits. . . . An American law student rejected in love finds a surprising new career in Woodrow Wilson’s White House...", "Books", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51PtqimkXdL._AC_US436_QL65_.jpg",null);
		Product headset = new Product("HyperX Cloud II Gaming Headset", 91.82, "USB Audio Sound Card with 7.1 Virtual Surround Sound","Electronic", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/514cV6xMKrL._AC_US436_QL65_.jpg",null);
		Product camera = new Product("Sony Cyber-shot DSC-RX100M4 Pack", 898.72 , "World's first1 201 MP 1 Exmor RS stacked back illuminated CMOS", "Electronic", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51HppQk1mfL._AC_US436_QL65_.jpg",null);
		Product donkeykong = new Product("Donkey Kong", 43, "Monkeys",  "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/913II3nRc0L._AC_SX215_.jpg",null);
		Product soundbar = new Product("Samsung HW-M360/ZA 2.1",182.43 , "Enjoy a dynamic home Audio experience with 2.1 Channel surround sound.", "Electronic", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/212eg94cyEL._AC_US436_QL65_.jpg",null);
		Product kirby = new Product("Kirby Star Allies ",54.24, "Go Pink", "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/81c18FOO5oL._AC_SX215_.jpg",null);
		Product darksouls = new Product("Dark Souls: Remastered  ",60.99, "Die and die", "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/81KXlktSUGL._AC_SX215_.jpg",null);
		productRepository.save(fifa);
		productRepository.save(farcry);
		productRepository.save(nba);
		productRepository.save(cdj);
		productRepository.save(pc);
		productRepository.save(quidditch);
		productRepository.save(iphone);
		productRepository.save(harrypotter);
		productRepository.save(rocketleague);
		productRepository.save(callofduty);
		productRepository.save(farcry5);
		productRepository.save(top);
		productRepository.save(dress);
		productRepository.save(galaxy8);
		productRepository.save(rasp);
		productRepository.save(grill);
		productRepository.save(forniture);
		productRepository.save(play4);
		productRepository.save(boots);
		productRepository.save(tshirt);
		productRepository.save(bars);
		productRepository.save(makeup);
		productRepository.save(hammer);
		productRepository.save(multitool);
		productRepository.save(sneakers);
		productRepository.save(origin);
		productRepository.save(gigants);
		productRepository.save(headset);
		productRepository.save(camera);
		productRepository.save(donkeykong);
		productRepository.save(soundbar);
		productRepository.save(kirby);
		productRepository.save(darksouls);
		
		
		
		 
		

		List<Product> products = new ArrayList<Product>();
		products.add(farcry);
		Pedido cartchubi = new Pedido("Pending", "Ruben", fecha.toGMTString(), products);
		pedidoRepository.save(cartchubi); 
		Pedido cartpablo = new Pedido("Pending", "Pablo", fecha.toGMTString(), new ArrayList<Product>() );
		pedidoRepository.save(cartpablo);
		Pedido cartdani = new Pedido("Pending", "Dani", fecha.toGMTString(), new ArrayList<Product>() );
		pedidoRepository.save(cartdani); 
		Pedido cartsarry = new Pedido("Pending", "Sergio", fecha.toGMTString(), new ArrayList<Product>() );
		pedidoRepository.save(cartsarry); 
		
		
		List<Pedido> myorderschubi = new ArrayList<>();
		myorderschubi.add(cartchubi);
		
		List<Pedido> myorderspablo = new ArrayList<>();
		myorderspablo.add(cartpablo);
		
		List<Pedido> myordersdani = new ArrayList<>();
		myordersdani.add(cartdani);
		
		List<Pedido> myorderssarry = new ArrayList<>();
		myorderssarry.add(cartsarry);
	 
		Customer c = new Customer("Ruben", "Iglesias", "chubi", "chubi", "c/Aprobado", 1313,"https://pbs.twimg.com/profile_images/743815180153393152/cEnZYY2g_400x400.jpg", myorderschubi, cartchubi, "ROLE_USER");
		c.getRoles().add("ROLE_ADMIN");
		Customer p = new Customer("Pablo", "Moreno", "pablo", "pablo", "c/Sprint", 666,"https://pbs.twimg.com/profile_images/916980080278102017/HfrABpSp_400x400.jpg",myorderspablo , cartpablo , "ROLE_USER");
		Customer d = new Customer("Dani", "Ribeiro", "dani", "dani", "c/Henry", 88,"https://pbs.twimg.com/profile_images/578500665565130752/xVoASGTj_400x400.jpeg",myordersdani, cartdani, "ROLE_USER");
		Customer s = new Customer("Sergio", "Sarria", "Porro", "sergio", "c/Avion 4",4532 ,"", myorderssarry,cartsarry,"ROLE_USER");
		customerRepository.save(c);
		customerRepository.save(p);
		customerRepository.save(d);
		customerRepository.save(s);
		java.util.Date fechaactual = new Date();
		Comment c1 = new Comment(c,"I like fifa", fechaactual.toGMTString() ,fifa);
		commentRepository.save(c1);
		Comment c2 = new Comment(s,"Great book", fechaactual.toGMTString() ,origin);
		commentRepository.save(c2);
		Comment c3 = new Comment(p,"Nice camera", fechaactual.toGMTString() ,camera);
		commentRepository.save(c3);
		Comment c4 = new Comment(d,"Very confortable", fechaactual.toGMTString() ,boots);
		commentRepository.save(c4);
		
		
 
	}

	@RequestMapping("/")
	public String mainStart(Model model, HttpServletRequest request) {
		model.addAttribute("products", productRepository.findAll(new PageRequest(0, 4)));
		
		boolean login=customerComponent.isLoggedUser();
    	
    	if(login){
    		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
    		if(uLogged.getRoles().contains("ROLE_USER")){

    			model.addAttribute("user", uLogged);
    			return "index";
    		}
    	}
    	
		return "index";
	}
	

	 
	@RequestMapping("/userprofile")
	public String userStart(Model model, HttpServletRequest request) {

		boolean login=customerComponent.isLoggedUser();
    	
    	if(login){
    		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
    		if(uLogged.getRoles().equals("ROLE_USER")){
    			model.addAttribute("loggeduser", uLogged);
    			
    			
    		}
    	}
    	
    	model.addAttribute("loggeduser", true);
		return "userprofile";
	}

	@RequestMapping("/userprofile/{id}")
	public String userStart(Model model ,@PathVariable long id, HttpServletRequest request) {
		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
		
		Customer user = customerRepository.findOne(id);
		if (uLogged.getId()==id) {
			
			//Esconder mis orders y editar
		}
		model.addAttribute("user", user);
		return "userprofile";
	}

	@RequestMapping("/signIn")
	public String signIn(Model model, @RequestParam(value = "username") String username,
    		@RequestParam(value = "email") String email,
    		@RequestParam(value = "password") String password){
		
		//RequestParameters, create customer with user_role, create order -> cart of customer, save order, save customer
		return "signUp";
	}

	
	

	@RequestMapping("/product/{id}")
	public String productStart(Model model, @PathVariable long id, HttpServletRequest request,
			@RequestParam(value = "addproduct", defaultValue = "") String addproduct,
			@RequestParam(value = "addcomment", defaultValue = "") String addcomment) {
		
		
    	
		Product p = productRepository.findOne(id);
		model.addAttribute("product", p);
		List<Comment> c = commentRepository.findByProduct(p);
		model.addAttribute("comments", c);
		
		boolean login=customerComponent.isLoggedUser();
    	if(login){
    		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
    		
    			model.addAttribute("user", uLogged);
    			Pedido pedidotoadd = uLogged.getMyCart();
    			
    			if(!addproduct.equals("") && addcomment.equals("")) {
    				pedidotoadd.addProduct(p);
    				pedidotoadd.calculaprecio();
    				customerRepository.save(uLogged);
    				
    			}
    			
    			if(!addcomment.equals("")) {
    				java.util.Date fecha = new Date(); 
    				
    				commentRepository.save(new Comment(uLogged,addcomment,fecha.toGMTString(),p));	
    				
    			} 
  

    	}
			else
				if(!addcomment.equals("")) {
    				java.util.Date fecha = new Date(); 
    				Customer anonimo = new Customer("Anonimo");
    				commentRepository.save(new Comment(anonimo,addcomment,fecha.toGMTString(),p));	
    				
    			} 
		
		
		
		

		
		return "product";
	}
	
	@RequestMapping("/searchNext/{searchterm}")
	public String searchNext(Model model, @PageableDefault(size = 8) Pageable page, @PathVariable String searchterm) {
		model.addAttribute("searchtext", searchterm);
		
		Page<Product> productos = productRepository.findByName(searchterm ,  page);
		model.addAttribute("products", productos);
		
		productos = productRepository.findByLabel(searchterm, page);
		model.addAttribute("productslabel", productos);
		
		model.addAttribute("prevPage", productos.getNumber()-1);
		model.addAttribute("currentPage", productos.getNumber());
		model.addAttribute("secondPageButton", productos.getNumber()+1);
		model.addAttribute("thirdPageButton", productos.getNumber()+2);
		model.addAttribute("nextPage", productos.getNumber()+1);

		return "search";
	}
	
	@RequestMapping("/search")
		public String searchStart(Model model, @PageableDefault(size = 8) Pageable page,  HttpServletRequest request,
							@RequestParam(value = "searchtext") String searchtext) {
		boolean login=customerComponent.isLoggedUser();
    	if(login){
    		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
    		
    			model.addAttribute("user", uLogged);
    	}
						model.addAttribute("searchtext", searchtext);
						
						Page<Product> productos = productRepository.findByNameContaining( "%" + searchtext + "%",  page);
						model.addAttribute("products", productos);
						productos = productRepository.findByLabel(searchtext, page);
						model.addAttribute("productslabel", productos);
				
						model.addAttribute("prevPage", productos.getNumber()-1);
						model.addAttribute("currentPage", productos.getNumber());
						model.addAttribute("secondPageButton", productos.getNumber()+1);
						model.addAttribute("thirdPageButton", productos.getNumber()+2);
						model.addAttribute("nextPage", productos.getNumber()+1);
		return "search";
	}

	@RequestMapping("/payment/{id}")
	public String paymentStart(Model model, @PathVariable long id,
			@RequestParam(value = "tarjeta", defaultValue = "") String tarjeta) {
		
		boolean login=customerComponent.isLoggedUser();
    	if(login){
    		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
    		
    			model.addAttribute("user", uLogged);
    	}
		Customer c= customerRepository.findById(id);
		Pedido p = c.getMyCart();
		
		model.addAttribute("pedido",p);
		if(!p.getStatus().equals("Paid")) {
		if(!tarjeta.equals("")) {
			p.setStatus("Paid");
			pedidoRepository.save(p);

			java.util.Date fechacarrito= new Date();
			List<Product> newcart=  new ArrayList<>();
			Pedido pedidonuevo = new Pedido("Pending",c.getFirstName(),fechacarrito.toGMTString(),newcart);
			c.setMyCart(pedidonuevo);
			pedidoRepository.save(pedidonuevo);
			
			c.setMyCart(pedidonuevo);
		customerRepository.save(c);}}
		
		
		
		return "payment";
	}

	@RequestMapping("/orderlist")
	public String orderlistsampleStart(Model model) {

		return "orderlist";
	}
	@RequestMapping("/orderlist/{id}")
	public String orderlistStart(Model model, @PathVariable long id ) {
		Customer c = customerRepository.findById(id);
		String x =c.getFirstName();
		List<Customer> n = customerRepository.findByFirstName(x);
		model.addAttribute("x", n);
		List<Pedido> norders = pedidoRepository.findByUser(x);
		model.addAttribute("orders" , norders);
		;
		model.addAttribute("ordersize" , c.getMyOrders().size());
		return "orderlist";
	}
 
	@RequestMapping("/order/{id}")
	public String orderStart(Model model, @PathVariable long id) {
		Pedido myorder = pedidoRepository.findById(id);

		boolean login=customerComponent.isLoggedUser();
    	if(login){
    		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
    		
    			model.addAttribute("user", uLogged);
    	if (myorder.getUser().equals(uLogged.getFirstName())){

		Pedido pedido = pedidoRepository.findOne(id);
		model.addAttribute("pedido", pedido);
		List <Product> productos = pedido.getProductsofPedido();
		model.addAttribute("productos", productos);
		Integer cantidad= productos.size();
		model.addAttribute("cantidad", cantidad);
    	}
    	}
    	else
    		return"error"; 
		
    	
				
		return "order";
	}

	@RequestMapping("/login")
	public  String loginStart(Model model, @RequestParam(value = "email", defaultValue = "") String email,
			@RequestParam(value = "password", defaultValue = "") String password) {
		/*if (!customerComponent.isLoggedUser()) {
			log.info("Not user logged");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			User loggedUser = userComponent.getLoggedUser();
			log.info("Logged as " + loggedUser.getName());
		return new ResponseEntity<>(loggedUser, HttpStatus.OK); */
		return "login";
	}
	
	@RequestMapping("/loginerror")
	public  String LoginError(){
		return "loginerror";
		
	}
 
	@RequestMapping("/list")
	public String listStart(Model model) {
		return "list";
	}
	
	
	@RequestMapping("/editprofile")
	public String editprofilesampleStart(Model model) {
		
		return "editprofile";
	} 
	//CON ID
	@RequestMapping("/editprofile/{id}")
	public String editprofileStart(Model model, @PathVariable long id,
					@RequestParam(value = "userfirstname", defaultValue = "") String userfirstname,
					@RequestParam(value = "userlastname", defaultValue = "") String userlastname,
					@RequestParam(value = "usermail", defaultValue = "") String usermail,
					@RequestParam(value = "useraddress", defaultValue = "") String useraddress,
					@RequestParam(value = "usertelephone", defaultValue = "") String usertelephone) {
		
		
		
		Customer customer= customerRepository.findOne(id);
		model.addAttribute("customer", customer);
		
		
		if(!userfirstname.equals("")) {
			customer.setFirstName(userfirstname);
			customerRepository.save(customer); 
		}
		
		if(!userlastname.equals("")) {
			customer.setLastName(userlastname);
			customerRepository.save(customer); 
		}
		if(!usermail.equals("")) {
			customer.setMail(usermail); 
			customerRepository.save(customer); 
			
		}
		if(!useraddress.equals("")) {
			customer.setAddress(useraddress);
			customerRepository.save(customer);  
			
		}
		
		if(!usertelephone.equals("")) {
			customer.setTelephone(Long.valueOf(usertelephone).longValue());;
			customerRepository.save(customer);  
			
		}
		

		return "editprofile";
	}

	
	
	@RequestMapping("/cart")
	public String cartStart(Model model) {
		
		return "cart";
	}
 //Aqui tendremos de id la id del customer que tiene ese carrito
	@RequestMapping("/cart/{id}")
	public String cartStart(Model model, @PathVariable long id, HttpServletRequest request,
			@RequestParam(value = "deletion", defaultValue = "-1") long deletion) {
		boolean login=customerComponent.isLoggedUser();
    	if(login){
    		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
    		
    			model.addAttribute("user", uLogged);
    	}
		Customer customer= customerRepository.findOne(id);
		model.addAttribute("customer", customer);
		Pedido carrito = customer.getMyCart();
		model.addAttribute("cartdetails", carrito);
		 
		List<Product> productsfromcart = customer.getMyCart().getProductsofPedido(); 
		model.addAttribute("products", productsfromcart);
		
		if(deletion!=-1) {
			
			pedidoRepository.findById(id).deleteProduct(productRepository.findById(deletion));
			pedidoRepository.findById(id).calculaprecio();
			pedidoRepository.save(carrito);
		} 
		 
		return "cart";
	}

	@RequestMapping("/admin/addProduct")
	public String addProduct(Model model, @RequestParam(value = "nameproduct", defaultValue = "") String nameproduct,
			@RequestParam(value = "priceproduct", defaultValue = "0.0") double priceproduct,
			@RequestParam(value = "labelsproduct", defaultValue = "") String labelsproduct,
			@RequestParam(value = "descriptionproduct", defaultValue = "") String descriptionproduct,
			@RequestParam(value = "imageproduct", defaultValue = "https://images-eu.ssl-images-amazon.com/images/I/318gIw2AsDL._SS500.jpg") String imageproduct){
		
		if(!nameproduct.equals("") && !descriptionproduct.equals("") ) {
		java.util.Date fecha = new Date(); 
		List<Comment> comments = new ArrayList<>();
		Product newproduct = new Product(nameproduct,priceproduct,descriptionproduct,labelsproduct,fecha.toGMTString(),imageproduct,comments);
		productRepository.save(newproduct);}
		return "addProduct";

	}

	@RequestMapping("/admin/manageUser")
	public String manageUser(Model model, @RequestParam(value = "deletion", defaultValue = "x") String deletion) {
		
		List<Customer> customers = customerRepository.findAll();
		model.addAttribute("customers", customers);
		Customer toDelete = customerRepository.findByMail(deletion);
		if (!deletion.equals("x")) {	
		//Implementar
			
	System.out.println(toDelete + "was eliminated");}
		return "manageUser";
 
	} 
	
	@RequestMapping("/admin/editproduct")
	public String editProduct(Model model, @RequestParam(value = "productnameoriginal", defaultValue = "") String productnameoriginal,
			@RequestParam(value = "productname", defaultValue = "") String productname,
			@RequestParam(value = "productlabel", defaultValue = "") String productlabel,
			@RequestParam(value = "productdescription", defaultValue = "") String productdescription,
			@RequestParam(value = "productprice", defaultValue = "-3") long productprice) {
		List<Product> p = productRepository.findAll();
		model.addAttribute("products", p);
		
		if (!productname.equals("")){
			
			 productRepository.findProductByName(productnameoriginal).setName(productname);
			 productRepository.save(productRepository.findProductByName(productnameoriginal));
		
		}
		
		if (!productlabel.equals("")){
			
			 productRepository.findProductByName(productnameoriginal).setLabel(productlabel);
			 productRepository.save(productRepository.findProductByName(productnameoriginal));
		} 
		
		if (!productdescription.equals("")){
			
			 productRepository.findProductByName(productnameoriginal).setLabel(productdescription);
			 productRepository.save(productRepository.findProductByName(productnameoriginal));
		} 
		if (productprice != -3){
			
			 productRepository.findProductByName(productnameoriginal).setPrice(productprice);
			 productRepository.save(productRepository.findProductByName(productnameoriginal));
		} 
		
		
		return "editProduct";
		}

	
	@RequestMapping("/admin")
	public String manageUser(Model model) {
		return "administration";
		}

}