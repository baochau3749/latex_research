package com.cs493.LatexResearch.Controller;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs493.LatexResearch.LatexResearchApplication;


@Controller
public class MainController {

//	@RequestMapping("/")
//	@ResponseBody
//	public String main(Model theModel) {
//		System.out.println(">>> Hello.............");
//		
//		return "Hello - Add latex_files folder";
//	}
	
	Logger logger = LoggerFactory.getLogger(LatexResearchApplication.class);
//	public static final Resource LATEX_DIR = new ClassPathResource("/latex_files");
	
	@RequestMapping("/")
	//@ResponseBody
	public String main(Model theModel) throws IOException {
		
		logger.info("\n>>> Start main from MainController...................");
		
//		
//		String latexFolder = LATEX_DIR.getURL().toString();
//		String pdfDoc = latexFolder + "/hello.pdf";
//		
//		System.out.println(">>> latexFolder = " + latexFolder);
//		System.out.println(">>> pdfDoc = " + pdfDoc);
//		
//		theModel.addAttribute("latexFolder", latexFolder);
//		theModel.addAttribute("pdfDoc", pdfDoc); 
//		
		logger.info("\n>>> End main from MainController...................");
		
		
//		String latexFolder = LATEX_DIR.getFile().getAbsolutePath();
//		String pdfDoc = latexFolder + "\\hello.pdf";
//		
//		System.out.println(">>> latexFolder = " + latexFolder);
//		System.out.println(">>> pdfDoc = " + pdfDoc);
//		
//		theModel.addAttribute("latexFolder", latexFolder);
//		theModel.addAttribute("pdfDoc", pdfDoc); 
		
		//return "Hello - Updated main controller - 7";
		return "hello";
	}
	
}
