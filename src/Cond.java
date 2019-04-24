public class Cond extends Prog {
	private Bexp b;
	private Prog c1;
	private Prog c2;
	
	public Cond(Bexp b, Prog c1, Prog c2) {
		this.b = b;
		this.c1 = c1;
		this.c2 = c2;
	}
	
	@Override
	public AbsSyntaxTree smallStep(State s) {
		if(!(b instanceof Boolean)) {
			return new Cond((Bexp) b.smallStep(s), c1, c2);
		}else if(((Boolean) b).getValue()) {
			return c1;
 		}else {
			return c2;
		}
	}
	
	@Override
	public String toString() {
		return "if " + b + " then {" + c1 + "} else {" + c2 +"}";
	}

}
