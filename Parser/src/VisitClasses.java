
import java.util.ArrayList;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class VisitClasses extends VoidVisitorAdapter<Void> {
	
	static ArrayList<String> interfacesList = new ArrayList<String>();
	static ArrayList<String> extendsList = new ArrayList<String>();	
	static ArrayList<String> implementsList = new ArrayList<String>();
	static String iName;

	public void visit(ClassOrInterfaceDeclaration n, Void arg) {
		// TODO Auto-generated method stub
		
		Parser p = new Parser();
		
		if(n.isInterface()){
			
			//p.umlString += ("interface " + n.getName().toString() + "\n\n");
			
			p.cName = n.getName();
			p.umlString += "interface " + p.cName + "{\n";
			
			interfacesList.add(n.getName().toString());
			//System.out.println("\n\n INTERFACES \n" + n.getName() + interfacesList);
			
			//System.out.println(n.getName().toString().replaceAll("\\[|\\]", ""));
		}
		
		else if(n.getExtends() != null)
		{
			
			p.umlString += ( n.getExtends().toString().replaceAll("\\[|\\]", "") + " ^-- " + n.getName() + " " +  "\n\n");
			p.umlString += "class " + n.getName() + "{\n";
			//System.out.println(n.getName() + " extends " + n.getExtends().toString().replaceAll("\\[|\\]", ""));
			
			extendsList.add(n.getExtends().toString());
			//System.out.println("\n\n EXTENDS \n" + n.getName() +   extendsList);
		}
		
		else if(n.getImplements() != null)
		{
			
			p.umlString += n.getImplements().toString().replaceAll("\\[|\\]", "") + " <|.. "  + n.getName() +  "\n\n" ;
			p.umlString += "class " + n.getName() + "{\n";
			//System.out.println(n.getName().toString() + " " + n.getImplements().toString().replaceAll("\\[|\\]", ""));
			
			implementsList.add(n.getImplements().toString());
			//System.out.println("\n\n IMPLEMENTS \n" + n.getName() +   implementsList);
		}
		
		else
		{
			p.umlString += "class " + n.getName() + "{\n";
		}
		
		//System.out.println("\n\n INTERFACES \n" + n.getName() + interfacesList + "\n\n EXTENDS \n" + n.getName() +   extendsList + "\n\n IMPLEMENTS \n" + n.getName() +   implementsList);
		
		
		
		super.visit(n, arg);
	}
	
	
	
	
	
}
	
	


