

package com.github.javaparser;

import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;

import static com.github.javaparser.ParseStart.*;
import static com.github.javaparser.Providers.*;
import static com.github.javaparser.utils.Utils.assertNotNull;

 public class umlparser {
		
	 File file = "/Users/janalbhandari/Documents/202/My Project/Test Cases/uml-parser-test-1/";
	 
	 for (File file : files) {
		    if (file.isFile() && file.getName().endsWith(".java")) {
		    	results.add(file.getName());
		        System.out.println("Display : " + file.getName());
		        
		    }
		 
	/*public void AddClassNamestoList(File currentFile)
	{
		ArrayList<String> className = new ArrayList<String>();
		if (currentFile.isFile() && currentFile.getName().endsWith(".class")) {
			String nameOfClass;
			nameOfClass = currentFile.getName();
			nameOfClass = nameOfClass
					.substring(0, nameOfClass.lastIndexOf('.'));
			className.add(nameOfClass);
		}
		for (String temp : className) {
			GetInterfaces(temp);
		}
		GetAssociations(className);
	}*/

  
 }
