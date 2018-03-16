package com.shoppaholic.shoppaholic.controllers;

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

import com.shoppaholic.shoppaholic.classes.Comment;
import com.shoppaholic.shoppaholic.classes.Customer;
import com.shoppaholic.shoppaholic.classes.Pedido;
import com.shoppaholic.shoppaholic.classes.Product;
import com.shoppaholic.shoppaholic.repositories.CommentRepository;
import com.shoppaholic.shoppaholic.repositories.CustomerRepository;
import com.shoppaholic.shoppaholic.repositories.PedidoRepository;
import com.shoppaholic.shoppaholic.repositories.ProductRepository;
import com.shoppaholic.shoppaholic.security.CustomerComponent;

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
	
	@PostConstruct
	public void init() {
		if(productRepository.findByName("FIFA").isEmpty()) {
		createData();
		}
	}
	
	@SuppressWarnings("deprecation")
	private void createData () {
			java.util.Date fecha = new Date(); 
			Product fifa = new Product("FIFA", 45, "Best football simulator", "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/81JEhgEtqGL._SX385_.jpg",34,null);

			Product farcry = new Product("FARCRY Primal", 30, "Survive ", "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/61oqT8IYn4L.jpg",22,null);
			Product nba = new Product("NBA", 34.99, "Play basketball ", "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/71r6RDosSDL._SL1000_.jpg",22,null);
			Product cdj = new Product("Pioneer cdj-2000nxs2", 2290.99, "For DJing ", "Music", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/9198ikbY1aL._SL1500_.jpg",31,null);
			Product pc = new Product("Medion S91 - Ordenador de sobremesa", 1071.18,"Intel Core i7-6700 | 8 GB RAM | 1 TB HDD", "Electronic", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/91jemD9L-OL._SL1500_.jpg",22,null);
			Product quidditch = new Product("Quidditch Through the Ages", 8.99,"If you have ever asked yourself where the Golden Snitch came from, how the Bludgers came into existence, or why the Wigtown Wanderers have pictures of meat cleavers on their robes, you need Quidditch Through the Ages.", "Books", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51ebk9M32HL._SX321_BO1,204,203,200_.jpg",22,null);
			Product iphone  = new Product("Apple iPhone X 256 GB",1450.0,"If you wanted an apple drawing on your phone...", "Smartphones", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/81qcvkPSa9L._SL1500_.jpg",50,null);
			Product harrypotter  = new Product("Harry Potter and the Chamber of Secrets",8.0,"Harry returns to Hogwarts, still famous and a hero, when strange thingsstart to happen", "Movies", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51JxWRcdnRL.jpg",22,null);
			Product rocketleague = new Product("Rocket League", 20, "Football + cars", "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51Rne6waRLL._SX215_.jpg",22,null);
			Product callofduty = new Product("Call of Duty WWII", 45 , "Fight in world war II",  "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/61TavA4DOhL.jpg",22,null);
			Product farcry5 = new Product("Farcry 5", 60 , "The new FarCry",  "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/91ASDwyZjrL._AC_SX215_.jpg",22,null);
			Product top = new Product("Romwe Women's Top Blouse", 14.99 , "95% Polyester, 5% Spandex",  "Clothing", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/41M0ZQ42IJL._AC_US0_.jpg",22,null);
			Product dress = new Product("KISSMODA Dresses", 18.99, "This pencil dress is made of polyester+spendex.It is lightweight soft and comfortable against your skin. ", "Clothing", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/31tW-sXP46L._AC_UL500_SR385,500_QL65_.jpg",22,null);
			Product galaxy8 = new Product("Samsung Galaxy S8 64GB", 626.28, "Infinity Display: a bezel-less, full-frontal, edge-to-edge screen.", "Smartphones", fecha.toGMTString(),"https://thumb.pccomponentes.com/w-530-530/articles/12/123417/s8n3.jpg",22,null);
			Product rasp = new Product("Raspberry Pi 3", 38.00, "1.2GHz 64-bit quad-core ARMv8 CPU, 1 GB RAM ", "Electronic", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51Vt9f26ryL._AC_US436_QL65_.jpg",22,null);
			Product grill = new Product("Char-Broil Performance 475", 193.03,"4-Burner, 36,000-BTU Cart-Style Gas Grill with 10,000-BTU Lidded Side Burner", "Garden", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/41ISNBS-kML._AC_US436_QL65_.jpg",22,null);
			Product forniture = new Product("Devoko Patio Porch Furniture Set", 129.99,"High quality strong steel frame with waterproof PE rattan wicker Patio furniture set.", "Garden", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/411fPmSFixL._AC_US400_QL65_.jpg",22,null);
			Product play4  = new Product("PlayStation 4 Slim 1TB",299.00,"Includes a new slim 1TB PlayStation®4 system, a matching DualShock 4 Wireless Controller.","Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/71xSJoog7OL._AC_.jpg",35,null);
			Product boots  = new Product("adidas Performance Men's",157.24,"Responsive touch and optimum ball control out of the box with soft AGILITY MESH", "Sports", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/518XBaSv+lL._AC_US0_.jpg",22,null);
			Product tshirt = new Product("Under Armour Men's Tech Short", 78.00, "UA Tech fabric is quick-drying, ultra-soft & has a more natural feel","Sports", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/61AWmuVtLkL._AC_US0_.jpg",22,null);
			Product bars = new Product("HEALTH WARRIOR Chia Bars", 11.99 , "100 calorie superfood snack made from real ingredients like chia that help keep you full",  "Health", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51TaOrSD3UL._AC_US400_QL65_.jpg",22,null);
			Product makeup = new Product("Maybelline 24 Hour Eyeshadow", 5.94, "24 hour wear without creasing or fading","Makeup", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/511GldPzSiL._AC_US400_QL65_.jpg",22,null);
			Product hammer = new Product("Titan Tools 63125 5-Piece Hammer", 44.47, "(1) 16 oz. Ball Pein Hammer (63316),(1) 32 oz. Ball Pein Hammer (63024)","Tools", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/516Gwp3ZREL._AC_US400_QL65_.jpg",22,null);
			Product multitool = new Product("IRWIN VISE-GRIP Multi-Tool", 13.90, "Wire cutter with induction hardened cutting edge stays sharp longer", "Tools", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/31uY1TVTmaL._AC_US400_QL65_.jpg",22,null);
			Product sneakers = new Product("Bruno Marc Sneakers", 29.99,"Lightweige, soft and comfortable design", "Sneakers", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/41Wg70BSzjL._AC_US0_.jpg",22,null);
			Product origin = new Product("Origin: A Novel", 17.96,"Robert Langdon, Harvard professor of symbology and religious iconology, arrives at the ultramodern Guggenheim Museum Bilbao to attend a major announcement...", "Books", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51OOD3HzgzL._AC_US436_QL65_.jpg",22,null);
			Product gigants  = new Product("Fall of Giants",7.99,"A thirteen-year-old Welsh boy enters a man’s world in the mining pits. . . . An American law student rejected in love finds a surprising new career in Woodrow Wilson’s White House...", "Books", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51PtqimkXdL._AC_US436_QL65_.jpg",22,null);
			Product headset = new Product("HyperX Cloud II Gaming Headset", 91.82, "USB Audio Sound Card with 7.1 Virtual Surround Sound","Electronic", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/514cV6xMKrL._AC_US436_QL65_.jpg",22,null);
			Product camera = new Product("Sony Cyber-shot DSC-RX100M4 Pack", 898.72 , "World's first1 201 MP 1 Exmor RS stacked back illuminated CMOS", "Electronic", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/51HppQk1mfL._AC_US436_QL65_.jpg",32,null);
			Product donkeykong = new Product("Donkey Kong", 43, "Monkeys",  "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/913II3nRc0L._AC_SX215_.jpg",22,null);
			Product soundbar = new Product("Samsung HW-M360/ZA 2.1",182.43 , "Enjoy a dynamic home Audio experience with 2.1 Channel surround sound.", "Electronic", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/212eg94cyEL._AC_US436_QL65_.jpg",22,null);
			Product kirby = new Product("Kirby Star Allies ",54.24, "Go Pink", "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/81c18FOO5oL._AC_SX215_.jpg",22,null);
			Product darksouls = new Product("Dark Souls: Remastered  ",60.99, "Die and die", "Videogames", fecha.toGMTString(),"https://images-na.ssl-images-amazon.com/images/I/81KXlktSUGL._AC_SX215_.jpg",27,null);
			Product sonyalpha = new Product("Sony Alpha 6000 ",750.00, "Faster focus than a reflex", "Electronic", fecha.toGMTString(),"https://sonyglobal.scene7.com/is/image/gwtprod/8a1691c1ffef2e705d1c09e2e3753f2b?fmt=pjpeg&wid=165&bgcolor=FFFFFF&bgc=FFFFFF",26,null);
			Product mercurial = new Product("Mercurial Puro Fenomeno ",100.00, "Play like Neymar", "Sports", fecha.toGMTString(),"http://eldiezdeportes.com/wp-content/uploads/descarga-9-3-800x425.jpg",21,null);
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
			productRepository.save(sonyalpha);
			productRepository.save(mercurial);
			
			
			
			
			 
			

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
		 
			Customer c = new Customer("Ruben", "Iglesias", "chubi", "chubi", "c/Aprobado", 1313,"../../../../imgProfile/chubi.jpg", myorderschubi, cartchubi, "ROLE_USER");
			c.getRoles().add("ROLE_ADMIN");
			Customer p = new Customer("Pablo", "Moreno", "pablo", "pablo", "c/Sprint", 666,"../../../../imgProfile/pablo.jpg",myorderspablo , cartpablo , "ROLE_USER");
			Customer d = new Customer("Dani", "Ribeiro", "dani", "dani", "c/Henry", 88,"../../../../imgProfile/dani.jpeg",myordersdani, cartdani, "ROLE_USER");
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
		model.addAttribute("best", productRepository.findTop5ByOrderByScoreDesc((new PageRequest(0,5))));
		
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
	

	 
	

	 

	
	



	

//	@RequestMapping("/login")
//	public  String loginStart(Model model, @RequestParam(value = "email", defaultValue = "") String email,
//			@RequestParam(value = "password", defaultValue = "") String password) {
//		/*if (!customerComponent.isLoggedUser()) {
//			log.info("Not user logged");
//			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//		} else {
//			User loggedUser = userComponent.getLoggedUser();
//			log.info("Logged as " + loggedUser.getName());
//		return new ResponseEntity<>(loggedUser, HttpStatus.OK); */
//		return "login";
//	}
//	
//	@RequestMapping("/loginerror")
//public  String LoginError(){
//		return "loginerror";
//		
//	}
 

	
	



}