public class Greater extends Bexp {
	Aexp e1;
	Aexp e2;
	
	public Greater(Aexp e1, Aexp e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	
	@Override
	public AbsSyntaxTree smallStep(State s) {
		if(!(e1 instanceof IntVal)) {
			return new Greater((Aexp) e1.smallStep(s), e2);
		}else if(!(e2 instanceof IntVal)) {
			return new Greater(e1, (Aexp) e2.smallStep(s));
		}else {
			return new Boolean(((IntVal) e1).getValue() > ((IntVal) e2).getValue());
		}
	}
	
	@Override
	public String toString() {
		return e1 + " > " + e2;
	}
}
