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
	public void visit(ClassOrInterfaceDeclaration n, Void arg){
		
		classes.add(n.getName().toString().replaceAll("\\[|\\]", ""));
		
		for(int i = 0; i<classes.size(); i++)
		{
			allClasses = classes.get(i).toString();
		}
		
		System.out.println(allClasses);
		
	}
	
	
	@Override
	public void visit(MethodDeclaration n, Void arg){
		
		VisitClasses vc = new VisitClasses();
		

		for(int i = 0; i<vc.classes.size(); i++)
		{
			allClasses = vc.classes.get(i).toString();
		}
		
		System.out.println(allClasses);
		
		if(n.getParameters() != null){
			
			methods.add(n.getName());
			//System.out.println(methods);
			String method_params = n.getParameters().toString().replaceAll("\\[|\\]", "");
			String[] tokens = method_params.split(" ");
			// ..>
			
			/*if(tokens[0] == classes.toArray(class_names).toString()){
				System.out.println(tokens[0] + " == " + n.getName());
				
			}*/
			
			
			
			/*for(int i=0; i<tokens_names; i++){
				
				if(tokens_names[i] == tokens[0]){
					System.out.println(tokens[0] + " == " + tokens_names[i]);
				}
					
			}*/
			
			
			//p.umlString += modifier + n.getName().toString() + "(" + tokens[1] + " : " + tokens[0] + ")" + "\n";
		}
		
	}
	
	
	
	
	@Override
	public void visit(FieldDeclaration n, Void arg){
		
		if(n.getModifiers() == ModifierSet.PRIVATE)
		{
			//System.out.println(n.getType() + "   belongs to   " + p.cName);
			
			if(n.getType().toString().contains("Collection")){
				
				String otherClass = n.getType().toString().substring(11, n.getType().toString().length()-1);
				
					p.umlString +=p.cName + " ..> " + otherClass + "\n";
				
				}

		}
	}
	
	
}

