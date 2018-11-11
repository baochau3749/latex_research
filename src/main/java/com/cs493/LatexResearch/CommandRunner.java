package com.cs493.LatexResearch;


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.cs493.LatexResearch.LatexResearchApplication;

@Component
public class CommandRunner implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(LatexResearchApplication.class);
	
	//public static final Resource LATEX_DIR = new ClassPathResource("/latex_files");
	//public static final Resource LATEX_FILE = new ClassPathResource("/document.tex");
	
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("\n>>> Start Latex_Research from CommandRunner...................");
		
//		logger.info("\n>>> Call LATEX_DIR.getFile().getName() - 6...................");
//		String latexFolder = LATEX_DIR.getURL().toString();
//		String pdfDoc = latexFolder + "\\hello.pdf";
//		//String latexFile = latexFolder + "/document.tex";
//		
//		System.out.println(">>> latexFolder = " + latexFolder);
//		System.out.println(">>> pdfDoc = " + pdfDoc);
		

		System.out.println("Run process - 1");
		ClassLoader classLoader = getClass().getClassLoader();
		
		System.out.println("Run process - 2");
		File file = new File(classLoader.getResource("/static/document_2.tex").getFile());
		
//		System.out.println(">>> file getParent = " + file.getParent());
//		System.out.println(">>> file getPath = " + file.getPath());
//		System.out.println(">>> file getAbsolutePath = " + file.getAbsolutePath());
//		System.out.println(">>> file name = " + file.getName());
		
		
		System.out.println("Run process - 3");
//		Process p = Runtime.getRuntime().exec("pdflatex " + file.getPath());
//		
//		System.out.println("Run process - 4");		
//		BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));		
//		BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
//		
//		System.out.println("Run process - 5");
//		System.out.println("****************************************************************");
//        System.out.println("Result status:");		
//		String s = null;
//        while ((s = stdInput.readLine()) != null) {
//            System.out.println(s);
//        }
//        
//        System.out.println("Result error:");
//        while ((s = stdError.readLine()) != null) {
//            System.out.println(s);
//        }
//        System.out.println("****************************************************************");
        
        
		logger.info("\n>>> End Latex_Research from CommandRunner...................");

	}
	
}
