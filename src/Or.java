public class Or extends Bexp {
	private Bexp e1;
	private Bexp e2;
	
	public Or(Bexp e1, Bexp e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	
	@Override
	public AbsSyntaxTree smallStep(State s) {
		if (!(e1 instanceof Boolean)) {
			return new Or((Bexp) e1.smallStep(s), e2);
		}else if (!(e2 instanceof Boolean)) {
			return new Or(e1, (Bexp) e2.smallStep(s));
		}else {
			return new Boolean(((Boolean) e1).getValue() || ((Boolean) e2).getValue());
		}
	}
	
	@Override
	public String toString() {
		return "(" + e1 + ") || (" + e2 + ")";
	}
}
