public class Att extends Prog {
	private Var e1;
	private Aexp e2;
	
	public Att(Var e1, Aexp e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	
	@Override
	public AbsSyntaxTree smallStep(State s) {
		if(!(e2 instanceof IntVal)) {
			return new Att(e1, (Aexp) e2.smallStep(s));
		}else {
			s.addVar(e1.getVar(), ((IntVal) e2).getValue());
			return new Skip();
		}
	}
	
	@Override
	public String toString() {
		return e1 + " := " + e2;
	}
}
