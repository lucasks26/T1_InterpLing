public class Var extends Aexp {
	String var;
	
	public Var(String var) {
		this.var = var;
	}
	
	public String getVar() {
		return var;
	}
	
	@Override
	public AbsSyntaxTree smallStep(State s) {
		return new IntVal(s.getVar(var).intValue());
	}
	
	@Override
	public String toString() {
		return var;
	}
}
