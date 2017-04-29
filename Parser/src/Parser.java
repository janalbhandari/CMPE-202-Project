

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

public class Parser {
	static String className;
	static String methodName;
	static ArrayList<String> classNames = new ArrayList<String>();	
	static ArrayList<String> methoNames = new ArrayList<String>();	
	static StringBuffer UMLPlant = new StringBuffer();
	static CompilationUnit cUnit;
	//static File sourceFiles = new File("/Users/janalbhandari/Documents/202/My_Project/Test_Cases/uml-parser-test-5/");
	static String cName = "";
	
	public static String umlString = "";
	public static String appendToClassString = "";
	
	public static String source;
	public static String outputFileName;
	public static String choice;
	
 public static void main(String[] args) throws IOException, ParseException{
	 // TODO Auto-generated method stub
	 
	 	source = args[0];
	 	outputFileName = args[1];
	 	
	 	
	 	
	 	/*if(choice == "class")
	 	{
	 		System.out.println("Generating Class Diagram!");
	 		parseJavaClass(source, outputFileName);
	 	}
	 	else if (choice == "sequence")
	 	{
	 		//parseJavaSequence(source, outputFileName);
	 		System.out.println("Generating sequence diagram!");
	 	}*/
	 	
		System.out.println("\n\n");
	 	
		appendToClassString += "@startuml\n";
		
		/*if(args[0].equals("class"))
	 	{
			
	 		System.out.println("Generating Class Diagram...\n");
	 		parseJavaClass(source, outputFileName);
	 	}*/
		
		System.out.println("Generating Class Diagram...\n");
 		parseJavaClass(source, outputFileName);
		
		appendToClassString += umlString;
		
		//System.out.println(appendToClassString);
		appendToClassString += "@enduml";
		
		//ImageGenerator(outputFileName);
		System.out.println("\n\n");
		
		
	
}


	private static void ImageGenerator(String outputFile) {
	// TODO Auto-generated method stub
		String fName = outputFile + ".png";
		System.out.println("Output file located at : " + fName);
		
		//SourceStringReader reader = new SourceStringReader(appendumlString.toString());
		SourceStringReader reader = new SourceStringReader(appendToClassString.toString());
		
		//FileOutputStream output = new FileOutputStream(new File("/Users/janalbhandari/Documents/202/My_Project/Sample/test5.png"));
		FileOutputStream output;
		try {
			output = new FileOutputStream(new File(fName));
			try {
		
					reader.generateImage(output, new FileFormatOption(FileFormat.PNG));
			} catch (IOException e) {
				System.out.println("Something's wrong!");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Something's wrong!");
		}
		
	
}


	private static void parseJavaClass(String source, String outputFileName) {
		
		// TODO Auto-generated method stub
		
		//File s = new File(source);
		File[] files = readFilesFromFolder(source);
		
		
		VisitMethods mv = new VisitMethods();
		VisitConstructor cv = new VisitConstructor();
		VisitClasses ci = new VisitClasses();
		VisitFields fd = new VisitFields();
		GetDependency gd = new GetDependency();
	 	
		
		
		
		for(File f: files){
				if(f.isFile() && f.getName().contains(".java")){
					
					className = f.getName().substring(0, f.getName().length() - 5);
					classNames.add(className);
					//umlString +=className + "\n";
					
					
					//System.out.println("___");
					//System.out.println(className);
					umlString += "skinparam classAttributeIconSize 0\n\n";
					
					
					try {
						cUnit = JavaParser.parse(f);
						cName = f.getName().substring(0, f.getName().length() - 5);
						
						gd.visit(cUnit,null);
						
						ci.visit(cUnit, null);
						
						//umlString += "Class " + cName + "{\n";
						fd.visit(cUnit, null);
						
						cv.visit(cUnit, null);
						
						mv.visit(cUnit, null);
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					umlString += "}\n\n\n";
					
				}
				
				
		}
		
		//System.out.println("<<interface>>" + ci.interfacesList.toString().replaceAll("\\[|\\]", "") + "\n\n");
		//System.out.println(ci.getClass().getName() + " extends " +ci.extendsList.toString().replaceAll("\\[|\\]", "") + "\n\n");
		//System.out.println(ci.implementsList.toString().replaceAll("\\[|\\]", "") + "\n\n");
		
	
		
	}


	private static File[] readFilesFromFolder(String sourcePath) {		//read all the java files in the specified source folder
		// TODO Auto-generated method stub
		File folder = new File(sourcePath);
		File[] allJavaFiles = new File[0];
		try {
			FileFilter fileFilter = new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if(pathname.getName().endsWith(".java"))
						return true;
					return false;
				}
			};
			allJavaFiles = folder.listFiles(fileFilter);
			if(allJavaFiles.length == 0)
				throw new Exception("No Java Files Found!!");
		} catch (FileNotFoundException e) {
			System.out.println("Enter valid source folder location!");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Enter valid source folder location!");
			e.printStackTrace();
		}
		return allJavaFiles;
	}
	
	
}



/*StringBuilder plantUmlSource = new StringBuilder();

plantUmlSource.append("@startuml\n");

plantUmlSource.append("Alice -> Bob: Authentication Request\n");

plantUmlSource.append("Bob --> Alice: Authentication Response\n");

plantUmlSource.append("@enduml");

SourceStringReader reader = new SourceStringReader(plantUmlSource.toString());

FileOutputStream output = new FileOutputStream(new File("/your/path/to/plantuml/test.svg"));

reader.generateImage(output, new FileFormatOption(FileFormat.SVG, false));*/

