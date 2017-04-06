

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
		
	 
	public void AddClassNamestoList(File currentFile)
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
	}

  
 }
