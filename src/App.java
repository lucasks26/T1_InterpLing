/*
 * Exemplos de execução
 * 
 * 	Exemplo 1: While, Not, Greater, Var, IntVal, Att, Sum
 * 
 *  Exemplo 2: Seq, Swap, Var, Att, Sub
 *  
 *  Exemplo 3: Cond, Eq, Or, Bool, And, Less, Mult
 * 
 * */

public class App {
	public static void main(String args[]) {
		State s;
		

		//while,greater,var,att,sum,equal,not,and,skip,seq,cond,sub,swap,or,mult,less
		//,,,,,,,,,,
		
		s = new State(new String[] {"x,1"});
		AbsSyntaxTree Teste1 = new While(new Not (new Greater(new Var("x"), new IntVal(5))), new Att(new Var("x"), new Sum(new Var("x"), new IntVal(1))));
		
		compute(Teste1, s);
		
		s = new State(new String[] {"x,1", "y,2"});
		AbsSyntaxTree Teste2 = new Seq (new Swap(new Var("x"), new Var("y")),new Att (new Var("x"),new Sub(new Var("x"), new Var("y"))));
		
		compute(Teste2,s);

		s = new State(new String[] {"x,3", "y,2"});
		AbsSyntaxTree Teste3 = new Cond(new And(new Or(new Equal(new Var("x"),new Var("y")),new Boolean(true)),new Not(new Less(new Var("y"),new IntVal(2)))),new Att(new Var("x"),new Mult(new Var("x"),new Var("y"))),new Seq( new Skip(),new Skip()));

		compute(Teste3,s);

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
