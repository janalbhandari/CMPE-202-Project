
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.ModifierSet;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


public class VisitFields extends VoidVisitorAdapter<Void>{

	public void visit(FieldDeclaration n, Void arg) {
		// TODO Auto-generated method stub
		
		
		
		Parser p = new Parser();
		
		if(n.getModifiers() == ModifierSet.PUBLIC){
			
			p.umlString += ("+" + n.getVariables().toString().replaceAll("\\[|\\]", "") + " : " + n.getType() + "\n");
			
				
			
		}
		else if(n.getModifiers() == ModifierSet.PRIVATE)
		{
			if(!n.getVariables().toString().contains("="))
			{
				if(n.getType().toString().contains("Collection")){
					p.umlString += "";
				}
				else
				{
					p.umlString += ("-" + n.getVariables().toString().replaceAll("\\[|\\]", "") + " : " + n.getType() + "\n");
				}
			}
			
			//System.out.println(n.getType() + "   belongs to   " + p.cName);
			
			
			/*if(n.getType().toString().contains("Collection")){
				
				String otherClass = n.getType().toString().substring(11, n.getType().toString().length()-1);
				
				
					p.umlString +=p.cName + " ..> " + otherClass;
				
				}*/

		}
		/*else if(n.getModifiers() == ModifierSet.PROTECTED)
		{
			
			p.umlString += ("#" + n.getVariables().toString().replaceAll("\\[|\\]", "") + " : " + n.getType() + "\n");
		}*/
	
		super.visit(n, arg);
	}
	
}
