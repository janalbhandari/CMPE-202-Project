import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;

public class Parser {
	static String className;
	static ArrayList<String> classNames = new ArrayList<String>();	
	static StringBuffer UMLPlant = new StringBuffer();
	static CompilationUnit cUnit;
	static String pu;
	static File sourceFiles = new File("/Users/janalbhandari/Documents/202/My Project/Test Cases/uml-parser-test-1");

	
	
    
    public static void main(String[] args) throws IOException, ParseException{
        // TODO Auto-generated method stub
        
		//String outputFile = "output.png";
		//File sourceFiles = new File("/Users/janalbhandari/Documents/202/My Project/Test Cases/uml-parser-test-4/ConcreteSubject.java");
		
		
		//cUnit = JavaParser.parse(sourceFiles);
		parseJava(sourceFiles);
	
  }
  
 
	private static void parseJava(File file)  {
		// TODO Auto-generated method stub
		File[] files = file.listFiles();
		MethodVisitor mv = new MethodVisitor();
		ConstructorVisitor cv = new ConstructorVisitor();
		ClassOrInterfaceDeclaration ci = new ClassOrInterfaceDeclaration();
		FieldDeclaration fd = new FieldDeclaration();
		//UMLPlant.append("@startuml");
		
		for(File f: files){
				if(f.isFile() && f.getName().contains(".java")){
					System.out.println("___");
					className = f.getName();
					System.out.println(className);
					
					
					try {
						cUnit = JavaParser.parse(f);

						fd.visit(cUnit, null);
						cv.visit(cUnit, null);
						mv.visit(cUnit, null);
						ci.visit(cUnit, null);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				
		}
		//UMLPlant.append("@enduml");
		
	}
	
		
	
}

