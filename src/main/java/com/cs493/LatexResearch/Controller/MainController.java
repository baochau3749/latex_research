package com.cs493.LatexResearch.Controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public static final Resource LATEX_DIR = new ClassPathResource("/latex_files");
	
	@RequestMapping("/")
//	@ResponseBody
	public String main(Model theModel) throws IOException {
		
		logger.info("\n>>> Start main from MainController...................");
		
		
		String latexFolder = LATEX_DIR.getURL().toString();
		String pdfDoc = latexFolder + "/hello.pdf";
		
		System.out.println(">>> latexFolder = " + latexFolder);
		System.out.println(">>> pdfDoc = " + pdfDoc);
		
		theModel.addAttribute("latexFolder", latexFolder);
		theModel.addAttribute("pdfDoc", pdfDoc); 
		
//		String[] cmd = new String[4];
//		cmd[0] = "pdflatex" ;
//        cmd[1] = "-output-format=pdf";
//        cmd[2] = "-output-directory=~/target/classes/static";
//        cmd[3] = "~/target/classes/static/document_2.tex" ;
    
		
//		String property = System.getProperty("user.dir") + "/src/main/resources/static/";
//		String filePath = property + "my_text.txt";
		
		String content;
		String filePath = System.getProperty("user.dir") + "/target/classes/static/my_text.txt";
		
        String[] cmd = new String[1];
        cmd[0] = "./target/classes/pdfScript" ;
        
		System.out.println("Run process - 3");
		Process p = Runtime.getRuntime().exec(cmd);
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		


		content = filePath + "<br>";		
		try {
			File file = ResourceUtils.getFile(filePath);
            content += new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
        	content += "error in reading data.";
        }
		theModel.addAttribute("content", content); 
		//return content;
		
//		System.out.println("Run process - 4");;		
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
//        
//        
//		logger.info("\n>>> End Latex_Research from CommandRunner...................");
		return "hello";
	}
	
	public String getFile() {
		return "";
	}
	
	@RequestMapping(value = "getFile", method = RequestMethod.GET)
	public void getFile(HttpServletResponse response) {
		String filePath = System.getProperty("user.dir") + "/target/classes/static/hello.pdf";
	    try {
	      // get your file as InputStream
	    	File initialFile = new File(filePath);
	        InputStream targetStream = new FileInputStream(initialFile);  
      	      
	      // copy it to response's OutputStream
	      IOUtils.copy(targetStream, response.getOutputStream());
	      response.flushBuffer();
	      
	      
	    } catch (IOException ex) {
	    	logger.info("Error writing file to output stream. Filename was '{}'", filePath, ex);
	    	throw new RuntimeException("IOError writing file to output stream");
	    }
	}
	
	@RequestMapping(value = "getAward", method = RequestMethod.GET)
	public void getAward(HttpServletResponse response) {
		
		Process p;
		try {
			p = Runtime.getRuntime().exec("./target/classes/latex_compiler");
			p.waitFor();
		} catch (IOException e) {
			throw new RuntimeException("There's an error in compiling latex file.");			
		} catch (InterruptedException e) {
			throw new RuntimeException("There's an error in compiling latex file.");
		}		
		
		String filePath = System.getProperty("user.dir") + "/target/classes/static/latex_files/Employee_of_the_Month_Award.pdf";
	    try {
	      // get your file as InputStream
	    	File initialFile = new File(filePath);
	        InputStream targetStream = new FileInputStream(initialFile);  
      	      
	      // copy it to response's OutputStream
	      IOUtils.copy(targetStream, response.getOutputStream());
	      response.flushBuffer();	       
	      
	    } catch (IOException ex) {
	    	logger.info("Error writing file to output stream. Filename was '{}'", filePath, ex);
	    	throw new RuntimeException("IOError writing file to output stream");
	    }
	}
}
