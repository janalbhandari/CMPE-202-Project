
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.ModifierSet;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class VisitMethods extends VoidVisitorAdapter<Void> {
	static ArrayList<MethodDeclaration> methods = new ArrayList<MethodDeclaration>();
	static ArrayList<String> methodNames = new ArrayList<String>();
	static String totalMethods;
	
	
        @Override
        public void visit(MethodDeclaration n, Void arg) {
            /* here you can access the attributes of the method.
             this method will be called for all methods in this 
             CompilationUnit, including inner class methods */
        	String modifier = null;
        	
        	Parser p = new Parser();
        	
        
        	//p.umlString += "Class " + p.cName + "{\n";
        	//System.out.println(p.cName + " ------ " + n.getName().toString());
        	//System.out.println(methodNames);
        	
    		if(n.getModifiers() == ModifierSet.PUBLIC){
    			modifier = "+";
    			    			
    			if(n.getName().toString().startsWith("get") || n.getName().toString().startsWith("set")){
    				p.umlString += "";
    			}
    			
    			else if(n.getParameters() != null){
    				
    				//System.out.println(n.getName() + " has parameters : " + n.getParameters().toString() + "\n\n");
    				
    				String method_params = n.getParameters().toString().replaceAll("\\[|\\]", "");
    				String[] tokens = method_params.split(" ");
    				
    				p.umlString += modifier + n.getName().toString() + "(" + tokens[1] + " : " + tokens[0] + ")" + "\n";
    				
    			}
    			
    			else
    			{
    				p.umlString += (modifier + n.getName().toString() + "() : " + n.getType().toString() + "\n");

    			}
    			//methods.add(n.getName().toString());
    			
    		}
    		
    		
    		
    		
    		
    		else if(n.getModifiers() == ModifierSet.PRIVATE)
    		{
    			modifier = "-";
    			
    			if(n.getName().toString().startsWith("get") || n.getName().toString().startsWith("set")){
    				p.umlString += "";
    			}
    			
    			else if(n.getParameters() != null){
    				
    				//System.out.println(n.getName() + " has parameters : " + n.getParameters().toString() + "\n\n");
    				
    				String method_params = n.getParameters().toString().replaceAll("\\[|\\]", "");
    				String[] tokens = method_params.split(" ");
    				
    				p.umlString += modifier + n.getName().toString() + "(" + tokens[1] + " : " + tokens[0] + ")" + "\n";
    			}
    			
    			else
    			{
    				p.umlString += (modifier + n.getName().toString() + "() : " + n.getType().toString() + "\n");

    			}
    			//methods.add(n.getName().toString());
    			
    		}
    		
    		
    		
    		
    		
    		/*else if(n.getModifiers() == ModifierSet.PROTECTED)
    		{
    			modifier = "#";
    			p.umlString += (modifier  + n.getName().toString() + "() : " + n.getType().toString() + "\n");
    			//methods.add(n.getName().toString());
    		}*/
    		
    		
            super.visit(n, arg);
            
            //p.umlString+= "}\n\n";
       }


		
        
        
 		
        
}
