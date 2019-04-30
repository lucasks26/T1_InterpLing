public class Not extends Bexp {
	private Bexp e1;
	
	public Not(Bexp e1) {
		this.e1 = e1;
	}
	
	@Override
	public AbsSyntaxTree smallStep(State s) {
		if (!(e1 instanceof Boolean)) {
			return new Not((Bexp) e1.smallStep(s));
		}else {
			return new Boolean(!((Boolean) e1).getValue());
		}
	}

	@Override
	public String toString() {
		return "!(" + e1.toString() +")";
	}
}
