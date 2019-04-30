/*
 * Sintaxe:
 * 
 * swap(x_1, x_2), onde x_n pertence a Var
 * 
 * 	c ::= skip 
 * 		| x := a 
 * 		| c_1 ; c_2
 * 		| while b do c
 * 		| if b then c_1 else c_2
 * 		| swap(x_1, x_2)
 * 
 * Semântica:
 * 	Big-Step:
 * 		<x1, s> => n1            <x2, s> => n2
 *     ----------------------------------------swap
 *        <swap(x1,x2), s> => s[x1/n2, x2/n1]
 * 
 *	Small-Step:
 *		
 *		-------------------------------------------swap
 *	     <swap(x1,x2), s> -> s[x1/s(x2), x2/s(x1)]
 * */

public class Swap extends Prog {
	private Var e1;
	private Var e2;
	
	public Swap(Var e1, Var e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	
	@Override
	public AbsSyntaxTree smallStep(State s) {
		int aux = s.getValue(e1.getVar());
		s.addVar(e1.getVar(), s.getValue(e2.getVar()));
		s.addVar(e2.getVar(), aux);
		return new Skip();
	}
	
	@Override
	public String toString() {
		return "swap(" + e1 + ", " + e2 + ")";
	}
}
