package com.ecodeup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecodeup.service.UploadService;

@Controller
public class HomeController {
	
	@Autowired
	private UploadService upload;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/cargar")
	public String carga( @RequestParam("archivos") MultipartFile file, RedirectAttributes ms) {
		upload.save(file);
		ms.addFlashAttribute("mensaje", "Archivo guardado correctamente!!");
		return "redirect:/";
	}

}
