public class Sub extends Aexp{
	private Aexp e1;
	private Aexp e2;
	
	public Sub(Aexp e1, Aexp e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	
	@Override
	public AbsSyntaxTree smallStep(State s) {
		if (!(e1 instanceof IntVal)) {
			return new Sub((Aexp) e1.smallStep(s), e2);
		}else if (!(e2 instanceof IntVal)) {
			return new Sub(e1, (Aexp) e2.smallStep(s));
		}else {
			return new IntVal(((IntVal) e1).getValue() - ((IntVal) e2).getValue());
		}
	}
	
	@Override
	public String toString() {
		return e1 + " - " + e2;
	}
}
