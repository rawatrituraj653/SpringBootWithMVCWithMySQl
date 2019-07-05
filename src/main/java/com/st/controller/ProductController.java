package com.st.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.st.email.util.EmailUtil;
import com.st.model.Product;
import com.st.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	@Autowired
	private EmailUtil util;
	
	@RequestMapping("/register")
	public String getRegister(Model map) {
		map.addAttribute("product",new Product());
		return "Register";
	}
		
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(@ModelAttribute Product product,Model map,@RequestParam MultipartFile fileOb) {
	 
		Integer id=service.saveProduct(product);
		String txt="your product Register with Id : "+id+" \nThankYOU for Using Our Services"; 
		boolean b=util.send(product.getPEmail(), "Product Registration", txt, fileOb);
		if(b) {
		map.addAttribute("msg","Product Inserted with Id:"+id+"\n mail sent to your mail Id");
		map.addAttribute("product", new Product());
		}
		else {
		map.addAttribute("msg", "Registration failed please try again");
		map.addAttribute("product", product);
		}
		return "Register";
	}
	@RequestMapping("/show")
	public String ProdList(Model map) {
		List<Product> list=service.getAllProduct();
		map.addAttribute("list", list);
		return "Data";
	}
	@RequestMapping("/delete")
	private String delete(@RequestParam int id) {
		service.deleteProduct(id);	
		return "redirect:show";
	}
	@RequestMapping("/edit")
	public  String editPage(@RequestParam Integer id,Model model) {
		Product p=service.getProductById(id);
		model.addAttribute("product", p);
		model.addAttribute("mode", "EDIT");
		return "Register";
	}
	
}
