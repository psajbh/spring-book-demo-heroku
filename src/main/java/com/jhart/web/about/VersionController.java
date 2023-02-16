//
//package com.jhart.web.about;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//
//@RequestMapping({ "", "/", "/about" })
//public class VersionController {
//
//	@GetMapping({"/version"}) public ModelAndView versionInformation() { 
//		//return  "Version 1.0-SNAPSHOT"; 
//		ModelAndView modelAndView = new  ModelAndView("about/versionInfo"); 
//		String data = readGitProperties();
//		modelAndView.addObject("data", data); return modelAndView; }
//
//	private String readGitProperties() {
//		ClassLoader classLoader = getClass().getClassLoader();
//		InputStream inputStream = classLoader.getResourceAsStream("git.properties");
//		try {
//			return readFromInputStream(inputStream);
//		} 
//		catch (IOException e) {
//			e.printStackTrace();
//			return "Version information could not be retrieved";
//		}
//	}
//
//	private String readFromInputStream(InputStream inputStream) throws IOException {
//		StringBuilder resultStringBuilder = new StringBuilder();
//		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){
//			String line;
//			while ((line = br.readLine()) != null) {
//				resultStringBuilder.append(line).append("\n");
//			}
//		}
//		return resultStringBuilder.toString();
//	}
//
//}
