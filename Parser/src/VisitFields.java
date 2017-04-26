
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.ModifierSet;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


public class VisitFields extends VoidVisitorAdapter<Void>{

	public void visit(FieldDeclaration n, Void arg) {
		// TODO Auto-generated method stub
		
		ClassOrInterfaceDeclaration c = new ClassOrInterfaceDeclaration();
		
		
		Parser p = new Parser();
		
		
		if(n.getModifiers() == ModifierSet.PUBLIC){
			
			p.umlString += ("+" + n.getVariables().toString().replaceAll("\\[|\\]", "") + " : " + n.getType() + "\n");
			
		}
		else if(n.getModifiers() == ModifierSet.PRIVATE)
		{
			if(!n.getVariables().toString().contains("="))
			p.umlString += ("-" + n.getVariables().toString().replaceAll("\\[|\\]", "") + " : " + n.getType() + "\n");

		}
		else if(n.getModifiers() == ModifierSet.PROTECTED)
		{
			
			p.umlString += ("#" + n.getVariables().toString().replaceAll("\\[|\\]", "") + " : " + n.getType() + "\n");
		}
		
		
		
		
		
		super.visit(n, arg);
	}
	
}
