import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.ModifierSet;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class VisitConstructor extends VoidVisitorAdapter<Void> {
	
	public void visit(ConstructorDeclaration n, Void arg) {
        /* here you can access the attributes of the method.
         this method will be called for all methods in this 
         CompilationUnit, including inner class methods */
		
		Parser p = new Parser();

		String modifier = null;
		
		if(n.getModifiers() == ModifierSet.PUBLIC){
			modifier = "+";
			
			if(n.getParameters() != null){
				
				//System.out.println(n.getName() + " has parameters : " + n.getParameters().toString() + "\n\n");
				
				String method_params = n.getParameters().toString().replaceAll("\\[|\\]", "");
				String[] tokens = method_params.split(" ");
				
				p.umlString += modifier + n.getName().toString() + "(" + tokens[1] + " : " + tokens[0] + ")" + "\n";
				
			}
			else
				{
					p.umlString += modifier + n.getName().toString() + "() " + "\n";
				}
		}
		else if(n.getModifiers() == ModifierSet.PRIVATE)
		{
			modifier = "-";
			p.umlString += modifier + n.getName().toString() + "() " + "\n";
		}
		else if(n.getModifiers() == ModifierSet.PROTECTED)
		{
			modifier = "#";
		}
		
		
       // System.out.println(modifier + n.getName().toString() + "() : " + n.getTypeParameters());
        super.visit(n, arg);
    }
}
