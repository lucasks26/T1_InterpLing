public class While extends Prog {
	private Bexp b;
	private Prog c;
	
	public While(Bexp b, Prog c) {
		this.b = b;
		this.c = c;
	}
	
	@Override
	public AbsSyntaxTree smallStep(State s) {
		return new Cond(b, new Seq(c, (Prog) new While(b,c)), (Prog) new Skip());
	}
	
	@Override
	public String toString() {
		return "while (" + b + ") do {" + c +"}";
	}
}
