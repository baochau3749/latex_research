package com.cs493.LatexResearch;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

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
		

//		System.out.println("Run process - 1");
//		ClassLoader classLoader = getClass().getClassLoader();
//		
//		System.out.println("Run process - 2");
//		File file = new File(classLoader.getResource("/static/document_2.tex").getFile());
//		
//		System.out.println("Run process - 2a");
//		System.out.println(">>> file name = " + file.getName());
//		
//		System.out.println("Run process - 2b");
//		System.out.println(">>> file getParent = " + file.getParent());
//		
//		System.out.println("Run process - 2c");
//		System.out.println(">>> file getPath = " + file.getPath());
//		
//		System.out.println("Run process - d");
//		System.out.println(">>> file getAbsolutePath = " + file.getAbsolutePath());
//		
//		System.out.println("Run process - 3");
//		String uploadDirectory = System.getProperty("user.dir");
//		System.out.println(">>> uploadDirectory = " + uploadDirectory);
//		
//		System.out.println("Run process - 4");
//		
//		String[] cmd = new String[4];
//		cmd[0] = "pdflatex" ;
//        cmd[1] = "--output-format=pdf";
//        cmd[2] = "--output-directory=target/classes/static";
//        cmd[3] = "target/classes/static/document_2.tex" ;

//		String[] cmd = new String[1];
//		cmd[0] = "chmod +x ./target/classes/pdfScript" ;

		
		System.out.println("Run process - 3a");
		Process p1 = Runtime.getRuntime().exec("chmod +x ./target/classes/pdfScript");
		p1.waitFor();
		
		System.out.println("Run process - 3a");
		Process p2 = Runtime.getRuntime().exec("chmod +x ./target/classes/latex_compiler");
		p2.waitFor();

		//		
//		cmd[0] = "./target/classes/pdfScript" ;
//		System.out.println("Run process - 3b");
//		Process p = Runtime.getRuntime().exec(cmd);
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
        
		getAward();
		logger.info("\n>>> End Latex_Research from CommandRunner...................");

	}
	
//	public String getLatexContent(String title, String ) {
//		String content;
//		content = "\\documentclass[paper=letter,oneside,fontsize=16pt, landscape, parskip=full]{scrartcl}\n";
//		content += "\\usepackage{contour}\n";
//		content += "\\usepackage[onehalfspacing]{setspace}\n";
//		//content += "%\\usepackage[placement=top,angle=0,color=black!40,scale=4,hshift=60,vshift=-25]{background}\n";
//		content += "\\usepackage[placement=top,hshift=-72.5,vshift=-542]{background}\n";
//		content += "\\newcommand{\\setfont}[1]{\\fontfamily{#1}\\selectfont}\n";
//		content += "\\pagestyle{empty}\n";
//		content += "\\begin{document}\n";
//		content += "\\backgroundsetup{scale = 1, angle = 0, opacity = 0.6,\n";
//		content += "contents = {\\includegraphics[width = \\paperwidth,\n";
//		content += "height = \\paperheight] {award_background_2}}}\n";
//		content += "\\parbox[c][2cm][s]{18.5cm}{\n";
//		content += "\\bfseries\\center\n";
//		content += "\\Huge\\textcolor{blue}{Employee of the Month}}\n";
//		content += "\\bfseries\\center\n";
//		content += "\\begin{spacing}{2}\n";
//		content += "\\large{Presented to}\\\n";
//		content += "\\end{spacing}\n";
//		content += "\\LARGE\\textit{<NAME>}\n";
//		content += "\n";
//		content += "\n";
//		content += "\\large\\parbox{18cm}{\\center{\n";
//		content += "In recognition of your dedicated service\n";
//		content += "to our customers and our company.\n";
//		content += "\\begin{spacing}{3.2}\\end{spacing}}}\n";
//		content += "\n";
//		content += "\\scalebox{.7}{\n";
//		content += "\\setlength{\\tabcolsep}{2.6em}\n";
//		content += "\\centering{\n";
//		content += "\\begin{tabular}{cccc}\n";
//		content += "\\\\\n";
//		content += "\\\\\n";
//		content += "& & & 11/04/2018\\\\\n";
//		content += "\\cline{1-1}\n";
//		content += "\\cline{4-4}\n";
//		content += "Bao Chau & &  & Date\n";
//		content += "\\end{tabular}\n";
//		content += "}}\n";
//		content += "\\begin{spacing}{.5}\\end{spacing}\n";
//		content += "\\end{document}\n";
//		return content;
//	} 
	
	public static final Resource LATEX_DIR = new ClassPathResource("/static/latex_files");
	
	public void getAward() {
//		String name = "Benjamin Johnson";		
//		String date = "11/11/2018";
//		String awarder = "Bao Chau";
//		LatexContent latexContent = new LatexContent(LatexContent.EMPLOYEE_OF_THE_MONTH);
//		latexContent.setName(name);
//		latexContent.setDate(date);
//		latexContent.setAwarder(awarder);
//		logger.info(latexContent.getContent());
//		latexContent.createLatexFile();
//		
		
//		String latexFilePath = System.getProperty("user.dir") + "/target/classes/static/latex_files";
//			
//		logger.info("latexFilePath = " + latexFilePath);
//		
//		File latexFolder;
//		
//		try {
//			latexFolder = ResourceUtils.getFile(latexFilePath);
//			File latexFile = File.createTempFile("award", ".tex", latexFolder);
//		    BufferedWriter writer = new BufferedWriter(new FileWriter(latexFile));
//		    writer.write(latexContent.getContent());
//		    writer.close();
//		    
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//	    BufferedWriter writer = new BufferedWriter(new FileWriter("c:/temp/samplefile1.txt"));
//	    writer.write(fileContent);
//	    writer.close();
	    
//		try {
//			//File latexFile = File.createTempFile("award", ".tex", latexFolder.);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
//		String latexFilePath = System.getProperty("user.dir")
//				+ "/target/classes/static/latex_files/Employee_of_the_Month_Award.tex";
//		File file;
//		String fileContent;
//		try {
//			file = ResourceUtils.getFile(latexFilePath);
////			fileContent = new String(Files.readAllBytes(file.toPath()));
////			fileContent.replace("documentclass", name); 
//		} catch (FileNotFoundException e) {
//			throw new RuntimeException("There's an error in reading latex file.");
//		} catch (IOException e) {
//			throw new RuntimeException("There's an error in reading latex file.");
//		}
		 
		//logger.info(getLatexContent());
		
//		// copy it to response's OutputStream
//		try {
//			InputStream sourceStream = new ByteArrayInputStream(fileContent.getBytes(Charset.forName("UTF-8")));
//			IOUtils.copy(sourceStream, response.getOutputStream());
//		} catch (IOException e) {
//			throw new RuntimeException("IOError writing file to output stream");
//		}
 

	}
	
}
