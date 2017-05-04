import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.ModifierSet;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class GetDependency extends VoidVisitorAdapter<Void> {
	
	static ArrayList<String> classes = new ArrayList<String>();
	static ArrayList<String> methods = new ArrayList<String>();
	static String[] class_names;
	static String allClasses;
	static Scanner scan = new Scanner(classes.toString());
	static ArrayList<String> constructor = new ArrayList<String>();
	
	Parser p = new Parser();
	
	@Override
	public void visit(FieldDeclaration n, Void arg){
		
		if(n.getModifiers() == ModifierSet.PRIVATE)
		{
			//System.out.println(n.getType() + "   belongs to   " + p.cName);
			
			if(n.getType().toString().contains("Collection")){
				
				String otherClass = n.getType().toString().substring(11, n.getType().toString().length()-1);
				
				//Class01 "1" -- "many" Class02
				
					p.umlString += p.cName + " ..> " + otherClass + "\n";
					p.umlString += p.cName + "  -- \"*\" " + otherClass + "\n";
				
				}

		}
		

		if(n.getModifiers() == ModifierSet.PUBLIC)
		{
			//System.out.println(n.getType() + "   belongs to   " + p.cName);
			
			if(n.getType().toString().contains("Collection")){
				
				String otherClass = n.getType().toString().substring(11, n.getType().toString().length()-1);
				
				//Class01 "1" -- "many" Class02
				
					p.umlString += p.cName + " ..> " + otherClass + "\n";
					p.umlString += p.cName + "  -- \"*\" " + otherClass + "\n";
				
				}

		}
	}
	
	
	@Override
	public void visit(MethodDeclaration n, Void arg){
		
		VisitClasses vc = new VisitClasses();
		
		
		if(n.getParameters() != null){
			
			methods.add(n.getName());
			//System.out.println(methods);
			String method_params = n.getParameters().toString().replaceAll("\\[|\\]", "");
			String[] tokens = method_params.split(" ");
			// ..>
			
			//System.out.println(p.cName);
			
			/*if(tokens[0].equals(classes.toArray(class_names).toString())){
				System.out.println(tokens[0] + " == " + n.getName());
				
			}*/
			
			
			
			//p.umlString += modifier + n.getName().toString() + "(" + tokens[1] + " : " + tokens[0] + ")" + "\n";
		}
		
	}
	
}

