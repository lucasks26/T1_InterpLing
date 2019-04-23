public class Prog {
	public static void main(String args[]) {
		State s = new State(new String[] {"x,10"});
		
		AbsSyntaxTree soma = new Sum(new IntVal(10), new IntVal(40));
		
		AbsSyntaxTree soma2 = new Sum(new Var("x"), new IntVal(20));
		
		AbsSyntaxTree sub = new Sub((Aexp) soma, (Aexp) soma2);
		
		System.out.println(sub.smallStep(s));
			
	}
}
