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
