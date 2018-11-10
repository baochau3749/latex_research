package com.cs493.LatexResearch.Controller;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 

@Controller
public class MainController {
	public static final Resource LATEX_DIR = new ClassPathResource("/latex_files");
	
	@RequestMapping("/")
	public String main(Model theModel) throws IOException {
		
		System.out.println(">>> Hello.............");
				
		String latexFolder = LATEX_DIR.getFile().getAbsolutePath();
		String pdfDoc = latexFolder + "\\hello.pdf";
		
		System.out.println(">>> latexFolder = " + latexFolder);
		System.out.println(">>> pdfDoc = " + pdfDoc);
		
		theModel.addAttribute("latexFolder", latexFolder);
		theModel.addAttribute("pdfDoc", pdfDoc); 
		return "hello"; 
	}
	
}
