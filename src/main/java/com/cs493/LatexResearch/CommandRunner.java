package com.cs493.LatexResearch;


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
		
		String latexFolder = LATEX_DIR.getFile().getAbsolutePath();
		String pdfDoc = latexFolder + "\\hello.pdf";
		
		System.out.println(">>> latexFolder = " + latexFolder);
		System.out.println(">>> pdfDoc = " + pdfDoc);
		
		
		logger.info("\n>>> End Latex_Research from CommandRunner...................");

	}
	
}
