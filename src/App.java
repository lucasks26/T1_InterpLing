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
		AbsSyntaxTree teste1 = new While(new Not (new Greater(new Var("x"), new IntVal(5))), new Att(new Var("x"), new Sum(new Var("x"), new IntVal(1))));
		
		compute(teste1, s);
		
		s = new State(new String[] {"x,1", "y,2"});
		AbsSyntaxTree teste2 = new Seq (new Swap(new Var("x"), new Var("y")),new Att (new Var("x"),new Sub(new Var("x"), new Var("y"))));
		
		compute(teste2,s);

		s = new State(new String[] {"x,3", "y,2"});
		AbsSyntaxTree teste3 = new Cond(new And(new Or(new Equal(new Var("x"),new Var("y")),new Boolean(true)),new Not(new Less(new Var("y"),new IntVal(2)))),new Att(new Var("x"),new Mult(new Var("x"),new Var("y"))),new Seq( new Skip(),new Skip()));

		compute(teste3,s);
		
		//Testes para interpretação sem comandos, só com expressões aritméticas e booleanas
		/* 
		s = new State();
		AbsSyntaxTree teste4 = new Sum(new IntVal(4), new IntVal(5));
		
		compute(teste4, s);
		
		s = new State();
		AbsSyntaxTree teste5 = new And(new Boolean(true), new Boolean(false));

		compute(teste5, s);
		
		s = new State(new String[] {"x,3"});
		AbsSyntaxTree teste6 = new Var("x");
		
		compute(teste6, s);
		*/
	}
	
	
	public static void compute(AbsSyntaxTree tree, State init) {
		AbsSyntaxTree aux = tree;
		System.out.println("Initial Sentence: <" + aux + ", "+ init.toString() +">");
		int i = 1;
		while(!((aux instanceof Skip) || (aux instanceof IntVal) || (aux instanceof Boolean))) {
			aux = aux.smallStep(init);
			System.out.println(i++ + ". <" + aux + ", "+ init.toString() +">");
		}
		System.out.println();
	}
}
