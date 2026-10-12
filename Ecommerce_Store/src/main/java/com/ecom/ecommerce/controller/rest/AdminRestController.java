package com.ecom.ecommerce.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ecommerce.entity.Category;
import com.ecom.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/api")
public class AdminRestController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/save-category")
	public String saveCategory(@ModelAttribute Category category) {
		categoryService.saveCategory(category);
		return "redirect:/category";
	}

}
