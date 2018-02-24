package com.shoppaholic.shoppaholic;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerComponent customerComponent;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/loginerror")
	public String loginerror() {
		return "loginerror";
	}

	@RequestMapping("/")
	public @ResponseBody String getIndex(HttpSession session, Model model, HttpServletRequest request,
			@RequestParam(value = "likeId", required=false) Long likeId){

		boolean login = customerComponent.isLoggedUser();

		if (login) {
			Customer cLogged = customerRepository.findOne(customerComponent.getIdLoggedUser());
			if (cLogged.getFirstName().equals("admin")) {
				model.addAttribute("admin", true);
				return "index";
			}
		}

		// Principal principal = request.getUserPrincipal();
		// User user = userRepository.findByName(principal.getName());

		// User u=userComponent.getLoggedUser();

		List<Product> topProducts = new ArrayList<>();

		topProducts = productRepository.findFirst3ByOrderByNLikesDesc();

		model.addAttribute("topProducts", topProducts);

		List<Product> wallProducts = new ArrayList<>();

		if (!login) {
			wallProducts = productRepository.findFirst3ByOrderByNLikesDesc();
			/*
			 * } else { Customer uLogged =
			 * customerRepository.findOne(userComponent.getIdLoggedUser()); List<Product>
			 * recentProducts = productRepository.findFirst100ByOrderByDateDesc(); boolean
			 * betweenFollowed; for (int i = 0; i < recentProducts.size(); ++i) { Product p
			 * = recentProducts.get(i); betweenFollowed = false; for (int j = 0; j <
			 * followingByLogged.size() && !betweenFollowed; ++j) { if (p.getCreatorId() ==
			 * followingByLogged.get(j).getId_user()) { betweenFollowed = true; } } if
			 * (!betweenFollowed) recentPlaylists.remove(p); } wallProducts =
			 * recentProducts; }
			 */

			// cheque el atributo booelan idLogged
			// para trazar la ruta dinamica de cada playlist desde la plantilla
			// if (login) {
			// Customer uLogged =
			// customerRepository.findOne(customerComponent.getIdLoggedUser());
			// long idLogged = uLogged.getIdCustomer();
			//
			// for (int i = 0; i < wallProducts.size(); ++i) {
			// Product p = wallProducts.get(i);
			// if (p.getCreatorId() == idLogged) {
			// p.setIdLogged(true);
			// }
			// }
			// }
			//
			// model.addAttribute("wallProducts", wallProducts);

			if (login) {
				Customer uLogged = customerRepository.findOne(customerComponent.getIdLoggedUser());
				model.addAttribute("uLogged", uLogged);
			}

			model.addAttribute("login", login);

			return "index";
		}
	}
}
