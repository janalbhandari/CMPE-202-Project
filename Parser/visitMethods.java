
import java.util.ArrayList;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.ModifierSet;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class visitMethods extends VoidVisitorAdapter<Void> {
	static ArrayList<String> methods = new ArrayList<String>();
	static String methodName;
	static ArrayList<String> methodNames = new ArrayList<String>();	
	
        @Override
        public void visit(MethodDeclaration n, Void arg) {
            /* here you can access the attributes of the method.
             this method will be called for all methods in this 
             CompilationUnit, including inner class methods */
        	String modifier = null;
        	
        	//System.out.println("___");
			//methodName = n.getName();
			//System.out.println(methodName);
        
    		if(n.getModifiers() == ModifierSet.PUBLIC){
    			modifier = "+";
    		}
    		else if(n.getModifiers() == ModifierSet.PRIVATE)
    		{
    			modifier = "-";
    		}
    		else if(n.getModifiers() == ModifierSet.PROTECTED)
    		{
    			modifier = "#";
    		}
    		
        	System.out.println(modifier +n.getName() + "() : " + n.getType());
            super.visit(n, arg);
       }
        
        
 		
        
}
