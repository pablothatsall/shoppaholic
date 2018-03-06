package com.shoppaholic.shoppaholic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shoppaholic.shoppaholic.Customer;
import com.shoppaholic.shoppaholic.CustomerComponent;
import com.shoppaholic.shoppaholic.CustomerRepository;

@Controller
public class FileUploadController {

private static final String USER_IMAGE_FOLDER = "src/main/resources/static/imgProfile";
	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerComponent customerComponent;
	

	
	@RequestMapping(value = "/image/upload", method = RequestMethod.POST)
	public String handleFileUpload(Model model, 
			@RequestParam("file") MultipartFile file) {

		String fileName = file.getOriginalFilename() + ".jpg";
		long idLogged = customerComponent.getIdLoggedUser();
		Customer customer = customerRepository.findOne(idLogged);
		//String fileName =idLogged  + ".jpg";

		
		if (!file.isEmpty()) {
			try {

				File filesFolder = new File(USER_IMAGE_FOLDER);
				if (!filesFolder.exists()) {
					filesFolder.mkdirs();
				}

				File uploadedFile = new File(filesFolder.getAbsolutePath(), fileName);
				file.transferTo(uploadedFile);
				
				customer.setImageUrl("../../../../"+fileName);
				customerRepository.save(customer);
				model.addAttribute("customer",customer);
				return "editProfile";

			} catch (Exception e) {
				
				model.addAttribute("fileName",fileName);
				model.addAttribute("error",
						e.getClass().getName() + ":" + e.getMessage());
				
				model.addAttribute("customer",customer);
				//model.addAttribute("imgProfile",true);
				return "editProfile";
			}
		} else {
			
			model.addAttribute("error",	"The file is empty");
			
			model.addAttribute("customer",customer);
			//model.addAttribute("imgProfile",true);
			return "editProfile";
		}
	}

	@RequestMapping("/image/{fileName}")
	public void handleFileDownload(@PathVariable String fileName,
			HttpServletResponse res) throws FileNotFoundException, IOException {

		File file = new File(USER_IMAGE_FOLDER, fileName + ".jpg");
		//File file = new File(FILES_FOLDER, fileName);

		if (file.exists()) {
			res.setContentType("image/jpeg");
			res.setContentLength(new Long(file.length()).intValue());
			FileCopyUtils
					.copy(new FileInputStream(file), res.getOutputStream());
		} else {
			res.sendError(404, "File" + fileName + "(" + file.getAbsolutePath()
					+ ") does not exist");
		}
	}

}