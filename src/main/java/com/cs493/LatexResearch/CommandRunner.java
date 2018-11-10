package com.cs493.LatexResearch;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
//public class CommandRunner implements CommandLineRunner {
//	
//}
public class CommandRunner implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(LatexResearchApplication.class);
	public static final Resource LATEX_DIR = new ClassPathResource("/latex_files");
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("\n>>> Start Latex_Research from CommandRunner .......................");

		System.out.println(">>> Latex_Dir = " + LATEX_DIR.getFile());
		String latexFolder = LATEX_DIR.getFile().getAbsolutePath();
		String pdfDoc = latexFolder + "\\hello.pdf";
		
		System.out.println(">>> latexFolder = " + latexFolder);
		System.out.println(">>> pdfDoc = " + pdfDoc);		
		
		logger.info("\n>>> End Latex_Research from CommandRunner .......................");
	} 
	
//	@Override
//	public void run(String... args) throws Exception {
//		logger.info("\n>>> Start Latex_Research.");
//		System.out.println(">>> Latex_Dir = " + LATEX_DIR.getFile());
//		String latexFolder = LATEX_DIR.getFile().getAbsolutePath();
//		String pdfDoc = latexFolder + "\\hello.pdf";
//		
//		System.out.println(">>> latexFolder = " + latexFolder);
//		System.out.println(">>> pdfDoc = " + pdfDoc);
//	}
//	
	
	
//	@RequestMapping("/")
//	@ResponseBody
//	public String main(Model theModel) throws IOException {
//		
//		System.out.println(">>> Hello.............");
//		System.out.println(">>> Latex_Dir = " + LATEX_DIR.getFile());
//		
//		//theModel.addAttribute("Latex_Dir", LATEX_DIR);		
//		//theModel.addAttribute("Latex_document", LATEX_DIR);
//		return "Hello";
//	}

}
