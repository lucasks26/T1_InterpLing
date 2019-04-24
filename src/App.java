public class App {
	public static void main(String args[]) {
		State s = new State(new String[] {"x,10"});
		
		AbsSyntaxTree attTeste = new Att(new Var("x"), new IntVal(40));
		AbsSyntaxTree somaTeste = new Sum(new Var("x"), new IntVal(20));
		AbsSyntaxTree attTeste2 = new Att(new Var("x"), (Aexp) somaTeste);
		AbsSyntaxTree seqTeste = new Seq((Prog) attTeste, (Prog) attTeste2);
		
		compute(seqTeste, s);
		
		
		s = new State(new String[] {"x,1"});
		AbsSyntaxTree whileTeste = new While(new Less(new Var("x"), new IntVal(5)), new Att(new Var("x"), new Sum(new Var("x"), new IntVal(1))));
		
		compute(whileTeste, s);
	}
	
	
	public static void compute(AbsSyntaxTree tree, State init) {
		AbsSyntaxTree aux = tree;
		System.out.println("Initial Sentence: <" + aux + ", "+ init.toString() +">");
		int i = 1;
		while(!(aux instanceof Skip)) {
			aux = aux.smallStep(init);
			System.out.println(i++ + ". <" + aux + ", "+ init.toString() +">");
		}
		System.out.println();
	}
}
