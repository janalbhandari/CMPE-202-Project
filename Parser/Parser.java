import java.io.File;
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
	static ArrayList<String> classNames = new ArrayList<String>();	
	static StringBuffer UMLPlant = new StringBuffer();
	static CompilationUnit cUnit;
	static File sourceFiles = new File("/Users/janalbhandari/Documents/202/My_Project/Test Cases/uml-parser-test-4/");
	static String cName = "";
	
	public static String umlString = "";
	public static String appendumlString = "";

	
	
    
    public static void main(String[] args) throws IOException, ParseException{
        // TODO Auto-generated method stub

		System.out.println("+++++");
		appendumlString += "@startuml\n";
		//appendumlString += "skinparam classAttributeIconSize 0";
		
		parseJava(sourceFiles);
		
		appendumlString += umlString;
		
		System.out.println(appendumlString);
		appendumlString += "@enduml";
		
		
		//SourceStringReader reader = new SourceStringReader(appendumlString.toString());
		//FileOutputStream output = new FileOutputStream(new File("/Users/janalbhandari/Documents/202/My_Project/Sample/test5.png"));
		//reader.generateImage(output, new FileFormatOption(FileFormat.PNG, false));
		
	
  }
  
 
	@SuppressWarnings("unchecked")
	private static void parseJava(File file)  {
		// TODO Auto-generated method stub
		File[] files = file.listFiles();
		VisitMethods mv = new VisitMethods();
		VisitConstructor cv = new VisitConstructor();
		VisitClasses ci = new VisitClasses();
		VisitFields fd = new VisitFields();
		
		
		
		for(File f: files){
				if(f.isFile() && f.getName().contains(".java")){
					
					className = f.getName();
					classNames.add(className);
					//umlString +=className + "\n";
					
					
					System.out.println("___");
					
					
					//System.out.println(className);
					
					
					
					try {
						cUnit = JavaParser.parse(f);
						umlString += "skinparam classAttributeIconSize 0\n";
						
						ci.visit(cUnit, null);
						
						cName = f.getName().substring(0, f.getName().length() - 5);
						umlString += "Class " + cName + "{\n";
						cv.visit(cUnit, null);
						
						fd.visit(cUnit, null);
						mv.visit(cUnit, null);
						
					
						
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					umlString += "}\n\n";
					
				}
				
				
		}
		
		
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
