package com.shoppaholic.shoppaholic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import Product.java;
import ProductRepository.java;

@Controller
public class FileUploadController {

	private static final String USER_IMAGE_FOLDER = "src/main/resources/static/img";
	
	
	@Autowired
	private ProductRepository ProductRepository;

	@Autowired
	private Product Product;
	

	
	@RequestMapping(value = "/imageproduct", method = RequestMethod.POST)
	public String handleFileUpload(Model model, 
			@RequestParam("file") MultipartFile file) {

		//String fileName = file.getOriginalFilename() + ".jpg";
		long id=Product.getId();
		Product u=ProductRepository.findById(id);
		String fileName =id  + ".jpg";

		if (!file.isEmpty()) {
			try {

				File filesFolder = new File(USER_IMAGE_FOLDER);
				if (!filesFolder.exists()) {
					filesFolder.mkdirs();
				}

				File uploadedFile = new File(filesFolder.getAbsolutePath(), fileName);
				file.transferTo(uploadedFile);
				
				u.setImageUrl(fileName);
				ProductRepository.save(u);
				model.addAttribute("u",u);
				return "config";

			} catch (Exception e) {
				
				model.addAttribute("fileName",fileName);
				model.addAttribute("error",
						e.getClass().getName() + ":" + e.getMessage());
				
				model.addAttribute("u",u);
				//model.addAttribute("imgProfile",true);
				return "config";
			}
		} else {
			
			model.addAttribute("error",	"The file is empty");
			
			model.addAttribute("u",u);
			//model.addAttribute("imgProfile",true);
			return "config";
		}
	}

	@RequestMapping("/imageproduct/{fileName}")
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