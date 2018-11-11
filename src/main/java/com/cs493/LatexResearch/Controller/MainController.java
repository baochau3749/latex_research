package com.cs493.LatexResearch.Controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		
		System.out.println("Run process - 3");
		Process p = Runtime.getRuntime().exec("pdflatex ~/target/classes/static/document_2.tex");
		
		System.out.println("Run process - 4");		
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));		
		BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		
		System.out.println("Run process - 5");
		System.out.println("****************************************************************");
        System.out.println("Result status:");		
		String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
        
        System.out.println("Result error:");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
        System.out.println("****************************************************************");
        
        
		logger.info("\n>>> End Latex_Research from CommandRunner...................");

		
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
