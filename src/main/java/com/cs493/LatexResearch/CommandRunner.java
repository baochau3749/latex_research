package com.cs493.LatexResearch;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(LatexResearchApplication.class);
	public static final Resource LATEX_DIR = new ClassPathResource("/latex_files");
	
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("\n>>> Start Latex_Research from CommandRunner...................");
		
		logger.info("\n>>> Call LATEX_DIR.getFile().getName() - 6...................");
		String latexFolder = LATEX_DIR.getURL().toString();
		String pdfDoc = latexFolder + "\\hello.pdf";
		
		System.out.println(">>> latexFolder = " + latexFolder);
		System.out.println(">>> pdfDoc = " + pdfDoc);
		
		
		//Process p = Runtime.getRuntime().exec("pdflatex C:\\heroku\\bc-test-buildpack\\test_latex_file.tex");
		//Process p = Runtime.getRuntime().exec("pdflatex C:\\heroku\\bc-test-buildpack\\document.tex");
		
		System.out.println("Run process - 1");
		//Process p = Runtime.getRuntime().exec("ipconfig");
		//Process p = Runtime.getRuntime().exec("pdflatex C:\\heroku\\bc-test-buildpack\\document.tex");
		Process p = Runtime.getRuntime().exec("pdflatex test_latex_file.tex");
		System.out.println("Run process - 2");
		//p.wait();
		System.out.println("Run process - 3");
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
		System.out.println("Run process - 4");
		BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		
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

	}
	
}
