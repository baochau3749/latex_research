package com.cs493.LatexResearch.Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cs493.LatexResearch.LatexContent;
import com.cs493.LatexResearch.LatexResearchApplication;

@Controller
public class MainController {

	Logger logger = LoggerFactory.getLogger(LatexResearchApplication.class);
		
	public static final String LATEX_FOLDER = System.getProperty("user.dir") + "src/main/resources/static/latex_files";
	public static final Resource LATEX_DIR = new ClassPathResource("/latex_files");
	public static final Resource APP_DIR = new ClassPathResource("/static/latex_files");
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	
	@RequestMapping("/")
	public String main(Model theModel) throws IOException {

		logger.info("\n>>> Start main from MainController...................");

		String latexFolder = LATEX_DIR.getURL().toString();
		String pdfDoc = latexFolder + "/hello.pdf";

		System.out.println(">>> latexFolder = " + latexFolder);
		System.out.println(">>> pdfDoc = " + pdfDoc);


		
		//String filePath = APP_DIR.getURL().toString() + "/my_text.txt";

		
		try {			
//			if (resourceLoader == null)
//				throw new IOException("There's an error in creating latex file.");
//			Resource resource  = resourceLoader.getResource("classpath://static//my_text.txt");
//			File  textFile = null;
//			
//			//textFile = ResourceUtils.getFile(filePath);	
			//File file = ResourceUtils.getFile("classpath:my_text.txt");

	        String fileName = "sample.txt";
	        ClassLoader classLoader = new MainController().getClass().getClassLoader();
	 
	        File file = new File(classLoader.getResource(fileName).getFile());

	        String content = new String(Files.readAllBytes(file.toPath()));
	        System.out.println(content);
	        
	        latexFolder = content;
//			if (!file)
//				throw new IOException("file is null");
			
//		    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//		    writer.write("New content for my_text.txt\n");
//		    writer.write("New content for my_text.txt\n");
//		    writer.close();
		    
		} catch (FileNotFoundException e) {
//			throw new RuntimeException("There's an error in creating latex file.");
			throw new RuntimeException(e.getMessage());
		} catch (IOException e) {
//			throw new RuntimeException("There's an error in creating latex file.");
			throw new RuntimeException(e.getMessage());
		}
		
		theModel.addAttribute("latexFolder", latexFolder);
		theModel.addAttribute("pdfDoc", pdfDoc);

//		String[] cmd = new String[4];
//		cmd[0] = "pdflatex" ;
//        cmd[1] = "-output-format=pdf";
//        cmd[2] = "-output-directory=~/target/classes/static";
//        cmd[3] = "~/target/classes/static/document_2.tex" ;

//		String property = System.getProperty("user.dir") + "/src/main/resources/static/";
//		String filePath = property + "my_text.txt";

//		String content;
//		String filePath = System.getProperty("user.dir") + "/target/classes/static/my_text.txt";
//
//		String[] cmd = new String[1];
//		cmd[0] = "./target/classes/pdfScript";
//
//		System.out.println("Run process - 3");
//		Process p = Runtime.getRuntime().exec(cmd);
//		try {
//			p.waitFor();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		content = filePath + "<br>";
//		try {
//			File file = ResourceUtils.getFile(filePath);
//			content += new String(Files.readAllBytes(file.toPath()));
//		} catch (IOException e) {
//			content += "error in reading data.";
//		}
//		theModel.addAttribute("content", content);
		// return content;

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

	@RequestMapping("/award")
	public String createAward(Model theModel) throws IOException {
		return "award";
	}
	
	@RequestMapping("/award2")
	public String createAward2(Model theModel) throws IOException {
		return "award2";
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

	@RequestMapping(value = "getAward", method = RequestMethod.POST) 		
	public void getAward(HttpServletResponse response, 
			@ModelAttribute("name") String name,
			@ModelAttribute("date") String date,
			@ModelAttribute("awarder") String awarder,
			@ModelAttribute("type") int type,
			Model theModel) {
		LatexContent latexContent = null;
		
		if (type == LatexContent.EMPLOYEE_OF_THE_MONTH) {
			latexContent = new LatexContent(LatexContent.EMPLOYEE_OF_THE_MONTH);
		}		
		else {
			latexContent = new LatexContent(LatexContent.TOP_PERFORMER_OF_THE_YEAR);
		}
		
		latexContent.setName(name);
		latexContent.setDate(date);
		latexContent.setAwarder(awarder);
		
		//File latexFile = latexContent.createLatexFile();
		latexContent.createLatexFile();
		
		Process p;
		try {
			p = Runtime.getRuntime().exec("./target/classes/latex_compiler");
			p.waitFor();
		} catch (IOException e) {
			throw new RuntimeException("There's an error in compiling latex file.");			
		} catch (InterruptedException e) {
			throw new RuntimeException("There's an error in compiling latex file.");
		}		
		
		String pdfFilePath = LATEX_FOLDER + "/sample.pdf";
		
	    try {
	      // get your file as InputStream
	      InputStream targetStream = new FileInputStream(new File(pdfFilePath));  
      	      
	      // copy it to response's OutputStream
	      IOUtils.copy(targetStream, response.getOutputStream());
	      response.flushBuffer();	       
	      
	    } catch (IOException ex) {
	    	throw new RuntimeException("IOError writing file to output stream");
	    }
		//return name;
	}
	
	
	@RequestMapping(value = "testAwardFile", method = RequestMethod.GET)
	public void testAwardFile(HttpServletResponse response) {

		String name = "Benjamin Johnson";		
		String date = "11/11/2018";
		String awarder = "Bao Chau";
		
		LatexContent latexContent = new LatexContent(LatexContent.EMPLOYEE_OF_THE_MONTH);
		latexContent.setName(name);
		latexContent.setDate(date);
		latexContent.setAwarder(awarder);
		
		File latexFile = latexContent.createLatexFile();

		Process p;
		try {
			p = Runtime.getRuntime().exec("./target/classes/latex_compiler");
			p.waitFor();
		} catch (IOException e) {
			throw new RuntimeException("There's an error in compiling latex file.");			
		} catch (InterruptedException e) {
			throw new RuntimeException("There's an error in compiling latex file.");
		}		
		
		String pdfFilePath = LATEX_FOLDER + "/sample.pdf";
		
	    try {
	      // get your file as InputStream
	        InputStream targetStream = new FileInputStream(new File(pdfFilePath));  
      	      
	      // copy it to response's OutputStream
	      IOUtils.copy(targetStream, response.getOutputStream());
	      response.flushBuffer();	       
	      
	    } catch (IOException ex) {
	    	throw new RuntimeException("IOError writing file to output stream");
	    }		
	}
}
